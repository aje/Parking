package com.dao;

import com.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository("userDao")
public class UserDaoImp implements UserDao {

	private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdb;

	@Override
	@Transactional
	public Boolean add(User user) {
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
	public Boolean edit(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(user);
		return true;
//		String paras = "";
//		for (int i=0; i< para.length; i++) {
//			paras += para[i] + "= \"" + values[i] + "\"" ;
//			if (i < para.length - 1)
//				paras += ", ";
//		}
//		final String query = "UPDATE users SET "+paras+" WHERE id LIKE " + id;
//		JdbcTemplate jdb = new JdbcTemplate(dataSource);
	}

	@Override
	public List<User> getUser(String queryString) {
//		JdbcTemplate jdb = new JdbcTemplate(dataSource);
		String qry = "SELECT * FROM `users` " + queryString;
		return jdb.query(qry, new BeanPropertyRowMapper<User>(User.class));
	}

	@Override
	public User getOne(int id) {
//		JdbcTemplate jdb = new JdbcTemplate(dataSource);
		String qry = "SELECT * FROM `users` WHERE id LIKE  " + id;
		return jdb.queryForObject(qry, new BeanPropertyRowMapper<User>(User.class));
	}


	@Override
	public int isMobileExist(String mobile){
//		JdbcTemplate jdb = new JdbcTemplate(dataSource);
        String sql = "SELECT COUNT(*) FROM users WHERE mobile=?";
        return jdb.queryForObject(sql, new Object[] { mobile }, int.class);
    }
				
	/**
	 * delete user database  
	 */
	@Override
	public Boolean delete(int id, int flag) {
		final String query = "UPDATE users SET" + " status = "+flag+" WHERE id LIKE ?";
//		JdbcTemplate jdb = new JdbcTemplate(dataSource);
		try {
			jdb.update(query, new Object[] { id });
		} catch (Exception e){
			return false;
		}
		
		return true;		
	}
}
