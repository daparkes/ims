package com.qa.ims.persistence.domain;

public class User {
	
	private long id;
	private String username;
	
	public User(long id, String username) {
		this.id = id;
		this.username = username;
	}
	
	public User(String username) {
		this.username = username;
	}
	public long getId() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}
}
