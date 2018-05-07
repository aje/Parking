package com.services;

import com.dao.OrderDao;
import com.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private final OrderDao orderDao;

    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public boolean add(Order order) {
        return this.orderDao.add(order);
    }

    public boolean save(Order order, int id) {
        return this.orderDao.save(order, id);
    }

    public Boolean delete(int id) {
        return this.orderDao.delete(id);
    }

    public List<Order> get(String queryString) {
        return this.orderDao.get(queryString);
    }

    public Order get(int id) {
        return this.orderDao.get(id);
    }

    public Number countOrders(String queryString) {
        return this.orderDao.countOrders(queryString);
    }
}
