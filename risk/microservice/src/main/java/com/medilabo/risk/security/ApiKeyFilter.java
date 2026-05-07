package com.medilabo.risk.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

public class ApiKeyFilter extends OncePerRequestFilter {

	private final String apiKey;

	public ApiKeyFilter(String apiKey) {
		this.apiKey = apiKey;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request,
									HttpServletResponse response,
									FilterChain chain) throws ServletException, IOException {

		String receivedKey = request.getHeader("X-Api-Key");

		if (apiKey.equals(receivedKey)) {
			SecurityContextHolder.getContext().setAuthentication(
					new PreAuthenticatedAuthenticationToken(receivedKey, null, List.of())
			);
			chain.doFilter(request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		}
	}
}