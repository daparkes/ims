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
	
	public long getId() {
		return id;
	}

	public long getCustomerId() {
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
	
	@Override
	public String toString() {
		return "id=" + id + ", customerId=" + customerId + ", totalPrice=" + totalPrice + ", itemId=" + itemId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (customerId ^ (customerId >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + itemId;
		result = prime * result + Float.floatToIntBits(totalPrice);
		return result;
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
		if (customerId != other.customerId)
			return false;
		if (id != other.id)
			return false;
		if (itemId != other.itemId)
			return false;
		if (Float.floatToIntBits(totalPrice) != Float.floatToIntBits(other.totalPrice))
			return false;
		return true;
	}
	
}
