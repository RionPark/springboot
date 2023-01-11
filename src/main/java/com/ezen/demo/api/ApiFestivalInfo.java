package com.ezen.demo.api;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.ezen.demo.config.SSLConfig;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ApiFestivalInfo {

	private static String url = "https://apis.data.go.kr/B551011/KorService/searchFestival";
	public static void main(String[] args) {
		SSLConfig sslConfig = new SSLConfig();
		
		try {
			UriComponents complexUrl = UriComponentsBuilder.fromUriString(url)
	                .queryParam("serviceKey", "q6xPLYOTKmxI4Dtg5c0efFs4Ex%2FPCUYgCdIuVP85iRKcDLaN%2FjOI%2BehUyQ2Qp3BiqDeqELgyRHCgUvVxgyczVA%3D%3D")
	                .queryParam("numOfRows", "2000")
	                .queryParam("pageNo", "1")
	                .queryParam("MobileOS", "ETC")
	                .queryParam("MobileApp", "AppTest")
	                .queryParam("_type", "json")
	                .queryParam("listYN", "Y")
	                .queryParam("arrange", "D")
	                .queryParam("eventStartDate", "20220601")
	                .build();
			RestTemplate restTemplate = sslConfig.restTemplate();
//			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String>  response = restTemplate.getForEntity(complexUrl.toUri(), String.class);
			log.info("response=>{}",  response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
