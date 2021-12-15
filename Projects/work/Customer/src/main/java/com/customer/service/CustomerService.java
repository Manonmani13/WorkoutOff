package com.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.customer.entity.Customer;
import com.customer.repository.CustomerRepository;
import com.customer.responsetemplate.Product;
import com.customer.responsetemplate.ResponseTemplate;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	RestTemplate restTemplate;
	
	public Customer saveCustomerDetails(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

//	public Customer getCustomerById(long customerId) {
//		// TODO Auto-generated method stub
//		return customerRepository.findByCustomerId(customerId);
//	}

	public ResponseTemplate getCustomerWithProductId(long customerId) {
		ResponseTemplate  rt=new ResponseTemplate();
		Customer customer=customerRepository.getByCustomerId(customerId);
		Product product=restTemplate.getForObject("http://localhost:8082/product/"+customer.getProductId(), Product.class);
		rt.setCustomer(customer);
		rt.setProduct(product);
		return rt;
	}



}
