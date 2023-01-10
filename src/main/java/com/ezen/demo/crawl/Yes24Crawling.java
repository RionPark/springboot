package com.ezen.demo.crawl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.ezen.demo.vo.BestsellerBookVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@PropertySource("classpath:env.properties")
public class Yes24Crawling {

	@Value("${yes24.url}")
	private String yes24Url;
	
	public List<BestsellerBookVO> crawlYes24() {
		List<BestsellerBookVO> bestsellerBookList = new ArrayList<>();
		for(int i=1;i<=5;i++) {
			try {
				Document document = Jsoup.connect(yes24Url+i).get();
				Elements els = document.select("#category_layout tr");
				for(Element el : els) {
					Element imgEl = el.selectFirst("td.image img");
					if(imgEl!=null) {
						Element noEl = el.selectFirst("td.num");
						Element titleEl = el.selectFirst("td.goodsTxtInfo p a");
						Element pEl = el.selectFirst("td.goodsTxtInfo p");
						Element aupuEl = el.selectFirst("td.goodsTxtInfo>div.aupu");
						Element authEl = (Element)aupuEl.childNode(1);
						Element publishingEl = (Element)aupuEl.childNode(aupuEl.childNodes().size()-2);
						TextNode publishingDataEl = (TextNode)aupuEl.childNode(aupuEl.childNodes().size()-1);
						Element secPEl = el.selectFirst("td.goodsTxtInfo p:nth-child(3)");
						BestsellerBookVO bestsellerBook = new BestsellerBookVO();
						String num = noEl.text().replace(".", "").trim();
						bestsellerBook.setNum(Integer.parseInt(num));
						String imgPath = imgEl.attr("src").trim();
						bestsellerBook.setImgPath(imgPath);
						String title = titleEl.text().trim();
						bestsellerBook.setTitle(title);
						String subTitle = pEl.childNode(2).toString().trim();
						bestsellerBook.setSubTitle(subTitle);
						String author = authEl.text().trim();
						bestsellerBook.setAuthor(author);
						String publishing = publishingEl.text().trim();
						bestsellerBook.setPublishing(publishing);
						String publishingDate = publishingDataEl.text().replace(" | ", "").trim();
						bestsellerBook.setPublishingDate(publishingDate);
						String price = secPEl.childNode(0).toString().replace(" →","").replace("원","").replace(",","").trim();
						bestsellerBook.setPrice(Integer.parseInt(price));
						String url = "http://www.yes24.com" + titleEl.attr("href").trim();
						bestsellerBook.setUrl(url);
						bestsellerBookList.add(bestsellerBook);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return bestsellerBookList;
	}
	
	public static void main(String[] args) {
		Yes24Crawling y24 = new Yes24Crawling();
		y24.yes24Url = "http://www.yes24.com/24/Category/BestSeller?CategoryNumber=001&sumgb=06&PageNumber=";
		List<BestsellerBookVO> bestsellerBookList = y24.crawlYes24();
		
	}
}
