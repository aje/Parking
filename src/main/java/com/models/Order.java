package com.models;

import java.util.Date;

public class Order {

	public Order() {
		// TODO Auto-generated constructor stub
	}

	private int id;
	private int price;
	private int type;
	private boolean status;
	private Lot lot;
	private User user;
	private Spot spot;
	private Date startTime;
	private Factor factore;
	private Date endTime;
	private Date created_at;
	private Date updated_at;

	/*
	* setters
	*/

	public void setPrice(int price){
		this.price = price;
	}
	public void setType(int type){
		this.type = type;
	}
	public void setStatus(boolean status){
		this.status = status;
	}
	public void setLot(Lot lot){
		this.lot = lot;
	}
	public void etUser(User user){
		this.user = user;
	}
	public void setSpot(Spot spot){
		this.spot = spot;
	}
	public void setStartTime(Date startTime){
		this.startTime = startTime;
	}
	public void setEndTime(Date endTime){
		this.endTime = endTime;
	}
	public void setCreated_at(Date created_at){
		this.created_at = created_at;
	}
	public void setUpdated_at(Date updated_at){
		this.updated_at = updated_at;
	}

	/*
	* getters
	*/

	public int getId(){
		return id;
	}
	public int getPrice(){
		return price;
	}
	public int getType(){
		return type;
	}
	public boolean getStatus(){
		return status;
	}
	public Lot getLot(){
		return lot;
	}
	public User getUser(){
		return user;
	}
	public Spot getSpot(){
		return spot;
	}
	public Date getStartTime(){
		return startTime;
	}
	public Date getEndTime(){
		return endTime;
	}
	public Date getCreated_at(){
		return created_at;
	}
	public Date getUpdated_at(){
		return updated_at;
	}

	public boolean save() {
		return true;
	}
	
	public boolean edit() {
		return true;
	}



}
