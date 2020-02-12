package com.qa.ims.persistence.domain;

public class Order {
	
	private long id;
	private long customerId;
	private float totalPrice;
	private int itemId;

	
	public Order(long id, long customerId, float totalPrice, int itemId) {
		this.id = id;
		this.customerId = customerId;
		this.totalPrice = totalPrice;
		this.itemId = itemId;
	}
	
	public Order(long customerId, int itemId) {
		this.customerId = customerId;		
		this.itemId = itemId;
	}
	
	public Order(long id, long customerId, int itemId) {
		this.id = id;
		this.customerId = customerId;
		this.itemId = itemId;
	}
	
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
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
