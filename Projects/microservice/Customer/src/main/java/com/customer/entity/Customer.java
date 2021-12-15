package com.customer.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
@Id
private long customerId;
private String customerName;
private long productId;

public Customer() {
	super();
}

public Customer(long customerId, String customerName, long productId) {
	super();
	this.customerId = customerId;
	this.customerName = customerName;
	this.productId = productId;
}

public long getCustomerId() {
	return customerId;
}

public void setCustomerId(long customerId) {
	this.customerId = customerId;
}

public String getCustomerName() {
	return customerName;
}

public void setCustomerName(String customerName) {
	this.customerName = customerName;
}

public long getProductId() {
	return productId;
}

public void setProductId(long productId) {
	this.productId = productId;
}



}
