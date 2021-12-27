package com.pro.user.registration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	@Bean
	public Docket api()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/user-registration/**"))
				.apis(RequestHandlerSelectors.basePackage("com.pro.user.registration"))
				.build()
				.apiInfo(apiDetails());

	}
	private ApiInfo apiDetails()
	{
		return new ApiInfo(
				"User Details Api",
				"Details about User",
				"1.0",
				"Easy to understand formate",
				new springfox.documentation.service.Contact("UserDetails", "http://localhost:9001/user-registration",
						"userRegistration.com"),
				"Api License",
				"http://localhost:9001",
				Collections.emptyList());
				
	}
}
