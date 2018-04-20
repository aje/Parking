package com.models;

import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class Reserve {
	
	@Autowired
	DataSource dataSource;

	public Reserve() {
		// TODO Auto-generated constructor stub
	}
	private int id;
	private int status;
	private int type;
	private int capacity;
	private String name;
	private AddressLot address;
	private Date created_at;
	private Date updated_at;

	/*
	* setters
	*/
	public void setStatus(int status) {
		this.status = status;
	}


	public void setType(int type) {
		this.type = type;
	}


	public void setAddress(AddressLot address) {
		this.address = address;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	public void setName(String name) {
		this.name = name;
	}

	/*
	* getters
	*/
	public int getStatus() {
		return status;
	}
	
	public int getId() {
		return id;
	}

	public int getType() {
		return type;
	}

	public AddressLot getAddress() {
		return address;
	}

	public int getCapacity() {
		return capacity;
	}

	public String getName() {
		return name;
	}

	/*
	* add and edit and get functions
	*/
	public Boolean save() {

		final String query = "INSERT INTO lots " + " (name, capacity) VALUES (?, ?)";
		JdbcTemplate jdb = new JdbcTemplate(dataSource);
		address.save();
		try {
			jdb.update(query, new Object[] { getName(),  getCapacity()});
		} catch (Exception e){
			return false;
		}
		return true;
	}
	public Boolean edit() {
		final String query = "UPDATE lots SET" + " name = ?, capacity = ? WHERE id LIKE "+ getId();
		JdbcTemplate jdb = new JdbcTemplate(dataSource);
		try {
			jdb.update(query, new Object[] { getName(),  getCapacity()});
		} catch (Exception e){
			return false;
		}
		return true;
	}
	public List<Lot> get(String queryString) {
		String qry = "SELECT * FROM `lots` " + queryString;
		JdbcTemplate jdb = new JdbcTemplate(dataSource);
		return jdb.query(qry, new BeanPropertyRowMapper<Lot>(Lot.class));	
	}
}
