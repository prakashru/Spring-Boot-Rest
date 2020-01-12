package com.journaldev.spring.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//Swagger Config
//Enable Swagger
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	//Bean Docket
	//Swagger 2
	//All the paths
	//All the Apis
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2) 
        		//.apiInfo(apiInfo)
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())  
          
          .build();                                           
    }
	

}
