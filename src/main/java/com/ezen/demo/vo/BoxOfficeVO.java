package com.ezen.demo.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BoxOfficeVO {
	private int rank;
	private String movieNm;
	private String movieCd;
	private int rankInten;
	private String rankOldAndNew;
	private String openDt;
	private long salesAmt;
	private double salesShare;
	private long salesInten;
	private double salesChange;
	private long salesAcc;
	private int audiCnt;
	private int audiInten;
	private double audiChange;
	private int audiAcc;
	private int scrnCnt;
	private int showCnt;
	private String targetDt;
}
