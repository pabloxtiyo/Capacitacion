package com.pportillo.localiza.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.pportillo.localiza.security.CustomAuthenticationProvider;
import com.pportillo.localiza.security.LoginFailureHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomAuthenticationProvider authenticationProvider;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().headers().disable().authorizeRequests()
			.anyRequest().authenticated()
			.and().formLogin().loginPage("/login").permitAll()
			.failureHandler(new LoginFailureHandler())
			.and().httpBasic().and().logout().permitAll()
			.and().exceptionHandling().accessDeniedPage("/403");

	}
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
	}

	@Override
    protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
		authManagerBuilder.authenticationProvider(authenticationProvider);
        
	}


}
