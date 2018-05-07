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
        if (session.getAttribute("authUser") == null) {
            return null;
        }
        return (AuthUser) session.getAttribute("authUser");
    }

}
