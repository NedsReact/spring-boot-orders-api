package com.ned.demo.repositories;

import java.beans.JavaBean;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ned.demo.models.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {
	//CRUD
}
