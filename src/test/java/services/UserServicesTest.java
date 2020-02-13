package services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.User;
import com.qa.ims.service.UserServices;

@RunWith(MockitoJUnitRunner.class)
public class UserServicesTest {
	
	@Mock
	private Dao<User> userDao;
	
	@InjectMocks
	private UserServices userServices;
	
	@Test
	public void userServicesCreate() {
		User user = new User(1L, "dan");
		userServices.create(user);
		Mockito.verify(userDao, Mockito.times(1)).create(user);
	}
	
	@Test
	public void userServicesRead() {
		userServices.readAll();
		Mockito.verify(userDao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void userServicesUpdate() {
		User user = new User(1L, "dan");
		userServices.update(user);
		Mockito.verify(userDao, Mockito.times(1)).update(user);
	}
	
	@Test
	public void userServicesDelete() {
		userServices.delete(1L);;
		Mockito.verify(userDao, Mockito.times(1)).delete(1L);
	}
}
