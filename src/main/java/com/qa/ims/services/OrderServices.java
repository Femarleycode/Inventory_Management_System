package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Orders;

public class OrderServices implements CrudServices<Orders> {

	private Dao<Orders> orderDao;

	public OrderServices(Dao<Orders> orderDao) {
		this.orderDao = orderDao;
	}

	public List<Orders> readAll() {
		return orderDao.readAll();
	}

	public Orders create(Orders orders) {
		return orderDao.create(orders);
	}

	public Orders update(Orders orders) {
		return orderDao.update(orders);
	}

	public void delete(Long order_id) {
		orderDao.delete(order_id);
	}
}
