package com.cg.service;

import java.util.List;
import java.util.Optional;

import com.cg.model.Product;
import com.cg.model.UserInfo;

public interface IProductService {
	
	public List<Product> findAll();
	public Optional<Product> findProductById(int prodId);
	public Product createProduct(Product p);
	public boolean deleteProduct(int id);
	public Product update(Product p);
	Optional<UserInfo> getProductByName(String name);
	public boolean hasPermission(String token);
}
 