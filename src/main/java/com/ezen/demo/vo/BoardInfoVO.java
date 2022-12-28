package com.ezen.demo.vo;

import lombok.Data;

@Data
public class BoardInfoVO {

	private int biNum;
	private String biTitle;
	private String biContent;
	private String biWriter;
	private String credat;
	private String moddat;
	private int biCnt;
}
