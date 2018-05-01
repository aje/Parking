package com.controllers;

import com.dao.UserDao;
import com.models.AuthUser;
import com.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;

@ControllerAdvice
public class GlobalController {
    @Autowired
    private HttpSession session;
    private AuthUser authUser = null;
    private  static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private  UserDao userDao;

    @ModelAttribute("authUser")
    public AuthUser getAuthUser() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        logger.info(auth.toString());
        if (session.getAttribute("authUser") == null && false) {
            // set session
//            User user = userDao.get(" WHERE mobile " + auth.getName()).get(0);
//            if (user != null) {
//                authUser.setFullname(user.getName());
//                authUser.setMobile(user.getMobile());
//                authUser.setType(user.getType());
//
//                session.setAttribute("user", authUser); // set session
//            }
//            logger.info(authUser.toString());
            return authUser;
        } else if (session.getAttribute("authUser") != null )  {
            return (AuthUser) session.getAttribute("authUser");
        }
        return null;
    }

}
