package io.start.productratingservice.productratingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author panchanan
 * This class is the starting of productDetailsService
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class ProductRatingServiceApplication {
	
	/**
	 * Create bean for rest template
	 * @return RestTemplate
	 * 
	 */
	@Bean
	@LoadBalanced
	public RestTemplate getestTemplate() {
		return new RestTemplate();
	}
	
	/**
	 * Main method of Springboot application service
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		SpringApplication.run(ProductRatingServiceApplication.class, args);
	}

}
