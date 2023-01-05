package com.ezen.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.demo.mapper.BoardInfoMapper;
import com.ezen.demo.vo.BoardInfoVO;

@Service
public class BoardInfoService{

	@Autowired
	private BoardInfoMapper boardInfoMapper;

	public List<BoardInfoVO> getBoardInfos(BoardInfoVO boardInfo){
		return boardInfoMapper.selectBoardInfoList(boardInfo);
	}
	public int insertBoardInfo(BoardInfoVO boardInfo) {
		return boardInfoMapper.insertBoardInfo(boardInfo);
	}
	
	public BoardInfoVO getBoardInfo(int biNum) {
		return boardInfoMapper.selectBoardInfo(biNum);
	}
}
