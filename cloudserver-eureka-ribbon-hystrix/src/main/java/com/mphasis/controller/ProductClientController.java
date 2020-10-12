package com.mphasis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.domain.Product;
import com.mphasis.service.ProductClientService;

@RestController
@Scope("request")
public class ProductClientController {

	@Autowired
	private ProductClientService productClientService;
	
	@GetMapping("/get-products/{id}")
	public Product getProductById(@PathVariable("id") int id) {

		return productClientService.getProductById(id);
	}
}
