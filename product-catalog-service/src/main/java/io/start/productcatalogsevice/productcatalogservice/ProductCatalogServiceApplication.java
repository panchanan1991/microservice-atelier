package io.start.productcatalogsevice.productcatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/**
 * This is entry class for the ProductCatalogService
 * @author Panchanan
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class ProductCatalogServiceApplication {
	
	@Bean
	@LoadBalanced
	public RestTemplate getestTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
	  SpringApplication.run(ProductCatalogServiceApplication.class, args); }
	 

}
