package com.ezen.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ezen.demo.service.BestsellerBookService;
import com.ezen.demo.vo.BestsellerBookVO;
import com.github.pagehelper.PageInfo;

@RestController
public class BestsellerBookController {

	@Autowired
	private BestsellerBookService bestsellerBookService;
	
	@GetMapping("/bestseller-books")
	public PageInfo<BestsellerBookVO> getBestsellerBooks(BestsellerBookVO bestsellerBook){
		return bestsellerBookService.getBestSellerBooks(bestsellerBook);
	}
}
