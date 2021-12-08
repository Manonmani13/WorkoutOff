package com.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.Product;
import com.product.repository.ProductRepository;

@Service
public class ProductService {
@Autowired
private ProductRepository productRepository;

public Product saveProducts(Product product) {
	// TODO Auto-generated method stub
	return productRepository.save(product);
}

public Product getProductById(long productId) {
	// TODO Auto-generated method stub
	return productRepository.getByProductId(productId);
}


}
