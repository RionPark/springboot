package com.ezen.demo;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ezen.demo.mapper.BoardInfoMapper;
import com.ezen.demo.vo.BoardInfoVO;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class DemoApplicationTests {

	@Autowired
	private BoardInfoMapper boardInfoMapper;
	@Test
	void contextLoads() {
		log.info("boardLit=>{}", boardInfoMapper.selectBoardInfoList(null));
		log.info("result=>{}", boardInfoMapper.updateBoardInfoActive(1));
		BoardInfoVO boardInfo = new BoardInfoVO();
		boardInfo.setBiTitle("제목");
		boardInfo.setBiContent("테스트 내용");
		boardInfo.setUiNum(1);
		log.info("result=>{}", boardInfoMapper.insertBoardInfo(boardInfo));
	}

}
