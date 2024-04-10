package net.zoostar.hws;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class HelloWorldSaml extends SpringBootServletInitializer {

	@Bean
	OpenAPI openAPI() {
		log.info("{}...", "Loading Swagger configuration");
		return new OpenAPI().info(new Info().title("Hello World SAML")
				.description("Example Project for SAML2 Integration with Spring Boot Project."));
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
		return security
				.authorizeRequests(authorize -> authorize.antMatchers("/").permitAll().anyRequest().authenticated())
				.saml2Login(withDefaults()).build();
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(HelloWorldSaml.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldSaml.class, args);
	}

}
