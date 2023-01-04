package com.ezen.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezen.demo.service.TestInfoService;
import com.ezen.demo.vo.TestInfoVO;

@Controller
public class TestInfoController {

	@Autowired
	private TestInfoService testInfoService;
	
	@GetMapping("/test-infos")
	public @ResponseBody List<TestInfoVO> getTestInfos(@ModelAttribute TestInfoVO testInfo){
		return testInfoService.selectTestInfoList(testInfo);
	}
	@GetMapping("/test/{cnt}")
	public @ResponseBody String sleepTest(@PathVariable int cnt) throws InterruptedException {
		Thread.sleep(cnt * 1000);
		return "니가 보낸 cnt : " + cnt;
	}
}
