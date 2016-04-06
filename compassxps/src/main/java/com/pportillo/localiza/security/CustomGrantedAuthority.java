package com.pportillo.localiza.security;

import org.springframework.security.core.GrantedAuthority;

public class CustomGrantedAuthority implements GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String Authority;

	/**
	 * @param authority
	 */
	public CustomGrantedAuthority(String authority) {
		super();
		Authority = authority;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return Authority;
	}

	public void setAuthority(String authority) {
		Authority = authority;
	}

}
