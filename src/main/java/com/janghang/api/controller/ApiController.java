package com.janghang.api.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")  // 여기를 추가해서 /api/ 경로를 처리하게 함
public class ApiController {
    public ApiController() {
        System.out.println("🛠 ApiController 생성됨");
    }

    @GetMapping("/")
    public String home() {
        System.out.println("✅ ApiController::viewApiItems() 진입");
        return "api";
    }
}