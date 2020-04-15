package com.qa.ims.persistence.domain;

import java.math.BigDecimal;

public class Orders {

	private Long order_id;
	private Long customer_id;
	private BigDecimal total_price;

	public Orders(Long customer_id, BigDecimal Total_price) {
		this.customer_id = customer_id;
		this.total_price = Total_price;
	}

	public Orders(Long order_id, Long customer_id, BigDecimal Total_price) {
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.total_price = Total_price;
	}

	public Long getOrder_Id() {
		return order_id;
	}

	public void setOrder_Id(Long order_id) {
		this.order_id = order_id;
	}

	public Long getCustomer_Id() {
		return customer_id;
	}

	public void setCustomer_Id(Long customer_id) {
		this.customer_id = customer_id;
	}

	public BigDecimal getTotal_Price() {
		return total_price;
	}

	public void setTotal_Price(BigDecimal Total_price) {
		this.total_price = Total_price;
	}

	public String toString() {
		return "order_id:" + order_id + " customer_id:" + customer_id + " total_price:" + total_price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer_id == null) ? 0 : customer_id.hashCode());
		result = prime * result + ((order_id == null) ? 0 : order_id.hashCode());
		result = prime * result + ((total_price == null) ? 0 : total_price.hashCode());
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
		Orders other = (Orders) obj;
		if (customer_id == null) {
			if (other.customer_id != null)
				return false;
		} else if (!customer_id.equals(other.customer_id))
			return false;
		if (order_id == null) {
			if (other.order_id != null)
				return false;
		} else if (!order_id.equals(other.order_id))
			return false;
		if (total_price == null) {
			if (other.total_price != null)
				return false;
		} else if (!total_price.equals(other.total_price))
			return false;
		return true;
	}

}
