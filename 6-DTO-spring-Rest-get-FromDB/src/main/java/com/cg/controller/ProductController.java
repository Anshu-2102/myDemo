package com.cg.controller;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.ProductDTO;
import com.cg.exception.ResourceNotFoundException;
import com.cg.model.Product;
import com.cg.service.IProductService;

@RequestMapping("/api")
@RestController
public class ProductController {
	
	@Autowired
	IProductService productService;
	//@GetMapping(path="/products", produces = {MediaType.APPLICATION_XML_VALUE})
//	@GetMapping("/products")
//	public List<Product> getProducts()
//	{
//		return productService.findAll();
//		
//	}
	
	@GetMapping("/products")
    public List<ProductDTO> getAllProducts() {
        return productService.findAll()
                            .stream()
                            .map(ProductDTO::fromEntity)  // Convert to ProductDTO
                            .collect(Collectors.toList());
    }
	
	//http://localhost:9090/api/products/101
//	@GetMapping("/products/{id}")
//	public Optional<Product>getProductById(@PathVariable int id)
//	{
//		return productService.findProductById(id);
//	}
	
	@GetMapping("/products/{id}")
    public List<ProductDTO> getAllProductsById(@PathVariable int id) {
        return productService.findProductById(id)
                            .stream()
                            .map(ProductDTO::fromEntity) // Convert to ProductDTO
                            .collect(Collectors.toList());
    }
	
	//http://localhost:9090/api/products/myProduct?id=101 use when sending data through form
//	@GetMapping("/products/myProduct")
//	public Optional<Product>getProductId(@RequestParam int id)
//	{
//		return productService.findProductById(id);
//	}
	
	@GetMapping("/products1/{id}")
	Optional<Product>findByProductIdFromDBWithException(@PathVariable int id) throws ResourceNotFoundException
	{	Optional<Product> product = productService.findProductById(id);
	
    	product.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));
    	System.out.println(id);
    return product;	
	}
	
//	@PostMapping("/products1")
//	public Product createmyProduct(@RequestBody Product p)
//	{
//		return productService.createProduct(p);
//	}
	
	@PostMapping("/products1")
    public ProductDTO createProduct(@Validated @RequestBody ProductDTO productDTO) {
		Product product=productDTO.toEntity();
        Product createProduct=productService.createProduct(product);
        return productDTO.fromEntity(createProduct);
    }
	
	@DeleteMapping("/delete/{id}")
	public String myDelete(@PathVariable int id)
	{
		if(productService.deleteProduct(id))
		{
			return "deleted";
		}else
		{
			return "not found";
		}
		
	}
	
	@PutMapping("/update")
	public Product myUpdate(@RequestBody Product p)
	{
		return productService.update(p);
		
	}
	
	@GetMapping("/byname/{name}")
	public List<Product> getProdByName(@PathVariable String name)
	{
		return productService.getProductByName(name);
	}
	@GetMapping("/count/{name}")
	public int getCountByNames(@PathVariable String name)
	{
		return productService.getCountByName(name);
	}

}