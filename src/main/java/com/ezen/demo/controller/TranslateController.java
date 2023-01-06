package com.ezen.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ezen.demo.api.ApiPapagoTranslate;
import com.ezen.demo.vo.PapagoParamVO;
import com.ezen.demo.vo.PapagoVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TranslateController {
	@Autowired
	private ApiPapagoTranslate apiPapagoTranslate;

	@PostMapping("/translate")
	public PapagoVO translate(@RequestBody PapagoParamVO papago) throws JsonMappingException, JsonProcessingException {
		return apiPapagoTranslate.translate(papago);
	}
	
}
