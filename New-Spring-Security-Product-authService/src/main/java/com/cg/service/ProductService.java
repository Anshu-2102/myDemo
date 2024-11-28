package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.feign.AuthFeign;
import com.cg.model.Product;
import com.cg.model.UserInfo;
import com.cg.repository.ProductRepository;
import com.cg.repository.UserInfoRepository;

@Service
public class ProductService implements IProductService{
 
	@Autowired
	ProductRepository productrepo;

	@Autowired
    private UserInfoRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "user added to system ";
    }


	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return  productrepo.findAll();
	}



	@Override
	public Product createProduct(Product p) {
		// TODO Auto-generated method stub
		return  productrepo.save(p);
	}



	@Override
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		if (productrepo.existsById(id)) {
			productrepo.deleteById(id);
	         return true;
	    } else {
	    	 return false;
	    }
	}



	@Override
	public Product update(Product p) {
		// TODO Auto-generated method stub
		return productrepo.save(p);
	}



	


	@Override
	public Optional<UserInfo> getProductByName(String name) {
		// TODO Auto-generated method stub
		return repository.findByName(name);
	}


	@Override
	public Optional<Product> findProductById(int prodId) {
		// TODO Auto-generated method stub
		return productrepo.findById(prodId);
	}
	@Autowired (required = true)
	AuthFeign authFeign;
	
	@Override
	public boolean hasPermission(String token) {
		boolean flag=  authFeign.getTokenValidity(token);
		System.out.println("Flag Token:"+ flag);
		return flag;
	
	}
 
}
 