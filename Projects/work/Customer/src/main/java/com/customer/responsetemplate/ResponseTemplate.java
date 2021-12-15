package com.customer.responsetemplate;

import com.customer.entity.Customer;

public class ResponseTemplate {
private Product product;
private Customer customer;
public Product getProduct() {
	return product;
}

public void setProduct(Product product) {
	this.product = product;
}

public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}

public ResponseTemplate(Product product, Customer customer) {
	super();
	this.product = product;
	this.customer = customer;
}

public ResponseTemplate() {
	super();
}

}
