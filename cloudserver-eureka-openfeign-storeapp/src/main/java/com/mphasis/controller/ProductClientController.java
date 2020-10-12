package com.mphasis.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.domain.Product;
import com.mphasis.proxy.ProductServiceProxy;

@RestController
@Scope("request")
public class ProductClientController {

	@Autowired
	private ProductServiceProxy productServiceProxy;

	@GetMapping("/get-products/{id}")
	public EntityModel<Product> getProductById(@PathVariable("id") int id) {

		return productServiceProxy.getProductById(id);
	}

	@GetMapping("/get-products")
	public CollectionModel<EntityModel<Product>> getAllProductById() {

		return productServiceProxy.getAllProducts();
	}
	
	@PostMapping(value = "/put-products", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public EntityModel<Product> addProduct(@RequestBody Product product) {
		
		return productServiceProxy.addProduct(product);
	}
}
