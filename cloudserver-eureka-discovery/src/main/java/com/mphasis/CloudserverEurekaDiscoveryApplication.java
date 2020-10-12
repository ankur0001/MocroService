package com.mphasis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;

@SpringBootApplication
public class CloudserverEurekaDiscoveryApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CloudserverEurekaDiscoveryApplication.class, args);
	}

	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Override
	public void run(String... args) throws Exception {
	
		discoveryClient.getServices().forEach((service) -> {
			
			discoveryClient.getInstances(service).forEach((serviceInstance) -> {
				
				System.out.println("---------------------------------------------");
				System.out.println("Service Id:" + serviceInstance.getServiceId());
				System.out.println("Service URI:" + serviceInstance.getUri());
				System.out.println("Service HOST:" + serviceInstance.getHost());
				System.out.println("Service PORT:" + serviceInstance.getPort());
				System.out.println("---------------------------------------------");
			});
		});
	}

}
