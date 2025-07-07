<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %> 

<!DOCTYPE html>
<html>
	<head>
	    <title>이벤트 출력</title>
	</head>
	<body>
		<form action="/cuture" method="get">
			<input type="text" name="title" placeholder="제목으로 검색">
		</form>
    	<span>${jsonData}</span>
	</body>
</html>