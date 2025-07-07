package com.janghang.api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.janghang.api.service.ApiService;
import com.janghang.api.vo.PerformanceVO;

@Controller
public class HomeController {
	 
	@Autowired
	private ApiService apiService;
	
	@GetMapping("/main")
	public String showMain(Model model) {
		
	    List<Map<String, String>> dummyList = new ArrayList<>();
	    
	    for (int i = 1; i <= 4; i++) {
	        Map<String, String> item = new HashMap<>();
	        item.put("title", "서울시립미술관 특별전 " + i);
	        item.put("place", "서울특별시");
	        item.put("startDate", "2025-07-" + String.format("%02d", 10 + i));
	        item.put("image", "/images/sample" + i + ".jpg");
	        dummyList.add(item);
	    }
	    model.addAttribute("recommendList", dummyList);
	    
	    return "main";
	}
	
	@GetMapping("/list") //클라이언트가 GET 방식으로 /list 경로로 요청할 때 이 메서드를 실행하겠다는 뜻. main.jsp의 <form action="/list" method="get">에 반응하는 메서드
	public String list(@RequestParam(value = "dtype", required = false) String dtype, //RequestParam = HTTP 요청 파라미터를 자바 변수로 꺼내주는 역할 //쿼리스트링 = 브라우저 주소창에 ? 뒤에 붙는 파라미터들
						@RequestParam(value = "title", required = false) String title, //클라이언트가 보낸 분야 값 (dtype=뮤지컬 등)을 받는 파라미터
						@RequestParam(value = "pageNo", required = false, defaultValue = "1") String pageNo, //사용자가 값을 보내지 않으면 기본값 "1"로 설정됨.
						@RequestParam(value = "numOfRows", required = false, defaultValue = "10") String numOfRows, //한 페이지당 몇 개의 결과를 가져올지 설정
						Model model) { //Spring MVC에서 뷰(JSP)에 데이터를 전달할 때 사용하는 객체
		List<PerformanceVO> result = apiService.searchPerformances(dtype, title, pageNo, numOfRows); //서비스의 메소드를 호출해 외부 OpenAPI에서 데이터를 가져옴.
																									//PerformanceVO는 하나의 공연/전시 정보를 담는 객체
		model.addAttribute("resultList", result); //위에서 받은 결과 리스트(result)를 모델에 담아서 JSP로 전달. JSP에서 ${resultList}로 접근 가능
		
		System.out.println("불러온 결과 수: " + result.size());
		
		return "list";
	}

	@GetMapping("/test")
	public String home() {
		return "test";
	}
	
}
