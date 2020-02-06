<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
		function logout(){
			location.href="memberLogout";
		}
		function memberModify(){
			location.href="memberModify";
		}
	</script>
</head>
<body>
	<h2>MemberMain.jsp 파일</h2>
	${sessionScope.loginId} 님 환영합니다. <br>  <br>
	<!-- 관리자(admin)로 로그인 한 경우 회원 목록을 볼 수 있는 링크 노출  -->
	<c:if test="${sessionScope.loginId eq 'admin'}">
		<a href="memberList">회원목록 조회</a> <br> <br>
	</c:if>
		
	<button onclick="memberModify()">회원정보수정</button>
	<button onclick="logout()">로그아웃</button>
</body>
</html>









