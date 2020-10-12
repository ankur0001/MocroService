package com.mphasis.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

	// Registry aware HTTP CLient
	// Ribbon - CLient Side Load Balancer
	
	@LoadBalanced
	@Bean
	@Scope("singleton")
	public RestTemplate	getRestTemplate() {
	
		return new RestTemplate();
	}
}
