package com.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "address_lot")
@DynamicUpdate
public class AddressLot {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(insertable=false)
	private int status;

	@Column(insertable=false)
	private int type;

	@Column(name = "full_address")
	private String fullAddress;

	private String city;

	private String province;

	@Column(name = "location_x")
	private String locationX;

	@Column(name = "location_y")
	private String locationY;

	@Column(name = "created_at", updatable = false, insertable=false)
	private Date createdAt;


	@Column(name = "updated_at", updatable = false, insertable = false)
	private Date updatedAt;

	@OneToOne
	@JsonIgnore
	private Lot lot;

	public Lot getLot() {
		return lot;
	}

	public void setLot(Lot lot) {
		this.lot = lot;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getLocationX() {
		return locationX;
	}

	public void setLocationX(String locationX) {
		this.locationX = locationX;
	}

	public String getLocationY() {
		return locationY;
	}

	public void setLocationY(String locationY) {
		this.locationY = locationY;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	@Override
	public String toString() {
		return "AddressLot{" +
				"id=" + id +
				", status=" + status +
				", type=" + type +
				", fullAddress='" + fullAddress + '\'' +
				", city='" + city + '\'' +
				", province='" + province + '\'' +
				", locationX='" + locationX + '\'' +
				", locationY='" + locationY + '\'' +
				", createdAt=" + createdAt +
				", updatedAt=" + updatedAt +
				'}';
	}
}
