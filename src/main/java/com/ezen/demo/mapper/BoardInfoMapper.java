package com.ezen.demo.mapper;

import java.util.List;

import com.ezen.demo.vo.BoardInfoVO;

public interface BoardInfoMapper {

	List<BoardInfoVO> selectBoardInfoList(BoardInfoVO boardInfo);
	BoardInfoVO selectBoardInfo(BoardInfoVO boardInfo);
	int insertBoardInfo(BoardInfoVO boardInfo);
	int updateBoardInfo(BoardInfoVO boardInfo);
	int updateBoardInfoCnt(int biNum);
	int deleteBoardInfo(int biNum);
}
