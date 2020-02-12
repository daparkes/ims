package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.*;

public class OrderDao implements Dao<Order> {
	
	public static final Logger LOGGER = Logger.getLogger(OrderDao.class);

	private String connectionURL;
	private String username;
	private String password;
	
	public OrderDao(String username, String password) {
		this.connectionURL = "jdbc:mysql://localhost:3306/ims";
		this.username = username;
		this.password = password;
	}
	
	@Override
	public ArrayList<Order> readAll() {
		ArrayList<Order> orders = new ArrayList<Order>();
		try (Connection connection = DriverManager.getConnection(
				connectionURL, username, password)) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from orders"
					+ "join order_items on orders.id=order_items.order_id");
			while (resultSet.next()) {
				Long id = resultSet.getLong("id");				
				Long customerId = resultSet.getLong("customer_id");
				float totalPrice = resultSet.getFloat("total_price");
				int itemId = resultSet.getInt("itemId");
				Order order = new Order(id, customerId, totalPrice, itemId);
				orders.add(order);
			}
		} catch (Exception e) {	
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}	
		return orders;
	}
	
	Order latestOrder(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("id");
		Long customerId = resultSet.getLong("customer_id");
		float totalPrice = resultSet.getFloat("total_price");
		int itemId = resultSet.getInt("item_id");
		return new Order(id, customerId, totalPrice, itemId);
	}
	
	public Order readLatest() {
		try (Connection connection = DriverManager.getConnection(
				connectionURL, username, password);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(
					"select from orders order by id desc limit 1");) {
				resultSet.next();
				return latestOrder(resultSet);
				} catch (SQLException e) {
					LOGGER.debug(e.getStackTrace());
					LOGGER.error(e.getMessage());
				}
			return null;
			}

	
	@Override
	public Order create(Order order) {
		try (Connection connection = DriverManager.getConnection(
				connectionURL, username, password)) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into order_items(item_id, order_id)"
				+ " values (" + order.getItemId() + ", " + order.getId() + ")");
			statement.executeUpdate("insert into orders(customer_id,"
				+ "total_price)" + "values (" + order.getCustomerId() + ", "
				+ "(select sum(price) as Order_Cost from (select item_id from order_items "
				+ "where order_id =" + order.getId() + ") as items_in_order join items "
				+ "on items_in_order.item_id = items.id))");
			return order;
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	@Override
	public Order update(Order order) {
		try (Connection connection = DriverManager.getConnection(
				connectionURL, username, password)) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("update order_items set item_id="
				+ order.getItemId() + " where order_id=" + order.getId());
			statement.executeUpdate("update orders set customer_id=" + order.getCustomerId()
				+ ", total_price=(select sum(price) as Order_Cost from (select item_id"
				+ "from order_items where order_id =" + order.getId() 
				+ ") as items_in_order join items on items_in_order.item_id = "
				+ "items.id where id=" + order.getId() + ") where id=" + order.getId());
			return order;
		} catch (Exception e) {	
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;		
	}
	
	@Override
	public void delete(long id) {
		try (Connection connection = DriverManager.getConnection(
				connectionURL, username, password)) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("delete from order_items where order_id="
					+ id);
			statement.executeUpdate("delete from orders where id=" + id);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}
}
