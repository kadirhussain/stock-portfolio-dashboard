package com.kane.portfolio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {
	
	@Bean
	public OpenAPI api() {
		return new OpenAPI()
		     .info(new Info().title("PortfolioTracker API"));
//		    	.description("Kane PortfolioTracker API Documentation")
//		    	.version("v1")
//		    	.license( new License().name("Apache")));
	}

}
