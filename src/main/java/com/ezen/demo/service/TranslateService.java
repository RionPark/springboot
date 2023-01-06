package com.ezen.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.demo.api.ApiPapagoTranslate;
import com.ezen.demo.vo.MessageVO;
import com.ezen.demo.vo.PapagoParamVO;
import com.ezen.demo.vo.PapagoTranslateVO;
import com.ezen.demo.vo.PapagoVO;
import com.ezen.demo.vo.ResultVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class TranslateService {
	
	@Autowired
	private PapagoTranslateService papagoTranService;
	@Autowired
	private ApiPapagoTranslate apiPapagoTranslate;
	
	public PapagoVO translate(PapagoParamVO papagoParam) throws JsonMappingException, JsonProcessingException {
		PapagoVO papago = new PapagoVO();
		PapagoTranslateVO pt = new PapagoTranslateVO();
		pt.setPtSource(papagoParam.getSource());
		pt.setPtTarget(papagoParam.getTarget());
		pt.setPtText(papagoParam.getText());
		
		PapagoTranslateVO resultPt = papagoTranService.selectPapagoTranslate(pt);
		if(resultPt==null) {
			papago = apiPapagoTranslate.translate(papagoParam);
			pt.setPtResult(papago.getMessage().getResult().getTranslatedText());
			papagoTranService.insertPapagoTranslate(pt);
			return papago;
		}
		MessageVO message = new MessageVO();
		ResultVO result = new ResultVO();
		result.setTranslatedText(resultPt.getPtResult());
		message.setResult(result);
		papago.setMessage(message);
		return papago;
	}
	
	
}
