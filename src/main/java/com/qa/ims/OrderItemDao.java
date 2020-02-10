package com.qa.ims;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class OrderItemDao implements Dao<OrderItem>{

	public ArrayList<OrderItem> readAll() {
		ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
		try (Connection connection = DriverManager.getConnection(
			"jdbc:mysql://34.76.133.172:3306/ims", "root", "root")) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from order_items");
			while (resultSet.next()) {
				long id = resultSet.getLong("id");				
				long orderId = resultSet.getLong("order_id");
				long itemId = resultSet.getLong("item_id");
				OrderItem orderItem = new OrderItem(id, orderId, itemId);
				orderItems.add(orderItem);
				}
		} catch (Exception e) {
		}	
		return orderItems;
	}
	
	public void create(OrderItem orderItem) {
		try (Connection connection = DriverManager.getConnection(
			"jdbc:mysql://34.76.133.172:3306/ims", "root", "root")) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into order_items("
				+ "order_id, item_id)" + "values ('" 
				+ orderItem.getOrderId() + "','" + orderItem.getItemId());
		} catch (Exception e) {
		}
	}
	
	public void update(OrderItem orderItem, String field, String newValue) {
		try (Connection connection = DriverManager.getConnection(
			"jdbc:mysql://34.76.133.172:3306/ims", "root", "root")) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("update order_items set " + field + "='" + newValue +
				"' where id=" + orderItem.getId());
		} catch (Exception e) {
		}
	}
	
	public void delete(OrderItem orderItem) {
		try (Connection connection = DriverManager.getConnection(
			"jdbc:mysql://34.76.133.172:3306/ims", "root", "root")) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("delete from orderItems where id=" + orderItem.getId());
		} catch (Exception e) {
		}
	}
}