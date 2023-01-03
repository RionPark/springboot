package com.ezen.demo.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.demo.mapper.UserInfoMapper;
import com.ezen.demo.util.SHA256;
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
	
	public int insertUserInfo(UserInfoVO userInfo) {
		String uiPwd = userInfo.getUiPwd();
		String encodePwd = SHA256.encode(uiPwd);
		userInfo.setUiPwd(encodePwd);
		return userInfoMapper.insertUserInfo(userInfo);
	}
	
	public UserInfoVO login(UserInfoVO userInfo) {
		userInfo.setUiPwd(SHA256.encode(userInfo.getUiPwd()));
		return userInfoMapper.selectUserInfoByIdAndPwd(userInfo);		
	}
}
