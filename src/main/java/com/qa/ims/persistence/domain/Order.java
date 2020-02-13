package com.qa.ims.persistence.domain;

public class Order {
	
	private Long id;
	private Long customerId;
	private Float totalPrice;
	private Long itemId;
	private Integer quantity;

	
	public Order(Long id, Long customerId, Float totalPrice, Long itemId, Integer quantity) {
		this.id = id;
		this.customerId = customerId;
		this.totalPrice = totalPrice;
		this.itemId = itemId;
		this.quantity = quantity;
	}
	
	public Order(Long customerId, Long itemId, Integer quantity) {
		this.customerId = customerId;		
		this.itemId = itemId;
		this.quantity = quantity;
	}
	
	public Order(Long id, Long customerId, Long itemId, Integer quantity) {
		this.id = id;
		this.customerId = customerId;
		this.itemId = itemId;
		this.quantity = quantity;
	}
	
	public Order(Long id) {
		this.id = id;
		}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Long getItemId() {
		return itemId;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}	

	@Override
	public String toString() {
		return "id=" + id + ", customerId=" + customerId + ", totalPrice=" + totalPrice + ", itemId=" + itemId
				+ ", quantity=" + quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((totalPrice == null) ? 0 : totalPrice.hashCode());
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
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (totalPrice == null) {
			if (other.totalPrice != null)
				return false;
		} else if (!totalPrice.equals(other.totalPrice))
			return false;
		return true;
	}
	
}
