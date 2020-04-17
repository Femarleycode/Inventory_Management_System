package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class OrderTest {

	private Orders Order;
	private Orders other;

	@Before
	public void setUp() {
		Order = new Orders(1L, 1L, "50");
		other = new Orders(2L, 2L, "75");
	}

	@Test
	public void settersTest() {
		assertNotNull(Order.getOrderId());
		assertNotNull(Order.getCustomerId());
		assertNotNull(Order.getTotalPrice());

		Order.setOrderId(null);
		assertNull(Order.getOrderId());
		Order.setCustomerId(null);
		assertNull(Order.getCustomerId());
		Order.setTotalPrice(null);
		assertNull(Order.getTotalPrice());

	}

	@Test
	public void equalsWithNull() {
		assertFalse(Order.equals(null));
	}

	@Test
	public void equalsWithDifferentObject() {
		assertFalse(Order.equals(new Object()));
	}

	@Test
	public void createOrderWithId() {
		assertEquals(1L, Order.getOrderId(), 0);
		assertEquals("1", Order.getCustomerId());
		assertEquals("50", Order.getTotalPrice());
	}

	@Test
	public void checkEquality() {
		assertTrue(Order.equals(Order));
	}

	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(Order.equals(other));
	}

	@Test
	public void customerNameNullButOtherNameNotNull() {
		Order.setCustomerId(null);
		assertFalse(Order.equals(other));
	}

	@Test
	public void customerNamesNotEqual() {
		other.setCustomerId("1");
		assertFalse(Order.equals(other));
	}

	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		Order.setCustomerId(null);
		other.setCustomerId(null);
		assertTrue(Order.equals(other));
	}

	@Test
	public void nullId() {
		Order.setOrderId(null);
		assertFalse(Order.equals(other));
	}

	@Test
	public void nullIdOnBoth() {
		Order.setOrderId(null);
		other.setOrderId(null);
		assertTrue(Order.equals(other));
	}

	@Test
	public void otherIdDifferent() {
		other.setOrderId(2L);
		assertFalse(Order.equals(other));
	}

	@Test
	public void nullSurname() {
		Order.setTotalPrice(null);
		assertFalse(Order.equals(other));
	}

	@Test
	public void nullTotalPriceOnBoth() {
		Order.setTotalPrice(null);
		other.setTotalPrice(null);
		assertTrue(Order.equals(other));
	}

	@Test
	public void otherTotalPriceDifferent() {
		other.setTotalPrice("75");
		assertFalse(Order.equals(other));
	}

	@Test
	public void constructorWithoutId() {
		Orders customer = new Orders("1", "50");
		assertNull(customer.getOrderId());
		assertNotNull(customer.getCustomerId());
		assertNotNull(customer.getTotalPrice());
	}

	@Test
	public void hashCodeTest() {
		assertEquals(Order.hashCode(), other.hashCode());
	}

	@Test
	public void hashCodeTestWithNull() {
		Orders customer = new Orders(null, null);
		Orders other = new Orders(null, null);
		assertEquals(customer.hashCode(), other.hashCode());
	}

	@Test
	public void toStringTest() {
		String toString = "orderId:1 customerId:1 totalPrice:50";
		assertEquals(toString, Order.toString());
	}
}
