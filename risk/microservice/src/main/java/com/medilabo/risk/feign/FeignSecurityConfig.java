package com.medilabo.risk.feign;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignSecurityConfig {

	@Value("${app.api-key}")
	private String apiKey;

	@Bean
	public RequestInterceptor apiKeyInterceptor() {
		return template -> template.header("X-Api-Key", apiKey);
	}
}