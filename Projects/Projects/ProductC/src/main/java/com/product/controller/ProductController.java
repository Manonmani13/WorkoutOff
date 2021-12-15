package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.Product;
import com.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
@Autowired
private ProductService productService;

@PostMapping()
public Product saveProducts(@RequestBody Product product)
{
	return productService.saveProducts(product);
}

@GetMapping("/{id}")
public Product getProductsById(@PathVariable("id") long productId)
{
	return productService.getProductById(productId);
}
}
