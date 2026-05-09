package com.medilabo.client_ui.feign;

import feign.RequestInterceptor;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;

@Configuration
public class FeignSecurityConfig {

	@Bean
	public RequestInterceptor jwtInterceptor() {
		return template -> {
			HttpServletRequest request = ((ServletRequestAttributes)
					RequestContextHolder.getRequestAttributes()).getRequest();
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				Arrays.stream(cookies)
						.filter(cookie -> cookie.getName().equals("jwt"))
						.findFirst()
						.ifPresent(cookie -> {
									template.header("Authorization", "Bearer " + cookie.getValue());
								}
						);
			}
		};
	}
}
