package com.mphasis.service;

import java.util.List;

import com.mphasis.domain.Product;

public interface IProductService {

	Product save(Product product);

	Product update(Product product);

	void delete(int id);

	Product getProductById(int id);

	List<Product> getAllProducts();
}
