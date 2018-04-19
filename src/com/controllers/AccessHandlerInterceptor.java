package com.controllers;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author Behrooz
 *
 */
public class AccessHandlerInterceptor extends HandlerInterceptorAdapter  {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		if(0 == 1) {
			response.getWriter().write("noooo");
			return false;
		}
		return true;	
	}	 
		

}
