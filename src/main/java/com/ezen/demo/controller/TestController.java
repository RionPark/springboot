package com.ezen.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ezen.demo.service.ShopInfoService;
import com.ezen.demo.vo.ShopInfoVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TestController {

	@Autowired
	private ShopInfoService shopInfoService;
	@GetMapping("/test")
	public List<ShopInfoVO> test() {
		return shopInfoService.getShopInfos(null);
	}
}
