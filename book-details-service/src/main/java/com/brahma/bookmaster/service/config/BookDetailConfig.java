package com.brahma.bookmaster.service.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class BookDetailConfig {

	@Value("${bookdetails.info.service.name}")
	private String serviceName;
	
	@Value("${bookdetails.info.service.description}")
	private String serviceDesc;
	
	@Value("${service.activeversion}")
	private String version;
	
	@Value("${bookdetails.info.service.usage}")
	private String usage;
	
	@Value("${bookdetails.info.service.owner}")
	private String owner;
	
	@Value("${bookdetails.info.service.website}")
	private String website;
	
	@Value("${bookdetails.info.service.officialemail}")
	private String officialemail;
	
	@Value("${bookdetails.info.service.license}")
	private String license;
	
	@Bean
	public Docket getDocketForSwagger() {
		return new Docket(DocumentationType.SWAGGER_2)
						.select()
							.apis(RequestHandlerSelectors.basePackage("com.ericsson.eai.deviceinfo.service"))
								.build()
									.apiInfo(apiDetails());
	}
	
	private ApiInfo apiDetails() {
		return new ApiInfo(serviceName, serviceDesc,version,usage, 
				new springfox.documentation.service.Contact(owner, website, officialemail), 
					license, owner, Collections.emptyList());
	}
}
