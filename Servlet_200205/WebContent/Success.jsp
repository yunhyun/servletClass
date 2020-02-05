<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
		function selectDB(){
			location.href="selectDB";
		}
	</script>
</head>
<body>
	<h2>Success.jsp 파일</h2>
	<h3>데이터 저장 성공</h3>
	<button onclick="selectDB()">DB 조회</button>
</body>
</html>