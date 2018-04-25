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
	@javax.validation.constraints.Email
	private String email;
	private String mobile;
	private String password;
	private String plate;
	private int remember;
	private String avatar;
	private Boolean status;
	private Boolean paid_status;
	private Lot lot;
	private Factor last_factor;
	private int order_counts;
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
	public void setEmail(String email) {
		this.email = email;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPaid_status(Boolean paid_status) {
		this.paid_status = paid_status;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public void setRmember(int remember) {
		this.remember = remember;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public void setType(int type) {
		this.type = type;
	}
	public void setLot(Lot lot){
		this.lot = lot;
	};
	public void setLast_factor(Factor last_factor){
		this.last_factor = last_factor;
	};
	public void setOrder_counts(int order_counts){
		this.order_counts = order_counts;
	};
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
	public String getEmail() {
		return email;
	}
	public String getMobile() {
		return mobile;
	}
	public String getPassword() {
		return password;
	}
	public int getRemember() {
		return remember;
	}
	public String getAvatar() {
		return avatar;
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
	public String getPlate() {
		return plate;
	}
	public Lot getLot(){
		return lot;
	};
	public Factor getLast_factor(){
		return last_factor;
	};
	public int getOrder_counts(){
		return order_counts;
	};
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
		final String query = "INSERT INTO users " + " (name,  mobile, email, password) VALUES (?, ?, ?, ? )";
 		JdbcTemplate jdb = new JdbcTemplate(dataSource);
 		try {
 			jdb.update(query, new Object[] { user.getName(),   user.getMobile(), user.getEmail(),  BCrypt.hashpw(user.getPassword(), BCrypt.gensalt())});
 		} catch (Exception e){	
 			return false;
 		}	
		return true;		
	}

	public int isMobileExist(String mobile){
		JdbcTemplate jdb = new JdbcTemplate(dataSource);
        String sql = "SELECT COUNT(*) FROM users WHERE mobile=?";
        return jdb.queryForObject(sql, new Object[] { mobile }, int.class);
    }
	
	/**
	 * edit user from database  
	 */
	public Boolean editUserInDB(User user) {
		final String query = "UPDATE users SET" + " name = ?, email = ?, mobile = ? WHERE id LIKE "+ user.getId();
		JdbcTemplate jdb = new JdbcTemplate(dataSource);
		try {
			jdb.update(query, new Object[] { user.getName(),  user.getEmail(),  user.getMobile()});
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
