package net.zoostar.hws;

import org.springframework.beans.factory.annotation.Value;
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

	@Value("${spring.security.enabled:false}")
	boolean securityEnabled;

	@Bean
	OpenAPI openAPI() {
		log.info("{}...", "Loading Swagger configuration");
		return new OpenAPI().info(new Info().title("Hello World SAML")
				.description("Example Project for SAML2 Integration with Spring Boot Project."));
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
		SecurityFilterChain bean = null;
		if (securityEnabled) {
			log.info("{}...", "Integrating SAML Security");
			bean = security.cors().and().csrf().disable().authorizeRequests().anyRequest().authenticated().and()
					.requiresChannel().anyRequest().requiresSecure().and()
					.saml2Login().and().build();
		} else {
			bean = security.authorizeRequests().anyRequest().permitAll().and().build();
		}

		return bean;
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(HelloWorldSaml.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldSaml.class, args);
	}

}
