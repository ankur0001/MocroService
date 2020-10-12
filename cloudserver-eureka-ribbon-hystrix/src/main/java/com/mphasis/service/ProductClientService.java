package com.mphasis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mphasis.domain.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
// or
// @Component
public class ProductClientService {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getDefaultProductById")
	public Product getProductById(int id) {

		Product product = restTemplate.getForObject("http://PRODUCT-SERVICE/products/" + id, Product.class);
		return product;
	}
	
	public Product getDefaultProductById(int id) {
		
		return new Product(id, "Sony", 88888.0);
	}
}
