package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Order {

	private Long order_id;
	private Long customer_id;
	private Long item_id;
	private Long quantity;
	
	
	public Order(Long customer_id, Long item_id, Long quantity) {
		this.setCustomer_id(customer_id);
		this.setItem_id(item_id);
		this.setQuantity(quantity); 
	}
	
	public Order(Long order_id, Long customer_id, Long item_id, Long quantity) {
		this.setOrder_id(order_id); 
		this.setCustomer_id(customer_id);
		this.setItem_id(item_id);
		this.setQuantity(quantity); 
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	public Long getItem_id() {
		return item_id;
	}

	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", customer_id=" + customer_id + ", item_id=" + item_id + ", quantity="
				+ quantity + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(customer_id, item_id, order_id, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(customer_id, other.customer_id) && Objects.equals(item_id, other.item_id)
				&& Objects.equals(order_id, other.order_id) && Objects.equals(quantity, other.quantity);
	}
	

	
}
	
	
