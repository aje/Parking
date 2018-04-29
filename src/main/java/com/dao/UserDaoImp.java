package com.dao;

import com.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("userDao")
public class UserDaoImp implements UserDao {


	private final SessionFactory sessionFactory;

	@Autowired
	public UserDaoImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	* add user to database
	 */
	@Override
	@Transactional
	public Boolean addUser(User user) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
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
	@Transactional
	public Boolean editUser(User user, int id) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			User obj = session.get(User.class, id);
			if(user.getMobile() != null) obj.setMobile(user.getMobile());
			if(user.getName() != null) obj.setName(user.getName());
			if(user.getStatus() != true || user.getStatus() != false ) obj.setStatus(user.getStatus());
			session.update(obj);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<User> getUser(String queryString) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			return session.createQuery("from users " + queryString).list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@Transactional
	public User getOneUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.load(User.class, new Integer(id));

	}


	@Override
	@Transactional
	public Boolean isMobileExistUser(String mobile){
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from users WHERE MOBILE = " + mobile) != null;
	}
				
	/**
	 * delete user database  
	 */
	@Override
	@Transactional
	public Boolean deleteUser(int id, Boolean flag) {
		try {
			User user = new User();
			user.setStatus(flag);
			this.editUser(user, id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
