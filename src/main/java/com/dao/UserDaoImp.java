package com.dao;

import com.controllers.UserController;
import com.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("userDao")
@Transactional
public class UserDaoImp implements UserDao {

    private  static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private final SessionFactory sessionFactory;

	@Autowired
	public UserDaoImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	* add user to database
	 */
	@Override
	public Boolean add(User user) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
//			user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
			session.persist(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * change user database
	 */
	@Override
	public Boolean save(User user, int id) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			User obj = session.get(User.class, id);
			if(user.getMobile() != null) obj.setMobile(user.getMobile());
            if(user.getConfirmMobile() != null) obj.setConfirmMobile(user.getConfirmMobile());
			if(user.getName() != null) obj.setName(user.getName());
			if(user.getStatus() != true || user.getStatus() != false ) obj.setStatus(user.getStatus());
			if(user.getType() != null) obj.setType(user.getType());
			if(user.getEmail() != null) obj.setEmail(user.getEmail());
			if(user.getPassword() != null) obj.setPassword(user.getPassword());
			if(user.getPlateNumber() != null) obj.setPlateNumber(user.getPlateNumber());
			if(user.getLastFactor() != null) obj.setLastFactor(user.getLastFactor());
			if(user.getPaidStatus() != null) obj.setPaidStatus(user.getPaidStatus());
			if(user.getOrderCount() != null) obj.setOrderCount(user.getOrderCount());
			if(user.getAvatarLink() != null) obj.setAvatarLink(user.getAvatarLink());
			if(user.getRememberToken() != null) obj.setRememberToken(user.getRememberToken());
			session.update(obj);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * insert user database
	 */
	@Override
	public Boolean save(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.update(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> get(String queryString) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			return session.createQuery("from users " + queryString).list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public User get(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.load(User.class, new Integer(id));

	}


	@Override
	public Boolean isMobileExist(String mobile){
		Session session = this.sessionFactory.getCurrentSession();
		if (session.createQuery("from users WHERE mobile = " + mobile).list().isEmpty())
		    return false;
		else
		    return true;
	}


    /**
	 * delete user database  
	 */
	@Override
	public Boolean delete(int id) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			User user = session.get(User.class, id);
			user.setStatus(!user.getStatus());
			session.update(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
