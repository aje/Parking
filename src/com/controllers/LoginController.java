package com.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	public boolean setUserSession(HttpServletRequest request, String name, String value) {
		HttpSession session = request.getSession();
        session.setAttribute(name, value); // set session
		return true;
	}
	
	public boolean setUserCookie(HttpServletResponse response, String name, String value) {
		Cookie cookie = new Cookie(name, value); // set cookie
		response.addCookie(cookie);
		return true;
	}
	

	/**
	 * login  handler
	 */
	@RequestMapping(value="/loginCheck" , method = RequestMethod.POST)
	public @ResponseBody Object loginCheck(@Valid @ModelAttribute("user") User user, BindingResult result, ModelMap model, HttpServletResponse response, HttpServletRequest request) {
		AjaxResponse ajaxResponse = new AjaxResponse(); 
		System.out.println(user.getMobile() + " | " + user.getPassword()  + " | " + request.getParameter("remember"));
		
		if (result.hasErrors()) {																		// form validation
			ajaxResponse.setStatus(false);
			ajaxResponse.setMsg("There was an error");
			return ajaxResponse;
		}
		List<User> userInfo = getUsersFromDB("WHERE `mobile` = '" + user.getMobile() + "' ");
		if(!userInfo.isEmpty()) { 																		// 3- check if user exists
			if(BCrypt.checkpw(user.getPassword(), userInfo.get(0).getPassword())) { 					// 3- check password 
				setUserSession(request,"user_id", String.valueOf(userInfo.get(0).getId())); 			// 4- set user_id to session 
				if(request.getParameter("remember") != null) { 
					System.out.println("ta inja");
					setUserCookie(response, "remember", BCrypt.hashpw(userInfo.get(0).getName() + "hehe", BCrypt.gensalt())); // 6- set cookie
				}
				ajaxResponse.setMsg("You have successfully logged in.");
				ajaxResponse.setRedirect("admin/dashboard");											// 8- send redirect
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
	 * @throws IOException 
	 */	
	@RequestMapping("/logout")
	public String logout(HttpServletResponse response, ModelMap model, HttpServletRequest request, SessionStatus sessionStatus) throws IOException {	
		Cookie cookie = new Cookie("mobile", null);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		sessionStatus.setComplete();
		HttpSession session = request.getSession();
		session.removeAttribute("user_id");
//        session.setAttribute("name", null);
		response.sendRedirect(request.getContextPath() + "/admin/login");
		return null;
	}

	

}
