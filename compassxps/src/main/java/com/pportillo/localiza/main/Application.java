package com.pportillo.localiza.main;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import com.pportillo.localiza.config.AppContext;

@EnableAutoConfiguration
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(AppContext.class, args);

	}


}
