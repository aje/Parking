package com.controllers;


import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author Behrooz
 *
 */
public class AccessHandlerInterceptor extends HandlerInterceptorAdapter  {
    @Autowired
    UserDao userDao;
    
	private String getHashFromCookie(HttpServletRequest request) {
		for(Cookie cookie : request.getCookies()) {
			if (cookie.getName().equals("remember")) {
				return cookie.getValue();
			}
		}
		return null;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		RequestMapping rm = ((HandlerMethod) handler).getMethodAnnotation(
                RequestMapping.class);
			
		boolean alreadyLoggedIn = request.getSession().getAttribute("user_id") != null; 						// 1 - check session if user is already login via session
		boolean loginPageRequested = rm != null && rm.value().length > 0
		                     		&& "/admin/login".equals(rm.value()[0]); 									// check request page if it's login page or not 
//		System.out.println(rm);
//		System.out.println(request.getSession().getAttribute("user_id"));
		if (alreadyLoggedIn && loginPageRequested) {
			response.sendRedirect(request.getContextPath() + "/admin/dashboard");								// 2 - send to dashboard 
			return false;
		} else if (!alreadyLoggedIn && !loginPageRequested) {
			String remember = getHashFromCookie(request); 														// 3 - get remember cookie
			if(remember != null) {
				User user = new User();
				List<User> userInfo = userDao.getUser("WHERE `remember_token` = '" + getHashFromCookie(request)+ "' ");
				if(!userInfo.isEmpty())
				if (BCrypt.checkpw(remember, userInfo.get(0).getRemember())) { 									// 4 - check if remember cookie exist in database
					LoginController lg = new LoginController();
					lg.setUserSession(request, "user_id",  String.valueOf(userInfo.get(0).getId())); 			// 5 - set session 
					response.sendRedirect(request.getContextPath() + "/admin/dashboard"); 						// 6 - send to dashboard
					return false;
				}
			}
//			return true;
			
			response.sendRedirect(request.getContextPath() + "/admin/login");																// 7 - send to login
			return false;
		}
		
		
		
		
//		String mobile = getHashFromCookie(request);
//		if(mobile != null) {
////			BCrypt.checkpw(mobile, userInfo.get(0).getPassword())
//			response.sendRedirect("/admin/login");
//			return false;
//		}
		return true;	
	}	
	
	
	@Override
	public void postHandle(
	  HttpServletRequest request, 
	  HttpServletResponse response,
	  Object handler, 
	  ModelAndView modelAndView) throws Exception {
		User user = new User();
//		int id = request.getSession().getAttribute("user_id");
//		user.getUsersFromDB(" WHERE id like " + request.getSession().getAttribute("user_id"));
//		ApplicationContext context = new ClassPathXmlApplicationContext("user-module.xml");
//        UserDao userDAO = (UserDao) context.getBean("userDao");
		if (request.getSession().getAttribute("user_id") != null)
		modelAndView.addObject("user" , userDao.getOne(Integer.parseInt(request.getSession().getAttribute("user_id").toString())));
//		System.out.println(userDao.getOne(Integer.parseInt(request.getSession().getAttribute("user_id").toString())));
	}
		

}
