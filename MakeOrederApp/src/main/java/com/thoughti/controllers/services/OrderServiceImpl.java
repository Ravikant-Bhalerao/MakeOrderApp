package com.thoughti.controllers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughti.entity.Item;
import com.thoughti.entity.OrderEntity;
import com.thoughti.pojo.OrderPojo;
import com.thoughti.repository.ItemRepo;
import com.thoughti.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private	ItemRepo itemRepo;
	@Override
	public boolean addOrder(OrderPojo orderPojo) {
		OrderEntity entity = new OrderEntity();
		
		entity.setOrderStatus(orderPojo.getOrderStatus());
		entity.setOrderDate(orderPojo.getOrderDate());
		entity.setItems(orderPojo.getItems());
		for (Item item : orderPojo.getItems()) {
			itemRepo.save(item);
		}
	
		if (orderRepository.save(entity).getOrderId() !=null) {
			return true;
		}
		return false;
	}

	@Override
	public OrderEntity getOrderById(Integer id) {
		java.util.Optional<OrderEntity> optional = orderRepository.findById(id);
		OrderEntity orderEntity = optional
				.get();
		return orderEntity ;
	}

	@Override
	public List<Item> getListOfOrders() {
		 List<Item> list = itemRepo.getOrderlist();
		
		return list;
	}

}
