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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.*;

import com.controllers.UserController;
import com.models.User;


@Controller
public class LoginController extends User{
	
	
	@Autowired
	UserController userController;
	
	/**
	 * show login page
	 */	
	@RequestMapping("/login")
	public String login() {	
		return "auth/login";
	}

	/**
	 * show admin login page
	 */	
	@RequestMapping("/admin/login")
	public String adminlogin() {	
		return "admin/users/login";
	}
	/**
	 * login  handler
	 */
	@RequestMapping(value="/loginCheck" , method = RequestMethod.POST)
	public @ResponseBody Object loginCheck(@Valid @ModelAttribute("user") User user, BindingResult result, ModelMap model, HttpServletResponse response, HttpServletRequest request) {
		AjaxResponse ajaxResponse = new AjaxResponse(); 
		if (result.hasErrors()) {			
			ajaxResponse.setStatus(false);
			ajaxResponse.setMsg("There was an error");
			return ajaxResponse;
		}
		List<User> userInfo = getUsersFromDB("WHERE `mobile` = '" + user.getMobile() + "' ");
		if(!userInfo.isEmpty()) {
			if(BCrypt.checkpw(user.getPassword(), userInfo.get(0).getPassword())) {
				userController.addNameToSessionCookie(response, request,"name", userInfo.get(0).getName());
				ajaxResponse.setMsg("You have successfully logged in.");
				ajaxResponse.setRedirect("admin/dashboard");
				ajaxResponse.setStatus(true);
			} else {
				ajaxResponse.setMsg("Mobile and password is wrong! Please try again.");
				ajaxResponse.setStatus(false);
			}
			
		} else {
			ajaxResponse.setMsg("Mobile and password is wrong! Please try again.");
			ajaxResponse.setStatus(false);		
		}		
		return ajaxResponse;
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
