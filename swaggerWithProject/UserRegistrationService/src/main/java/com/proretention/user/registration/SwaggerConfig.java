package com.proretention.user.registration;

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
				.apis(RequestHandlerSelectors.basePackage("com.proretention.user.registration"))
				.build()
				.apiInfo(apiDetails());

	}
	private ApiInfo apiDetails()
	{
		return new ApiInfo(
				 "User Registration Service",
		            "This API acts as a gateway, communicating with other microservices for user registration",
		            "1.0",
		            "",
		            new springfox.documentation.service.Contact("Pradeep Kumar", "https://proretention.com","pradeepkumar.s@engage2serve.com"),
		            "Apache 2.0",
		            "http://www.apache.org/licenses/LICENSE-2.0.html",
		            Collections.emptyList());
				
	}
}
