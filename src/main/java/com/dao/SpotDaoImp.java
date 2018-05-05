package com.dao;

import com.controllers.UserController;
import com.models.Spot;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("spotDao")
@Transactional
public class SpotDaoImp implements SpotDao {

    private  static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final SessionFactory sessionFactory;

    @Autowired
    public SpotDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Boolean add(Spot spot) {
        try {
            Session session = this.sessionFactory.getCurrentSession();
            session.persist(spot);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean save(Spot spot, int id) {
        return null;
    }

    @Override
    public Boolean save(Spot spot) {
        return null;
    }

    @Override
    public Boolean delete(int id) {
        return null;
    }

    @Override
    public Spot get(int id) {
        return null;
    }

    @Override
    public List<Spot> get(String queryString) {
        Session session = this.sessionFactory.getCurrentSession();
        try {
            return session.createQuery("from spots " + queryString).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
