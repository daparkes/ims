package services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.service.OrderServices;


@RunWith(MockitoJUnitRunner.class)
public class OrderServicesTest {
	
	@Mock
	private Dao<Order> orderDao;
	
	@InjectMocks
	private OrderServices orderServices;
	
	@Test
	public void orderServicesCreate() {
		Order order = new Order(1L, 2L, 5);
		orderServices.create(order);
		Mockito.verify(orderDao, Mockito.times(1)).create(order);
	}
	
	@Test
	public void orderServicesRead() {
		orderServices.readAll();
		Mockito.verify(orderDao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void orderServicesUpdate() {
		Order order = new Order(1L, 2L, 5);
		orderServices.update(order);
		Mockito.verify(orderDao, Mockito.times(1)).update(order);
	}
	
	@Test
	public void orderServicesDelete() {
		orderServices.delete(1L);;
		Mockito.verify(orderDao, Mockito.times(1)).delete(1L);
	}
}
