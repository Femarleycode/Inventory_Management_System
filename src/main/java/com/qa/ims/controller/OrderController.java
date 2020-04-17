package com.qa.ims.controller;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Orders> {

	public static final Logger LOGGER = Logger.getLogger(OrderController.class);

	private CrudServices<Orders> orderService;

	public OrderController(CrudServices<Orders> orderService) {
		this.orderService = orderService;
	}

	String getInput() {
		return Utils.getInput();
	}

	/**
	 * Reads all order to the logger
	 */
	@Override
	public List<Orders> readAll() {
		List<Orders> Orders1 = orderService.readAll();
		for (Orders customers : Orders1) {
			LOGGER.info(customers.toString());
		}
		return Orders1;
	}

	/**
	 * Creates a order by taking in user input
	 */
	@Override
	public Orders create() {
		LOGGER.info("Please enter a customerId");
		Long customerId = Long.valueOf(getInput());
		LOGGER.info("Please enter a totalPrice");
		BigDecimal totalPrice = BigDecimal.valueOf(Double.parseDouble(getInput()));
		Orders customers = orderService.create(new Orders(customerId, totalPrice));
		LOGGER.info("Customers created");
		return customers;
	}

	/**
	 * Updates an existing order by taking in user input
	 */
	@Override
	public Orders update() {
		LOGGER.info("Please enter the orderId of the order you would like to update");
		Long orderId = Long.valueOf(getInput());
		LOGGER.info("Please enter a customerId");
		Long customerId = Long.valueOf(getInput());
		LOGGER.info("Please enter a totalPrice");
		BigDecimal totalPrice = BigDecimal.valueOf(Double.parseDouble(getInput()));
		Orders orders = orderService.update(new Orders(orderId, customerId, totalPrice));
		LOGGER.info("Customers Updated");
		return orders;
	}

	/**
	 * Deletes an existing order by the id of the customer
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the orders you would like to delete");
		Long orderId = Long.valueOf(getInput());
		orderService.delete(orderId);
	}

}
