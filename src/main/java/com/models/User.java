package com.models;

import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

public class User {

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
	private String remember_token;
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
	public void setRmember(String remember_token) {
		this.remember_token = remember_token;
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
	public String getRemember() {
		return remember_token;
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
	
}
