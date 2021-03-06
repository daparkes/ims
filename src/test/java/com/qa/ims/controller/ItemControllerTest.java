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

import com.qa.ims.controller.ItemController;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.service.ItemServices;

@RunWith(MockitoJUnitRunner.class)

/**
 * Mockito tests that stub Services functionality to test Controller methods.
 * @author Dan
 *
 */
public class ItemControllerTest {
	
	@Mock
	private ItemServices itemServices;
	
	@Spy
	@InjectMocks
	private ItemController itemController;
	
	@Test
	public void readAllTest() {
		ItemController itemController = new ItemController(itemServices);
		List<Item> items = new ArrayList<>();
		items.add(new Item(3L, "fanta", 1.50f));
		items.add(new Item(4L, "coke", 1.50f));
		items.add(new Item(2L, "mars bar", 0.90f));
		Mockito.when(itemServices.readAll()).thenReturn(items);
		assertEquals(items, itemController.readAll());
	}
	
	@Test
	public void createTest() {
		String itemName = "fanta";
		String price = "1.50";
		Mockito.doReturn(itemName, price).when(itemController).getInput();
		Item item = new Item(itemName, 1.50f);
		Item savedItem = new Item("fanta", 1.50f);
		Mockito.when(itemServices.create(item)).thenReturn(savedItem);
		assertEquals(savedItem, itemController.create());
	}
	
	@Test
	public void updateTest() {
		String id = "1";
		String itemName = "fanta";
		String price = "1.50";
		Mockito.doReturn(id, itemName, price).when(itemController).getInput();
		Item item = new Item(1L, itemName, 1.50f);
		Mockito.when(itemServices.update(item)).thenReturn(item);
		assertEquals(item, itemController.update());
	}
	
	@Test
	public void deleteTest() {
		String id = "1";
		Mockito.doReturn(id).when(itemController).getInput();
		itemController.delete();
		Mockito.verify(itemServices, Mockito.times(1)).delete(1L);
	}
}
