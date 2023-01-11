package com.ezen.demo.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BoxOfficeResultVO {
	private List<BoxOfficeVO> dailyBoxOfficeList;
}
