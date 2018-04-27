package com.garbarino.productos.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author Gaston
 *
 */
@Entity
@Table(name = "products", schema = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
	
	private String name;
	
	private String description;
	
	private double price;
	
	private Integer stock;
	
	private Brand brand;
	
//	@Transient
//	@Formula("SELECT AVG(rating) FROM product_ratings pr where pr.product_id=id")
//	private double averageRating;
//	
	public Product() {
		
	}
	
	/**
	 * 	Constructor de la Entity Product.
	 * 
	 * @param id
	 * @param name
	 * @param description
	 * @param price
	 * @param stock
	 * @param brand
	 */
	public Product(String id, String name, String description, double price, Integer stock, Brand brand) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.brand = brand;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (brand != other.brand)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return String.format(
				"Product [getId()=%s, getName()=%s, getBrand()=%s, getPrice()=%s, getDescription()=%s, getStock()=%s]",
				getId(), getName(), getBrand(), getPrice(), getDescription(), getStock());
	}

}
