package com.ezen.demo.api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ezen.demo.vo.PapagoParamVO;
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

	public static void main(String[] args)throws JsonMappingException, JsonProcessingException {
		Instant now = Instant.now();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String movieUrl = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=5ace18a434b1614abd7df1f4a58c67aa&targetDt=";
		ApiBoxOffice  abo = new ApiBoxOffice();
		for(int i=1;i<=2;i++) {
			Instant before = now.minus(Duration.ofDays(i));
			Date date = Date.from(before);
			String dateStr = sdf.format(date);
			log.debug("dateStr=>{}", movieUrl+dateStr);
			String json = abo.get(movieUrl);
			log.debug("json=>{}",json);
		}
//        String json = get();
//        Map<String,Object> map = om.readValue(json, Map.class);
//        Map<String,Object> messageMap = (Map<String,Object>)map.get("message");
//        Map<String,Object> resultMap = (Map<String,Object>) messageMap.get("result");
//        resultMap.get("translatedText");
//        return om.readValue(json, PapagoVO.class);
	}

    private String get(String url){
        HttpURLConnection con = connect(url);
        
        try {
            con.setRequestMethod("get");
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 응답
                return readBody(con.getInputStream());
            } else {  // 에러 응답
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }

    private HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + movieUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + movieUrl, e);
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
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }
}
