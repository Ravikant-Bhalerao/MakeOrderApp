package com.thoughti.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ORDERS")
public class OrderEntity {

	@Id
	@GeneratedValue(
	    strategy = GenerationType.SEQUENCE,
	    generator = "seq_order"
	)
	@SequenceGenerator(
	    name = "seq_order",
	    allocationSize = 1
	)
	private Integer orderId;
	@Temporal(TemporalType.DATE)
	private Date orderDate;
	private String orderStatus;
	@OneToMany()
    @JoinColumn(name = "OID")
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
