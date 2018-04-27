package com.controllers;

import com.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.util.List;

/**
 * @author Behrooz
 *
 */
@Controller
@SessionAttributes("name")
public class UserController extends User {
	@Autowired
	UserDao userDao;
	/**
	 * attribues
	 */
	@Autowired
	DataSource dataSource;
	
//	@Autowired
//	private ResourceService service;
	
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

	/**
	 * show all users
	 */
	@RequestMapping("/admin/users/json")
	public @ResponseBody List<User> showUsers() {
		return  userDao.getUser("");
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
//		editUserInDB(user);
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
			userDao.delete(id, 0);
			model.addObject("msg", "successfully deleted");
		} catch (Exception e) {
			model.addObject("msg", "can't delete");
		}
		model.addObject("msg", "successfully deleted");
		model.addObject("data", userDao.getUser(""));
		return model;
	}
	
	/**
	 * show edit page
	 */
	
	@RequestMapping(value="/users/edit" , method = RequestMethod.POST)
	public ModelAndView edit(@ModelAttribute("id") String id) {	
		String qrr = " WHERE id LIKE " + id;
		ModelAndView model = new ModelAndView("users/editUser");
		model.addObject("user",userDao.getUser(qrr));
		return model;
	}
	

	/**
	 * recover handler
	 */
	@RequestMapping(value="/users/recover/{id}" , method = RequestMethod.GET)
	public ModelAndView revocerUser(@PathVariable("id") int id) {
		
		ModelAndView model = new ModelAndView("users/usersList");
		try {
			userDao.delete(id, 1);
			model.addObject("msg", "successfully deleted");
		} catch (Exception e) {
			model.addObject("msg", "can't delete");
		}
		model.addObject("msg", "successfully deleted");
		model.addObject("data", userDao.getUser(""));
		return model;
	}
}
