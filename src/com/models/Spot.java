package com.models;

import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class Spot {
	
	@Autowired
	DataSource dataSource;

	public Spot() {
		// TODO Auto-generated constructor stub
	}
	private int id;
	private int type;
	private Lora loraSpot;
	private int floor;
	private int row;
	private boolean status;
	private SpotAddress spotAddress;
	private Date created_at;
	private Date updated_at;

	/*
	* setters
	*/
	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}
	
	public void setRow(int row) {
		this.row = row;
	}

	public void setLoraSpot(Lora loraSpot) {
		this.loraSpot = loraSpot;
	}

	public void setSpotLocation(SpotAddress spotAddress) {
		this.spotAddress = spotAddress;
	}

	/*
	* getters
	*/
	public boolean getStatus() {
		return status;
	}
	
	public int getId() {
		return id;
	}

	public int getType() {
		return type;
	}

	public int getFloor() {
		return floor;
	}

	public int getRow() {
		return row;
	}

	public Lora getLoraSpot() {
		return loraSpot;
	}

	public SpotAddress getSpotLocation() {
		return spotAddress;
	}

	/*
	* add and edit and get functions
	*/
	public Boolean save(Spot spot) {
		final String query = "INSERT INTO spots " + " (name) VALUES (?, ?)";
		JdbcTemplate jdb = new JdbcTemplate(dataSource);
		try {
			jdb.update(query, new Object[] { spot.getLoraSpot()});
		} catch (Exception e){
			return false;
		}
		return true;
	}

	public Boolean edit(Spot spot) {
		final String query = "UPDATE spots SET" + " name = ?, capacity = ? WHERE id LIKE "+ spot.getId();
		JdbcTemplate jdb = new JdbcTemplate(dataSource);
		try {
			jdb.update(query, new Object[] { spot.getLoraSpot()});
		} catch (Exception e){
			return false;
		}
		return true;
	}

	public List<Lot> get(String queryString) {
		String qry = "SELECT * FROM `spots` " + queryString;
		JdbcTemplate jdb = new JdbcTemplate(dataSource);
		return jdb.query(qry, new BeanPropertyRowMapper<Lot>(Lot.class));	
	}
}
