package com.mycompany.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {
	@Bean
	OpenAPI openApiInformation() {
		Server localServer = new Server().url("http://localhost:8006").description("Localhost Server URL");

		Contact contact = new Contact().email("kamalikadas2003j@gmail.com").name("Kamalika Das");

		Info info = new Info().contact(contact).description("Spring Boot 3 + Open API 3")
				.summary("Demo of Spring Boot 3 & Open API 3 Integration").title("Spring Boot 3 + Open API 3")
				.version("V1.0.0")
				.license(new License().name("Kamalika 2.0").url("https://amitava-portfolio-updated.vercel.app/"));

		return new OpenAPI().info(info).addServersItem(localServer);
	}

}
