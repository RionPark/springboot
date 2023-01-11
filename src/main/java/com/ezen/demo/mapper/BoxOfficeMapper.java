package com.ezen.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ezen.demo.vo.BoxOfficeVO;

public interface BoxOfficeMapper {
	int insertBoxOffices(@Param("boxOfficeList")List<BoxOfficeVO> boxOfficeList);
	int insertBoxOffice(BoxOfficeVO boxOffice);
	List<BoxOfficeVO> selectBoxOfficeList();
}
