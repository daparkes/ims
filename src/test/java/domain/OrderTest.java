package domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.qa.ims.persistence.domain.Order;

public class OrderTest {

	Order order = new Order(3L, 4L, 15.50f, 5);
		
	@Test
	public void getItemIdTest() {
		assertEquals(5, order.getItemId());
	}
	
	@Test
	public void getIdTest() {
		assertEquals(3L, order.getId());
	}
	
	@Test
	public void getCustomerIdTest() {
		assertEquals(4L, order.getCustomerId());
	}
	
	@Test
	public void getTotalPrice() {
		assertEquals(15.50f, order.getTotalPrice(), 0);
	}
}
