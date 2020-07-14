package com.tataaia.tatarestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan("com.tataaia.*")
@EnableSwagger2
public class TataRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TataRestApiApplication.class, args);
	}
	
	@Bean
	public Docket productApi() {
	    return new Docket(DocumentationType.SWAGGER_2).select()
	    		.apis(RequestHandlerSelectors.basePackage("com.tataaia.*")).build();
	}

}
