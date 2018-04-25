package com.controllers;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.controllers.UserDao;
import com.models.User;

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
}
