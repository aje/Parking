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

    private final LotService lotService;
    private final OrderService orderService;
    private final UserService userService;

    @Autowired
    public DashboardController(LotService lotService, OrderService orderService, UserService userService) {
        this.lotService = lotService;
        this.orderService = orderService;
        this.userService = userService;
    }

    @RequestMapping("/dashboard")
    public ModelAndView showDashboard() {
        ModelAndView model = new ModelAndView("/dashboard/user-dashboard");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getByMobile(auth.getName());

        model.addObject("hoursCounts", orderService.countOrders(""));
        model.addObject("mostUsedLot", lotService.mostUsedLot(user));
        model.addObject("orderCounts", orderService.countOrders("WHERE status = 1  and user_id = " + user.getId()));
        return model;
    }
}
