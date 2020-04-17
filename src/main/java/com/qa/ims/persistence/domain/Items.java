package com.qa.ims.persistence.domain;

import java.math.BigDecimal;

public class Items {

	private Long itemId;
	private String name;
	private BigDecimal price;

	public Items(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}

	public Items(Long itemId, String name, BigDecimal price) {
		this.itemId = itemId;
		this.name = name;
		this.price = price;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
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
		return "itemId:" + itemId + " name:" + name + " price:" + price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
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

		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;

		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;

		return true;
	}

}
