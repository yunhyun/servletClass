<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function boardWrite() {
		boardWriteForm.submit();
	}
</script>
</head>
<body>

	<h2>BoardWrite.jsp 파일</h2>
	<form action="boardWrite" method="post" name="boardWriteForm">
		작성자 : <input type="text" name="bWriter"><br>
		비밀번호 : <input type="text" name="bPassword"><br>
		제목 : <input type="text" name="bTitle"><br>
		내용 : <textarea name="bContents" cols="40" rows="20"></textarea><br>
	</form>
	<button onclick="boardWrite()">글등록</button>
	<button onclick="location.href='boardListPaging'">목록</button>
	
	
	
</body>
</html>