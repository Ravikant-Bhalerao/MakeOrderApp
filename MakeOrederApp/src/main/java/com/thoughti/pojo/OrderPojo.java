package com.thoughti.pojo;

import java.util.Date;

import com.thoughti.entity.Item;

public class OrderPojo {
	private Integer orderId;
	private Date orderDate;
	private String orderStatus;
	private java.util.List<Item> items;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public java.util.List<Item> getItems() {
		return items;
	}

	public void setItems(java.util.List<Item> items) {
		this.items = items;
	}
}
