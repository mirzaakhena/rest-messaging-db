package com.mirzaakhena.frontend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class FrontendConfig {

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
