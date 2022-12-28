package com.ezen.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezen.demo.service.ShopInfoService;
import com.ezen.demo.vo.ShopInfoVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ShopInfoController {
/*
 * Controller, RestController
 * Configuration
 * Service, Repository, Component
 * Bean
 */
	@Autowired
	private ShopInfoService shopInfoService;
	@Autowired
	private ShopInfoService shopInfoService1;

	@GetMapping("/shop-infos")
	public String getShopInfos(Model model,@ModelAttribute ShopInfoVO shopInfo){
		log.info("shopInfoService == shopInfoService1 ==>{}", shopInfoService == shopInfoService1);
		model.addAttribute("shopList", shopInfoService.getShopInfos(shopInfo));
		return "views/shop-info/list";
	}
	@GetMapping("/shop-info")
	public String getShopInfo(Model model,@ModelAttribute ShopInfoVO shopInfo) {
		model.addAttribute("shopInfo",shopInfoService.getShopInfo(shopInfo));
		return "views/shop-info/view";
	}

	@GetMapping("/shop-info/update")
	public String getShopInfo2(Model model,@ModelAttribute ShopInfoVO shopInfo) {
		model.addAttribute("shopInfo",shopInfoService.getShopInfo(shopInfo));
		return "views/shop-info/update";
	}
	@PostMapping("/shop-infos/insert")
	public String insertShopInfo(Model model,@ModelAttribute ShopInfoVO shopInfo) {
		model.addAttribute("msg","상품등록이 완료되었습니다.");
		model.addAttribute("url","/shop-infos");
		if(shopInfoService.insertShopInfo(shopInfo)!=1) {
			model.addAttribute("msg","상품등록이 실패하였습니다.");
			model.addAttribute("url","/views/shop-info/insert");
		}
		return "views/common/msg";
	}
	@PostMapping("/shop-infos/update")
	public String updateShopInfo(Model model,@ModelAttribute ShopInfoVO shopInfo) {
		model.addAttribute("msg","상품수정이 완료되었습니다.");
		model.addAttribute("url","/shop-infos");
		if(shopInfoService.updateShopInfo(shopInfo)!=1) {
			model.addAttribute("msg","상품수정이 실패하였습니다.");
			model.addAttribute("url","/shop-info/update?siNum=" + shopInfo.getSiNum());
		}
		return "views/common/msg";
	}
	@PostMapping("/shop-infos/delete")
	public String deleteShopInfo(Model model,@ModelAttribute ShopInfoVO shopInfo) {
		model.addAttribute("msg","상품삭제가 완료되었습니다.");
		model.addAttribute("url","/shop-infos");
		if(shopInfoService.deleteShopInfo(shopInfo.getSiNum())!=1) {
			model.addAttribute("msg","상품삭제가 실패하였습니다.");
			model.addAttribute("url","/shop-info/update?siNum=" + shopInfo.getSiNum());
		}
		return "views/common/msg";
	}
}
