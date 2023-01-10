package com.ezen.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ezen.demo.vo.BestsellerBookVO;

public interface BestsellerBookMapper {
	int insertBestsellerBook(@Param("bestsellerBookList")List<BestsellerBookVO> bestsellerBookList);
	List<BestsellerBookVO> selectBestsellerBookList();
}
