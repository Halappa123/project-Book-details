package com.example;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class OnlineBookingStoreProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineBookingStoreProjectApplication.class, args);
	}
	
	@Bean
	public Docket getDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}
	private ApiInfo apiInfo() {
		return new ApiInfo("Book Api 1", "apis Of the Books", "1.0", "open Source",
				new springfox.documentation.service.Contact("Halappa", "www.google.com", "halappanm28@gmail.com"),
				"api Licence","www.google.com",Collections.EMPTY_LIST);
	}
	
//	 @Bean
//	    public Docket api() {
//	        return new Docket(DocumentationType.SWAGGER_2)
//	                .securitySchemes(Collections.singletonList(apiKey()))
//	   //             .securityContexts(Collections.singletonList(securityContext()))
//	                .select()
//	                .apis(RequestHandlerSelectors.basePackage("com.example.controllers"))
//	                .paths(PathSelectors.any())
//	                .build();
//	    }
//
//	    private ApiKey apiKey() {
//	        return new ApiKey("apiKey", "Authorization", "header");
//	    }
//
//	    private SecurityContext securityContext() {
//	        return SecurityContext
//	        		.builder()
//	                .securityReferences(Collections.singletonList(new SecurityReference("apiKey", (springfox.documentation.service.AuthorizationScope[]) new AuthorizationScope[0])))
//	                .build();
//	    }

}
