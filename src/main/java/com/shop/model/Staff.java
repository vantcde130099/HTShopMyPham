package com.shop.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Staff {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "fullname", columnDefinition = "nvarchar(50)")
	private String fullName;
	@Column(columnDefinition = "char(10)")
	private String mobile;
	@Column(columnDefinition = "nvarchar(50)")
	private String address;
	@Column(name = "startedDate")
	@Temporal(TemporalType.DATE)
	private Date startedDate;
	@OneToOne
	User user;
	public Staff() {
		super();
	}

	public int getId() {
		return id;
	}


	
	public Staff(String fullName, String mobile, String address, Date startedDate) {
		super();
		this.fullName = fullName;
		this.mobile = mobile;
		this.address = address;
		this.startedDate = startedDate;
	}
	
	

	public Staff(String fullName, String mobile, String address, Date startedDate, User user) {
		super();
		this.fullName = fullName;
		this.mobile = mobile;
		this.address = address;
		this.startedDate = startedDate;
		this.user = user;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getStartedDate() {
		return startedDate;
	}

	public void setStartedDate(Date startedDate) {
		this.startedDate = startedDate;
	}

	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}

