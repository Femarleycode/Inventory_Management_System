package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class ItemTest {

	private Items item;
	private Items other;

	@Before
	public void setUp() {
		item = new Items(1L, "Nokia", BigDecimal.valueOf(50));
		other = new Items(1L, "Nokia", BigDecimal.valueOf(50));
	}

	@Test
	public void settersTest() {
		assertNotNull(item.getItemId());
		assertNotNull(item.getName());
		assertNotNull(item.getPrice());

		item.setItemId(null);
		assertNull(item.getItemId());
		item.setName(null);
		assertNull(item.getName());
		item.setPrice(null);
		assertNull(item.getPrice());

	}

	@Test
	public void equalsWithNull() {
		assertFalse(item.equals(null));
	}

	@Test
	public void equalsWithDifferentObject() {
		assertFalse(item.equals(new Object()));
	}

	@Test
	public void createItemWithItemId() {
		assertEquals(1L, item.getItemId(), 0);
		assertEquals("Nokia", item.getName());
		assertEquals(BigDecimal.valueOf(50), item.getPrice());
	}

	@Test
	public void checkEquality() {
		assertTrue(item.equals(item));
	}

	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(item.equals(other));
	}

	@Test
	public void customerNameNullButOtherNameNotNull() {
		item.setName(null);
		assertFalse(item.equals(other));
	}

	@Test
	public void customerNamesNotEqual() {
		other.setName("samsung");
		assertFalse(item.equals(other));
	}

	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		item.setName(null);
		other.setName(null);
		assertTrue(item.equals(other));
	}

	@Test
	public void nullId() {
		item.setItemId(null);
		assertFalse(item.equals(other));
	}

	@Test
	public void nullIdOnBoth() {
		item.setItemId(null);
		other.setItemId(null);
		assertTrue(item.equals(other));
	}

	@Test
	public void otherIdDifferent() {
		other.setItemId(2L);
		assertFalse(item.equals(other));
	}

	@Test
	public void nullPrice() {
		item.setPrice(null);
		assertFalse(item.equals(other));
	}

	@Test
	public void nullPriceOnBoth() {
		item.setPrice(null);
		other.setPrice(null);
		assertTrue(item.equals(other));
	}

	@Test
	public void otherPriceDifferent() {
		other.setPrice(BigDecimal.valueOf(75));
		assertFalse(item.equals(other));
	}

	@Test
	public void constructorWithoutItemId() {
		Items customer = new Items("Nokia", BigDecimal.valueOf(50));
		assertNull(customer.getItemId());
		assertNotNull(customer.getName());
		assertNotNull(customer.getPrice());
	}

	@Test
	public void hashCodeTest() {
		assertEquals(item.hashCode(), other.hashCode());
	}

	@Test
	public void hashCodeTestWithNull() {
		Items customer = new Items(null, null);
		Items other = new Items(null, null);
		assertEquals(customer.hashCode(), other.hashCode());
	}

	@Test
	public void toStringTest() {
		String toString = "itemId:1 name:Nokia price:50";
		assertEquals(toString, item.toString());
	}
}
