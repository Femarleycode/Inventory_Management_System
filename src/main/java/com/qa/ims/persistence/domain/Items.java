package com.qa.ims.persistence.domain;

import java.math.BigDecimal;

public class Items {

	private Long item_id;
	private String name;
	private BigDecimal price;

	public Items(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}

	public Items(Long item_id, String name, BigDecimal price) {
		this.item_id = item_id;
		this.name = name;
		this.price = price;
	}

	public Long getItem_Id() {
		return item_id;
	}

	public void setItem_Id(Long item_id) {
		this.item_id = item_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String toString() {
		return "item_id:" + item_id + " name:" + name + " price:" + price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((item_id == null) ? 0 : item_id.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Items other = (Items) obj;

		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;

		if (item_id == null) {
			if (other.item_id != null)
				return false;
		} else if (!item_id.equals(other.item_id))
			return false;

		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;

		return true;
	}

}
