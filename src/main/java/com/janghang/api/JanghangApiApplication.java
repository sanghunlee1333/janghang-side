package com.janghang.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class JanghangApiApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(JanghangApiApplication.class);
    }

    public static void main(String[] args) {
    	System.out.println("🚀 JanghangApiApplication 시작됨");
        SpringApplication.run(JanghangApiApplication.class, args);
    }
}