package com.models;

import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Date;

public class Spot {
	
	@Autowired
	DataSource dataSource;

	public Spot() {
		// TODO Auto-generated constructor stub
	}
	private int id;
	private int type;
	private Lora loraSpot;
	private Lot lot;
	private boolean status;
	private AddressSpot spotAddress;
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

	public void setLot(Lot lot) {
		this.lot = lot;
	}
	
	public void setLoraSpot(Lora loraSpot) {
		this.loraSpot = loraSpot;
	}

	public void setSpotLocation(AddressSpot spotAddress) {
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

	public Lot getLot() {
		return lot;
	}


	public Lora getLoraSpot() {
		return loraSpot;
	}

	public AddressSpot getSpotLocation() {
		return spotAddress;
	}

	/*
	* add and edit and get functions
	*/

}
