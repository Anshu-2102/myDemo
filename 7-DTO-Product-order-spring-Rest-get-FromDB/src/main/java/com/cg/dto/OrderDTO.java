package com.cg.dto;

import com.cg.entity.Order;

public class OrderDTO {
	private int id;
	private String orderNo;
	private String date;
	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDTO(int id, String orderNo, String date) {
		super();
		this.id = id;
		this.orderNo = orderNo;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "OrderDTO [id=" + id + ", orderNo=" + orderNo + ", date=" + date + "]";
	}
	
	public static OrderDTO fromEntity(Order order)
	{
		return new OrderDTO(order.getId(),order.getOrderNo(),order.getDate());
	}
	
	public Order toEntity()
	{
		return new Order(this.id,this.orderNo,this.date);
	}

}
