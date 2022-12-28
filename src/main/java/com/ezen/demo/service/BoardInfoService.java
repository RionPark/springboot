package com.ezen.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.demo.mapper.BoardInfoMapper;
import com.ezen.demo.vo.BoardInfoVO;

@Service
public class BoardInfoService {

	@Autowired
	private BoardInfoMapper boardInfoMapper;

	public List<BoardInfoVO> getBoardInfos(BoardInfoVO boardInfo){
		return boardInfoMapper.selectBoardInfoList(boardInfo);
	}
	public BoardInfoVO getBoardInfo(BoardInfoVO boardInfo) {
		return boardInfoMapper.selectBoardInfo(boardInfo);
	}
	public int insertBoardInfo(BoardInfoVO boardInfo) {
		return boardInfoMapper.insertBoardInfo(boardInfo);
	}
	public int updateBoardInfo(BoardInfoVO boardInfo) {
		return boardInfoMapper.updateBoardInfo(boardInfo);
	}
	public int deleteBoardInfo(int biNum) {
		return boardInfoMapper.deleteBoardInfo(biNum);
	}
}
