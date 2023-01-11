package com.ezen.demo.crawl;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.ezen.demo.vo.AlbumVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WikiCrawlingTest {

	private static final String URL = "https://ko.wikipedia.org/wiki/%EB%8C%80%ED%95%9C%EB%AF%BC%EA%B5%AD%EC%9D%98_%EC%97%AD%EB%8C%80_%EC%9D%8C%EB%B0%98_%ED%8C%90%EB%A7%A4%EB%9F%89_%EC%88%9C%EC%9C%84_%EB%AA%A9%EB%A1%9D";

	public static void main(String[] args) {
		try {
			Document document = Jsoup.connect(URL).get();
			Elements trEls = document.select("table.wikitable>tbody>tr");
			trEls.remove(0);
			String singer = "";
			for(Element trEl:trEls) {
				Elements tdEls = trEl.select("th,td");
				String rank = tdEls.get(0).text();
				int cnt = 1;
				if(tdEls.size()==5) {
					singer = tdEls.get(cnt++).text();
				}
				String name = tdEls.get(cnt++).text();
				String year = tdEls.get(cnt++).text();
				String salesCnt = tdEls.get(cnt++).text().replace("+", "").replace(",", "");
				AlbumVO album = new AlbumVO();
				album.setRank(Integer.parseInt(rank));
				album.setSinger(singer);
				album.setYear(year);
				album.setName(name);
				album.setSalesCnt(Integer.parseInt(salesCnt));
				log.debug("album=>{}", album);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
