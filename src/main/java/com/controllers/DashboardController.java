package com.controllers;

import com.models.User;
import com.services.LotService;
import com.services.OrderService;
import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController {

    private LotService lotService;
    private OrderService orderService;
    private UserService userService;

    @Autowired
    public DashboardController(LotService lotService, OrderService orderService, UserService userService) {
        this.userService = userService;
        this.lotService = lotService;
        this.orderService = orderService;
    }

    private User getUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userService.getByMobile(auth.getName());
    }

    @RequestMapping("/dashboard")
    public ModelAndView showDashboard() {
        ModelAndView model = new ModelAndView("/dashboard/user-dashboard");
        model.addObject("hoursCounts", orderService.countOrders(""));
        model.addObject("mostUsedLot", lotService.mostUsedLot(this.getUser()));
        model.addObject("orderCounts", orderService.countOrders("WHERE status = 1  and user_id = " + getUser().getId()));
        return model;
    }

    @RequestMapping("/user/settings")
    public ModelAndView showUserEdit() {
        ModelAndView model = new ModelAndView("/user/edit");
        return model;
    }

    @RequestMapping("/dashboard/parking-history")
    public ModelAndView showParkHistory() {
        ModelAndView model = new ModelAndView("/dashboard/park-history");
        model.addObject("orders", orderService.get("WHERE user_id  = " + getUser().getId()));
        return model;
    }

    @RequestMapping("/dashboard/lots-history")
    public ModelAndView showLotsHistory() {
        ModelAndView model = new ModelAndView("/dashboard/lots-history");
        return model;
    }

    @RequestMapping("/dashboard/payments-history")
    public ModelAndView showPaymentsHistory() {
        ModelAndView model = new ModelAndView("/dashboard/payment-history");
        return model;
    }

}
