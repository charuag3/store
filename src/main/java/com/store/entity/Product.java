package com.store.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@XmlRootElement
public class Product {
	@Id
	int id;
	String name;
	String category;
	String color;
	Double price;
	String dimension;
	Double weight;
	Double discount;
	@Column(name="unitsavailabe")
	int unitsAvailabe;
	String image;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public int getUnitsAvailabe() {
		return unitsAvailabe;
	}
	public void setUnitsAvailabe(int unitsAvailabe) {
		this.unitsAvailabe = unitsAvailabe;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", color=" + color + ", price="
				+ price + ", dimension=" + dimension + ", weight=" + weight + ", discount=" + discount
				+ ", unitsAvailabe=" + unitsAvailabe + ", image=" + image + "]";
	}

}
