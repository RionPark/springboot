package com.ezen.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezen.demo.service.UserInfoService;
import com.ezen.demo.vo.UserInfoVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserInfoController {
/*
 * Controller, RestController
 * Configuration
 * Service, Repository, Component
 * Bean
 */
	@Autowired
	private UserInfoService userInfoService;
	
	
	@GetMapping("/user-infos")
	public String getUserInfos(Model model,@ModelAttribute UserInfoVO userInfo){
		model.addAttribute("userList", userInfoService.getUserInfos(userInfo));
		return "views/user-info/list";
	}
	
	@GetMapping("/user-infos/check/{uiId}")
	@ResponseBody
	public boolean existUserId(@PathVariable("uiId") String uiId) {
		return userInfoService.existsUserId(uiId);
	}
	
	@PostMapping("/user-infos")
	public @ResponseBody int addUserInfo(@RequestBody UserInfoVO userInfo) {
		return userInfoService.insertUserInfo(userInfo);
	}
	
	@PostMapping("/login")
	public @ResponseBody UserInfoVO login(@RequestBody UserInfoVO userInfo, HttpSession session) {
		UserInfoVO loginUserInfo = userInfoService.login(userInfo);
		if(loginUserInfo !=null) {
			session.setAttribute("userInfo", loginUserInfo);
			loginUserInfo.setUiPwd(null);
		}
		return loginUserInfo;
	}
}
