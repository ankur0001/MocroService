package com.mphasis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@EnableFeignClients
@SpringBootApplication
public class CloudserverEurekaOpenfeignStoreappApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudserverEurekaOpenfeignStoreappApplication.class, args);
	}

}
