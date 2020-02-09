package com.qa.ims;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDao implements Dao<User>{

	public ArrayList<User> readAll() {
		ArrayList<User> users = new ArrayList<User>();
		try (Connection connection = DriverManager.getConnection(
			"jdbc:mysql://34.76.133.172:3306/ims", "root", "root")) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from users");
			while (resultSet.next()) {
				long id = resultSet.getLong("id");
				String username = resultSet.getString("username");
				User user = new User(id, username);
				users.add(user);
				}
		} catch (Exception e) {
		}	
		return users;
	}
	
	public void create(User user) {
		try (Connection connection = DriverManager.getConnection(
			"jdbc:mysql://34.76.133.172:3306/ims", "root", "root")) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into users(username) values ('" 
				+ user.getUsername());
		} catch (Exception e) {
		}
	}
	
	public void update(User user, String field, String newValue) {
		try (Connection connection = DriverManager.getConnection(
			"jdbc:mysql://34.76.133.172:3306/ims", "root", "root")) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("update users set " + field + "='" + newValue +
				"' where id=" + user.getId());
		} catch (Exception e) {
		}
	}
	
	public void delete(User user) {
		try (Connection connection = DriverManager.getConnection(
			"jdbc:mysql://34.76.133.172:3306/ims", "root", "root")) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("delete from users where id=" + user.getId());
		} catch (Exception e) {
		}
	}
}
