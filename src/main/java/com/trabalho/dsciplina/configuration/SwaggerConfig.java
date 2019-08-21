package com.trabalho.dsciplina.configuration;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	public Docket documentApi() {
		return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.apis(RequestHandlerSelectors.basePackage("com.trabalho.diciplina"))
					.paths(regex("/api.*"))
					.build()
					.apiInfo(infoMeta());
	}
	
	private ApiInfo infoMeta() {
		ApiInfo apiInfo = new ApiInfo("api diciplina", 
									  "API trabalho de manuentenção", 
									  "0.1", 
									  "", 
									  "marllo", 
									  "", 
									  "");
		return apiInfo;
	}
}
