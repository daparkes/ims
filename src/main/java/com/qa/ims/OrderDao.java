package com.qa.ims;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class OrderDao implements Dao<Order> {

	public ArrayList<Order> readAll() {
		ArrayList<Order> orders = new ArrayList<Order>();
		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://34.76.133.172:3306/ims", "root", "root")) {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from orders");
				while (resultSet.next()) {
					Long id = resultSet.getLong("id");				
					String customerId = resultSet.getString("customer_id");
					int quantity = resultSet.getInt("quantity");
					float totalPrice = resultSet.getFloat("total_price");
					Order order = new Order(id, customerId, quantity, totalPrice);
					orders.add(order);
				}
		} catch (Exception e) {			
		}	
		return orders;
	}
	
	public void create(Order order) {
		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://34.76.133.172:3306/ims", "root", "root")) {
				Statement statement = connection.createStatement();
				statement.executeUpdate("insert into orders(customerId,"
						+ "quantity, total_price)" + "values ('" 
						+ order.getCustomerId() + "','" + order.getQuantity()
						+ "','" + order.getTotalPrice());
		} catch (Exception e) {
		}
	}
	
	public void update(Order order, String field, String newValue) {
		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://34.76.133.172:3306/ims", "root", "root")) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("update orders set " + field + "='" + newValue +
					"' where id=" + order.getId());
		} catch (Exception e) {			
		}
	}
	
	public void delete(Order order) {
		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://34.76.133.172:3306/ims", "root", "root")) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("delete from orders where id="
				+ order.getId());
		} catch (Exception e) {
			
		}
	}
}
