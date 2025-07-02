package com.janghang.api.service;

import com.janghang.api.config.KcisaApiProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class ApiService {

    private final KcisaApiProperties properties;

    public ApiService(KcisaApiProperties properties) {
        this.properties = properties;
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
}