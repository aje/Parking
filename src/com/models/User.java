package com.models;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.*;

import javax.sql.DataSource;
import javax.validation.constraints.Pattern;

public class User {
	
	@Autowired
	DataSource dataSource;

	public User() {
		// TODO Auto-generated constructor stub
	}
	private int id;
	
	@Size(min=4, max=50) @Pattern(regexp="[^0-9]*")
	private String name;
	
	@Pattern(regexp="[^0-9]*")
	private String lastname;
	@javax.validation.constraints.Email
	private String email;
	@NumberFormat
	private Long mobile;
	private String password;
	private String plate;
	private Boolean status;
	private Boolean paid_status;
	private int order_id;
	private int type;
	private Date created_at;
	private Date updated_at;
	
	
	/**
	 * setters  
	 */
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPaid_status(Boolean paid_status) {
		this.paid_status = paid_status;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public void setType(int type) {
		this.type = type;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	
	/**
	 * getters  
	 */
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getLastname() {
		return lastname;
	}
	public String getEmail() {
		return email;
	}
	public Long getMobile() {
		return mobile;
	}
	public String getPassword() {
		return password;
	}
	public Boolean getStatus() {
		return status;
	}
	public int getType() {
		return type;
	}
	public Boolean getPaid_status() {
		return paid_status;
	}
	public int getOrder_id() {
		return order_id;
	}
	public String getPlate() {
		return plate;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}



	
	/**
	 * insert into database  
	 */
	public Boolean addUserToDB(User user) {
		final String query = "INSERT INTO users " + " (name, lastname, email, mobile, password) VALUES (?, ?, ?, ?, ? ,? )";
		JdbcTemplate jdb = new JdbcTemplate(dataSource);
		try {
			jdb.update(query, new Object[] { user.getName(),  user.getLastname(),  user.getEmail(),  user.getMobile(),  BCrypt.hashpw(user.getPassword(), BCrypt.gensalt())});
		} catch (Exception e){
			return false;
		}
		
		return true;		
	}
	
	/**
	 * edit user from database  
	 */
	public Boolean editUserInDB(User user) {
		final String query = "UPDATE users SET" + " name = ?, lastname = ?, email = ?, mobile = ? WHERE id LIKE "+ user.getId();
		JdbcTemplate jdb = new JdbcTemplate(dataSource);
		try {
			jdb.update(query, new Object[] { user.getName(),  user.getLastname(),  user.getEmail(),  user.getMobile()});
		} catch (Exception e){
			return false;
		}
		
		return true;		
	}
	
	/**
	 * delete user database  
	 */
	public Boolean deleteUserFromDB(int id, int flag) {
		final String query = "UPDATE users SET" + " status = "+flag+" WHERE id LIKE ?";
		JdbcTemplate jdb = new JdbcTemplate(dataSource);
		try {
			jdb.update(query, new Object[] { id });
		} catch (Exception e){
			return false;
		}
		
		return true;		
	}
	
	/**
	 * get users from database 
	 */
	public List<User> getUsersFromDB(String queryString) {
		String qry = "SELECT * FROM `users` " + queryString;
		JdbcTemplate jdb = new JdbcTemplate(dataSource);
		return jdb.query(qry, new BeanPropertyRowMapper<User>(User.class));				
	}

}
