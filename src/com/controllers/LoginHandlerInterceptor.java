package com.controllers;


import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author Behrooz
 *
 */
public class LoginHandlerInterceptor extends HandlerInterceptorAdapter  {
	
	private String getUsernameFromCookie(HttpServletRequest request) {
		for(Cookie cookie : request.getCookies()) {
			if (cookie.getName().equals("mobile")) {
				return cookie.getValue();
			}
		}
		return null;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		String mobile = getUsernameFromCookie(request);
		if(mobile != null) {
			ModelMap model = new ModelMap();
			response.sendRedirect("/Parking");
			return false;
		}
		return true;	
	}	 
		

}
