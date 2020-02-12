package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.User;

public class UserDao implements Dao<User>{

	public static final Logger LOGGER = Logger.getLogger(UserDao.class);
	
	private String connectionURL;
	private String username;
	private String password;
	
	public UserDao(String connectionURL, String username, String password) {
		this.connectionURL = "jdbc:mysql://localhost:3306/ims";
		this.username = username;
		this.password = password;
	}
	
	@Override
	public ArrayList<User> readAll() {
		ArrayList<User> users = new ArrayList<User>();
		try (Connection connection = DriverManager.getConnection(
			connectionURL, username, password)) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from users");
			while (resultSet.next()) {
				long id = resultSet.getLong("id");
				String username = resultSet.getString("username");
				User user = new User(id, username);
				users.add(user);
				}
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}	
		return users;
	}
	
	@Override
	public User create(User user) {
		try (Connection connection = DriverManager.getConnection(
				connectionURL, username, password)) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into users(username) values ('" 
				+ user.getUsername());
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return user;
	}
	
	@Override
	public User update(User user) {
		try (Connection connection = DriverManager.getConnection(
				connectionURL, username, password)) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("update users set username=" + user.getUsername() 
			+ " where id=" + user.getId());
			return user;
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
			statement.executeUpdate("delete from users where id=" + id);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}
}
