package com.thoughti.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thoughti.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Serializable> {

	

}
