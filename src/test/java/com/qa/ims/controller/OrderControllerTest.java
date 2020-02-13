package com.qa.ims.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.service.OrderServices;

@RunWith(MockitoJUnitRunner.class)

public class OrderControllerTest {
	
	@Mock
	private OrderServices orderServices;
	
	@Spy
	@InjectMocks
	private OrderController orderController;
	
	@Test
	public void readAllTest() {
		OrderController orderController = new OrderController(orderServices);
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(1L, 1L, 3L));
		orders.add(new Order(2L, 2L, 3L));
		orders.add(new Order(3L, 3L, 5L));
		Mockito.when(orderServices.readAll()).thenReturn(orders);
		assertEquals(orders, orderController.readAll());
	}
	
	@Test
	public void createTest() {
		String id = "2";
		String customerId = "4";
		String itemId = "3";
		Mockito.doReturn(customerId, itemId).when(orderController).getInput();
		Order order = new Order(4L, 3L);
		Order savedOrder = new Order(2L, 4L, 3L);
		Mockito.when(orderServices.create(order)).thenReturn(savedOrder);
		assertEquals(savedOrder, orderController.create());
	}
	
	@Test
	public void updateTest() {
		String id = "2";
		String customerId = "4";
		String itemId = "3";
		Mockito.doReturn(id, customerId, itemId).when(orderController).getInput();		
		Order order = new Order(2L, 4L, 3L);
		Mockito.when(orderServices.update(order)).thenReturn(order);
		assertEquals(order, orderController.update());
	}
	
	@Test
	public void deleteTest() {
		String id = "1";
		Mockito.doReturn(id).when(orderController).getInput();
		orderController.delete();
		Mockito.verify(orderServices, Mockito.times(1)).delete(1L);
	}
}
