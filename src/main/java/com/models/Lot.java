package com.models;

import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Date;

public class Lot {
	
	@Autowired
	DataSource dataSource;

	public Lot() {
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

}
