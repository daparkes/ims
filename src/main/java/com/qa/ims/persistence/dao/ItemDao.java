package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.qa.ims.persistence.domain.*;

public class ItemDao implements Dao<Item>{

	public static final Logger LOGGER = Logger.getLogger(ItemDao.class);
	
	private String connectionURL;
	private String username;
	private String password;
	
	public ItemDao(String username, String password) {
		this.connectionURL = "jdbc:mysql://34.76.133.172:3306/ims";
		this.username = username;
		this.password = password;
	}
	
	/**
	 * Returns a complete list of all records in the table.
	 */
	@Override
	public ArrayList<Item> readAll() {
		ArrayList<Item> items = new ArrayList<Item>();
		try (Connection connection = DriverManager.getConnection(
				connectionURL, username, password)) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from items");
			while (resultSet.next()) {
				Long id = resultSet.getLong("id");				
				String itemName = resultSet.getString("item_name");
				float price = resultSet.getFloat("price");
				Item item = new Item(id, itemName, price);
				items.add(item);
				}
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}	
		return items;
	}
	
	/**
	 * Creates a record in the database. 
	 */
	@Override
	public Item create(Item item) {
		try (Connection connection = DriverManager.getConnection(
				connectionURL, username, password)) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into items("
				+ "item_name, price)" + " values ('" 
				+ item.getItemName() + "'," + item.getPrice() +")");
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return item;
	}
	
	/**
	 * Modifies a record in the database.
	 */
	@Override
	public Item update(Item item) {
		try (Connection connection = DriverManager.getConnection(
				connectionURL, username, password)) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("update items set item_name='" + item.getItemName()
			+ "', price=" + item.getPrice() + " where id=" + item.getId());
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return item;
		
	}
	
	/**
	 * Deletes a record in the database.
   */
	@Override
	public void delete(long id) {
		try (Connection connection = DriverManager.getConnection(
				connectionURL, username, password)) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("delete from order_items where item_id=" + id);
			statement.executeUpdate("delete from items where id=" + id);			
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}
}
