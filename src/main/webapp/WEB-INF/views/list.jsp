<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/template/header.jsp" %>

<div class="containter py-5">
	
	<!-- 검색 필터 -->
	<form action="${pageContext.request.contextPath}/list" method="get" class="mb-4">
		
		<div class="row g-2 justify-content-end">
			<!-- 지역 선택창 -->
			<div class="col-auto">
				<!--
				<select name="region" class="form-select">
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
					</select>
				-->
			</div>
			
			<!-- 기간 입력창 -->
			<!--
			<div class="col-md-4">
	            <input type="text" id="date-range" name="period class="form-control" placeholder="기간">
	        </div>
			-->
			
			<!-- 유형 선택창 -->
			<div class="col-auto">
				<select name="dtype" class="form-select">
					<option value="">유형</option>
					<option value="뮤지컬" ${param.dtype == '뮤지컬' ? 'selected' : ''}>뮤지컬</option>
					<option value="연극" ${param.dtype == '연극' ? 'selected' : ''}>연극</option>
				</select>
			</div>
			 
			<!-- 제목 입력창 -->
			<div class="col-auto">
				<input type="text" name="title" class="form-control" placeholder="제목으로 검색" value="${param.title}">
			</div>
			
			<!-- 검색 버튼 -->
			<div class="col-auto">
				<button type="submit" class="btn btn-primary w-50">
					<i class="bi bi-search"></i>
				</button>
			</div>
		</div>
	</form>
	
	<div class="row mb-3">
		<div class="col text-start">
			<span class="fw-bold">검색 결과 : (총 ${totalCount}건)</span>
		</div>
		<div class="col text-end">
			<select name="sort" class="form-select w-auto d-inline-block">
				<option value="recent">최신순</option>
				<option value="title">제목순</option>
			</select>
		</div>
	</div>
	
	<div class="row mb-3">
		<c:forEach var="item" items=${resultList}>
			<div class="col-12 col-sm-6 col-lg-4 col-xl-3">
				<div class="card h-100 shadow-sm rounded-2">
					<img src="${item.imageObject}" class="card-img-top rounded-2 rounded-bottom-0" alt="썸네일">
					<div class="card-body">
						<h5 class="card-title d-flex justify-content-between align-items-center">
							<span class="fw-bold fs-6">${item.title}</span>
						</h5>
						<div class="row card-text small text-muted">
							<p class="card-text small text-muted mb-1">${item.eventSite}</p>
							<p class="card-text small text-muted mb-1">${item.period}</p>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
		
<%@ include file="/WEB-INF/views/template/footer.jsp" %>