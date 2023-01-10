package com.ezen.demo;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ezen.demo.crawl.Yes24Crawling;
import com.ezen.demo.mapper.BestsellerBookMapper;
import com.ezen.demo.vo.BestsellerBookVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class DemoApplicationTests {
	@Autowired
	private Yes24Crawling yes24;
	@Autowired
	private BestsellerBookMapper bestsellerBookMapper;
	
	@Test
	void contextLoads() {
		PageHelper.startPage(2, 20);
		List<BestsellerBookVO> bestsellerBookList = bestsellerBookMapper.selectBestsellerBookList();
		PageInfo<BestsellerBookVO> pageList = PageInfo.of(bestsellerBookList);
		log.info("pageList=>{}", pageList);
		//int result = bestsellerBookMapper.insertBestsellerBook(bestsellerBookList);
		for(BestsellerBookVO bestseller : bestsellerBookList) {
			log.info("num=>{}", bestseller.getNum());
		}
	}

}
