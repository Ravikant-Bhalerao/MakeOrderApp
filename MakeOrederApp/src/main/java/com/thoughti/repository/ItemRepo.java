package com.thoughti.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thoughti.entity.Item;
import com.thoughti.entity.OrderEntity;

public interface ItemRepo extends JpaRepository<Item, Serializable> {
	@Query("SELECT * FROM ITEM " + "LEFT JOIN  ORDERS ON orderId=:oid")
	List<Item> getOrderlist();
}
