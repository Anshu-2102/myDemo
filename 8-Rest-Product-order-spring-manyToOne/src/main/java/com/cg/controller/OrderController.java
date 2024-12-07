package com.cg.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Order;
import com.cg.service.IOrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	IOrderService orderService;
	
	@GetMapping("/orderlist")
	public List<Order> getAllOrder(Order o)
	{
		return orderService.findAll();
	}

	@GetMapping("/find/{id}")
	public Optional<Order> findOrdersById(@PathVariable int id)
	{
		return orderService.findOrderById(id);
	}
	
	@PostMapping("/create")
	public Order createOrders(@RequestBody Order o)
	{
		return orderService.createOrder(o);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id)
	{
		orderService.deleteOrder(id);
		return "deleted";
	}
	                     
    
	@PutMapping("/update")
	public Order update(@RequestBody Order o)
	{
		return orderService.update(o);
	}
}
