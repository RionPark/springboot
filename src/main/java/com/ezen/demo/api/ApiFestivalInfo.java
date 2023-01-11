package com.ezen.demo.api;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ezen.demo.config.SSLConfig;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ApiFestivalInfo {

	private static String url = "https://apis.data.go.kr/B551011/KorService/searchFestival?numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&serviceKey=q6xPLYOTKmxI4Dtg5c0efFs4Ex%2FPCUYgCdIuVP85iRKcDLaN%2FjOI%2BehUyQ2Qp3BiqDeqELgyRHCgUvVxgyczVA%3D%3D&_type=json&eventStartDate=20220601";
	public static void main(String[] args) {
		SSLConfig sslConfig = new SSLConfig();
		
		try {
			URI uri = new URI(url);
			RestTemplate restTemplate = sslConfig.restTemplate();
			ResponseEntity<String>  response = restTemplate.getForEntity(uri, String.class);
			log.info("response=>{}",  response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
