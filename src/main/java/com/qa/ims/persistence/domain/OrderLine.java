package com.qa.ims.persistence.domain;

public class OrderLine {

	private Long order_id;
	private Long item_id;
	// private List<Long> item_id = new ArrayList<>();

	// update
	public OrderLine(Long item_id) {
		this.item_id = item_id;
	}

	// create
	public OrderLine(Long order_id, Long item_id) {
		this.order_id = order_id;
		this.item_id = item_id;
	}

	// order_id
	public Long getOrder_Id() {
		return order_id;
	}

	public void setOrder_Id(Long order_id) {
		this.order_id = order_id;
	}

	// item_id
	public Long getItem_Id() {
		return item_id;
	}

	public void setItem_Id(Long item_id) {
		this.item_id = item_id;
	}

	public String toString() {
		return "order_id:" + order_id + "item_id:" + item_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order_id == null) ? 0 : order_id.hashCode());
		result = prime * result + ((item_id == null) ? 0 : item_id.hashCode());
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

		if (order_id == null) {
			if (other.order_id != null)
				return false;
		} else if (!order_id.equals(other.order_id))
			return false;

		if (item_id == null) {
			if (other.order_id != null)
				return false;
		} else if (!item_id.equals(other.item_id))
			return false;

		return true;
	}

}
