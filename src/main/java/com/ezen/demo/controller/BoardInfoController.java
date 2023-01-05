package com.ezen.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezen.demo.service.BoardInfoService;
import com.ezen.demo.vo.BoardInfoVO;
import com.ezen.demo.vo.UserInfoVO;

@Controller
public class BoardInfoController {

	@Autowired
	private BoardInfoService boardInfoService;

	@GetMapping("/board-infos")
	@ResponseBody
	public List<BoardInfoVO> getBoardInfos(@ModelAttribute BoardInfoVO boardInfo) {
		return boardInfoService.getBoardInfos(boardInfo);
	}
	@GetMapping("/board-infos/{biNum}")
	@ResponseBody
	public BoardInfoVO getBoardInfos(@PathVariable int biNum) {
		return boardInfoService.getBoardInfo(biNum);
	}
	
	@PostMapping("/board-infos")
	@ResponseBody
	public int insertBoardInfo(@RequestBody BoardInfoVO boardInfo, HttpSession session) {
		UserInfoVO userInfo = (UserInfoVO)session.getAttribute("userInfo");
		if(userInfo == null) {
			throw new RuntimeException("로그인이 필요합니다.");
		}
		boardInfo.setUiNum(userInfo.getUiNum());
		return boardInfoService.insertBoardInfo(boardInfo);
	}
	
	@DeleteMapping("/board-infos/{biNum}")
	@ResponseBody
	public int deleteBoardInfo(@PathVariable int biNum) {
		return boardInfoService.updateBoardInfoActive(biNum);
	}
	
	@PatchMapping("/board-infos/{biNum}")
	@ResponseBody
	public int updateBoardInfo(@RequestBody BoardInfoVO boardInfo, @PathVariable int biNum) {
		boardInfo.setBiNum(biNum);
		return boardInfoService.updateBoardInfo(boardInfo);
	}
}
