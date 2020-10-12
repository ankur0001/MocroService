package com.mphasis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.mphasis.domain.Product;
import com.mphasis.repository.ProductRepository;

@EnableEurekaClient
@SpringBootApplication
public class StoreappApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StoreappApplication.class, args);
	}

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {

		productRepository.save(new Product("LG", 45393.0));
		productRepository.save(new Product("Sony", 55393.0));
		productRepository.save(new Product("Samsung", 35393.0));
		productRepository.save(new Product("Dell", 25393.0));
		productRepository.save(new Product("hp", 75393.0));
	}

}
