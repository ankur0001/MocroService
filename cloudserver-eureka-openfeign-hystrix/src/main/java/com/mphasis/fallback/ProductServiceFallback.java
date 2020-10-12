package com.mphasis.fallback;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mphasis.domain.Product;
import com.mphasis.proxy.ProductServiceProxy;

@Service
//or
//@Component
public class ProductServiceFallback implements ProductServiceProxy {

	@Override
	public Product getProductById(int id) {

		return new Product("Navneet", 23223.0);
	}

	@Override
	public List<Product> getAllProducts() {

		return new ArrayList<>();
	}

	@Override
	public Product addProduct(Product product) {

		return null;
	}

}
