package com.qa.ims;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;

import com.qa.ims.controller.Action;
import com.qa.ims.controller.CrudController;
import com.qa.ims.controller.CustomerController;
import com.qa.ims.controller.ItemController;
import com.qa.ims.controller.OrderController;
import com.qa.ims.controller.UserController;
import com.qa.ims.persistence.dao.CustomerDao;
import com.qa.ims.persistence.dao.ItemDao;
import com.qa.ims.persistence.dao.OrderDao;
import com.qa.ims.persistence.dao.UserDao;
import com.qa.ims.persistence.domain.Domain;
import com.qa.ims.service.CustomerServices;
import com.qa.ims.service.ItemServices;
import com.qa.ims.service.OrderServices;
import com.qa.ims.service.UserServices;
import com.qa.ims.utils.Utils;

public class System {
	
	public static final Logger LOGGER = Logger.getLogger(System.class);
	
	public void imSystem() {
		String cont="y";
		while (cont=="y") {
			LOGGER.info("Please enter your username:");
			String username = Utils.getInput();
			LOGGER.info("Please enter your password:");
			String password = Utils.getInput();
			
			init(username, password);
			
			LOGGER.info("Which system would you like to access?");
			Domain.printDomains();
			
			Domain domain = Domain.getDomain();
			LOGGER.info("What would you like to do with " + domain.name().toLowerCase() + ":");
			
			
			Action.printActions();
			Action action = Action.getAction();
			
			switch(domain) {
			case CUSTOMER:
				CustomerController customerController = new CustomerController(
					new CustomerServices(new CustomerDao(username, password)));
				doAction(customerController, action);
				continue;
			case ITEM:
				ItemController itemController = new ItemController(
					new ItemServices(new ItemDao(username, password)));
				doAction(itemController, action);
			case ORDER:
				OrderController orderController = new OrderController(
					new OrderServices(new OrderDao(username, password)));
				doAction(orderController, action);
			case USER:
				UserController userController = new UserController(
						new UserServices(new UserDao(username, password)));
				doAction(userController, action);
			case STOP:
				break;
			default:
				break;
			}
		}
	}
	
	public void doAction(CrudController<?> crudController, Action action) {
		switch(action) {
		case CREATE:
			crudController.create();
			break;
		case READ:
			crudController.readAll();
			break;
		case UPDATE:
			crudController.update();
			break;
		case DELETE:
			crudController.delete();
			break;
		case RETURN:
			break;
		default:
			break;
		}
	}
	
	public void init(String username, String password) {
		init("jdbc:mysql://localhost:3306/ims", username, password);
	}
	
	/**
	 * Initialises the database with the username and password provided by the user
	 * and a pre-defined connection URL.
	 * 
	 * @param connectionURL
	 * @param username
	 * @param password
	 */
	public void init(String connectionURL, String username, String password) {
		try (Connection connection = DriverManager.getConnection(connectionURL, 
				username, password);) {
		} catch (SQLException e) {
		LOGGER.debug(e.getStackTrace());
		LOGGER.error(e.getMessage());
		}
	}
}