package com.cg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.model.Order;
import com.cg.repository.OrderRepository;

@Service
public class OrderService implements IOrderService {

	@Autowired
	OrderRepository orderRepository;
	@Override
	public List<Order> findAll() {
		
		
//		ArrayList<Order> order = new ArrayList<Order>();
//		order.add(new Order(100, "Laptop", 9000.0));  
//    	order.add(new Order(101, "Smart TV", 60000.00));  
//		order.add(new Order(102, "Mobile",  9000.00));  
		return orderRepository.findAll();
		
	}

}
