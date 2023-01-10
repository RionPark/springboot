package com.ezen.demo.vo;

import com.github.pagehelper.Page;

import lombok.Data;

@Data
public class BestsellerBookVO {
	private int num;
	private String imgPath;
	private String title;
	private String subTitle;
	private String author;
	private String publishing;
	private String publishingDate;
	private int price;
	private String url;
	private String credat;
	private int page;
	private int rows;
}
