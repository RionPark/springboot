package com.ezen.demo.mapper;

import java.util.List;

import com.ezen.demo.vo.UserInfoVO;

public interface UserInfoMapper {
	List<UserInfoVO> selectUserInfoList(UserInfoVO userInfo);
}
