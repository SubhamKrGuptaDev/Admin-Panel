package com.admin.panel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdminPanelApiApplication {

	private Logger logger = LoggerFactory.getLogger(AdminPanelApiApplication.class);
	
	@Bean
	public GroupedOpenApi userApi() {
		String path = "/user/**";
		logger.info("Initialization userApi() -> ");
		return GroupedOpenApi.builder().group("User").pathsToMatch(path).build();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(AdminPanelApiApplication.class, args);
	}
	
}








