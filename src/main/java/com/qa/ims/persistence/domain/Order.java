package com.qa.ims.persistence.domain;

public class Order {
	
	private long id;
	private long customerId;
	private float totalPrice;
	private int quantity;
	private int itemId;

	
	public Order(long id, long customerId, int quantity, float totalPrice) {
		this.id = id;
		this.customerId = customerId;
		this.totalPrice = totalPrice;
		this.quantity = quantity;
	}
	
	public Order(long customerId, int quantity, float totalPrice) {
		this.customerId = customerId;
		this.totalPrice = totalPrice;
	}
	
	public Order(long customerId, int quantity, int itemId) {
		this.customerId = customerId;
		this.quantity = quantity;
		this.itemId = itemId;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}	
}
