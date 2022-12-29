package com.ezen.demo.mapper;

import java.util.List;

import com.ezen.demo.vo.TestInfoVO;

public interface TestInfoMapper {

	List<TestInfoVO> selectTestInfoList(TestInfoVO testInfo);
}
