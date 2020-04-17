package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.OrderLine;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class OrderLineController implements CrudController<OrderLine> {

	public static final Logger LOGGER = Logger.getLogger(OrderLineController.class);

	private CrudServices<OrderLine> orderLineService;

	public OrderLineController(CrudServices<OrderLine> orderLineService) {
		this.orderLineService = orderLineService;
	}

	String getInput() {
		return Utils.getInput();
	}

	/**
	 * Reads all order to the logger
	 */
	@Override
	public List<OrderLine> readAll() {
		List<OrderLine> iOrderLine = orderLineService.readAll();
		for (OrderLine customers : iOrderLine) {
			LOGGER.info(customers.toString());
		}
		return iOrderLine;
	}

	/**
	 * Creates a order by taking in user input
	 */
	@Override
	public OrderLine create() {
		LOGGER.info("Please enter an orderId");
		Long orderId = Long.valueOf(getInput());
		LOGGER.info("Please enter an itemId");
		Long itemId = Long.valueOf(getInput());
		OrderLine customers = orderLineService.create(new OrderLine(orderId, itemId));
		LOGGER.info("OrderLine created");
		return customers;
	}

	/**
	 * Updates an existing order by taking in user input
	 */
	@Override
	public OrderLine update() {
		LOGGER.info("Please enter the orderId of the orderLine you would like to update");
		Long orderId = Long.valueOf(getInput());
		LOGGER.info("Please enter a itemId");
		Long itemId = Long.valueOf(getInput());
		OrderLine orders = orderLineService.update(new OrderLine(orderId, itemId));
		LOGGER.info("OrderLine Updated");
		return orders;
	}

	/**
	 * Deletes an existing order by the id of the customer
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the orderId of the orderLine you would like to delete");
		Long orderId = Long.valueOf(getInput());
		orderLineService.delete(orderId);
	}

}
