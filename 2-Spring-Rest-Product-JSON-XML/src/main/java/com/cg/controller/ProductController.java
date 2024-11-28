package com.cg.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.Product;
import com.cg.service.IProductService;

@RequestMapping("/api")
@RestController
public class ProductController {
	
	@Autowired
	IProductService productService;
	//@GetMapping(path="/products", produces = {MediaType.APPLICATION_XML_VALUE})
	@GetMapping(path="/products", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Product> getProducts()
	{
		return productService.findAll();
		
	}
	

}
