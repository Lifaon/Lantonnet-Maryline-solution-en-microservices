package com.medilabo.client_ui.config;

import feign.FeignException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(FeignException.Unauthorized.class)
	public String handleUnauthorized() {
		return "redirect:/login";
	}
}