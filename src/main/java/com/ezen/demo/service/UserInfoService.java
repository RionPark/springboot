package com.ezen.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.demo.mapper.UserInfoMapper;
import com.ezen.demo.vo.UserInfoVO;

@Service
public class UserInfoService {
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	public List<UserInfoVO> getUserInfos(UserInfoVO userInfo){
		return userInfoMapper.selectUserInfoList(userInfo);
	}
	
	public boolean existsUserId(String uiId) {
		if(userInfoMapper.selectUserInfoById(uiId)==null) {
			return false;
		}
		return true;
	}
}
