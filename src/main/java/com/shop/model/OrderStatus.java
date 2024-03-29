package com.shop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int code;
	private String description;
	
	public OrderStatus() {
		super();
	}
	public OrderStatus(String description) {
		super();
		this.description = description;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
