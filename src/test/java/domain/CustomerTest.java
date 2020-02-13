package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Customer;

public class CustomerTest {
	
	private Customer customer;
	private Customer other;
	
	@Before
	public void setUp() {
		customer = new Customer(1L, "bob", "dylan");
		other = new Customer(1L, "bob", "dylan");
	}
	
	@Test
	public void settersTest() {
		assertNotNull(customer.getId());
		assertNotNull(customer.getFirstName());
		assertNotNull(customer.getSurname());
		
		customer.setId(null);
		assertNull(customer.getId());
		customer.setFirstName(null);
		assertNull(customer.getFirstName());
		customer.setSurname(null);
		assertNull(customer.getSurname());
		
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(customer.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(customer.equals(new Object()));
	}
	
	@Test
	public void createCustomerWithId() {
		assertEquals(1L, customer.getId(), 0);
		assertEquals("bob", customer.getFirstName());
		assertEquals("dylan", customer.getSurname());
	}
	
	@Test
	public void checkEquality() {
		assertTrue(customer.equals(customer));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(customer.equals(other));
	}
	
	@Test
	public void customerNameNullButOtherNameNotNull() {
		customer.setFirstName(null);
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void customerNamesNotEqual() {
		other.setFirstName("james");
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		customer.setFirstName(null);
		other.setFirstName(null);
		assertTrue(customer.equals(other));
	}
	
	@Test
	public void nullId() {
		customer.setId(null);
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void nullIdOnBoth() {
		customer.setId(null);
		other.setId(null);
		assertTrue(customer.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setId(2L);
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void nullSurname() {
		customer.setSurname(null);
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void nullSurnameOnBoth() {
		customer.setSurname(null);
		other.setSurname(null);
		assertTrue(customer.equals(other));
	}
	
	@Test
	public void otherSurnameDifferent() {
		other.setSurname("smith");
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void constructorWithoutId() {
		Customer customer = new Customer("fred", "durst");
		assertNull(customer.getId());
		assertNotNull(customer.getFirstName());
		assertNotNull(customer.getSurname());
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(customer.hashCode(), other.hashCode());
	}
	@Test
	public void hashCodeTestWithNull() {
		Customer customer = new Customer(null, null);
		Customer other = new Customer(null, null);
		assertEquals(customer.hashCode(), other.hashCode());
	}
	
	@Test
	public void toStringTest() {
		String toString = "id: 1, first name: bob, surname: dylan";
		assertEquals(toString, customer.toString());
	}
}
