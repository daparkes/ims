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
	
	public void getSurnameTest() {
		assertEquals("dylan", customer.getSurname());
	}
	
}
