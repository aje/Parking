package com.controllers;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.*;

import com.controllers.UserController;
import com.models.User;

@Controller
//@SessionAttributes("name")
public class LoginController extends User{
	
	
	@Autowired
	UserController userController;
	/**
	 * show register page
	 */	
	@RequestMapping("/login")
	public String login() {	
		return "login";
	}
	/**
	 * login  handler
	 */
	@RequestMapping(value="/loginCheck" , method = RequestMethod.POST)
	public String loginCheck(@Valid @ModelAttribute("user") User user, BindingResult result, ModelMap model, HttpServletResponse response, HttpServletRequest request) {
		if (result.hasErrors()) {			
			model.put("msg", "There was an error");
			return "home";
		}
		List<User> userInfo = getUsersFromDB("WHERE `mobile` = " + user.getMobile());
		if(!userInfo.isEmpty()) {
			if(BCrypt.checkpw(user.getPassword(), userInfo.get(0).getPassword())) {
//				HttpSession session = request.getSession();
//		        session.setAttribute("name", userInfo.get(0).getName()); // set session
//				Cookie cookie = new Cookie("mobile", user.getMobile().toString()); // set cookie
//				response.addCookie(cookie);
				
				userController.addNameToSessionCookie(response, request,"name", userInfo.get(0).getName());
				model.put("msg", "You logged in ");	
			}
			// it means we have such user
//			model.addAttribute("name", user.getMobile()); // set session
			
		} else {
			model.put("msg", "Mobile and password is wrong");
		}		
		return "home";
	}
	


	/**
	 * show register page
	 */	
	@RequestMapping("/logout")
	public String logout(HttpServletResponse response, ModelMap model, HttpServletRequest request, SessionStatus sessionStatus) {	
		Cookie cookie = new Cookie("mobile", null);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		sessionStatus.setComplete();
		HttpSession session = request.getSession();
		session.removeAttribute("name");
//        session.setAttribute("name", null);
		return "home";
	}

	

}
