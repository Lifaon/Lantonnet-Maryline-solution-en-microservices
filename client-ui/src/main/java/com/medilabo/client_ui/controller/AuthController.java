package com.medilabo.client_ui.controller;

import com.medilabo.client_ui.feign.GatewayProxy;
import com.medilabo.client_ui.model.LoginForm;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.SameSiteCookies;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class AuthController {

	final private GatewayProxy gatewayProxy;

	@Value("${app.jwt-period}")
	private Integer period;

	@GetMapping
	public String login(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		return "login";
	}

	@PostMapping
	public String login(@ModelAttribute LoginForm loginForm,
						HttpServletResponse response) {

		String jwt = gatewayProxy.login(loginForm);

		Cookie cookie = new Cookie("jwt", jwt);
		cookie.setHttpOnly(true);
		cookie.setSecure(true);
		cookie.setPath("/");
		cookie.setMaxAge(period);
		cookie.setAttribute("SameSite", SameSiteCookies.STRICT.getValue());
		response.addCookie(cookie);

		return "redirect:/";
	}

}
