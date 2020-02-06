<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
	<script>
		function memberJoin(){
			location.href="JoinForm.jsp";
		}
		function memberLogin(){
			location.href="LoginForm.jsp";
		}
	</script>
</head>
<body>
	<h2>Main.jsp 파일</h2>
	
	<button onclick="memberJoin()">회원가입</button>
	<button onclick="memberLogin()">로그인</button>
</body>
</html>