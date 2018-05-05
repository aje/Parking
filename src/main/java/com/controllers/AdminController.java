package com.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController{
    private  static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping("/dashboard")
	public ModelAndView showDashboard() {
		ModelAndView model = new ModelAndView("/admin/dashboard");
		return model;
	}
}
