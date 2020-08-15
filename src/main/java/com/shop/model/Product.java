package com.shop.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String productName;
	private String origin;
	private float weight;
	private String description;
	private float price;
	private int unitsInStock;
	@JoinColumn(name = "brand_id")
	@ManyToOne
	private Brand brand;
	@JoinColumn(name = "category_id")
	@ManyToOne
	private ProductCategory category;
	@OneToMany
	private List<Color> listColor;

	public Product() {
		super();
	}
	
	

	public Product(String productName, String origin, float weight, String description, float price, int unitsInStock,
			Brand brand, ProductCategory category, List<Color> listColor) {
		super();
		this.productName = productName;
		this.origin = origin;
		this.weight = weight;
		this.description = description;
		this.price = price;
		this.unitsInStock = unitsInStock;
		this.brand = brand;
		this.category = category;
		this.listColor = listColor;
	}



	public Product(String productName, String origin, float weight, String description, float price, int unitsInStock) {
		super();
		this.productName = productName;
		this.origin = origin;
		this.weight = weight;
		this.description = description;
		this.price = price;
		this.unitsInStock = unitsInStock;
	}



	public ProductCategory getCategory() {
		return category;
	}



	public void setCategory(ProductCategory category) {
		this.category = category;
	}






	public List<Color> getListColor() {
		return listColor;
	}



	public void setListColor(List<Color> listColor) {
		this.listColor = listColor;
	}



	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getUnitsInStock() {
		return unitsInStock;
	}
	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	
}
