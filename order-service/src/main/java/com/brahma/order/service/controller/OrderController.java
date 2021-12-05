package com.brahma.order.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brahma.order.service.business.OrderBusiness;
import com.brahma.order.service.model.OrderRequest;
import com.brahma.order.service.model.OrderResponse;

@RestController
@RequestMapping(value="${base-url}")
public class OrderController {

	@Autowired
	private OrderBusiness orderBusiness;
	
	@PostMapping(value="/save")
	public OrderResponse saveOrder(@RequestBody final List<OrderRequest> orderRequest){
		return orderBusiness.saveOrder(orderRequest);
	}
	
	@GetMapping(value="/{id}")
	public OrderResponse findOrderById(@PathVariable long id) {
		return orderBusiness.findOrderById(id);
	}
}
