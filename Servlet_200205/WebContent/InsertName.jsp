<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
		function nameInsert(){
			formName.submit();
		}
	</script>
</head>
<body>
	<h2>InsertName.jsp 파일</h2>
	<form action="insertName" method="get" id="formName">
		이름 : <input type="text" name="name">
		
	</form>
		<button onclick="nameInsert()">서버로 전송</button>
</body>
</html>




