package br.com.toshiakibruno.workshopmongo.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
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
		return new Docket(DocumentationType.SWAGGER_2).useDefaultResponseMessages(false)

				.select().apis(RequestHandlerSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.nelioalves.cursomc.resources"))
				.paths(PathSelectors.any()).build().	apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("WorkShop usando MongoDB e Spring Boot", "", "Versão 1.0", "",
				new Contact("Bruno Toshiaki Watanabe Avelar", "https://www.linkedin.com/in/brunotoshiaki/",
						"brunotw@gmail.com"),
				"", "", Collections.emptyList()

		);
	}

}
