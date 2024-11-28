package com.cg.service;

import java.util.List;
import java.util.Optional;

import com.cg.entity.Order;

public interface IOrderService {
	public List<Order> findAll();
	public Optional<Order> findOrderById(int orderId);
	public Order createOrder(Order o);
	public boolean deleteOrder(int id);
	public Order update(Order o);
}
