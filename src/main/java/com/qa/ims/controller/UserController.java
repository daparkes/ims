package com.qa.ims.controller;

import java.util.List;
import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.User;
import com.qa.ims.service.CrudServices;
import com.qa.ims.utils.Utils;

public class UserController implements CrudController<User> {
	
	public static final Logger LOGGER = Logger.getLogger(UserController.class);
	
	private CrudServices<User> userService;
	
	public UserController(CrudServices<User> userService) {
		this.userService = userService;
	}
	
	String getInput() {
		return Utils.getInput();
	}
	
	/**
	 * Reads all users to the logger.
	 */	
	@Override
	public List<User> readAll(){
		List<User> users = userService.readAll();
		for (User user : users) {
			LOGGER.info(user.toString());
		}
	 return users;
	}
	
	/**
	 * Creates a user by taking in user input.
	 */
	@Override
	public User create() {
		LOGGER.info("Please enter a username:");
		String username = getInput();
		User user = userService.create(new User(username));
		LOGGER.info("User created successfully");
		return user;
	}
	
	/**
	 * Updates an existing user specified by user input.
	 */
	@Override
	public User update() {
		LOGGER.info("Please enter the ID of the user you would like to update: ");
		Long id = Long.valueOf(getInput());
		LOGGER.info("Please enter a new username:");
		String username = getInput();
		User user = userService.update(new User(username));
		LOGGER.info("User Updated");
		return user;
	}
	
	/**
	 * Deletes an existing user by the id of the user.
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the ID of the user you would like to delete:");
		Long id = Long.valueOf(getInput());
		userService.delete(id);
		LOGGER.info("User successfully deleted");
	}
}
