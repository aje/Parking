package com.dao;

import com.models.Order;

import java.util.List;


public interface OrderDao {

    Boolean add(Order order);

    Boolean save(Order order, int id);

    Boolean save(Order order);

    Boolean delete(int id);

    Order get(int id);

    List<Order> get(String queryString);

    Number countOrders(String queryString);
}
