package com.controllers;

import com.dao.LotDao;
import com.services.OrderService;
import com.services.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController{

	private final LotDao lotDao;
	private final SpotService spsrv;
	private final OrderService orderService;

	@Autowired
	public AdminController(LotDao lotDao, SpotService spsrv, OrderService orderService) {
		this.lotDao = lotDao;
		this.spsrv = spsrv;
		this.orderService = orderService;
	}

	@RequestMapping("/dashboard")
	public ModelAndView showDashboard() {
		ModelAndView model = new ModelAndView("/admin/dashboard");
		model.addObject("lotsCount",  this.lotDao.countLots(" WHERE status = 1"));
		model.addObject("spotsCount", spsrv.countSpots(""));
		model.addObject("countOrders", orderService.countOrders(""));
		return model;
	}
}
