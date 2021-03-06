package com.qa.ims.controller;

import java.util.List;
import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.service.CrudServices;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {
	
	public static final Logger LOGGER = Logger.getLogger(OrderController.class);
	
	private CrudServices<Order> orderService;
	
	public OrderController(CrudServices<Order> orderService) {
		this.orderService = orderService;
	}
	
	String getInput() {
		return Utils.getInput();
	}
	
	/**
	 * Reads all orders to the logger
	 */
	@Override
	public List<Order> readAll(){
		List<Order> orders = orderService.readAll();
		for (Order order : orders) {
			LOGGER.info(order.toString());
		}
	 return orders;
	}
	
	/**
	 * Creates a order by taking in user input
	 */
	@Override
	public Order create() {
		LOGGER.info("Please enter a customer ID:");
		Long customerId = Long.valueOf(getInput());
		LOGGER.info("Please enter an item ID:");
		Long itemId = Long.valueOf(getInput());
		LOGGER.info("Please enter a quantity:");
		Integer quantity = Integer.valueOf(getInput());
		Order order = orderService.create(new Order(customerId, itemId, quantity));
		LOGGER.info("Order created");
		return order;
	}
	
	/**
	 * Updates an existing order specified by user input
	 */
	@Override
	public Order update() {
		LOGGER.info("Please enter the ID of the order you would like to update: ");
		Long id = Long.valueOf(getInput());
		LOGGER.info("Please enter a new customer ID:");
		Long customerId = Long.valueOf(getInput());
		LOGGER.info("Please enter a new item ID:");
		Long itemId = Long.valueOf(getInput());
		LOGGER.info("Please enter a new quantity:");
		Integer quantity = Integer.valueOf(getInput());
		Order order = orderService.update(new Order(id, customerId, itemId, quantity));
		LOGGER.info("Order Updated");
		return order;
	}
	
	/**
	 * Deletes an existing order by the id of the order.
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the ID of the order you would like to delete:");
		Long id = Long.valueOf(getInput());
		orderService.delete(id);
		LOGGER.info("Order successfully deleted");
	}
}
