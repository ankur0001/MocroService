package com.mphasis.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mphasis.domain.Product;

@FeignClient("product-service")
public interface ProductServiceProxy {

	@GetMapping(value = "/products/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public EntityModel<Product> getProductById(@PathVariable("id") int id);

	@GetMapping(value = "/products", produces = { MediaType.APPLICATION_JSON_VALUE })
	public CollectionModel<EntityModel<Product>> getAllProducts();

	@PostMapping(value = "/products", 
			consumes = { MediaType.APPLICATION_JSON_VALUE },
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public EntityModel<Product> addProduct(@RequestBody Product product);
	
	@PutMapping(value = "/products/{id}", 
			consumes = { MediaType.APPLICATION_JSON_VALUE },
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public EntityModel<Product> updateProduct(
				@PathVariable("id") int id,
				@RequestBody Product product);
	
	@DeleteMapping(value = "/products/{id}")
	public void deleteProductById(@PathVariable("id") int id);
}
