package com.qa.ims;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerDao {

	public ArrayList<Customer> readAll() {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://34.76.133.172:3306/ims", "root", "root")) {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from customers");
				while (resultSet.next()) {
					Long id = resultSet.getLong("id");				
					String firstName = resultSet.getString("first_name");
					String surname = resultSet.getString("surname");
					Customer customer = new Customer(id, firstName, surname);
					customers.add(customer);
				}
				
	}
}
