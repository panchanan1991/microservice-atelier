package io.start.springbootconfigure.springbootconfigureservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author panchanan
 * This class is the starting of productDetailsService
 *
 */
@SpringBootApplication
@EnableConfigServer
public class SpringbootConfigureServiceApplication {
	
	/**
	 * SpirngBoot Main method
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringbootConfigureServiceApplication.class, args);
	}

}
