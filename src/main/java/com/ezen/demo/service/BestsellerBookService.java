package com.ezen.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.demo.mapper.BestsellerBookMapper;
import com.ezen.demo.vo.BestsellerBookVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class BestsellerBookService {
	@Autowired
	private BestsellerBookMapper bestsellerBookMapper;

	public PageInfo<BestsellerBookVO> getBestSellerBooks(BestsellerBookVO bestsellrBook){
		PageHelper.startPage(bestsellrBook.getPage(), bestsellrBook.getRows());
		return PageInfo.of(bestsellerBookMapper.selectBestsellerBookList());
	}
}
