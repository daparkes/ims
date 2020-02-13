package domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.qa.ims.persistence.domain.User;

public class UserTest {
	
	User user = new User(1L, "dan");
	
	@Test
	public void getIdTest() {
		assertEquals(new Long (1), user.getId());
	}
	
	@Test
	public void getUsernameTest() {
		assertEquals("dan", user.getUsername());
	}
}
