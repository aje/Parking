package com.controllers;

import com.dao.UserDao;
import com.models.User;
import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
//@SessionAttributes("name")
public class RegisterController extends User{
	
	final
	UserService userService;

	@Autowired
	public RegisterController(UserService userService) {
		this.userService = userService;
	}

	/**
	 * register handler
	 * 
	 */
	
	@RequestMapping(value="/adduser" , method = RequestMethod.POST)
	public ModelAndView register(@Valid @ModelAttribute("user") User user, BindingResult result,  HttpServletResponse response, HttpServletRequest request) {
		ModelAndView model = new ModelAndView("auth/register");
		
//		if (result.hasErrors() || !(userDao.isMobileExist(user.getMobile()))) {	// add to database
//			if (!(userDao.isMobileExist(user.getMobile()))) {
//				model.addObject("msg", "Mobile exist");
//			} else {
//				model.addObject("msg", "There was an error");
//			}
//			return model;
//		} else {
//			userDao.add(user);
////			userController.addNameToSessionCookie(response, request,"name", user.getName());
//			model.addObject("msg", "It was successful");
//		}
			
		return model;
	}
	

}
