package com.thoughti.controllers.services;

import java.util.List;

import com.thoughti.entity.Item;
import com.thoughti.entity.OrderEntity;
import com.thoughti.pojo.OrderPojo;

public interface OrderService {
	boolean addOrder(OrderPojo orderPojo);

	OrderEntity getOrderById(Integer id);

	List<Item> getListOfOrders();
}
