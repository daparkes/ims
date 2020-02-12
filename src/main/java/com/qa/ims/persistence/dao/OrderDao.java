package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.qa.ims.persistence.domain.*;

public class OrderDao implements Dao<Order> {

	@Override
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
			e.printStackTrace();
		}	
		return orders;
	}
	
	@Override
	public Order create(Order order) {
		try (Connection connection = DriverManager.getConnection(
			"jdbc:mysql://34.76.133.172:3306/ims", "root", "root")) {
			Statement statement = connection.createStatement();
//			statement.executeUpdate("insert into order_items(item_id, order_id)"
//				+ " values (" + orderItem.getItemId() + ", " + orderItem.getOrderId() + ")");
			statement.executeUpdate("insert into orders(customer_id,"
				+ "total_price)" + "values (" + order.getCustomerId() + ", (select sum(price) as "
				+ "Order_Cost from (select item_id from order_items "
				+ "where order_id =" + order.getId() + ") as items_in_order join items "
				+ "on items_in_order.item_id = items.id))");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return order;
	}
	
	@Override
	public Order update(Order order) {
		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://34.76.133.172:3306/ims", "root", "root")) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("update orders set customer_id=" + order.getCustomerId()
				+ ", total_price=(select sum(price) as Order_Cost from (select item_id"
				+ "from order_items where order_id =" + order.getId() + ") as items_in_order join items"
				+ "on items_in_order.item_id = items.id where id=" + order.getId()
				+ ") where id=" + order.getId());
			return order;
		} catch (Exception e) {	
			e.printStackTrace();
		}
		return null;		
	}
	
	@Override
	public void delete(long id) {
		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://34.76.133.172:3306/ims", "root", "root")) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("delete from orders where id=" + id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
