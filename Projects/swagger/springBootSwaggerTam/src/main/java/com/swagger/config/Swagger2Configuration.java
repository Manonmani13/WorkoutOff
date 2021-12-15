package com.swagger.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class Swagger2Configuration {
	@Bean
	public Docket swaggerConfig() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/*"))
				.build()
				.apiInfo(new ApiInfo("movies api", "movie management api description", 
						"1.0", "http://c/termsofuse", 
						new Contact("name", "url", "info@com.swagger.controller"), 
						"opensource", "http://coderulagam.com/license", 
						Collections.emptyList()));

	}
}
