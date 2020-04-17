package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class OrderTest {

	private Orders order;
	private Orders other;

	@Before
	public void setUp() {
		order = new Orders(1L, 1L, BigDecimal.valueOf(50));
		other = new Orders(1L, 1L, BigDecimal.valueOf(50));
	}

	@Test
	public void settersTest() {
		assertNotNull(order.getOrderId());
		assertNotNull(order.getCustomerId());
		assertNotNull(order.getTotalPrice());

		order.setOrderId(null);
		assertNull(order.getOrderId());
		order.setCustomerId(null);
		assertNull(order.getCustomerId());
		order.setTotalPrice(null);
		assertNull(order.getTotalPrice());

	}

	@Test
	public void equalsWithNull() {
		assertFalse(order.equals(null));
	}

	@Test
	public void equalsWithDifferentObject() {
		assertFalse(order.equals(new Object()));
	}

	@Test
	public void createOrderWithId() {
		assertEquals(1L, order.getOrderId(), 0);
		assertEquals(1L, order.getCustomerId(), 0);
		assertEquals(BigDecimal.valueOf(50), order.getTotalPrice());
	}

	@Test
	public void checkEquality() {
		assertTrue(order.equals(order));
	}

	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(order.equals(other));
	}

	@Test
	public void customerNameNullButOtherNameNotNull() {
		order.setCustomerId(null);
		assertFalse(order.equals(other));
	}

	@Test
	public void OrderCustomerIdNotEqual() {
		other.setCustomerId(2L);
		assertFalse(order.equals(other));
	}

	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		order.setCustomerId(null);
		other.setCustomerId(null);
		assertTrue(order.equals(other));
	}

	@Test
	public void nullId() {
		order.setOrderId(null);
		assertFalse(order.equals(other));
	}

	@Test
	public void nullIdOnBoth() {
		order.setOrderId(null);
		other.setOrderId(null);
		assertTrue(order.equals(other));
	}

	@Test
	public void otherIdDifferent() {
		other.setOrderId(2L);
		assertFalse(order.equals(other));
	}

	@Test
	public void nullPrice() {
		order.setTotalPrice(null);
		assertFalse(order.equals(other));
	}

	@Test
	public void nullTotalPriceOnBoth() {
		order.setTotalPrice(null);
		other.setTotalPrice(null);
		assertTrue(order.equals(other));
	}

	@Test
	public void otherTotalPriceDifferent() {
		other.setTotalPrice(BigDecimal.valueOf(75));
		assertFalse(order.equals(other));
	}

	@Test
	public void constructorWithoutId() {
		Orders customer = new Orders(1L, BigDecimal.valueOf(50));
		assertNull(customer.getOrderId());
		assertNotNull(customer.getCustomerId());
		assertNotNull(customer.getTotalPrice());
	}

	@Test
	public void hashCodeTest() {
		assertEquals(order.hashCode(), other.hashCode());
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
		assertEquals(toString, order.toString());
	}
}
