package com.ezen.demo.mapper;

import java.util.List;

import com.ezen.demo.vo.BoardInfoVO;

public interface BoardInfoMapper {
	
	List<BoardInfoVO> selectBoardInfoList(BoardInfoVO boardInfo);
	BoardInfoVO selectBoardInfo(int biNum);
	int insertBoardInfo(BoardInfoVO boardInfo);
	int updateBoardInfoActive(int biNum);
}
