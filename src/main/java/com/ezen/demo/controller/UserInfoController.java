package com.ezen.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
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
	
	@PostMapping("/user-infos/{uiNum}")
	public @ResponseBody boolean checkPassword(@RequestBody UserInfoVO userInfo, @PathVariable("uiNum") int uiNum) {
		return userInfoService.checkPassword(userInfo, uiNum);
	}
	
	@PatchMapping("/user-infos/{uiNum}")
	public @ResponseBody boolean modifyUserInfo(@RequestBody UserInfoVO userInfo, @PathVariable("uiNum") int uiNum, HttpSession session) {
		UserInfoVO sessioUserInfo = (UserInfoVO) session.getAttribute("userInfo");
		if(sessioUserInfo==null || sessioUserInfo.getUiNum()!=uiNum) {
			throw new RuntimeException("잘못 정보 수정 입니다.");
		}
		userInfo.setUiNum(uiNum);
		return userInfoService.updateUserInfo(userInfo);
	}
	
	@DeleteMapping("/user-infos/{uiNum}")
	public @ResponseBody boolean removeUserInfo(@RequestBody UserInfoVO userInfo, @PathVariable("uiNum") int uiNum) {
		return userInfoService.removeUserInfo(userInfo, uiNum);
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
