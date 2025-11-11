package com.ned.demo.models;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="orders") // table name in H2
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	
	@NotBlank(message="Customer name is required")
	@Size(max=100, message="Customer name must be maximum 100 characters long")
	private String customerName;
	
	@NotBlank(message="Product is required")
	private String product;
	
	@Min(value=1, message="Quantity must be at least 1")
	private int quantity;
	
	public Order(){ }
	
	public Order(Long orderId, String customerName,
			String product, int quantity)
	{
		this.orderId=orderId;
		this.customerName=customerName;
		this.product=product;
		this.quantity=quantity;		
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}



