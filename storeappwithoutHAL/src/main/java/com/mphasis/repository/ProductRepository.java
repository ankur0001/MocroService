package com.mphasis.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mphasis.domain.Product;

@Repository("productRepository")
@Scope("singleton")
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
