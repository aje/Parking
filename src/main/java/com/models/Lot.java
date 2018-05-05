package com.models;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "lots")
@DynamicUpdate
public class Lot {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(insertable=false)
	private int status;

	@Column(insertable=false)
	private int type;

	private int capacity;

	private String name;

	private String phone;

	@OneToOne(mappedBy = "lot", cascade = CascadeType.ALL)
	private AddressLot addressLot;

	@Column(name = "created_at", updatable = false, insertable=false)
	private Date createdAt;

	@Column(name = "updated_at", updatable = false, insertable = false)
	private Date updatedAt;

	public AddressLot getAddressLot() {
		return addressLot;
	}

	public void setAddressLot(AddressLot addressLot) {
		this.addressLot = addressLot;
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

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Lot{" +
				"id=" + id +
				", status=" + status +
				", type=" + type +
				", capacity=" + capacity +
				", name='" + name + '\'' +
				", phone='" + phone + '\'' +
				", address=" + addressLot +
				", createdAt=" + createdAt +
				", updatedAt=" + updatedAt +
				'}';
	}
}
