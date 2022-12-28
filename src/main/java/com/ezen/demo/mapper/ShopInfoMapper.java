package com.ezen.demo.mapper;

import java.util.List;

import com.ezen.demo.vo.ShopInfoVO;

public interface ShopInfoMapper {

	List<ShopInfoVO> selectShopInfoList(ShopInfoVO shopInfo);
	ShopInfoVO selectShopInfo(ShopInfoVO shopInfo);
	int insertShopInfo(ShopInfoVO shopInfo);
	int updateShopInfo(ShopInfoVO shopInfo);
	int deleteShopInfo(int siNum);
}
