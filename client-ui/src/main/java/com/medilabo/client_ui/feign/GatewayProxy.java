package com.medilabo.client_ui.feign;

import com.medilabo.client_ui.model.LoginForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "gateway", url = "${app.gateway-url}")
public interface GatewayProxy {

	@PostMapping("/auth/login")
	String login(@RequestBody LoginForm form);
}
