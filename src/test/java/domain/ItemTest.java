package domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.qa.ims.persistence.domain.Item;

public class ItemTest {
	
	Item item = new Item(1L, "fanta", 1.50f);
	
	@Test
	public void getIdTest() {
		assertEquals(1, item.getId());
	}
	
	@Test
	public void getItemNameTest() {
		assertEquals("fanta", item.getItemName());
	}
	@Test
	public void getPriceTest() {
		assertEquals(1.50, item.getPrice(), 0);
	}
}
