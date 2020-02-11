package com.qa.ims.persistence.domain;

public class Order {
	
	private long id;
	private String customerId;
	private int quantity;
	private float totalPrice;

	
	public Order(long id, String customerId, int quantity, float totalPrice) {
		this.id = id;
		this.customerId = customerId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}	
}
