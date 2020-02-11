package com.qa.ims.persistence.domain;

public class OrderItem {
	
	private long id;
	private long orderId;
	private long itemId;
	
	public OrderItem(long id, long orderId, long itemId) {
		this.id = id;
		this.orderId = orderId;
		this.itemId = itemId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	
}
