package com.controllers;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.models.User;

/**
 * @author Behrooz
 *
 */
@Controller
@SessionAttributes("name")
public class UserController extends User {

	/**
	 * attribues
	 */
	@Autowired
	DataSource dataSource;
	
	/**
	 * get cookie
	 */
	public String getUsernameFromCookie(HttpServletRequest request) {
		for(Cookie cookie : request.getCookies()) {
			if (cookie.getName().equals("mobile")) {
				return cookie.getValue();
			}
		}
		return null;
	}
	
	
	public boolean addNameToSessionCookie(HttpServletResponse response, HttpServletRequest request, String name, String value) {
		
		HttpSession session = request.getSession();
        session.setAttribute(name, value); // set session
		Cookie cookie = new Cookie(name, value); // set cookie
		response.addCookie(cookie);
		return true;
	}
	




	/**
	 * show all users
	 */
	@RequestMapping("/users")
	public ModelAndView showUsers() {
		
		ModelAndView model = new ModelAndView("users/usersList");
		model.addObject("data", getUsersFromDB(""));
		return model;
	}

	/*
	 * edit handler
	 */
	@RequestMapping(value="/users/editUser" , method = RequestMethod.POST)
	public ModelAndView editUser(@ModelAttribute("user") User user, BindingResult result) {
		ModelAndView model = new ModelAndView("home");
		if (result.hasErrors()) {
			model.addObject("msg", "Something is wrong here");
			return model;
		}
		editUserInDB(user);
		model.addObject("msg", "successfully edited");
		return model;
	}


	/**
	 * delete handler
	 */
	@RequestMapping(value="/users/delete/{id}" , method = RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable("id") int id) {
		ModelAndView model = new ModelAndView("users/usersList");
		try {
			deleteUserFromDB(id, 0);
			model.addObject("msg", "successfully deleted");
		} catch (Exception e) {
			model.addObject("msg", "can't delete");
		}
		model.addObject("msg", "successfully deleted");
		model.addObject("data", getUsersFromDB(""));
		return model;
	}
	
	/**
	 * show edit page
	 */
	
	@RequestMapping(value="/users/edit" , method = RequestMethod.POST)
	public ModelAndView edit(@ModelAttribute("id") String id) {	
		String qrr = " WHERE id LIKE " + id;
		ModelAndView model = new ModelAndView("users/editUser");
		model.addObject("user",getUsersFromDB(qrr));
		return model;
	}
	

	/**
	 * recover handler
	 */
	@RequestMapping(value="/users/recover/{id}" , method = RequestMethod.GET)
	public ModelAndView revocerUser(@PathVariable("id") int id) {
		
		ModelAndView model = new ModelAndView("users/usersList");
		try {
			deleteUserFromDB(id, 1);
			model.addObject("msg", "successfully deleted");
		} catch (Exception e) {
			model.addObject("msg", "can't delete");
		}
		model.addObject("msg", "successfully deleted");
		model.addObject("data", getUsersFromDB(""));
		return model;
	}
}
