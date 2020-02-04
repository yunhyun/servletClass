<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>

<!-- JSTL(JavaServer Page Standard Tag Library) -->
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>SelectResult.jsp 파일</h2>
	<h3>DB 조회 내용 출력</h3>
	<c:forEach var="result111" items="${selectResult}">
		${result111} <br>
	</c:forEach>
	




</body>
</html>