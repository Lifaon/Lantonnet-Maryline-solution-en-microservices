package com.medilabo.client_ui.feign;

import com.medilabo.risk.api.RiskApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "risk-client", url = "${app.gateway-url}/risk-microservice", configuration = FeignSecurityConfig.class)
public interface RiskProxy extends RiskApi {
}
