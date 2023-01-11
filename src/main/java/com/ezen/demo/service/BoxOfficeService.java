package com.ezen.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.demo.api.ApiBoxOffice;
import com.ezen.demo.mapper.BoxOfficeMapper;
import com.ezen.demo.vo.BoxOfficeVO;

@Service
public class BoxOfficeService {


	@Autowired
	private ApiBoxOffice apiBoxOffice;
	@Autowired
	private BoxOfficeMapper boxOfficeMapper;
	
	public int insertBoxOffice(List<BoxOfficeVO> boxOfficeList) {
		return boxOfficeMapper.insertBoxOffices(boxOfficeList);
	}
	
	public List<BoxOfficeVO> getBoxOffices(int cnt){
		return apiBoxOffice.getBoxOfficeList(cnt);
	}
}
