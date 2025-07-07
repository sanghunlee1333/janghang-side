package com.janghang.api.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data = @Getter, @Setter, @ToString(클래스 내용을 문자열로 보여줌), @EqualsAndHashCode, @RequiredArgsConstructor (final 필드용 생성자) 적용
/*
@NoArgsConstructor = 기본 생성자 (파라미터 없는 생성자)를 자동으로 만들어줌
예를 들어, 서버가 아래와 같은 JSON을 받았다고 하자
{
  "title": "헤드윅",
  "dtype": "뮤지컬"
}
이걸 PerformanceVO라는 객체로 바꾸려면, Jackson 같은 JSON 라이브러리가 기본 생성자로 객체를 만들고
그 다음에 setTitle(), setDtype() 등을 호출해서 값을 채워 넣음.
-> 이때 기본 생성자 (PerformanceVO())가 없으면 에러

@AllArgsConstructor = 모든 필드를 매개변수로 받는 생성자를 자동 생성
생성자 없이 객체 생성하면
PerformanceVO p = new PerformanceVO();
p.setTitle("헤드윅");
p.setDtype("뮤지컬");
p.setPeriod("2025.07.01~07.20");
...
-> 코드가 길어짐.

예시 2: @AllArgsConstructor 있으면

PerformanceVO p = new PerformanceVO("헤드윅", "뮤지컬", "2025.07.01~07.20", ...);
-> 한 줄로 깔끔하게 만들 수 있음. 테스트 코드 작성할 때 빠르게 객체 만들 수 있어서 좋아.

@Builder = Builder 패턴을 자동 생성. 가독성이 좋고, 필드가 많아도 유연하게 객체 생성 가능
예시 1: 생성자가 필드가 많을 때 순서 헷갈림
new PerformanceVO("헤드윅", "뮤지컬", "2025.07.01~07.20", "블루스퀘어", "image.jpg", "url", "설명");
-> 이건 뭐가 title이고, 뭐가 장소인지 코드만 봐선 몰라

@Builder
PerformanceVO p = PerformanceVO.builder()
    .title("헤드윅")
    .dtype("뮤지컬")
    .period("2025.07.01~07.20")
    .eventSite("블루스퀘어")
    .build();
-> 가독성도 좋고, 실수도 줄어들고, 순서도 상관 없어.
*/
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class PerformanceVO { //VO = 외부 API에서 받아온 응답(JSON or XML)을 자바 객체로 매핑하기 위한 클래스. DTO와 비슷하지만, 주로 뷰(View)에 넘길 데이터를 담는 데 초점
	private String title; //제목
	private String dtype; //분야
	private String period; //기간
	private String eventSite; //장소
	private String imageObject; //이미지(썸네일) url
	private String url; //상세 url
	private String description; //설명
}
