package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;

public class ItemTest {
	
	private Item item;
	private Item other;
	
	@Before
	public void setUp() {
		item = new Item(1L, "fanta", 1.50f);
		other = new Item(1L, "fanta", 1.50f);
	}
	
//	@Test
//	public void getIdTest() {
//		assertEquals(1L, item.getId());
//	}
	
	@Test
	public void getItemNameTest() {
		assertEquals("fanta", item.getItemName());
	}
	@Test
	public void getPriceTest() {
		assertEquals(1.50, item.getPrice(), 0);
	}
	
	@Test
	public void settersTest() {
		assertNotNull(item.getId());
		assertNotNull(item.getItemName());
		assertNotNull(item.getPrice());
		
		item.setId(null);
		assertNull(item.getId());
		item.setItemName(null);
		assertNull(item.getItemName());
		item.setPrice(null);
		assertNull(item.getPrice());	
	}
	
	@Test
	public void toStringTest() {
		String toString = "id=1, itemName=fanta, price=1.5";
		assertEquals(toString, item.toString());
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(item.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(item.equals(new Object()));
	}
	
	@Test
	public void createItemWithId() {
		assertEquals(1L, item.getId(), 0);
		assertEquals("fanta", item.getItemName());
		assertEquals(1.50f, item.getPrice(), 0);
	}
	
	@Test
	public void checkEquality() {
		assertTrue(item.equals(item));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(item.equals(other));
	}
	
	@Test
	public void itemNameNullButOtherNameNotNull() {
		item.setItemName(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void itemNamesNotEqual() {
		other.setItemName("rhys");
		assertFalse(item.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		item.setItemName(null);
		other.setItemName(null);
		assertTrue(item.equals(other));
	}
	
	@Test
	public void nullId() {
		item.setId(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void nullIdOnBoth() {
		item.setId(null);
		other.setId(null);
		assertTrue(item.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setId(2L);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void nullPrice() {
		item.setPrice(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void nullPriceOnBoth() {
		item.setPrice(null);
		other.setPrice(null);
		assertTrue(item.equals(other));
	}
	
	@Test
	public void otherPriceDifferent() {
		other.setPrice(1.40f);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void constructorWithoutId() {
		Item item = new Item("fanta", 1.50f);
		assertNull(item.getId());
		assertNotNull(item.getItemName());
		assertNotNull(item.getPrice());
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(item.hashCode(), other.hashCode());
	}
	@Test
	public void hashCodeTestWithNull() {
		Item item = new Item(null, null);
		Item other = new Item(null, null);
		assertEquals(item.hashCode(), other.hashCode());
	}
	
}
