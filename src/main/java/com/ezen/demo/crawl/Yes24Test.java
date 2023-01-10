package com.ezen.demo.crawl;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Yes24Test {

	private final static String URL = "http://www.yes24.com/24/Category/BestSeller?CategoryNumber=001&sumgb=06";
	
	public static void main(String[] args) {
		try {
			Document document = Jsoup.connect(URL).get();
			Elements els = document.select("#category_layout tr");
			for(Element el : els) {
				Element imgEl = el.selectFirst("td.image img");
				if(imgEl!=null) {
					Element noEl = el.selectFirst("td.num");
					log.debug("no =>{}", noEl.text());
					log.debug("img src=>{}", imgEl.attr("src"));
					Element titleEl = el.selectFirst("td.goodsTxtInfo p a");
					log.debug("title=>{}", titleEl.text());
					log.debug("url=>{}", "http://www.yes24.com" + titleEl.attr("href"));
					Element pEl = el.selectFirst("td.goodsTxtInfo p");
					log.debug("sub title=>{}",pEl.childNode(2));
					Element aupuEl = el.selectFirst("td.goodsTxtInfo>div.aupu");
					Element authEl = (Element)aupuEl.childNode(1);
					log.debug("author=>{}", authEl.text());
					Element publishingEl = (Element)aupuEl.childNode(aupuEl.childNodes().size()-2);
					log.debug("publishing=>{}", publishingEl.text());
					Element secPEl = el.selectFirst("td.goodsTxtInfo p:nth-child(3)");
					log.debug("lastPel=>{}", secPEl.childNode(0).toString().replace(" →",""));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
