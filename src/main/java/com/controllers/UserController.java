package com.controllers;

import com.models.User;
import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.util.List;

/**
 * @author Behrooz
 *
 */
@Controller
@SessionAttributes("name")
public class UserController extends User {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

//	/**
//	 * get cookie
//	 */
//	private String getUsernameFromCookie(HttpServletRequest request) {
//		for(Cookie cookie : request.getCookies()) {
//			if (cookie.getName().equals("mobile")) {
//				return cookie.getValue();
//			}
//		}
//		return null;
//	}

	@RequestMapping(value = "/users/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("user") User u) {
		this.userService.add(u);
		return "/admin/users/done";
	}

	/**
	 * show all users
	 */
	@RequestMapping("/admin/users/json")
	@Transactional
	public @ResponseBody List<User> showUsers() {
		return  userService.get("");
	}

	/*
	 * edit handler
	 */
	@RequestMapping(value="/users/editUser" , method = RequestMethod.POST)
	public ModelAndView editUser(@ModelAttribute("user") User user, BindingResult result) {
		ModelAndView model = new ModelAndView("home");
		if (result.hasErrors()) {
			model.addObject("msg", "Something is wrong here");
			return model;
		}
		if (this.userService.update(user, user.getId())) {
			model.addObject("msg", "successfully edited");
		}
		return model;
	}


	/**
	 * delete handler
	 */
	@RequestMapping(value="/{flag}/{id}" , method = RequestMethod.GET)
	public ModelAndView deleteOrRecoverUser(@PathVariable("id") int id, @PathVariable("flag") Boolean flag) {
		ModelAndView model = new ModelAndView("/admin/users/users");
        userService.delete(id, flag);
		return model;
	}
	
	/**
	 * show edit page
	 */
	
	@RequestMapping(value="/users/edit" , method = RequestMethod.POST)
	public ModelAndView edit(@ModelAttribute("id") String id) {	
		String qrr = " WHERE id LIKE " + id;
		ModelAndView model = new ModelAndView("users/editUser");
		model.addObject("user",userService.get(qrr));
		return model;
	}

}
