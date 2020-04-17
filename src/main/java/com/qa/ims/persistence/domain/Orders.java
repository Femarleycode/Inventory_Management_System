package com.qa.ims.persistence.domain;

import java.math.BigDecimal;

public class Orders {

	private Long orderId;
	private Long customerId;
	private BigDecimal totalPrice;

	public Orders(Long customerId, BigDecimal totalPrice) {
		this.customerId = customerId;
		this.totalPrice = totalPrice;
	}

	public Orders(Long orderId, Long customerId, BigDecimal totalPrice) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.totalPrice = totalPrice;
	}

	// orderId
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	// cust_id
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	// totalPrice
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String toString() {
		return "orderId:" + orderId + " customerId:" + customerId + " totalPrice:" + totalPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((totalPrice == null) ? 0 : totalPrice.hashCode());
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
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (totalPrice == null) {
			if (other.totalPrice != null)
				return false;
		} else if (!totalPrice.equals(other.totalPrice))
			return false;
		return true;
	}

}
