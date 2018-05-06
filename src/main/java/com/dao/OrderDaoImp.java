package com.dao;

import com.models.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("orderDao")
@Transactional
public class OrderDaoImp implements OrderDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public OrderDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Boolean add(Order order) {
        try {
            Session session = this.sessionFactory.getCurrentSession();
            session.persist(order);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public Boolean save(Order order, int id) {
        return null;
    }

    @Override
    public Boolean save(Order order) {
        return null;
    }

    @Override
    public Boolean delete(int id) {
        return null;
    }

    @Override
    public Order get(int id) {
        return null;
    }

    @Override
    public List<Order> get(String queryString) {
        Session session = this.sessionFactory.getCurrentSession();
        try {
            return session.createQuery("from orders " + queryString).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Number countOrders(String queryString) {
        Session session = this.sessionFactory.getCurrentSession();
        return (Number) session.createQuery("SELECT count(*) from  orders " + queryString).uniqueResult();
    }
}
