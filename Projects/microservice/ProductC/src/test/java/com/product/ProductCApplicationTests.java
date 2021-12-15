package com.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.product.entity.Product;
import com.product.repository.ProductRepository;

@SpringBootTest
class ProductCApplicationTests {

		@Autowired
		ProductRepository productRepository;
	
//		@Test
//	void contextLoads() {
//	}
	
    @Test
	public void testCreate()
	{
			Product p=new Product();
			p.setProductId(2L);
			p.setProductName("LunchBox");
			productRepository.save(p);
			assertNotNull(productRepository.getByProductId(2L));
			
	}
//    @Test
//    public  void testPrductbyId()
//    {
//    	Product product=productRepository.findById(1L).get();
//    	assertEquals("LunchBox",product.getProductName());
//    }
    
}
