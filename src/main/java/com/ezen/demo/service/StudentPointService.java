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
	public int deleteStudentPoint(int spNum){
		return studentPointMapper.deleteStudentPoint(spNum);
	}
	
	public int deleteStudentPoint1(List<Integer> spNums) {
		int cnt = 0;
		for(int spNum : spNums) {
			cnt += studentPointMapper.deleteStudentPoint(spNum);
		}
		return cnt;
	}
	public int deleteStudentPoint2(List<Integer> spNums) {
		return studentPointMapper.deleteStudentPoints2(spNums);
	}
	
	public int deleteStudentPoints3(List<Integer> spNums) {
		return studentPointMapper.deleteStudentPoints3(spNums);
	}
}
