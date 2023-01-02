package com.ezen.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ezen.demo.vo.StudentPointVO;

public interface StudentPointMapper {

	List<StudentPointVO> selectStudentPointList(StudentPointVO studentPoint);
	StudentPointVO selectStudentPoint(int spNum);
	int insertStudentPoint(StudentPointVO studentPoint);
	int updateStudentPoint(StudentPointVO studentPoint);
	int deleteStudentPoint(int spNum); 
	int deleteStudentPoints2(@Param("spNums") List<Integer> spNums);
	int deleteStudentPoints3(@Param("spNums") List<Integer> spNums);
}
