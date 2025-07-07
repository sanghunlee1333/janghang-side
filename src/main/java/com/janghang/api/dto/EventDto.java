package com.janghang.api.dto;

import lombok.Data;

@Data
public class EventDto {
	private String title; //제목
	private String type; //분야
	private String eventPeriod; //시간
	private String eventSite; //장소
	private String charge; //금액
	private String contactPoint; //문의 안내
	private String url; //url
	private String imageObject; //이미지
	private String description; //설명
	private String viewCount; //조회수
}
