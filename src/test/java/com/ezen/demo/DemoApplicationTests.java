package com.ezen.demo;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ezen.demo.api.ApiBoxOffice;
import com.ezen.demo.crawl.Yes24Crawling;
import com.ezen.demo.mapper.BestsellerBookMapper;
import com.ezen.demo.mapper.BoxOfficeMapper;
import com.ezen.demo.vo.BestsellerBookVO;
import com.ezen.demo.vo.BoxOfficeVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class DemoApplicationTests {
	
	@Test
	void contextLoads() {
	}

}
