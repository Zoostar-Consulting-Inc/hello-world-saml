package net.zoostar.hws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class HelloWorldSaml {

	@Bean
	OpenAPI openAPI() {
		log.info("{}...", "Loading Swagger configuration");
		return new OpenAPI().info(new Info().title("Hello World SAML")
				.description("Example Project for SAML2 Integration with Spring Boot Project."));
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldSaml.class, args);
	}

}
