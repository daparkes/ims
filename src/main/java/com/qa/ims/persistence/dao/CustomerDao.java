package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.qa.ims.persistence.domain.Customer;
import org.apache.log4j.Logger;

public class CustomerDao implements Dao<Customer> {
	
	public static final Logger LOGGER = Logger.getLogger(CustomerDao.class);
	
	/**
	 * Reads all records from the table.
	 */
	@Override
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
		} catch (Exception e) {		
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}	
		return customers;
	}
		
	/**
	 * Creates a record in the database. 
	 */
	@Override
	public Customer create(Customer customer) {
		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://34.76.133.172:3306/ims", "root", "root")) {
				Statement statement = connection.createStatement();
				statement.executeUpdate("insert into customers(first_name, surname)"
						+ "values ('" + customer.getFirstName() + "','" +
						customer.getSurname() + "')");
		} catch (Exception e) {			
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return customer;
	}
	
	/**
	 * Modifies a record in the database.
	 */
	@Override
	public Customer update(Customer customer) {
		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://34.76.133.172:3306/ims", "root", "root")) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("update customers set first_name ='"
					+ customer.getFirstName() + "', surname ='"
					+ customer.getSurname() + "' where id =" + customer.getId());
			return customer;
		} catch (Exception e) {	
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	/**
	 * Deletes a record in the database.
	 */
	@Override
	public void delete(long id) {
		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://34.76.133.172:3306/ims", "root", "root")) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("delete from customers where id="
				+ id);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}
}
