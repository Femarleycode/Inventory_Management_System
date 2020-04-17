package com.qa.ims.controller;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

/**
 * Takes in item details for CRUD functionality
 *
 */
public class ItemController implements CrudController<Items> {

	public static final Logger LOGGER = Logger.getLogger(ItemController.class);

	private CrudServices<Items> itemService;

	public ItemController(CrudServices<Items> itemService) {
		this.itemService = itemService;
	}

	String getInput() {
		return Utils.getInput();
	}

	/**
	 * Reads all items to the logger
	 */
	@Override
	public List<Items> readAll() {
		List<Items> items1 = itemService.readAll();
		for (Items items : items1) {
			LOGGER.info(items.toString());
		}
		return items1;
	}

	/**
	 * Creates a item by taking in user input
	 */
	@Override
	public Items create() {
		LOGGER.info("Please enter a name");
		String name = getInput();
		LOGGER.info("Please enter a price");
		BigDecimal price = BigDecimal.valueOf(Double.parseDouble(getInput()));
		Items item = itemService.create(new Items(name, price));
		LOGGER.info("Items created");
		return item;
	}

	/**
	 * Updates an existing item by taking in user input
	 */
	@Override
	public Items update() {
		LOGGER.info("Please enter the id of the item you would like to update");
		Long item_id = Long.valueOf(getInput());
		LOGGER.info("Please enter a name");
		String name = getInput();
		LOGGER.info("Please enter a price");
		BigDecimal price = BigDecimal.valueOf(Double.parseDouble(getInput()));
		Items item = itemService.update(new Items(item_id, name, price));
		LOGGER.info("Items Updated");
		return item;
	}

	/**
	 * Deletes an existing item by the id of the item
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long item_id = Long.valueOf(getInput());
		itemService.delete(item_id);
	}

}
