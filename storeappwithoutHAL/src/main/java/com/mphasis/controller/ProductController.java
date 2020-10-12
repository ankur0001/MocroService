package com.mphasis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.domain.Product;
import com.mphasis.service.IProductService;

@RestController("productRestController")
@Scope("request")
public class ProductController {

	@Autowired
	@Qualifier("productService")
	private IProductService productService;

	@GetMapping(value = "/products", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping(value = "/products/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Product getProductById(@PathVariable("id") int id) {
		return productService.getProductById(id);
	}

	@DeleteMapping(value = "/products/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteProductById(@PathVariable("id") int id) {
		productService.delete(id);
	}

	@PostMapping(value = "/products", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.CREATED)
	public Product addProduct(@RequestBody Product product) {
		return productService.save(product);
	}

	@PutMapping(value = "/products", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.OK)
	public Product updateProduct(@RequestBody Product product) {
		return productService.save(product);
	}

}
