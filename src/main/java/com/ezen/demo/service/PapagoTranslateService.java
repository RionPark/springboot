package com.ezen.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.demo.mapper.PapagoTranslateMapper;
import com.ezen.demo.vo.PapagoTranslateVO;

@Service
public class PapagoTranslateService {
	@Autowired
	private PapagoTranslateMapper papagoTranslateMapper;
	public PapagoTranslateVO selectPapagoTranslate(PapagoTranslateVO papagoTranslate){
		return papagoTranslateMapper.selectPapagoTranslate(papagoTranslate);
	}

	public int insertPapagoTranslate(PapagoTranslateVO papagoTranslate) {
		return papagoTranslateMapper.insertPapagoTranslate(papagoTranslate);
	}
}
