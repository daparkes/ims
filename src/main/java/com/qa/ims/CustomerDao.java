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
					Customer customer = new Customer(firstName, surname, id);
					customers.add(customer);
				}
		} catch (Exception e) {
			
		}
	
		return customers;
	}
	
	public void create(Customer customer) {
		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://34.76.133.172:3306/ims", "root", "root")) {
				Statement statement = connection.createStatement();
				statement.executeUpdate("insert into customers(first_name, surname)"
						+ "values ('" + customer.getFirstName() + "','" +
						customer.getSurname() + "')");
		} catch (Exception e) {			
		}
	}
	
	public void update(Customer customer, String field, String newValue) {
		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://34.76.133.172:3306/ims", "root", "root")) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("update customers set " + field + "='" + newValue +
					"' where id=" + customer.getId());
		} catch (Exception e) {			
		}
	}
	
	public void delete(Customer customer) {
		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://34.76.133.172:3306/ims", "root", "root")) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("delete from customers where id="
				+ customer.getId());
		} catch (Exception e) {
			
		}
	}
}
