package com.medilabo.client_ui.feign;

import com.medilabo.risk.api.RiskApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "risk-client", url = "${gateway.url}/risk-microservice")
public interface RiskProxy extends RiskApi {
}
