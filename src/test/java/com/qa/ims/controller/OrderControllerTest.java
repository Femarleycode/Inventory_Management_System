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

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.services.OrderServices;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	/**
	 * The thing I want to fake functionality for
	 */
	@Mock
	private OrderServices OrderServices;

	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer
	 * controller
	 */
	@Spy
	@InjectMocks
	private OrderController OrderController;

	@Test
	public void readAllTest() {
		OrderController customerController = new OrderController(OrderServices);
		List<Order> iOrder = new ArrayList<>();
		iOrder.add(new Orders("Chris", "50"));
		iOrder.add(new Orders("Rhys", "75"));
		iOrder.add(new Orders("Nic", "100"));
		Mockito.when(OrderServices.readAll()).thenReturn(iOrder);
		assertEquals(iOrder, customerController.readAll());
	}

	@Test
	public void createTest() {
		String customer_id = "1";
		String total_price = "50";
		Mockito.doReturn(customer_id, total_price).when(OrderController).getInput();
		Orders customer = new Orders(customer_id, total_price);
		Orders savedCustomer = new Orders(1L, "Chris", "50");
		Mockito.when(OrderServices.create(customer)).thenReturn(savedCustomer);
		assertEquals(savedCustomer, OrderController.create());
	}

	/**
	 * 
	 */
	@Test
	public void updateTest() {
		String order_id = "1";
		String customer_id = "Rhys";
		String total_price = "75";
		Mockito.doReturn(order_id, customer_id, total_price).when(OrderController).getInput();
		Orders customer = new Orders(1L, customer_id, total_price);
		Mockito.when(OrderServices.update(customer)).thenReturn(customer);
		assertEquals(customer, OrderController.update());
	}

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the
	 * delete method
	 */
	@Test
	public void deleteTest() {
		String customer_id = "1";
		Mockito.doReturn(customer_id).when(OrderController).getInput();
		OrderController.delete();
		Mockito.verify(OrderServices, Mockito.times(1)).delete(1L);
	}

}
