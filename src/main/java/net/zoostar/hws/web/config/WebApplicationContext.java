package net.zoostar.hws.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class WebApplicationContext implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		log.info("{}...", "Configuring index page to redirect to Swagger UI");
		registry.addRedirectViewController("/", "/swagger-ui/index.html");
	}
}
