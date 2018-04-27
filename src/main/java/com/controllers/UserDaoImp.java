package com.controllers;

import com.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository()
public class UserDaoImp implements UserDao {
	@Autowired DataSource dataSource;
	@Autowired JdbcTemplate jdb;

	@Override
	public List<User> getUser(String queryString) {
		JdbcTemplate jdb = new JdbcTemplate(dataSource);
		String qry = "SELECT * FROM `users` " + queryString;
		return jdb.query(qry, new BeanPropertyRowMapper<User>(User.class));	
	}
	
	/**
	 * change user database  
	 */
	@Override
	public Boolean edit(int id, String[] para, String[] values) {
		String paras = "";
		for (int i=0; i< para.length; i++) {
			paras += para[i] + "= \"" + values[i] + "\"" ;
			if (i < para.length - 1)
				paras += ", ";	
		}
		System.out.println(paras);
		final String query = "UPDATE users SET "+paras+" WHERE id LIKE " + id;
		JdbcTemplate jdb = new JdbcTemplate(dataSource);
		try {
			jdb.update(query);
			
		} catch (Exception e){
			return false;
		}
		return true;		
	}

	@Override
	public User getOne(int id) {
		JdbcTemplate jdb = new JdbcTemplate(dataSource);
		String qry = "SELECT * FROM `users` WHERE id LIKE  " + id;
		return jdb.queryForObject(qry, new BeanPropertyRowMapper<User>(User.class));	
	}

	/**
	 * insert into database  
	 */
	@Override
	public Boolean addUserToDB(User user) {
		final String query = "INSERT INTO users " + " (name,  mobile, email, password) VALUES (?, ?, ?, ? )";
 		JdbcTemplate jdb = new JdbcTemplate(dataSource);
 		try {
 			jdb.update(query, new Object[] { user.getName(),   user.getMobile(), user.getEmail(),  BCrypt.hashpw(user.getPassword(), BCrypt.gensalt())});
 		} catch (Exception e){	
 			return false;
 		}	
		return true;		
	}

	@Override
	public int isMobileExist(String mobile){
		JdbcTemplate jdb = new JdbcTemplate(dataSource);
        String sql = "SELECT COUNT(*) FROM users WHERE mobile=?";
        return jdb.queryForObject(sql, new Object[] { mobile }, int.class);
    }
				
	/**
	 * delete user database  
	 */
	@Override
	public Boolean delete(int id, int flag) {
		final String query = "UPDATE users SET" + " status = "+flag+" WHERE id LIKE ?";
		JdbcTemplate jdb = new JdbcTemplate(dataSource);
		try {
			jdb.update(query, new Object[] { id });
		} catch (Exception e){
			return false;
		}
		
		return true;		
	}
}
