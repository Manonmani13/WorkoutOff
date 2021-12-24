package com.module;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/module"))
				.apis(RequestHandlerSelectors.basePackage("com.module"))
				.build()
				.apiInfo(apiDetails());

	}
	private ApiInfo apiDetails()
	{
		return new ApiInfo(
				"Module Details Api",
				"Details about Module",
				"1.0",
				"Easy to understand",
				new springfox.documentation.service.Contact("Module", "http://localhost:8080/module",
						"modulegmail.com"),
				"Api License",
				"http://localhost:8080",
				Collections.emptyList());
				
	}
}
