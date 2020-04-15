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
		LOGGER.info("Please enter an order_id");
		Long order_id = Long.valueOf(getInput());
		LOGGER.info("Please enter a customer_id");
		BigDecimal customer_id = BigDecimal.valueOf(Double.parseDouble(getInput()));
		Orders customers = orderService.create(new Orders(order_id, customer_id));
		LOGGER.info("Customers created");
		return customers;
	}

	/**
	 * Updates an existing order by taking in user input
	 */
	@Override
	public Orders update() {
		LOGGER.info("Please enter the order_id of the order you would like to update");
		Long order_id = Long.valueOf(getInput());
		LOGGER.info("Please enter a customer_id");
		Long customer_id = Long.valueOf(getInput());
		LOGGER.info("Please enter a total_price");
		BigDecimal total_price = BigDecimal.valueOf(Double.parseDouble(getInput()));
		Orders orders = orderService.update(new Orders(order_id, customer_id, total_price));
		LOGGER.info("Customers Updated");
		return orders;
	}

	/**
	 * Deletes an existing order by the id of the customer
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the orders you would like to delete");
		Long order_id = Long.valueOf(getInput());
		orderService.delete(order_id);
	}

}
