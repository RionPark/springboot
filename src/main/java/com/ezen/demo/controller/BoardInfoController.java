package com.ezen.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ezen.demo.service.BoardInfoService;
import com.ezen.demo.vo.BoardInfoVO;

@Controller
public class BoardInfoController {

	@Autowired
	private BoardInfoService boardInfoService;
	@GetMapping("/board-infos")
	public String getBoardInfos(@ModelAttribute BoardInfoVO boardInfo, Model model) {
		model.addAttribute("boardInfoList",boardInfoService.getBoardInfos(boardInfo));
		return "views/board-info/list";
	}
	@GetMapping("/board-info")
	public String getBoardInfo(@ModelAttribute BoardInfoVO boardInfo, Model model) {
		model.addAttribute("boardInfo",boardInfoService.getBoardInfo(boardInfo));
		return "views/board-info/view";
	}
}
