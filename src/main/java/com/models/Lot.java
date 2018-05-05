package com.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "lots")
@DynamicUpdate
public class Lot  implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer  id;

	private static final long serialVersionUID = 1L;

	@Column(insertable=false)
	private int status;

	@Column(insertable=false)
	private int type;

	@Column(name = "created_at", updatable = false, insertable=false)
	private Date createdAt;

	@Column(name = "updated_at", updatable = false, insertable = false)
	private Date updatedAt;

	private int capacity;

	private String name;

	private String phone;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "address_lot_id")
	private AddressLot addressLot;

	@OneToMany(mappedBy = "lot")
	@JsonIgnore
	private Set<Spot> lotSpots = new HashSet<Spot>(0);

	public Set<Spot> getLotSpots() {
		return lotSpots;
	}

	public void setLotSpots(Set<Spot> lotSpots) {
		this.lotSpots = lotSpots;
	}

	public AddressLot getAddressLot() {
		return addressLot;
	}

	public void setAddressLot(AddressLot addressLot) {
		this.addressLot = addressLot;
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

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreatedAt() { return createdAt; }

	public Date getUpdatedAt() {
		return updatedAt;
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
				", createdAt=" + createdAt +
				", updatedAt=" + updatedAt +
				'}';
	}

	public Lot() {

	}
}
