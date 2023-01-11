package com.ezen.demo.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.List;
import java.util.Map;

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

	public static void main(String[] args)throws JsonMappingException, JsonProcessingException {
		Instant now = Instant.now();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String movieUrl = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=5ace18a434b1614abd7df1f4a58c67aa&targetDt=";
		ApiBoxOffice  abo = new ApiBoxOffice();
		ObjectMapper om = new ObjectMapper();
//		for(int i=1;i<=2;i++) {
//			Instant before = now.minus(Duration.ofDays(i));
//			Date date = Date.from(before);
//			String dateStr = sdf.format(date);
//			String json = abo.get(movieUrl+dateStr);
//			Map<String,Object> result = om.readValue(json, Map.class);
//			List<Map<String,String>> dailyBoxOfficeList = (List<Map<String,String>>)result.get("dailyBoxOfficeList");
//			log.debug("result=>{}",result);
//		}

		String json = "{\"boxOfficeResult\":{\"boxofficeType\":\"일별 박스오피스\",\"showRange\":\"20230110~20230110\",\"dailyBoxOfficeList\":[{\"rnum\":\"1\",\"rank\":\"1\",\"rankInten\":\"0\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20225061\",\"movieNm\":\"아바타: 물의 길\",\"openDt\":\"2022-12-14\",\"salesAmt\":\"850616259\",\"salesShare\":\"38.3\",\"salesInten\":\"-99798565\",\"salesChange\":\"-10.5\",\"salesAcc\":\"111437142937\",\"audiCnt\":\"63376\",\"audiInten\":\"-7140\",\"audiChange\":\"-10.1\",\"audiAcc\":\"8910541\",\"scrnCnt\":\"1350\",\"showCnt\":\"4018\"},{\"rnum\":\"2\",\"rank\":\"2\",\"rankInten\":\"0\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20228555\",\"movieNm\":\"더 퍼스트 슬램덩크\",\"openDt\":\"2023-01-04\",\"salesAmt\":\"388556090\",\"salesShare\":\"17.5\",\"salesInten\":\"-47589488\",\"salesChange\":\"-10.9\",\"salesAcc\":\"5183017346\",\"audiCnt\":\"38514\",\"audiInten\":\"-4716\",\"audiChange\":\"-10.9\",\"audiAcc\":\"501865\",\"scrnCnt\":\"953\",\"showCnt\":\"2618\"},{\"rnum\":\"3\",\"rank\":\"3\",\"rankInten\":\"0\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20196478\",\"movieNm\":\"영웅\",\"openDt\":\"2022-12-21\",\"salesAmt\":\"363461267\",\"salesShare\":\"16.3\",\"salesInten\":\"-19892932\",\"salesChange\":\"-5.2\",\"salesAcc\":\"22611621176\",\"audiCnt\":\"37878\",\"audiInten\":\"-1994\",\"audiChange\":\"-5\",\"audiAcc\":\"2301350\",\"scrnCnt\":\"823\",\"showCnt\":\"2556\"},{\"rnum\":\"4\",\"rank\":\"4\",\"rankInten\":\"0\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20224109\",\"movieNm\":\"장화신은 고양이: 끝내주는 모험\",\"openDt\":\"2023-01-04\",\"salesAmt\":\"202425907\",\"salesShare\":\"9.1\",\"salesInten\":\"9203983\",\"salesChange\":\"4.8\",\"salesAcc\":\"3389980367\",\"audiCnt\":\"22557\",\"audiInten\":\"1486\",\"audiChange\":\"7.1\",\"audiAcc\":\"359713\",\"scrnCnt\":\"785\",\"showCnt\":\"2112\"},{\"rnum\":\"5\",\"rank\":\"5\",\"rankInten\":\"0\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20215315\",\"movieNm\":\"스위치\",\"openDt\":\"2023-01-04\",\"salesAmt\":\"176363877\",\"salesShare\":\"7.9\",\"salesInten\":\"18051701\",\"salesChange\":\"11.4\",\"salesAcc\":\"2562428614\",\"audiCnt\":\"20110\",\"audiInten\":\"3675\",\"audiChange\":\"22.4\",\"audiAcc\":\"261410\",\"scrnCnt\":\"831\",\"showCnt\":\"2470\"},{\"rnum\":\"6\",\"rank\":\"6\",\"rankInten\":\"0\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20228313\",\"movieNm\":\"오늘 밤, 세계에서 이 사랑이 사라진다 해도\",\"openDt\":\"2022-11-30\",\"salesAmt\":\"100524642\",\"salesShare\":\"4.5\",\"salesInten\":\"4432485\",\"salesChange\":\"4.6\",\"salesAcc\":\"8345097899\",\"audiCnt\":\"9841\",\"audiInten\":\"413\",\"audiChange\":\"4.4\",\"audiAcc\":\"814694\",\"scrnCnt\":\"324\",\"showCnt\":\"552\"},{\"rnum\":\"7\",\"rank\":\"7\",\"rankInten\":\"0\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20227762\",\"movieNm\":\"올빼미\",\"openDt\":\"2022-11-23\",\"salesAmt\":\"21622363\",\"salesShare\":\"1.0\",\"salesInten\":\"-2837069\",\"salesChange\":\"-11.6\",\"salesAcc\":\"32512088384\",\"audiCnt\":\"2140\",\"audiInten\":\"-267\",\"audiChange\":\"-11.1\",\"audiAcc\":\"3295973\",\"scrnCnt\":\"202\",\"showCnt\":\"277\"},{\"rnum\":\"8\",\"rank\":\"8\",\"rankInten\":\"2\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20228652\",\"movieNm\":\"3000년의 기다림\",\"openDt\":\"2023-01-04\",\"salesAmt\":\"15350788\",\"salesShare\":\"0.7\",\"salesInten\":\"5346498\",\"salesChange\":\"53.4\",\"salesAcc\":\"147575560\",\"audiCnt\":\"2041\",\"audiInten\":\"959\",\"audiChange\":\"88.6\",\"audiAcc\":\"14982\",\"scrnCnt\":\"143\",\"showCnt\":\"204\"},{\"rnum\":\"9\",\"rank\":\"9\",\"rankInten\":\"0\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20228640\",\"movieNm\":\"신비아파트 극장판 차원도깨비와 7개의 세계\",\"openDt\":\"2022-12-14\",\"salesAmt\":\"14920998\",\"salesShare\":\"0.7\",\"salesInten\":\"-834600\",\"salesChange\":\"-5.3\",\"salesAcc\":\"3954782534\",\"audiCnt\":\"1594\",\"audiInten\":\"-76\",\"audiChange\":\"-4.6\",\"audiAcc\":\"414096\",\"scrnCnt\":\"145\",\"showCnt\":\"163\"},{\"rnum\":\"10\",\"rank\":\"10\",\"rankInten\":\"-2\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20210140\",\"movieNm\":\"젠틀맨\",\"openDt\":\"2022-12-28\",\"salesAmt\":\"9540393\",\"salesShare\":\"0.4\",\"salesInten\":\"-1679803\",\"salesChange\":\"-15\",\"salesAcc\":\"2045024220\",\"audiCnt\":\"1439\",\"audiInten\":\"-233\",\"audiChange\":\"-13.9\",\"audiAcc\":\"217168\",\"scrnCnt\":\"140\",\"showCnt\":\"164\"}]}}";
		BoxOfficeResponseVO result = om.readValue(json, BoxOfficeResponseVO.class);
		List<BoxOfficeVO> dailyBoxOfficeList = result.getBoxOfficeResult().getDailyBoxOfficeList();
		for(BoxOfficeVO dailyBoxOffice : dailyBoxOfficeList) {
			log.info("dailyBoxOffice=>{}",dailyBoxOffice);
		}
		log.debug("dailyBoxOfficeList=>{}", dailyBoxOfficeList);
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
            con.setRequestMethod("GET");
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
