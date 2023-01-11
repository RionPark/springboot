package com.ezen.demo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;


@Data
class DataVO{
	private DrinkVO drink; 
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class DrinkVO{
	private List<CoffeeVO> list;
}
@Data
class CoffeeVO{
	private String name;
	private int price;
	private String brand;
}
@Slf4j
public class JSONTest {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		ObjectMapper om = new ObjectMapper();
		String json = "{\r\n"
				+ "  \"drink\": {\r\n"
				+ "    \"list\": [\r\n"
				+ "      {\r\n"
				+ "        \"name\": \"coffee\",\r\n"
				+ "        \"price\": 2000,\r\n"
				+ "        \"brand\": \"back\"\r\n"
				+ "      },\r\n"
				+ "      {\r\n"
				+ "        \"name\": \"coffee\",\r\n"
				+ "        \"price\": 5000,\r\n"
				+ "        \"brand\": \"starbucks\"\r\n"
				+ "      },\r\n"
				+ "      {\r\n"
				+ "        \"name\": \"coffee\",\r\n"
				+ "        \"price\": 1700,\r\n"
				+ "        \"brand\": \"venti\"\r\n"
				+ "      }\r\n"
				+ "    ],\r\n"
				+ "    \"hotBrand\": \"back\",\r\n"
				+ "    \"hotBrandAddress\": \"Seoul\"\r\n"
				+ "  }\r\n"
				+ "}";
		DataVO data = om.readValue(json, DataVO.class);
		log.debug("data=>{}", data);
	}
}
