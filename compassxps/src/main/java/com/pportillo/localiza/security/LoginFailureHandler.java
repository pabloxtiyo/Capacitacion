package com.pportillo.localiza.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException ae)
			throws IOException, ServletException {
		if (ae.getClass().isAssignableFrom(BadCredentialsException.class)) {
			request.getSession().setAttribute("error", true);
			request.getSession().setAttribute("excep", ae.getMessage());
			response.sendRedirect("/LocalizaGPS/login");
		} else if (ae.getClass().isAssignableFrom(DisabledException.class)) {
		}
	}

}
