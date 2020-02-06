<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>MemberList.jsp 파일</h2>

<table border="1">
	<tr>
		<th>ID</th> <th>PASSWORD</th> <th>NAME</th>
		<th>BIRTH</th> <th>GENDER</th> <th>EMAIL</th>
		<th>상세조회</th><th>탈퇴</th></tr>
		
	<c:forEach var="member" items="${memberList}">
		<tr>
			<td>${member.id}</td>
			<td>${member.password}</td>
			<td>${member.name}</td>
			<td>${member.birth}</td>
			<td>${member.gender}</td>
			<td>${member.email}</td> 
			<td><a href="memberView?id=${member.id}">조회</a></td>
			<td><a href="memberDelete?id=${member.id}">삭제</a></td>
			</tr> 
		<br>
	</c:forEach>
	
	
</table>
	
	
</body>
</html>