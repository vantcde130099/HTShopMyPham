package com.shop.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "fullname", columnDefinition = "nvarchar(50)")
	private String fullName;
	@Column(name = "Address", columnDefinition = "nvarchar(50)")
	private String address;
	@Column(columnDefinition = "char(10)")
	private String mobile;
	@OneToOne
	User user;
	
	@ManyToMany
	@JoinTable(name = "liked_products",
	joinColumns = @JoinColumn(name = "customer_id"),
	inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<Product> likedProducts;
	
	public Customer(String fullName, String address, String mobile, User user) {
		super();
		this.fullName = fullName;
		this.address = address;
		this.mobile = mobile;
		this.user = user;
	}
	public Customer() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}




	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}


	
	
}
