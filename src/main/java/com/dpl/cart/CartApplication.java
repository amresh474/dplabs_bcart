package com.dpl.cart;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CartApplication {
	private static Logger logger = LogManager.getLogger(CartApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(CartApplication.class, args);
		 logger.info("Info level log message  =============================");
	}

}
