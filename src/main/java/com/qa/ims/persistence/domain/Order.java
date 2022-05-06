package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Order {

	private Long order_id;
	private Long item_id;
	private String item_name;
	private double price;
	private Long id;
	private String surname;

	public Order(Long order_id, Long id) {
		this.setOrder_id(order_id);
		this.setId(id);
	}

	public Order(Long id) {
		this.setId(id);
	}

	public Order(Long order_id, Long item_id, String item_name, double price, Long id, String surname) {
		this.setOrder_id(order_id);
		this.setItem_id(item_id);
		this.setItem_name(item_name);
		this.setPrice(price);
		this.setId(id);
		this.setSurname(surname);
	}

	public Order(Long id, Long order_id, Long item_id) {
		this.setId(id);
		this.setOrder_id(order_id);
		this.setItem_id(item_id);
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public Long getItem_id() {
		return item_id;
	}

	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, item_id, item_name, order_id, price, surname);
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
		return Objects.equals(id, other.id) && Objects.equals(item_id, other.item_id)
				&& Objects.equals(item_name, other.item_name) && Objects.equals(order_id, other.order_id)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(surname, other.surname);
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", item_id=" + item_id + ", item_name=" + item_name + ", price=" + price
				+ ", id=" + id + ", surname=" + surname + "]";
	}
	

//	private Long order_id;
//	private Long customer_id;

//	public Order(Long customer_id) {
//		this.setCustomer_id(customer_id);
//	}
//	
//	public Order(Long order_id, Long customer_id) {
//		this.setOrder_id(order_id); 
//		this.setCustomer_id(customer_id);
//	}
//
//	public Long getOrder_id() {
//		return order_id;
//	}
//
//	public void setOrder_id(Long order_id) {
//		this.order_id = order_id;
//	}
//
//	public Long getCustomer_id() {
//		return customer_id;
//	}
//
//	public void setCustomer_id(Long customer_id) {
//		this.customer_id = customer_id;
//	}
//
//	@Override
//	public String toString() {
//		return "Order [order_id=" + order_id + ", customer_id=" + customer_id + "]";
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(customer_id, order_id);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Order other = (Order) obj;
//		return Objects.equals(customer_id, other.customer_id) && Objects.equals(order_id, other.order_id);
//	}

}
