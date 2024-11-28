package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{
	public List<Product> findAllByName(String name);  //name should be same as attribute 
	//of the class eg-name and first letter is capital
	
	@Query
	("select count(*)from Product p where p.name=:name")
	public int getCountByName(String name);
}
