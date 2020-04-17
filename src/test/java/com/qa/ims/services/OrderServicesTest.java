package com.qa.ims.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Customers;

@RunWith(MockitoJUnitRunner.class)
public class OrderServicesTest {

	@Mock
	private Dao<Customers> customerDao;

	@InjectMocks
	private CustomerServices customerServices;

	@Test
	public void customerServicesCreate() {
		Customers customer = new Customers("john", "moorside");
		customerServices.create(customer);
		Mockito.verify(customerDao, Mockito.times(1)).create(customer);
	}

//	@Test
//	public void customerServicesRead() {
//		customerServices.readAll();
//		Mockito.verify(customerDao, Mockito.times(1)).readAll();
//	}

//	@Test
//	public void customerServicesUpdate() {
//		Customer customer = new Customer("chris", "perrins");
//		customerServices.update(customer);
//		Mockito.verify(customerDao, Mockito.times(1)).update(customer);
//	}

//	@Test
//	public void customerServicesDelete() {
//		customerServices.delete(1L);;
//		Mockito.verify(customerDao, Mockito.times(1)).delete(1L);
//	}
}
