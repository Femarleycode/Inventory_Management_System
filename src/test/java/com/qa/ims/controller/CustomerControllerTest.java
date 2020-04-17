package com.qa.ims.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.domain.Customers;
import com.qa.ims.services.CustomerServices;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

	/**
	 * The thing I want to fake functionality for
	 */
	@Mock
	private CustomerServices customerServices;

	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customers
	 * controller
	 */
	@Spy
	@InjectMocks
	private CustomerController customerController;

	@Test
	public void readAllTest() {
		CustomerController customerController = new CustomerController(customerServices);
		List<Customers> icustomer = new ArrayList<>();
		icustomer.add(new Customers("Chris", "P"));
		icustomer.add(new Customers("Rhys", "T"));
		icustomer.add(new Customers("Nic", "J"));
		Mockito.when(customerServices.readAll()).thenReturn(icustomer);
		assertEquals(icustomer, customerController.readAll());
	}

	@Test
	public void createTest() {
		String name = "John";
		String address = "Snowhouse";
		Mockito.doReturn(name, address).when(customerController).getInput();
		Customers customer = new Customers(name, address);
		Customers savedCustomer = new Customers(1L, "John", "Snowhouse");
		Mockito.when(customerServices.create(customer)).thenReturn(savedCustomer);
		assertEquals(savedCustomer, customerController.create());
	}

	/**
	 * 
	 */
	@Test
	public void updateTest() {
		String customer_id = "1";
		String name = "Rhys";
		String address = "Moorside";
		Mockito.doReturn(customer_id, name, address).when(customerController).getInput();
		Customers customer = new Customers(Long.parseLong(customer_id), name, address);
		Mockito.when(customerServices.update(customer)).thenReturn(customer);
		assertEquals(customer, customerController.update());
	}

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the
	 * delete method
	 */
	@Test
	public void deleteTest() {
		String customer_id = "1";
		Mockito.doReturn(customer_id).when(customerController).getInput();
		customerController.delete();
		Mockito.verify(customerServices, Mockito.times(1)).delete(1L);
	}

}
