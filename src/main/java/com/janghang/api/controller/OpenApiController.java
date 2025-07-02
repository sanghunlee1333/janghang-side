package com.janghang.api.controller;

import com.janghang.api.service.ApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/openapi")
public class OpenApiController {

    private final ApiService apiService;

    public OpenApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/")
    public String openApi(Model model) {
        String apiResult = apiService.callOpenApi();
        model.addAttribute("apiResult", apiResult);
        return "apiResult";
    }
    
}