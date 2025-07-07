package com.janghang.api.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.janghang.api.config.KcisaApiProperties;
import com.janghang.api.controller.ApiController;
import com.janghang.api.vo.PerformanceVO;

@Service
public class ApiService {

    private final ApiController apiController;

    private final KcisaApiProperties properties;

    public ApiService(KcisaApiProperties properties, ApiController apiController) {
        this.properties = properties;
        this.apiController = apiController;
    }

    public String callOpenApi() {
        StringBuilder result = new StringBuilder();

        try {
        	UriComponents url = UriComponentsBuilder.newInstance()
        		    .scheme("http")
        		    .host(properties.getBaseUrl())
        		    .path(properties.getEndpoint())
        		    .queryParam("serviceKey", properties.getResolvedServiceKey())
        		    .queryParam("numOfRows", 10)
        		    .queryParam("pageNo", 1)
        		    .queryParam("dtype", "뮤지컬")
        		    .queryParam("title", "시라노")
        		    .build().encode();
            // URI 생성
        	URI uri = url.toUri();
        	System.out.println("url : " + uri);
            //URI uri = new URI("http", null, properties.getBaseUrl(), -1, properties.getEndpoint(), query, null);
            // URI → URL로 변환
            HttpURLConnection conn = (HttpURLConnection) uri.toURL().openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");

            int responseCode = conn.getResponseCode();
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(
                            responseCode >= 200 && responseCode < 300
                                    ? conn.getInputStream()
                                    : conn.getErrorStream()
                    )
            );

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            System.out.println("url:"+uri);
            System.out.println("result:"+result);
            
            rd.close();
            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
            return "API 호출 중 오류가 발생했습니다.";
        }

        return result.toString();
    }
    
    //공연 검색 메소드
    public List<PerformanceVO> searchPerformances(String dtype, String title, String pageNo, String numOfRows) {
        List<PerformanceVO> resultList = new ArrayList<>();

        try {
            // 1. API URL 구성
            String apiUrl = "http://api.kcisa.kr/openapi/CNV_060/request" +
                    "?serviceKey=" + properties.getResolvedServiceKey() + 
                    "&returnType=xml" + // XML 형식 명시
                    "&dtype=" + URLEncoder.encode(dtype, "UTF-8") +
                    "&title=" + URLEncoder.encode(title, "UTF-8") +
                    "&pageNo=" + pageNo +
                    "&numOfRows=" + numOfRows;

            // 2. HttpURLConnection으로 요청
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(15000); // 연결 타임아웃 (10초)
            conn.setReadTimeout(60000);    // 응답 대기 타임아웃 (60초)
            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0"); // 일부 API는 User-Agent 요구

            // 3. 응답 읽기
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8)
            );
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            conn.disconnect();

            // 4. Jsoup으로 응답 문자열을 XML 파싱
            Document doc = Jsoup.parse(sb.toString(), "", Parser.xmlParser());

            // 5. item 태그들 선택
            Elements itemElements = doc.select("item");

            for (Element item : itemElements) {
                // 6. 각 item의 자식 태그들을 Map에 담기
                Map<String, Object> itemMap = new HashMap<>();
                for (Element child : item.children()) {
                    itemMap.put(child.tagName(), child.text());
                }

                // 7. Map -> VO 수동 매핑
                PerformanceVO vo = PerformanceVO.builder()
                        .title((String) itemMap.get("title"))
                        .dtype(dtype)
                        .period((String) itemMap.get("period"))
                        .eventSite((String) itemMap.get("eventSite"))
                        .imageObject((String) itemMap.get("imageObject"))
                        .url((String) itemMap.get("url"))
                        .description((String) itemMap.get("description"))
                        .build();

                resultList.add(vo);
            }

        } catch (Exception e) {
            e.printStackTrace(); // TODO: 실제 서비스에서는 로깅 처리
        }

        return resultList;
    }


    
}