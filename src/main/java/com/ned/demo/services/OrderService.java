package com.ned.demo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ned.demo.models.Order;
import com.ned.demo.repositories.OrderRepository;

@Service
public class OrderService {	
	
	private final OrderRepository repository;
	
	public OrderService(OrderRepository repository)
	{
		this.repository=repository;
	}
	
	public List<Order> findAll()
	{
		return this.repository.findAll();
	}
	
	public Optional<Order> findById(Long id)
	{
		return this.repository.findById(id);
	}

	 public Order create(Order order) 
	 {
	        // ensure ID is null so JPA generates it
	        order.setOrderId(null);
	        return this.repository.save(order);
	 }
	
	public Optional<Order> update(Long id, Order updated)
	{
		 if (!repository.existsById(id)) {
	            return Optional.empty();
	        }
	        updated.setOrderId(id);
	        Order saved = repository.save(updated);
	        return Optional.of(saved);
	}
	
	public boolean delete(Long id)
	{
		if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
	}
	
	
}




