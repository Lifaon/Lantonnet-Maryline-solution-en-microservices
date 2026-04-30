package com.medilabo.risk.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface RiskApi {

	@GetMapping("/risk/{id}")
	public Risk getUserRisk(@PathVariable Integer id);
}
