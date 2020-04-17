package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Customers;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

/**
 * Takes in customer details for CRUD functionality
 *
 */
public class CustomerController implements CrudController<Customers> {

	public static final Logger LOGGER = Logger.getLogger(CustomerController.class);

	private CrudServices<Customers> customerService;

	public CustomerController(CrudServices<Customers> customerService) {
		this.customerService = customerService;
	}

	String getInput() {
		return Utils.getInput();
	}

	/**
	 * Reads all customers to the logger
	 */
	@Override
	public List<Customers> readAll() {
		List<Customers> customers1 = customerService.readAll();
		for (Customers customers : customers1) {
			LOGGER.info(customers.toString());
		}
		return customers1;
	}

	/**
	 * Creates a customer by taking in user input
	 */
	@Override
	public Customers create() {
		LOGGER.info("Please enter a name");
		String name = getInput();
		LOGGER.info("Please enter an address");
		String address = getInput();
		Customers customers = customerService.create(new Customers(name, address));
		LOGGER.info("Customers created");
		return customers;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Customers update() {
		LOGGER.info("Please enter the id of the customers you would like to update");
		Long CustomerId = Long.valueOf(getInput());
		LOGGER.info("Please enter a name");
		String name = getInput();
		LOGGER.info("Please enter an address");
		String address = getInput();
		Customers customers = customerService.update(new Customers(CustomerId, name, address));
		LOGGER.info("Customers Updated");
		return customers;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the customers you would like to delete");
		Long id = Long.valueOf(getInput());
		customerService.delete(id);
	}

}
