package com.qa.ims.persistence.domain;

public class Customer {

	private String firstName;
	private String surname;
	private long id;
		
	public Customer (long id, String firstName, String surname) {
		this.firstName = firstName;
		this.surname = surname;
		this.id = id;
	}
	
	public Customer (String firstName, String surname) {
		this.firstName = firstName;
		this.surname = surname;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}		
	
	public String toString() {
		return "id:" + id + " first name:" + firstName + " surname:" + surname;
	}
}
