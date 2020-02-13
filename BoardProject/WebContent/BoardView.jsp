<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function boardDelete(){
		var passConfirm = prompt('비밀번호를 입력하세요');
		var password = '${boardView.bPassword}';
		if(password == passConfirm){
			location.href='boardDelete?bNumber=${boardView.bNumber}';
		} else{
			alert('비밀번호가 틀립니다');
		}
	}
</script>
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
	<tr>
		<td>파일</td>
		<td><img src="fileUpload/${boardView.bFile}" width="200" height="200"></td></tr>
	<tr>
		<td>파일명</td>
		<td>${boardView.bFile}</td></tr>		
		
	</table>
	
	<button onclick="location.href='boardList'">목록</button>
	<button onclick="location.href='boardListPaging?page=${page}'">페이징목록</button>
	<button onclick="location.href='boardModify?bNumber=${boardView.bNumber}'">수정</button>
	<button onclick="location.href='boardDelete?bNumber=${boardView.bNumber}'">삭제</button>
	<button onclick="boardDelete()">삭제(비번)</button>
	
	
	
	
	
	
	
	
</body>
</html>