package com.controllers;

import java.io.IOException;
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
import com.models.User;


@Controller
public class LoginController {
    private final
	UserDao userDao;

	@Autowired
	public LoginController(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * show login page
	 */	
	@RequestMapping("/login")
	public String login() {	
		return "/admin/users/login";
	}

	/**
	 * show admin login page
	 */	
	@RequestMapping("/admin/login")
	public String adminLogin() {
		return "/admin/users/login";
	}
	
	
	private void setUserSession(HttpServletRequest request, String name, String value) {
		HttpSession session = request.getSession();
        session.setAttribute(name, value); // set session
	}
	
	public void setUserCookie(HttpServletResponse response, String name, String value) {
		Cookie cookie = new Cookie(name, value); // set cookie
		response.addCookie(cookie);
	}
	

	/**
	 * login  handler
	 */
	@RequestMapping(value="/loginCheck" , method = RequestMethod.POST)
	public @ResponseBody AjaxResponse loginCheck(@Valid @ModelAttribute("user1") User user1, BindingResult result, ModelMap model, HttpServletResponse response, HttpServletRequest request) {
		AjaxResponse ajaxResponse = new AjaxResponse(); 
//		System.out.println(user.getMobile() + " | " + user.getPassword()  + " | " + request.getParameter("remember_me"));
		if (result.hasErrors()) {																		// form validation
			ajaxResponse.setStatus(false);
			ajaxResponse.setMsg("There was an error");
			return ajaxResponse;
		}

		List<User> userInfo = userDao.getUser("WHERE `mobile` = '" + user1.getMobile() + "' ");
		if(!userInfo.isEmpty()) { 																		// 3- check if user exists
			if(BCrypt.checkpw(user1.getPassword(), userInfo.get(0).getPassword())) { 					// 3- check password 
				setUserSession(request,"user_id", String.valueOf(userInfo.get(0).getId())); 			// 4- set user_id to session
				if(request.getParameter("remember_me") != null) {
					String hashRemember = BCrypt.hashpw(userInfo.get(0).getName() + "hehe", BCrypt.gensalt());
					setUserCookie(response, "remember", hashRemember);
					userDao.edit(userInfo.get(0).getId(), new String[] {"remember_token"}, new String[]  {hashRemember});
				}
				ajaxResponse.setMsg("You have successfully logged in.");
				ajaxResponse.setRedirect("/admin/dashboard");											// 8- send redirect
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
	 * logout
	 * @throws IOException 
	 */	
	@RequestMapping("/logout")
	public void logout(HttpServletResponse response, ModelMap model, HttpServletRequest request, SessionStatus sessionStatus) throws IOException {
		Cookie cookie = new Cookie("remember", null);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		sessionStatus.setComplete();
		HttpSession session = request.getSession();
		session.removeAttribute("user_id");
		response.sendRedirect(request.getContextPath() + "/admin/login");
	}

	

}
