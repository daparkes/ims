package com.qa.ims;

import com.qa.ims.persistence.dao.CustomerDao;

public class Runner {
	public static void main(String[] args) {
		CustomerDao customerDao = new CustomerDao();
		System.out.println(customerDao.readAll());
	}
}
