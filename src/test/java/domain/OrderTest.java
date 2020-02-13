package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Order;

public class OrderTest {
	
	private Order order;
	private Order other;
	
	@Before
	public void setUp() {
		order = new Order(1L, 3L, 4L, 5);
		other = new Order(1L, 3L, 4L, 5);
	}
	
	@Test
	public void settersTest() {
		assertNotNull(order.getId());
		assertNotNull(order.getItemId());
		assertNotNull(order.getCustomerId());
		
		order.setId(null);
		assertNull(order.getId());
		order.setItemId(null);
		assertNull(order.getItemId());
		order.setCustomerId(null);
		assertNull(order.getCustomerId());
		
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(order.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(order.equals(new Object()));
	}
	
	@Test
	public void createOrderWithId() {
		assertEquals(1L, order.getId(), 0);
		assertEquals(new Long(4L), order.getItemId());
		assertEquals(new Long(3L), order.getCustomerId());
	}
	
	@Test
	public void checkEquality() {
		assertTrue(order.equals(order));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(order.equals(other));
	}
	
	@Test
	public void orderNameNullButOtherNameNotNull() {
		order.setItemId(null);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void orderNamesNotEqual() {
		other.setItemId(3L);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		order.setItemId(null);
		other.setItemId(null);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void nullId() {
		order.setId(null);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullIdOnBoth() {
		order.setId(null);
		other.setId(null);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setId(2L);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullCustomerId() {
		order.setCustomerId(null);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullCustomerIdOnBoth() {
		order.setCustomerId(null);
		other.setCustomerId(null);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void otherCustomerIdDifferent() {
		other.setCustomerId(2L);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void constructorWithoutId() {
		Order order = new Order(5L, 7L, 5);
		assertNull(order.getId());
		assertNotNull(order.getItemId());
		assertNotNull(order.getCustomerId());
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(order.hashCode(), other.hashCode());
	}
	@Test
	public void hashCodeTestWithNull() {
		Order order = new Order(null, null, null);
		Order other = new Order(null, null, null);
		assertEquals(order.hashCode(), other.hashCode());
	}
	
	@Test
	public void toStringTest() {
		String toString = "id=1, customerId=3, totalPrice=null, itemId=4, quantity=5";
		assertEquals(toString, order.toString());
	}
}
