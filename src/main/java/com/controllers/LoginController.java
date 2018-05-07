package com.controllers;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.models.AuthUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import com.models.User;


@Controller
public class LoginController {


	private  static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private final UserDao userDao;
	private Object result;

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
	 * show login page
	 */
	@RequestMapping("/add-plate")
	public String getPlateShow() {
		return "/admin/users/get-plate";
	}

	/**
	 * loginChecker handler
	 */
	@RequestMapping("/getCode")
	public @ResponseBody AjaxResponse getCode(@RequestParam("mobile") String mobile) {
        User user = new User();
        AjaxResponse ar = new AjaxResponse();
		Boolean userExists = userDao.isMobileExist(mobile);
        // check if user exists, if exists get it from db, if no, save it to db
        if(!userExists) {
            user.setMobile(mobile);
            userDao.add(user);
        } else {
            user = userDao.get(" WHERE mobile = "+mobile).get(0);
        }
        String hashCode = generateCodeAndSendSMS();
        if(hashCode != null) {
            user.setConfirmMobile(hashCode);
			if(userExists) {
				userDao.save(user);
			} else {
				userDao.save(user, user.getId());
			}
            ar.setStatus(true);
            ar.setMsg("We've sent a 5 digit code to your phone number!");
        } else {
            ar.setStatus(false);
            ar.setMsg("We couldn't send sms to you, please check your phone number!");
        }
        return ar;
    }

    private Boolean sendSMS(int code) {
	    return true;
    }

    private String generateCodeAndSendSMS() {
	    int code = 5222;
        String codeHashed = BCrypt.hashpw(""+code, BCrypt.gensalt());
        if(sendSMS(code))
            return codeHashed;
        else
            return null;
    }

//	/**
//	 * show admin login page
//	 */
//	@RequestMapping("/admin/login")
//	public String adminLogin() {
//		return "/admin/users/login";
//	}
	
	
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
	@RequestMapping(value="/login-success")
	public @ResponseBody AjaxResponse loginCheck(HttpServletResponse response, HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userDao.get(" WHERE mobile = "+auth.getName()).get(0);
		AjaxResponse ajaxResponse = new AjaxResponse();
		AuthUser sm = new AuthUser();
		sm.setFullname(user.getName());
		sm.setMobile(user.getMobile());
		sm.setType(user.getType());
//		logger.info(userDao.get(" WHERE mobile = "+auth.getName()).get(0).toString());
		ajaxResponse.setStatus(true);
		if(user.getPlateNumber() == null) {
			ajaxResponse.setRedirect("/add-plate");
		} else if (user.getType() == 5)
			ajaxResponse.setRedirect("/admin/dashboard");
		else if (user.getType() == 1){
			ajaxResponse.setRedirect("/user/dashboard");
		}
		HttpSession session = request.getSession();
		session.setAttribute("authUser", sm); // set session
		ajaxResponse.setMsg("You have successfully logged in.");
//		System.out.println(user.getMobile() + " | " + user.getPassword()  + " | " + request.getParameter("remember_me"));
//		if (result.hasErrors()) {																		// form validation
//			ajaxResponse.setStatus(false);
//			ajaxResponse.setMsg("There was an error");
//			return ajaxResponse;
//		}
//
//		List<User> userInfo = userService.get("WHERE `mobile` = '" + user1.getMobile() + "' ");
//		if(!userInfo.isEmpty()) { 																		// 3- check if user exists
//			if(BCrypt.checkpw(user1.getPassword(), userInfo.get(0).getPassword())) { 					// 3- check password
//				setUserSession(request,"user_id", String.valueOf(userInfo.get(0).getId())); 			// 4- set user_id to session
//				if(request.getParameter("remember_me") != null) {
//					String hashRemember = BCrypt.hashpw(userInfo.get(0).getName() + "hehe", BCrypt.gensalt());
//					setUserCookie(response, "remember", hashRemember);
//					userDao.edit(userInfo.get(0));
//				}
//				ajaxResponse.setMsg("You have successfully logged in.");
//				ajaxResponse.setRedirect("/admin/dashboard");											// 8- send redirect
//				ajaxResponse.setStatus(true);
//			} else {
//				ajaxResponse.setMsg("Mobile and password is wrong! Please try again.");
//				ajaxResponse.setStatus(false);
//			}
//
//		} else {
//			ajaxResponse.setMsg("Mobile and password is wrong! Please try again.");
//			ajaxResponse.setStatus(false);
//		}
		return ajaxResponse;
	}

	@RequestMapping(value="/addPlate",  method = RequestMethod.POST)
	public @ResponseBody AjaxResponse addPlate(@RequestParam("plateNumber") String plateNumber) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userDao.get(" WHERE mobile = "+auth.getName()).get(0);
		user.setPlateNumber(plateNumber);
		AjaxResponse ajaxResponse = new AjaxResponse();
		if(userDao.save(user)) {
			ajaxResponse.setStatus(true);
			if (user.getType() == 5)
				ajaxResponse.setRedirect("/admin/dashboard");
			else if (user.getType() == 1) {
				ajaxResponse.setRedirect("/user/dashboard");
			}
		}
		return ajaxResponse;
	}



	/**
	 * logout
	 */
	@RequestMapping("/logout")
	public void logout(HttpServletResponse response, ModelMap model, HttpServletRequest request, SessionStatus sessionStatus) throws IOException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
//		Cookie cookie = new Cookie("remember", null);
//		cookie.setMaxAge(0);
//		response.addCookie(cookie);
//		sessionStatus.setComplete();
//		HttpSession session = request.getSession();
//		session.removeAttribute("user_id");
		response.sendRedirect(request.getContextPath() + "/login");
	}



}
