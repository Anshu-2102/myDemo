package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Product;
import com.cg.repository.ProductRepository;

@Service
public class ProductService implements IProductService {

	@Autowired
	ProductRepository productRepository;
	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
		
//		ArrayList<Product> products = new ArrayList<Product>();
//		products.add(new Product(100, "Laptop", 9000.0));  
//		products.add(new Product(101, "Smart TV", 60000.00));  
//		products.add(new Product(102, "Mobile",  9000.00));  
//		return products;
		
		
	}
	public Optional<Product> findProductById(int prodId)
	{
		return productRepository.findById(prodId);
	}
	@Override
	public Product createProduct(Product p) {
		// TODO Auto-generated method stub
		
		return productRepository.save(p);
	}
	

	@Override
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		try {
			productRepository.deleteById(id);
			System.out.println("deleted"+id);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	@Override
	public Product update(Product p) {
		// TODO Auto-generated method stub
		return productRepository.save(p);
	}
	
	@Override
	public List<Product> getProductByName(String name)
	{
		return productRepository.findAllByName(name);
	}
	@Override
	public int getCountByName(String name)
	{
		return productRepository.getCountByName(name) ;
		
	}
}
