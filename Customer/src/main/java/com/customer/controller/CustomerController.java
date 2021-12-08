package com.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.entity.Customer;
import com.customer.responsetemplate.ResponseTemplate;
import com.customer.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

@PostMapping()
public Customer saveCustomerDetails(@RequestBody Customer customer)
{
	return customerService.saveCustomerDetails(customer);
}

@GetMapping("/{id}")
public ResponseTemplate getByCustomerWithProductId(@PathVariable("id") long customerId)
{
	return customerService.getByCustomerProductId(customerId);
}
}
