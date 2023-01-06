package com.ezen.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PapagoRestTest {
	private final RestTemplate restTemplate1;
	private final RestTemplate restTemplate2;
	
	
	public PapagoRestTest(@Autowired RestTemplate restTemplate1, @Autowired RestTemplate restTemplate2) {
		this.restTemplate1 = restTemplate1;
		this.restTemplate2 = restTemplate2;
		log.info("restTemplate1=>{}", restTemplate1);
		log.info("restTemplate2=>{}", restTemplate2);
	}
	
}
