package com.models;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "orders")
@DynamicUpdate
public class Order  implements Serializable {
	private static final long serialVersionUID = 1L;

	public Order() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer price;

//	@ManyToOne
//	@JoinColumn(name = "lot_id", nullable = false)
//	private Lot lot;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "spot_id", nullable = false)
	private Spot spot;

	@Column(name = "start_time")
	private Date startTime;

	@Column(name = "end_time", insertable=false)
	private Date endTime;

	@Column(insertable=false)
	private Integer status;

	@Column(insertable=false)
	private Integer type;

	@Column(name = "created_at", updatable = false, insertable=false)
	private java.util.Date createdAt;

	@Column(name = "updated_at", updatable = false, insertable = false)
	private java.util.Date updatedAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Spot getSpot() {
		return spot;
	}

	public void setSpot(Spot spot) {
		this.spot = spot;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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

	public Date getCreatedAt() {
		return createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	@Override
	public String toString() {
		return "Order{" +
				"id=" + id +
				", price=" + price +
				", startTime=" + startTime +
				", endTime=" + endTime +
				", status=" + status +
				", type=" + type +
				", createdAt=" + createdAt +
				", updatedAt=" + updatedAt +
				'}';
	}
}
