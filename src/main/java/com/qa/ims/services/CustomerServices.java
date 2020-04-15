package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Customers;

public class CustomerServices implements CrudServices<Customers> {

	private Dao<Customers> customerDao;

	public CustomerServices(Dao<Customers> customerDao) {
		this.customerDao = customerDao;
	}

	public List<Customers> readAll() {
		return customerDao.readAll();
	}

	public Customers create(Customers customer) {
		return customerDao.create(customer);
	}

	public Customers update(Customers customer) {
		return customerDao.update(customer);
	}

	public void delete(Long customer_id) {
		customerDao.delete(customer_id);
	}

}
