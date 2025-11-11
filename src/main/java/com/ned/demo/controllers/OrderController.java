package com.ned.demo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ned.demo.models.Order;
import com.ned.demo.services.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/orders")
public class OrderController {
		
	private final OrderService service;
	
	public OrderController(OrderService orderService)
	{
		this.service=orderService;
	}

	@GetMapping
	public List<Order> getAll()
	{
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> getOrder(@PathVariable Long id)
	{
		return service.findById(id).map(ResponseEntity::ok) // 200 + body
	            .orElse(ResponseEntity.notFound().build()); // 404
	}
	
	@PostMapping
	public ResponseEntity<Order> create(@Valid @RequestBody Order order)
	{
		Order created= service.create(order);
		return ResponseEntity.ok(created);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Order> update(@PathVariable Long id,
			@Valid @RequestBody Order order)
	{
		return service.update(id, order)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id)
	{
		boolean removed=service.delete(id);
		return removed ? ResponseEntity.noContent().build()
				: ResponseEntity.notFound().build();
	}
	
	
	
}
