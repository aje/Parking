package com.models;

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
	private Date endTime;
	private Date created_at;
	private Date updated_at;

	/*
	* setters
	*/

	public setPrice(int price){
		this.price = price;
	}
	public setType(int type){
		this.type = type;
	}
	public setStatus(boolean status){
		this.status = status;
	}
	public setLot(Lot lot){
		this.lot = lot;
	}
	public setUser(User user){
		this.user = user;
	}
	public setSpot(Spot spot){
		this.spot = spot;
	}
	public setStartTime(Date startTime){
		this.startTime = startTime;
	}
	public setEndTime(Date endTime){
		this.endTime = endTime;
	}
	public setCreated_at(Date created_at){
		this.created_at = created_at;
	}
	public setUpdated_at(Date updated_at){
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
