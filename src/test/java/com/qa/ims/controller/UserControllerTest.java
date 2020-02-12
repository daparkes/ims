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

import com.qa.ims.controller.UserController;
import com.qa.ims.persistence.domain.User;
import com.qa.ims.service.UserServices;

@RunWith(MockitoJUnitRunner.class)

public class UserControllerTest {
	
	@Mock
	private UserServices userServices;
	
	@Spy
	@InjectMocks
	private UserController userController;
	
	@Test
	public void readAllTest() {
		UserController userController = new UserController(userServices);
		List<User> users = new ArrayList<>();
		users.add(new User("chris"));
		users.add(new User("chris"));
		users.add(new User("nick"));
		Mockito.when(userServices.readAll()).thenReturn(users);
		assertEquals(users, userController.readAll());
	}
	
	@Test
	public void createTest() {
		String username = "dan";
		Mockito.doReturn(username).when(userController).getInput();
		User user = new User("dan");
		User savedUser = new User(1L, "dan");
		Mockito.when(userServices.create(user)).thenReturn(savedUser);
		assertEquals(savedUser, userController.create());
	}
	
	@Test
	public void updateTest() {
		String id = "1";
		String username = "dan";
		Mockito.doReturn(id, username).when(userController).getInput();
		User user = new User(username);
		Mockito.when(userServices.update(user)).thenReturn(user);
		assertEquals(user, userController.update());
	}
	
	@Test
	public void deleteTest() {
		String id = "1";
		Mockito.doReturn(id).when(userController).getInput();
		userController.delete();
		Mockito.verify(userServices, Mockito.times(1)).delete(1L);
	}
}
