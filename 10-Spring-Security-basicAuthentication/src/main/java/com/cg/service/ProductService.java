package com.cg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.model.Product;

@Service
public class ProductService implements IProductService {

	@Override
	public List<Product> findAll() {
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(new Product(100, "Laptop", 9000.0));  
		products.add(new Product(101, "Smart TV", 60000.00));  
		products.add(new Product(102, "Mobile",  9000.00));  
		return products;
		
		
	}

}
