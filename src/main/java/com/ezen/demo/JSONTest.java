package com.ezen.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
@Data
class PapagoVO{
	private MessageVO message;
}
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class MessageVO{
	private ResultVO result;
}
@Data
class ResultVO{
	private String srcLangType;
	private String tarLangType;
	private String translatedText;
	private String engineType;
	private String pivot;
	private String dict;
	private String tarDict;
}
@Slf4j
public class JSONTest {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		ObjectMapper om = new ObjectMapper();
		String json = "{\r\n"
				+ "    \"message\": {\r\n"
				+ "        \"result\": {\r\n"
				+ "            \"srcLangType\": \"ko\",\r\n"
				+ "            \"tarLangType\": \"ru\",\r\n"
				+ "            \"translatedText\": \"Вы поели?\",\r\n"
				+ "            \"engineType\": \"N2MT\",\r\n"
				+ "            \"pivot\": null,\r\n"
				+ "            \"dict\": null,\r\n"
				+ "            \"tarDict\": null\r\n"
				+ "        },\r\n"
				+ "        \"@type\": \"response\",\r\n"
				+ "        \"@service\": \"naverservice.nmt.proxy\",\r\n"
				+ "        \"@version\": \"1.0.0\"\r\n"
				+ "    }\r\n"
				+ "}";
		PapagoVO papago = om.readValue(json, PapagoVO.class);
		log.info("papago=>{}", papago);
		log.info("결국 내가 원하는 값은 =>{}", papago.getMessage().getResult().getTranslatedText());
	}
}
