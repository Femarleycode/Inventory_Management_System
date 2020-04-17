package com.qa.ims.persistence.domain;

public class OrderLine {

	private Long orderId;
	private Long itemId;

	// update
	public OrderLine(Long itemId) {
		this.itemId = itemId;
	}

	// create
	public OrderLine(Long orderId, Long itemId) {
		this.orderId = orderId;
		this.itemId = itemId;
	}

	// orderId
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	// itemId
	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String toString() {
		return "orderId:" + orderId + "itemId:" + itemId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
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
		OrderLine other = (OrderLine) obj;

		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;

		if (itemId == null) {
			if (other.orderId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;

		return true;
	}

}
