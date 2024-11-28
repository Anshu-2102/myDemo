package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Order;
import com.cg.repository.OrderRepository;

@Service
public class OrderService implements IOrderService{
	@Autowired
	OrderRepository orderRepository;

	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
		
	}

	@Override
	public Optional<Order> findOrderById(int orderId) {
		// TODO Auto-generated method stub
		return orderRepository.findById(orderId);
	}

	@Override
	public Order createOrder(Order o) {
		// TODO Auto-generated method stub
		return orderRepository.save(o);
	}

	@Override
	public boolean deleteOrder(int id) {
		// TODO Auto-generated method stub
		try {
			orderRepository.deleteById(id);
			System.out.println("deleted"+id);
			return true;
		}catch(Exception e)
		{
			return false;
		}
		
	}

	@Override
	public Order update(Order o) {
		// TODO Auto-generated method stub
		return orderRepository.save(o);
	}
	
}
