package com.models;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import java.util.Date;

@Entity(name = "users")
@DynamicUpdate
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Size(min=4, max=50) @Pattern(regexp="[^0-9]*")
	private String name;

	@NotNull
	private String mobile;

	@Column(name = "confirm_mobile")
	private Integer confirmMobile;

	@Column(name = "type", insertable=false)
	private int type;

	@javax.validation.constraints.Email
	private String email;

	private String password;

	@Column(name = "plate_number")
	private String plateNumber;

	@Column(name = "last_factor", insertable = false)
	private Integer lastFactor;

	@Column(name = "paid_status", insertable=false)
	private Boolean paidStatus;

	@Column(name = "order_count", insertable = false)
	private Integer orderCount;

	@Column(name = "status", insertable=false)
	private Boolean status;


	@Column(name = "created_at", updatable = false, insertable=false)
	private Date createdAt;


	@Column(name = "updated_at", updatable = false, insertable = false)
	private Date updatedAt;

	@Column(name = "avatar_link")
	private String avatarLink;

	@Column(name = "remember_token")
	private String rememberToken;

	private String role;

	private Integer lot;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getConfirmMobile() {
		return confirmMobile;
	}

	public void setConfirmMobile(Integer confirmMobile) {
		this.confirmMobile = confirmMobile;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public Integer getLastFactor() {
		return lastFactor;
	}

	public void setLastFactor(Integer lastFactor) {
		this.lastFactor = lastFactor;
	}

	public Boolean getPaidStatus() {
		return paidStatus;
	}

	public void setPaidStatus(Boolean paidStatus) {
		this.paidStatus = paidStatus;
	}

	public Integer getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(Integer orderCount) {
		this.orderCount = orderCount;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
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

	public String getAvatarLink() {
		return avatarLink;
	}

	public void setAvatarLink(String avatarLink) {
		this.avatarLink = avatarLink;
	}

	public String getRememberToken() {
		return rememberToken;
	}

	public void setRememberToken(String rememberToken) {
		this.rememberToken = rememberToken;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getLot() {
		return lot;
	}

	public void setLot(Integer lot) {
		this.lot = lot;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", mobile='" + mobile + '\'' +
				", confirmMobile=" + confirmMobile +
				", type=" + type +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", plateNumber='" + plateNumber + '\'' +
				", lastFactor=" + lastFactor +
				", paidStatus=" + paidStatus +
				", orderCount=" + orderCount +
				", status=" + status +
				", createdAt=" + createdAt +
				", updatedAt=" + updatedAt +
				", avatarLink='" + avatarLink + '\'' +
				", rememberToken='" + rememberToken + '\'' +
				", role='" + role + '\'' +
				", lot=" + lot +
				'}';
	}
}


