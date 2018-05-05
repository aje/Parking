package com.models;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.Date;

@Entity(name = "spots")
@DynamicUpdate
public class Spot  implements Serializable {
	private static final long serialVersionUID = 1L;

	public Spot() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "lora_serial")
	private Integer loraSerial;

	@ManyToOne
	@JoinColumn(name = "lot_id", nullable = false)
	private Lot lot;

	@Column(name = "used_count", insertable=false)
	private Integer userCount;


	@Column(insertable=false)
	private Integer status;

	@Column(insertable=false)
	private Integer type;

	@Column(name = "created_at", updatable = false, insertable=false)
	private java.util.Date createdAt;

	@Column(name = "updated_at", updatable = false, insertable = false)
	private java.util.Date updatedAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getLoraSerial() {
		return loraSerial;
	}

	public void setLoraSerial(Integer loraSerial) {
		this.loraSerial = loraSerial;
	}

	public Lot getLot() {
		return lot;
	}

	public void setLot(Lot lot) {
		this.lot = lot;
	}

	public Integer getUserCount() {
		return userCount;
	}

	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public java.util.Date getCreatedAt() {
		return createdAt;
	}

	public java.util.Date getUpdatedAt() {
		return updatedAt;
	}

	//	private AddressSpot spotAddress;
}
