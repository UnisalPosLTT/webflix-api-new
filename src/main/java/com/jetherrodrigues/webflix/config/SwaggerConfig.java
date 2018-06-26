package com.jetherrodrigues.webflix.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {                                    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2) 
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.jetherrodrigues.webflix.resource"))  
          .paths(regex("/api.*"))                     
          .build()
          .apiInfo(metaData());
    }

	private ApiInfo metaData() {
		ApiInfo apiInfo = new ApiInfo("Webflix REST API", "Webflix", "1.0",
				"Terms of service",
				new Contact("Webflix", "http://www.webflix.com", "contato@webflix.com"),
				"2018 © Webflix.", "http://www.webflix.com");
		return apiInfo;
	}

}