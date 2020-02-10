package com.qa.ims;

public class Runner {
	public static void main(String[] args) {
		CustomerDao customerDao = new CustomerDao();
		System.out.println(customerDao.readAll());
	}
}
