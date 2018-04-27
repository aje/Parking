package com.controllers;

import com.models.User;
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
	
	@Autowired
    UserDao userDao;
	/**
	 * show register page
	 */
	@RequestMapping("/register")
	public ModelAndView showRegisterPage() {	
		ModelAndView model = new ModelAndView("auth/register");
		return model;
	}
	
	/**
	 * register handler
	 * 
	 */
	
	@RequestMapping(value="/adduser" , method = RequestMethod.POST)
	public ModelAndView register(@Valid @ModelAttribute("user") User user, BindingResult result,  HttpServletResponse response, HttpServletRequest request) {
		ModelAndView model = new ModelAndView("auth/register");
		
		if (result.hasErrors() || (userDao.isMobileExist(user.getMobile()) > 0)) {	// add to database
			if ((userDao.isMobileExist(user.getMobile()) > 0)) {
				model.addObject("msg", "Mobile exist");
			} else {
				model.addObject("msg", "There was an error");	
			}
			return model;
		} else {
			userDao.addUserToDB(user);
//			userController.addNameToSessionCookie(response, request,"name", user.getName());
			model.addObject("msg", "It was successful");
		}
			
		return model;
	}
	

}
