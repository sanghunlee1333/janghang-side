package com.janghang.api.dto;

public class OpenApiResponseDTO {
    private String message;

    // 생성자, getter, setter
    public OpenApiResponseDTO(String message) {
        this.message = message;
    }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}