package com.cg.service;

import java.util.List;
import java.util.Optional;

import com.cg.model.Product;

public interface IProductService {
	
	public List<Product> findAll();
	public Optional<Product> findProductById(int prodId);
	public Product createProduct(Product p);
	public boolean deleteProduct(int id);
	public Product update(Product p);
	List<Product> getProductByName(String name);
	public int getCountByName(String name);
	
	public boolean hasPermission(String token);
}
 