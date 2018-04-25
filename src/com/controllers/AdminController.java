package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.models.*;

@Controller
@RequestMapping("admin")
public class AdminController extends User {

	public AdminController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/dashboard")
	public ModelAndView showDashboard(){
//		String[] para = {"name" , "fsdf", "esm", "sdfsfd"};
//		saveDB(10, para, para);
		ModelAndView model = new ModelAndView("admin/dashboard");
		return model;
	}


	@RequestMapping("/users")
	public ModelAndView showUsers(){
		ModelAndView model = new ModelAndView("admin/users/users");
		return model;
	}

}
