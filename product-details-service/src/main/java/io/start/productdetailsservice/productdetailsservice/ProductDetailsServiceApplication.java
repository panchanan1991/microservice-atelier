package io.start.productdetailsservice.productdetailsservice;

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
public class ProductDetailsServiceApplication {
	
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
	 * SpirngBoot Main method
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		SpringApplication.run(ProductDetailsServiceApplication.class, args);
	}

}
