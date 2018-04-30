package com.controllers;

import com.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView modelandview = new ModelAndView("/home");
		return modelandview;
	}

	@RequestMapping("/registerf")
	public ModelAndView showRegister() {
		User user = new User();
		ModelAndView mv = new ModelAndView("/auth/register");
		mv.addObject("user", user);
		return mv;
	}
}