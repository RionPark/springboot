package com.ezen.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.demo.mapper.StudentPointMapper;
import com.ezen.demo.vo.StudentPointVO;
@Service
public class StudentPointService {

	@Autowired
	private StudentPointMapper studentPointMapper;
	
	public List<StudentPointVO> selectStudentPointList(StudentPointVO studentPoint){
		return studentPointMapper.selectStudentPointList(studentPoint);
	}
	public StudentPointVO selectStudentPoint(int spNum){
		return studentPointMapper.selectStudentPoint(spNum);
	}
	public int insertStudentPoint(StudentPointVO studentPoint){
		return studentPointMapper.insertStudentPoint(studentPoint);
	}
	public int updateStudentPoint(StudentPointVO studentPoint){
		return studentPointMapper.updateStudentPoint(studentPoint);
	}
	public int deleteStudentPoint(StudentPointVO studentPoint){
		return studentPointMapper.deleteStudentPoint(studentPoint);
	}
}
