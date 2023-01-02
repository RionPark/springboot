package com.ezen.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezen.demo.service.StudentPointService;
import com.ezen.demo.vo.StudentPointVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class StudentPointController {

	@Autowired
	private StudentPointService studentPointService;
	
	@GetMapping("/student-points")
	@ResponseBody
	public List<StudentPointVO> getStudentPoints(@ModelAttribute StudentPointVO studentPoint) {
		return studentPointService.selectStudentPointList(studentPoint);
	}
	
	@GetMapping("/student-points/{spNum}")
	@ResponseBody
	public StudentPointVO getStudentPoint(@PathVariable("spNum") int spNum) {
		return studentPointService.selectStudentPoint(spNum);
	}
	@PostMapping("/student-points")
	@ResponseBody
	public int insertStudentPoint(@RequestBody StudentPointVO studentPoint) {
		return studentPointService.insertStudentPoint(studentPoint);
	}
	
	@PatchMapping("/student-points/{spNum}")
	@ResponseBody
	public int updateStudentPoint(@RequestBody StudentPointVO studentPoint, @PathVariable("spNum") int spNum) {
		studentPoint.setSpNum(spNum);
		return studentPointService.updateStudentPoint(studentPoint);
	}
	
	@DeleteMapping("/student-points/{spNum}")
	@ResponseBody
	public int deleteStudentPoint(@PathVariable("spNum") int spNum) {
		return studentPointService.deleteStudentPoint(spNum);
	}
	
	@DeleteMapping("/student-points")
	@ResponseBody
	public int deleteStudentPoints1(@RequestBody StudentPointVO studentPoint) {
		return studentPointService.deleteStudentPoint1(studentPoint.getSpNums());
	}
	
	@DeleteMapping("/student-points2")
	@ResponseBody
	public int deleteStudentPoints2(@RequestBody StudentPointVO studentPoint) {
		return studentPointService.deleteStudentPoint2(studentPoint.getSpNums());
	}
	
	@DeleteMapping("/student-points3")
	@ResponseBody
	public int deleteStudentPoints3(@RequestBody StudentPointVO studentPoint) {
		return studentPointService.deleteStudentPoints3(studentPoint.getSpNums());
	}
}
