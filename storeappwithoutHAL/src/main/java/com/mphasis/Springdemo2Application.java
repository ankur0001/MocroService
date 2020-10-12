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
public class Springdemo2Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Springdemo2Application.class, args);
	}

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {

		productRepository.save(new Product("LG", 43832.0));
		productRepository.save(new Product("Sony", 33832.0));
		productRepository.save(new Product("Samsung", 23832.0));
		productRepository.save(new Product("Dell", 63832.0));
		productRepository.save(new Product("HP", 77832.0));
	}

}
