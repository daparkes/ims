package com.qa.ims;

public class Customer {

	private String firstName;
	private String surname;
	private long id;
		
	public Customer (String firstName, String surname, long id) {
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
}
