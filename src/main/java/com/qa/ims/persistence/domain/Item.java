package com.qa.ims.persistence.domain;

public class Item {
	
	private long id;
	private String itemName;
	private float price;
	
	public Item(long id, String itemName, float price) {
		this.id = id;
		this.itemName = itemName;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
