package com.ezen.demo.mapper;

import java.util.List;

import com.ezen.demo.vo.StudentPointVO;

public interface StudentPointMapper {

	List<StudentPointVO> selectStudentPointList(StudentPointVO studentPoint);
	StudentPointVO selectStudentPoint(int spNum);
	int insertStudentPoint(StudentPointVO studentPoint);
	int updateStudentPoint(StudentPointVO studentPoint);
	int deleteStudentPoint(int spNum); 
}
