package com.controllers;

import com.dao.UserDao;
import com.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Behrooz
 *
 */
@Controller
@SessionAttributes("name")
public class UserController extends User {

	private  static final Logger logger = LoggerFactory.getLogger(UserController.class);

	private final UserDao userDao;

	@Autowired
	public UserController( UserDao userDao) {
		this.userDao = userDao;
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
	public String add(@Valid @ModelAttribute("user") User u, BindingResult result) {
		logger.info(u.toString());
		if (result.hasErrors()) {
			return "/auth/register";
		} else {
			this.userDao.add(u);
			return "/home";
		}
	}

	/**
	 * show all users
	 */
	@RequestMapping("/admin/users/json")
	@Transactional
	public @ResponseBody List<User> showUsers() {
		return  userDao.get("");
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
		if (this.userDao.save(user, user.getId())) {
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
        userDao.delete(id);
		return model;
	}
	
	/**
	 * show edit page
	 */
	
	@RequestMapping(value="/users/edit" , method = RequestMethod.POST)
	public ModelAndView edit(@ModelAttribute("id") String id) {	
		String qrr = " WHERE id LIKE " + id;
		ModelAndView model = new ModelAndView("users/editUser");
		model.addObject("user",userDao.get(qrr));
		return model;
	}

}
