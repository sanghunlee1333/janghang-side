<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 헤더 템플릿 -->
<%@ include file="/WEB-INF/views/template/header.jsp" %>

<!-- 본문 -->
<div class="container py-5">
	
	<!-- 히어로 영역 -->
	<section class="rounded p-3 mb-5" style="background-color: #e6f2ff;">
		<div class="row align-items-center">
			
			<!-- 왼쪽 텍스트 & 입력창 -->
			<div class="col-md-7">
				<h2 class="fw-bold ms-5 mb-4">무료 전시/공연을 <br />찾아보세요!</h2>
				<form class="row g-2 ms-5" action="${pageContext.request.contextPath}/list" method="get">
					<div class="col-md-3">
						<!-- 지역 선택창 -->
						<!--<select name="region" class="form-select">
							<option value="">지역</option>
							<option value="서울">서울</option>
							<option value="부산">부산</option>
							<option value="대구">대구</option>
							<option value="인천">인천</option>
							<option value="광주">광주</option>
							<option value="대전">대전</option>
							<option value="울산">울산</option>
							<option value="세종">세종</option>
							<option value="경기">경기</option>
							<option value="강원">강원</option>
							<option value="충북">충북</option>
							<option value="충남">충남</option>
							<option value="전북">전북</option>
							<option value="전남">전남</option>
							<option value="경북">경북</option>
							<option value="경남">경남</option>
							<option value="제주">제주</option>
						</select>-->
						<select name="dtype" class="form-select">
							<option value="">유형</option>
							<option value="뮤지컬">뮤지컬</option>
							<option value="연극">연극</option>
						</select>
					</div>
					
					<!-- 기간 입력창 -->
					<!--
					<div class="col-md-4">
			            <input type="text" id="date-range" name="period class="form-control" placeholder="기간">
			        </div>
					-->
					
					<!-- 제목 입력창 -->
					<div class="col md-4">
						<input type="text" name="title" class="form-control" placeholder="제목 입력">
					</div>
					
					<!-- 검색 버튼 -->
					<div class="col-md-2">
			            <button type="submit" class="btn btn-primary w-50">
			              <i class="bi bi-search"></i>
			            </button>
					</div>
				</form>
			</div>
			
			<!-- 오른쪽 이미지 -->
			<div class="col-md-5 text-center">
	    		<img src="/api/images/performance.png" alt="공연" style="max-width: 240px;">
			</div>
		</div>
	</section>
	
	<div class="row mb-3">
		<div class="col">
			<span class="fs-4 fw-bold">추천 전시/공연</span>
		</div>
	</div>
	
	<!-- 추천 콘텐츠 카드 -->
	<div class="row">
		<!--<c:forEach var="item" items="${recommendList}">-->
			<div class="col-12 col-sm-6 col-lg-4 col-xl-3">
				<div class="card h-100 shadow-sm rounded-2">
					<!-- <img src="${item.image}" class="card-img-top" alt="썸네일"> -->
					<img src="https://picsum.photos/300/200" class="card-img-top rounded-2 rounded-bottom-0" alt="썸네일">
					<div class="card-body">
						<h5 class="card-title d-flex justify-content-between align-items-center">
							<!--<span>${item.title}</span>-->
							<span class="fw-bold fs-6">서울시립미술관 특별전</span>
						</h5>
						<div class="row card-text small text-muted">
							<!--<p class="col">${item.place}</p>-->
							<p class="card-text small text-muted mb-1">서울</p>
							<!--<p class="col">${item.startDate}</p>-->
							<p class="card-text small text-muted">2025.07.01 ~ 07.30</p>
						</div>
					</div>
				</div>	
			</div>
		<!--</c:forEach>-->
	</div>
	
</div>

<!-- 푸터 템플릿 -->
<%@ include file="/WEB-INF/views/template/footer.jsp" %>
<!--<%@ include file="template/footer.jsp" %>-->
