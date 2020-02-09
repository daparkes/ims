package com.qa.ims;

public class Order {
	
	private long id;
	private String customer_id;
	private int quantity;
	private float total_price;
	
	public Order(long id, String customer_id, int quantity, float total_price) {
		this.id = id;
		this.customer_id = customer_id;
		this.quantity = quantity;
		this.total_price = total_price;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getTotal_price() {
		return total_price;
	}
	public void setTotal_price(float total_price) {
		this.total_price = total_price;
	}	
}
