package com.cg.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.User;
import com.cg.exception.BadRequestException;
import com.cg.exception.ResourceNotFoundException;
import com.cg.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	IUserService userService;
	

	@GetMapping("/userlist")
	public List<User> getAllUsers(User u)
	{
		return userService.findAll();
	}
	
	@GetMapping("/products1/{id}")
	Optional<User>findByProductIdFromDBWithException(@PathVariable int id) throws ResourceNotFoundException
	{	Optional<User> product = userService.findUserById(id);
	
    	product.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));
    	System.out.println(id);
    return product;	
	}
	
	@GetMapping("/find/{id}")
	public Optional<User> findUsersById(@PathVariable int id)
	{
		return userService.findUserById(id);
	}
	
	@PostMapping("/create")
	public User createUsers(@RequestBody User u) throws BadRequestException
	{
		if(u==null || u.getUsername()==null ||u.getPassword()==null||u.getUsername()==""||u.getPassword()=="")
		{
			throw new BadRequestException("Invalid user data");
		}
		return userService.createUser(u);
	}
	
	
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) throws ResourceNotFoundException
	{
		Optional<User> user = userService.findUserById(id);
    	user.orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + id));
		userService.deleteUser(id);
		return "deleted";
	}
	
	
	@PutMapping("/update")
	public User update(@RequestBody User u) throws BadRequestException
	{
		if(u==null || u.getUsername()==null ||u.getPassword()==null||u.getUsername()==""||u.getPassword()=="")
		{
			throw new BadRequestException("Invalid user data,cannot update");
		}
		return userService.update(u);
	}

}
