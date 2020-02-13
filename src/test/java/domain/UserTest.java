package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.User;

public class UserTest {
	
	private User user;
	private User other;
	
	@Before
	public void setUp() {
		user = new User(1L, "dan");
		other = new User(1L, "dan");
	}
	
	@Test
	public void getIdTest() {
		assertEquals(new Long(1L), user.getId());
	}
	
	@Test
	public void getUsernameTest() {
		assertEquals("dan", user.getUsername());
	}
	
	@Test
	public void settersTest() {
		assertNotNull(user.getId());
		assertNotNull(user.getUsername());
				
		user.setId(null);
		assertNull(user.getId());
		user.setUsername(null);
		assertNull(user.getUsername());
		
	}
	
	@Test
	public void toStringTest() {
		String toString = "id=1, username=dan";
		assertEquals(toString, user.toString());
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(user.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(user.equals(new Object()));
	}
	
	@Test
	public void createUserWithId() {
		assertEquals(1L, user.getId(), 0);
		assertEquals("dan", user.getUsername());
		
	}
	
	@Test
	public void checkEquality() {
		assertTrue(user.equals(user));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(user.equals(other));
	}
	
	@Test
	public void userNameNullButOtherNameNotNull() {
		user.setUsername(null);
		assertFalse(user.equals(other));
	}
	
	@Test
	public void userNamesNotEqual() {
		other.setUsername("rhys");
		assertFalse(user.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		user.setUsername(null);
		other.setUsername(null);
		assertTrue(user.equals(other));
	}
	
	@Test
	public void nullId() {
		user.setId(null);
		assertFalse(user.equals(other));
	}
	
	@Test
	public void nullIdOnBoth() {
		user.setId(null);
		other.setId(null);
		assertTrue(user.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setId(2L);
		assertFalse(user.equals(other));
	}
	
	@Test
	public void nullUsername() {
		user.setUsername(null);
		assertFalse(user.equals(other));
	}
	
	@Test
	public void nullUsernameOnBoth() {
		user.setUsername(null);
		other.setUsername(null);
		assertTrue(user.equals(other));
	}
	
	@Test
	public void otherUsernameDifferent() {
		other.setUsername("bob");
		assertFalse(user.equals(other));
	}
	
	@Test
	public void constructorWithoutId() {
		User user = new User("bob");
		assertNull(user.getId());
		assertNotNull(user.getUsername());
		}
	
	@Test
	public void hashCodeTest() {
		assertEquals(user.hashCode(), other.hashCode());
	}
	@Test
	public void hashCodeTestWithNull() {
		User user = new User(null, null);
		User other = new User(null, null);
		assertEquals(user.hashCode(), other.hashCode());
	}
	
}
