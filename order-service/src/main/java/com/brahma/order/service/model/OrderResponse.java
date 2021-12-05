package com.brahma.order.service.model;

import java.util.Date;
import java.util.List;

public class OrderResponse {
	
	private long id;
	private double amount;
	private Date orderDate;
	private int noOfBooks;
	private int status;
	private List<OrderDetails> orderDetailsList;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getNoOfBooks() {
		return noOfBooks;
	}
	public void setNoOfBooks(int noOfBooks) {
		this.noOfBooks = noOfBooks;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public List<OrderDetails> getOrderDetailsList() {
		return orderDetailsList;
	}
	public void setOrderDetailsList(List<OrderDetails> orderDetailsList) {
		this.orderDetailsList = orderDetailsList;
	}
}
