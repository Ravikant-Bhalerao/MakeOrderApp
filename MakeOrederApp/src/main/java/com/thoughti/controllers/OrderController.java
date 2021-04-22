package com.thoughti.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thoughti.controllers.services.OrderService;
import com.thoughti.entity.Item;
import com.thoughti.entity.OrderEntity;
import com.thoughti.pojo.OrderPojo;

@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@PostMapping(path = "order/create", consumes = "application/json")
	public ResponseEntity<String> createOrder(@RequestBody OrderPojo pojo) {
		if (orderService.addOrder(pojo)) {
			return new ResponseEntity<String>("Order Added Successfully", HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Failed To Add", HttpStatus.BAD_REQUEST);

	}

	@GetMapping(path = "order/{order_id}", produces = "application/json")
	public ResponseEntity<OrderPojo> getOrderById(@PathVariable Integer order_id) {
		OrderEntity entity = orderService.getOrderById(order_id);
		OrderPojo pojo = new OrderPojo();
		pojo.setOrderId(entity.getOrderId());
		pojo.setOrderStatus(entity.getOrderStatus());
		pojo.setOrderDate(entity.getOrderDate());
		pojo.setItems(entity.getItems());
		if (entity.getOrderId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<OrderPojo>(pojo, HttpStatus.ACCEPTED);
	}

	@GetMapping(path = "/orders", produces = "application/json")
	public ResponseEntity<List<Item>> getListOfOrders() {
		List<Item> orders = orderService.getListOfOrders();
		return new ResponseEntity<List<Item>>(orders, HttpStatus.ACCEPTED);

	}

}
