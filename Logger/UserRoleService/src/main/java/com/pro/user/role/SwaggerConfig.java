package com.pro.user.role;

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
				.paths(PathSelectors.ant("/user/role/**"))
				.apis(RequestHandlerSelectors.basePackage("com.pro.user.role"))
				.build()
				.apiInfo(apiDetails());

	}
	private ApiInfo apiDetails()
	{
		return new ApiInfo(
				"UserRole Details Api",
				"Details about UserRole",
				"1.0",
				"Easy to understand formate",
				new springfox.documentation.service.Contact("UserRole Details", "http://localhost:9006/user/role",
						"userRole.com"),
				"Api License",
				"http://localhost:9006",
				Collections.emptyList());
				
	}
}
