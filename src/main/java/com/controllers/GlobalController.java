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
import java.util.List;

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
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        logger.info(auth.getName());
        if (session.getAttribute("authUser") == null) {
            // set session
//            List<User> user = userDao.get(" WHERE mobile = " + auth.getName() );
//            if (!user.isEmpty()) {
//                authUser.setFullname(user.get(0).getName());
//                authUser.setMobile(user.get(0).getMobile());
//                authUser.setType(user.get(0).getType());
//
//                session.setAttribute("user", authUser); // set session
//            }
//            logger.info(authUser.toString());
//            return authUser;
//        } else if (auth.getName() == "anonymousUser" )  {
//            logger.info("null");
            return null;
        }
        return (AuthUser) session.getAttribute("authUser");
    }

}
