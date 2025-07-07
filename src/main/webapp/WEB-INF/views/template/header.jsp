<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<!-- 부트스트랩 CDN -->
		<!-- Bootstrap의 스타일(CSS) -> Cosmo 테마 적용 -->
		<link href="https://cdnjs.cloudflare.com/ajax/libs/bootswatch/5.3.7/cosmo/bootstrap.min.css" rel="stylesheet">
		<!-- Bootstrap의 동작(JS) -->	
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>
		<!-- 부트스트랩 아이콘 -->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
		
		<!-- FlatPicker CDN -->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
		<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
		<script>
			document.addEventListener("DOMContentLoaded", function() {
			    flatpickr("#date-range", {
			    	mode: "range",
			    	dateFormat: "Y-m-d"
			    });
			});
		</script>
		
		<style>
			.hover-box {
				border: none;
				border-radius: 4px;
				transition: all 0.2s ease;
			}
	
			.hover-box:hover {
				border: 1px solid #e9ecef;  /* 회색 테두리 */
				background-color: #e9ecef; /* 연한 회색 배경 */
				font-weight: bold;
			}
		</style>
	</head>
	<body>
		<nav class="navbar navbar-expand-lg bg-light px-4">
			<div class="container-fluid">
				<a class="navbar-brand fw-bold text-primary" href="/">문화나들이</a>
				<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navMenu">
					<span class="navbar-toggler-icon"></span>
				</button>
				
				<div class="collapse navbar-collapse" id="navMenu">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link" href="/">홈</a></li>
						<li class="nav-item"><a class="nav-link" href="/exhibit">전시</a></li>
						<li class="nav-item"><a class="nav-link" href="/performance">공연</a></li>
						<li class="nav-item"><a class="nav-link" href="/favorite">즐겨찾기</a></li>
					</ul>
					<div class="d-flex gap-2">
						<a href="/login" class="hover-box text-decoration-none text-dark px-2 py-1">로그인</a>
						<a href="/join" class="hover-box text-decoration-none text-dark px-2 py-1">회원가입</a>
					</div>
				</div>
			</div>
		</nav>