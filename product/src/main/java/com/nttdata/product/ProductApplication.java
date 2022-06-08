package com.nttdata.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ProductApplication {

	private final Logger LOGGER = LoggerFactory.getLogger("start");

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}


}
