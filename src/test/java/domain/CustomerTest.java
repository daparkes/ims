package domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Customer;

public class CustomerTest {
	
	Customer customer = new Customer(1L, "bob", "dylan");
	
	@Test
	public void getFirstNameTest() {
		assertEquals("bob", customer.getFirstName());
	}
	
	@Test
	public void getSurnameTest() {
		assertEquals("dylan", customer.getSurname());
	}
	
	@Test
	public void getIdTest() {
		assertEquals(1L, customer.getId());
	}
	
	@Test
	public void toStringTest() {
		assertEquals("id: 1 first name: bob surname: dylan", customer.toString());
	}
}
