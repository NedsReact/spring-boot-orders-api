package com.ned.demo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ned.demo.models.Order;

@Service
public class OrderService {

	private final Map<Long,Order> store=new HashMap<>();
	private long nextId=1;
	
	public List<Order> findAll()
	{
		return new ArrayList<>(store.values());
	}
	
	public Optional<Order> findById(Long id)
	{
		return Optional.ofNullable(store.get(id));
	}

	public Order create(Order order) 
	{
		order.setOrderId(nextId++);
		store.put(order.getOrderId(), order);
		return order;
	}
	
	public Optional<Order> update(Long id, Order updated)
	{
		if (!store.containsKey(id)) return Optional.empty();
		updated.setOrderId(id);
		store.put(id, updated);
		return Optional.of(updated);
	}
	
	public boolean delete(Long id)
	{
		return store.remove(id)!=null;
	}
	
	
}



