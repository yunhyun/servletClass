<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function login(){
		loginForm.submit();
	}
	function joinForm(){
		location.href="JoinForm.jsp";
	}
</script>
</head>
<body>
	<h2>LoginForm.jsp 파일</h2>
	<form action="memberLogin" method="post" id="loginForm">
		아이디 : <input type="text" name="id">
		비밀번호 : <input type="password" name="password">		
	</form>
	<button onclick="login()">로그인</button>
	<button onclick="joinForm()">회원가입</button>
</body>
</html>










