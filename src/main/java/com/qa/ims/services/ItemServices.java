package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Items;

public class ItemServices implements CrudServices<Items> {

	private Dao<Items> itemDao;

	public ItemServices(Dao<Items> itemDao) {
		this.itemDao = itemDao;
	}

	public List<Items> readAll() {
		return itemDao.readAll();
	}

	public Items create(Items items) {
		return itemDao.create(items);
	}

	public Items update(Items items) {
		return itemDao.update(items);
	}

	public void delete(Long item_id) {
		itemDao.delete(item_id);
	}

}
