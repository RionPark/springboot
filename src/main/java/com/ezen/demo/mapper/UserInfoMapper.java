package com.ezen.demo.mapper;

import java.util.List;

import com.ezen.demo.vo.UserInfoVO;

public interface UserInfoMapper {
	List<UserInfoVO> selectUserInfoList(UserInfoVO userInfo);
	UserInfoVO selectUserInfoById(String uiId);
	UserInfoVO selectUserInfoByIdAndPwd(UserInfoVO userInfo);
	int insertUserInfo(UserInfoVO userInfo);
}
