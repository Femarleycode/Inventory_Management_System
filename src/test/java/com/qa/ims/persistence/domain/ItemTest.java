package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ItemTest {

	private Customers customer;
	private Customers other;

	@Before
	public void setUp() {
		customer = new Customers(1L, "John", "Moorside");
		other = new Customers(1L, "John", "Moorside");
	}

	@Test
	public void settersTest() {
		assertNotNull(customer.getId());
		assertNotNull(customer.getName());
		assertNotNull(customer.getAddress());

		customer.setId(null);
		assertNull(customer.getId());
		customer.setName(null);
		assertNull(customer.getName());
		customer.setAddress(null);
		assertNull(customer.getAddress());

	}

	@Test
	public void equalsWithNull() {
		assertFalse(customer.equals(null));
	}

	@Test
	public void equalsWithDifferentObject() {
		assertFalse(customer.equals(new Object()));
	}

	@Test
	public void createCustomerWithId() {
		assertEquals(1L, customer.getId(), 0);
		assertEquals("John", customer.getName());
		assertEquals("Moorside", customer.getAddress());
	}

	@Test
	public void checkEquality() {
		assertTrue(customer.equals(customer));
	}

	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(customer.equals(other));
	}

	@Test
	public void customerNameNullButOtherNameNotNull() {
		customer.setName(null);
		assertFalse(customer.equals(other));
	}

	@Test
	public void customerNamesNotEqual() {
		other.setName("rhys");
		assertFalse(customer.equals(other));
	}

	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		customer.setName(null);
		other.setName(null);
		assertTrue(customer.equals(other));
	}

	@Test
	public void nullId() {
		customer.setId(null);
		assertFalse(customer.equals(other));
	}

	@Test
	public void nullIdOnBoth() {
		customer.setId(null);
		other.setId(null);
		assertTrue(customer.equals(other));
	}

	@Test
	public void otherIdDifferent() {
		other.setId(2L);
		assertFalse(customer.equals(other));
	}

	@Test
	public void nullSurname() {
		customer.setAddress(null);
		assertFalse(customer.equals(other));
	}

	@Test
	public void nullSurnameOnBoth() {
		customer.setAddress(null);
		other.setAddress(null);
		assertTrue(customer.equals(other));
	}

	@Test
	public void otherSurnameDifferent() {
		other.setAddress("thompson");
		assertFalse(customer.equals(other));
	}

	@Test
	public void constructorWithoutId() {
		Customers customer = new Customers("John", "Moorside");
		assertNull(customer.getId());
		assertNotNull(customer.getName());
		assertNotNull(customer.getAddress());
	}

	@Test
	public void hashCodeTest() {
		assertEquals(customer.hashCode(), other.hashCode());
	}

	@Test
	public void hashCodeTestWithNull() {
		Customers customer = new Customers(null, null);
		Customers other = new Customers(null, null);
		assertEquals(customer.hashCode(), other.hashCode());
	}

	@Test
	public void toStringTest() {
		String toString = "id:1 name:John address:Moorside";
		assertEquals(toString, customer.toString());
	}
}
