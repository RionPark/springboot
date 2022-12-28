package com.ezen.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.demo.mapper.ShopInfoMapper;
import com.ezen.demo.vo.ShopInfoVO;

@Service
public class ShopInfoService {
	@Autowired
	private ShopInfoMapper shopInfoMapper;
	
	public List<ShopInfoVO> getShopInfos(ShopInfoVO userInfo){
		return shopInfoMapper.selectShopInfoList(userInfo);
	}
	public ShopInfoVO getShopInfo(ShopInfoVO shopInfo) {
		return shopInfoMapper.selectShopInfo(shopInfo);
	}
	public int insertShopInfo(ShopInfoVO shopInfo) {
		return shopInfoMapper.insertShopInfo(shopInfo);
	}
	public int updateShopInfo(ShopInfoVO shopInfo) {
		return shopInfoMapper.updateShopInfo(shopInfo);
	}
	public int deleteShopInfo(int siNum) {
		return shopInfoMapper.deleteShopInfo(siNum);
	}
}
