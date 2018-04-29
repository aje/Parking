package com.controllers;

import com.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController{
    private  static final Logger logger = LoggerFactory.getLogger(UserController.class);
	public AdminController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/dashboard")
	public ModelAndView showDashboard(){
//		String[] para = {"name" , "fsdf", "esm", "sdfsfd"};
//		saveDB(10, para, para);
		ModelAndView model = new ModelAndView("/admin/dashboard");
		return model;
	}


	@RequestMapping("/users/all")
	public ModelAndView showUsers(){
        logger.info("inji hastim");
		ModelAndView model = new ModelAndView("/admin/users/users");
		return model;
	}

}
