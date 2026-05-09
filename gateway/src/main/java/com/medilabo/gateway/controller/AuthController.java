package com.medilabo.gateway.controller;

import com.medilabo.gateway.model.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequiredArgsConstructor
public class AuthController {

	final private JwtEncoder jwtEncoder;

	@Value("${app.jwt-period}")
	private Integer period;

	@PostMapping("/auth/login")
	public ResponseEntity<String> login(@RequestBody LoginRequest request) {

		// Pas de gestion des users pour l'instant
		if (request.username().equals("user") && request.password().equals("password")) {

			Instant now = Instant.now();
			JwtClaimsSet claims = JwtClaimsSet.builder()
					.subject(request.username())
					.issuedAt(now)
					.expiresAt(now.plusMillis(period))
					.build();

			JwsHeader headers = JwsHeader
					.with(MacAlgorithm.HS256)
					.build();

			String token = jwtEncoder.encode(JwtEncoderParameters.from(headers, claims)).getTokenValue();
			return ResponseEntity.ok(token);
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}
}
