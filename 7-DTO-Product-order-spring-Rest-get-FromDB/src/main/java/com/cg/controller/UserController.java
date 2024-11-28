package com.cg.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.OrderDTO;
import com.cg.dto.ProductDTO;
import com.cg.dto.UserDTO;
import com.cg.entity.Order;
import com.cg.entity.User;
import com.cg.exception.ResourceNotFoundException;
import com.cg.service.IUserService;
import com.cg.service.OrderService;
import com.cg.service.ProductService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@Autowired
	OrderService orderService;
	
	
	
	@GetMapping("/findorder/{id}")
	public List<OrderDTO> findOrdersById(@PathVariable int id)
	{
		return orderService.findOrderById(id)
				.stream()
				.map(OrderDTO::fromEntity)
				.collect(Collectors.toList());
	}
	
	@Autowired
	ProductService productService; 
	@GetMapping("/findproduct/{id}")
    public List<ProductDTO> getAllProductsById(@PathVariable int id) {
        return productService.findProductById(id)
                            .stream()
                            .map(ProductDTO::fromEntity) // Convert to ProductDTO
                            .collect(Collectors.toList());
    }
	@GetMapping("/userlist")
	public List<User> getAllUsers(User u)
	{
		return userService.findAll();
	}
	
	@GetMapping("/userlist1")
	public List<UserDTO> getAllUsers1(User u)
	{
		return userService.findAll()
				.stream()
				.map(UserDTO::fromEntity)
				.collect(Collectors.toList());
	}
	
	@GetMapping("/find/{id}")
	public Optional<User> findUsersById(@PathVariable int id)
	{
		return userService.findUserById(id);
	}
	
	@GetMapping("/find1/{id}")
	public List<UserDTO> findUsersById1(@PathVariable int id)
	{
		return userService.findUserById(id)
				.stream()
				.map(UserDTO::fromEntity)
				.collect(Collectors.toList());
	}
	@PostMapping("/create")
	public User createUsers(@RequestBody User u)
	{
		return userService.createUser(u);
	}
	
	@PostMapping("/create1")
	public UserDTO createUsers1(@Validated @RequestBody UserDTO userDTO)
	{
		User user=userDTO.toEntity();
		User createUser=userService.createUser(user);
		return userDTO.fromEntity(createUser);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id)
	{
		userService.deleteUser(id);
		return "deleted";
	}
	
	@DeleteMapping("/delete1/{id}")
    public UserDTO delete1(@PathVariable int id) throws ResourceNotFoundException {
       User user=userService.findUserById(id)  
                            .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));
        UserDTO userDTO=UserDTO.fromEntity(user);
		userService.deleteUser(id);
		return userDTO;
    } 
	@PutMapping("/update")
	public User update(@RequestBody User u)
	{
		return userService.update(u);
	}

}
