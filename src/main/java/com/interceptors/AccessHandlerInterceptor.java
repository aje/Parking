package com.interceptors;


import com.controllers.UserDao;
import com.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		RequestMapping rm = ((HandlerMethod) handler).getMethodAnnotation(RequestMapping.class);


		boolean alreadyLoggedIn = request.getSession().getAttribute("user_id") != null; 						// 1 - check session if user is already login via session
		boolean loginPageRequested = rm != null && rm.value().length > 0
				&& "/login".equals(rm.value()[0]); 									// check request page if it's login page or not
//		System.out.println(alreadyLoggedIn);
//		System.out.println((int) request.getSession().getAttribute("user_id"));

		if (alreadyLoggedIn && loginPageRequested) {															//
			response.sendRedirect(request.getContextPath() + "/admin/dashboard");								// 2 - send to dashboard when user is log in and requests login page
			return false;																						//
		}

		else if (!alreadyLoggedIn && !loginPageRequested) {														// if user is not log in via session and not it's not login page
//			String remember = getHashFromCookie(request); 														// 3 - get remember cookie and check if it's not empty
//			if(remember != null) {
			System.out.println("this");
//				List<User> userInfo = userDao.getUser("WHERE `remember_token` = '" +
//														getHashFromCookie(request)+ "' ");
//				if(!userInfo.isEmpty())
//				if (BCrypt.checkpw(remember, userInfo.get(0).getRemember()) && userInfo.get(0).getType() == 5) { 		// 4 - check if remember cookie exist in database
//					LoginController lg = new LoginController();
//					lg.setUserSession(request, "user_id",  String.valueOf(userInfo.get(0).getId())); 			// 5 - set session
//					return true;																				// 6
//
//				}
//			}

			response.sendRedirect(request.getContextPath() + "/login");									// 7 - send to login
			return false;
		}

		else if (alreadyLoggedIn) {
			int user_id;
			user_id = Integer.valueOf(request.getSession().getAttribute("user_id").toString());
			User userInfo = userDao.getOne(user_id);
//			System.out.println(userInfo.getType());
			if (userInfo.getType() != 5) {
				response.sendRedirect(request.getContextPath() + "/admin/login");
				return false;
			}
		}

		return true;
	}
//	
	
	@Override
	public void postHandle(
	  HttpServletRequest request, 
	  HttpServletResponse response,
	  Object handler, 
	  ModelAndView modelAndView) throws Exception {
		if (request.getSession().getAttribute("user_id") != null)
		modelAndView.addObject("user" , userDao.getOne(Integer.parseInt(request.getSession().getAttribute("user_id").toString())));
//		System.out.println(userDao.getOne(Integer.parseInt(request.getSession().getAttribute("user_id").toString())));
	}
		

}
