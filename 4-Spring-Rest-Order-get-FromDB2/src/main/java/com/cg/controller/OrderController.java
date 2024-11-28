package com.cg.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.Order;
import com.cg.service.IOrderService;

@RequestMapping("/api")
@RestController
public class OrderController {
	
//	//@GetMapping(path="/products", produces = {MediaType.APPLICATION_XML_VALUE})
	
	@Autowired
	IOrderService orderService;
	
	@GetMapping("/orders")
	public List<Order> getOrders()
	{
		return orderService.findAll();
	}
	

}
