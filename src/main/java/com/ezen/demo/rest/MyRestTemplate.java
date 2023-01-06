package com.ezen.demo.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyRestTemplate{

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
