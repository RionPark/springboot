package com.ezen.demo.vo;

import java.util.List;

import lombok.Data;

@Data
public class StudentPointVO {

	private int spNum;
	private String spName;
	private int spKorPoint;
	private int spEngPoint;
	private int spMathPoint;
	private String spProfile;
	private List<Integer> spNums;
}
