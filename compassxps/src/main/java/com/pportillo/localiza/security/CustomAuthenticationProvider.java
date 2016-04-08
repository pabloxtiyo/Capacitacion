package com.pportillo.localiza.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.pportillo.localiza.service.JdbCallService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private JdbCallService jdbCallService;

	@Override
	public Authentication authenticate(Authentication autentic)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		
		try {
			
			String username = autentic.getName();
			String password = (String) autentic.getCredentials();
			
//			Integer usuario = jdbCallService.getValue(username, password);
			Integer usuario = 1;
			
			if(usuario >= 1)
			{
				Authentication auth = null;
				List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
				grantedAuths.add(new CustomGrantedAuthority("ROLE_"+"Prueba"));
				auth = new UsernamePasswordAuthenticationToken("pablo", "pportillo", grantedAuths);
				SecurityContextHolder.getContext().setAuthentication(autentic);
				
				return auth;
			}
			else
			{
				throw new BadCredentialsException("Usuario o Contrase&ntilde;a Inv&aacute;lidos");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new BadCredentialsException("Usuario o Contrase&ntilde;a Inv&aacute;lidos");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
