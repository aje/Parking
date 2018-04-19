package com.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.controllers.UserController;
import com.models.User;

@Controller
//@SessionAttributes("name")
public class RegisterController extends User{
	
	@Autowired
	UserController userController;
	/**
	 * show register page
	 */
	@RequestMapping("/register")
	public ModelAndView showRegisterPage() {	
		ModelAndView model = new ModelAndView("register");
		return model;
	}
	
	/**
	 * register handler
	 * 
	 */
	
	@RequestMapping(value="/adduser" , method = RequestMethod.POST)
	public ModelAndView register(@Valid @ModelAttribute("user") User user, BindingResult result,  HttpServletResponse response, HttpServletRequest request) {
		ModelAndView model = new ModelAndView("register");
		if (result.hasErrors() || !addUserToDB(user)) {	// add to database	
			
			model.addObject("msg", "There was an error");
			return model;
		} else {
			userController.addNameToSessionCookie(response, request,"name", user.getName());
			model.addObject("msg", "It was successful");
		}
			
		return model;
	}
	

}
