package com.dao;

import com.controllers.UserController;
import com.models.Lot;
import com.models.Spot;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("lotDao")
@Transactional
public class LotDaoImp implements LotDao {

    private  static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final SessionFactory sessionFactory;

    @Autowired
    public LotDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Boolean add(Lot lot) {
        try {
            Session session = this.sessionFactory.getCurrentSession();
            session.persist(lot);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean save(Lot lot, int id) {
        return null;
    }

    @Override
    public Boolean save(Lot lot) {
        return null;
    }

    @Override
    public Boolean delete(int id) {
        return null;
    }

    @Override
    public Lot get(int id) {
        return null;
    }

    @Override
    public List<Lot> get(String queryString) {
        Session session = this.sessionFactory.getCurrentSession();
        try {
            return session.createQuery("from lots " + queryString).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Spot> getSpots() {

        return null;
    }
}
