package com.fotos.photographer.master.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class PhotoGMasterConfig {

	@Value("${root.service.name}")
	private String serviceName;
	
	@Value("${root.service.description}")
	private String serviceDesc;
	
	@Value("${root.service.version}")
	private String version;
	
	@Value("${root.service.usage}")
	private String usage;
	
	@Value("${root.service.owner}")
	private String owner;
	
	@Value("${root.service.website}")
	private String website;
	
	@Value("${root.service.officialemail}")
	private String officialemail;
	
	@Value("${root.service.license}")
	private String license;
	
	@Bean
	public Docket getDocketForSwagger() {
		return new Docket(DocumentationType.SWAGGER_2)
						.select()
							.apis(RequestHandlerSelectors.basePackage("com.fotos.photographer.master.service"))
								.build()
									.apiInfo(apiDetails());
	}
	
	private ApiInfo apiDetails() {
		return new ApiInfo(serviceName, serviceDesc,version,usage, 
				new springfox.documentation.service.Contact(owner, website, officialemail), 
					license, owner, Collections.emptyList());
	}
}
