<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>BoardView.jsp 파일</h2>
	
	<table border="1">
	<tr>
		<td>제목</td>
		<td>${boardView.bTitle}</td></tr>
	<tr>
		<td>작성자</td>
		<td>${boardView.bWriter}</td></tr>		
	<tr>
		<td>내용</td>
		<td>${boardView.bContents}</td></tr>
	<tr>
		<td>조회수</td>
		<td>${boardView.bHits}</td></tr>		
</table>
	
	
	
	
	
	
	
	
	
</body>
</html>