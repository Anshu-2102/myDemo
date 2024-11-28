package com.cg.dto;

import com.cg.model.Product;

public class ProductDTO {
	private int id;
	private String name;
	private double price;
	public ProductDTO() {
		super();
		
	}
	public ProductDTO(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	
	//to convert product entity to dto object
	public static ProductDTO fromEntity(Product product)
	{
		return new ProductDTO(product.getId(),product.getName(),product.getPrice());
	}
	
	//from dto to product object
	public Product toEntity()
	{
		return new Product(this.id,this.name,this.price);
	}
}
