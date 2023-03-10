package com.ezen.demo.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.ezen.demo.vo.BoxOfficeResponseVO;
import com.ezen.demo.vo.BoxOfficeVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@PropertySource("classpath:env.properties")
public class ApiBoxOffice {
	@Value("${movie.url}")
	private String movieUrl = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=5ace18a434b1614abd7df1f4a58c67aa&targetDt=";
	@Autowired
	private ObjectMapper om;
	private int cnt =1;

	public List<BoxOfficeVO> getBoxOfficeList(int max){
		Instant now = Instant.now();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String movieUrl = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=5ace18a434b1614abd7df1f4a58c67aa&targetDt=";
		List<BoxOfficeVO> allBoxOfficeList = new ArrayList<>();
		
		for(int i=1;i<=max;i++) {
			Instant before = now.minus(Duration.ofDays(i));
			Date date = Date.from(before);
			String dateStr = sdf.format(date);
			String json = get(movieUrl+dateStr);
			try {
				BoxOfficeResponseVO result = om.readValue(json, BoxOfficeResponseVO.class);
				List<BoxOfficeVO> dailyBoxOfficeList = result.getBoxOfficeResult().getDailyBoxOfficeList();
				for(BoxOfficeVO boxOffice : dailyBoxOfficeList) {
					boxOffice.setTargetDt(dateStr);
				}
				allBoxOfficeList.addAll(dailyBoxOfficeList);
			}catch(Exception e) {
				log.error("parse error=>{}", e);
			}
		}
		return allBoxOfficeList;

	}

    private String get(String url){
        HttpURLConnection con = connect(url);
        
        try {
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // ?????? ??????
                return readBody(con.getInputStream());
            } else {  // ?????? ??????
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API ????????? ?????? ??????", e);
        } finally {
            con.disconnect();
        }
    }

    private HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL??? ?????????????????????. : " + movieUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("????????? ??????????????????. : " + movieUrl, e);
        }
    }

    private String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }

            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API ????????? ????????? ??????????????????.", e);
        }
    }
}
