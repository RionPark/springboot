package com.ezen.demo.mapper;

import com.ezen.demo.vo.PapagoTranslateVO;

public interface PapagoTranslateMapper {
	PapagoTranslateVO selectPapagoTranslate(PapagoTranslateVO papagoTranslate);
	int insertPapagoTranslate(PapagoTranslateVO papagoTranslate);
}
