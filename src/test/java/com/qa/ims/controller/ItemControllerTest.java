package com.qa.ims.controller;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.services.ItemServices;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {

	/**
	 * The thing I want to fake functionality for
	 */
	@Mock
	private ItemServices itemServices;

	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the item
	 * controller
	 */
	@Spy
	@InjectMocks
	private ItemController itemController;

	@Test
	public void readAllTest() {
		ItemController itemController = new ItemController(itemServices);
		List<Items> items = new ArrayList<>();
		items.add(new Items("Nokia", BigDecimal.valueOf(50)));
		items.add(new Items("Samsung", BigDecimal.valueOf(75)));
		items.add(new Items("iPhone", BigDecimal.valueOf(100)));
		Mockito.when(itemServices.readAll()).thenReturn(items);
		assertEquals(items, itemController.readAll());
	}

	@Test
	public void createTest() {
		String name = "Nokia";
		String price = "50";

		Mockito.doReturn(name, price).when(itemController).getInput();
		Items item = new Items(name, BigDecimal.valueOf(Double.parseDouble(price)));
		Items savedItem = new Items(1L, "Nokia", BigDecimal.valueOf(50));

		Mockito.when(itemServices.create(item)).thenReturn(savedItem);
		assertEquals(savedItem, itemController.create());
	}

	/**
	 * 
	 */
	@Test
	public void updateTest() {
		String item_id = "1";
		String name = "Nokia";
		String price = "50";

		Mockito.doReturn(item_id, name, price).when(itemController).getInput();
		Items item = new Items(Long.parseLong(item_id), name, BigDecimal.valueOf(Double.parseDouble(price)));

		Mockito.when(itemServices.update(item)).thenReturn(item);
		assertEquals(item, itemController.update());
	}

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the
	 * delete method
	 */
	@Test
	public void deleteTest() {
		String item_id = "1";
		Mockito.doReturn(item_id).when(itemController).getInput();
		itemController.delete();
		Mockito.verify(itemServices, Mockito.times(1)).delete(1L);
	}

}
