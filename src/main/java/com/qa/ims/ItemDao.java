package com.qa.ims;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ItemDao implements Dao<Item>{

	public ArrayList<Item> readAll() {
		ArrayList<Item> items = new ArrayList<Item>();
		try (Connection connection = DriverManager.getConnection(
			"jdbc:mysql://34.76.133.172:3306/ims", "root", "root")) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from items");
			while (resultSet.next()) {
				long id = resultSet.getLong("id");				
				String itemName = resultSet.getString("item_name");
				float price = resultSet.getInt("price");
				Item item = new Item(id, itemName, price);
				items.add(item);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return items;
	}
	
	public void create(Item item) {
		try (Connection connection = DriverManager.getConnection(
			"jdbc:mysql://34.76.133.172:3306/ims", "root", "root")) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into items("
				+ "item_name, price)" + "values ('" 
				+ item.getItemName() + "','" + item.getPrice());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Item item, String field, String newValue) {
		try (Connection connection = DriverManager.getConnection(
			"jdbc:mysql://34.76.133.172:3306/ims", "root", "root")) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("update items set " + field + "='" + newValue +
				"' where id=" + item.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void delete(Item item) {
		try (Connection connection = DriverManager.getConnection(
			"jdbc:mysql://34.76.133.172:3306/ims", "root", "root")) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("delete from items where id=" + item.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
