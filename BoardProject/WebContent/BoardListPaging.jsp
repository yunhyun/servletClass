<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>BoardListPaging.jsp 파일입니다.</h2>
	<table border="1">
		<tr>
			<td>글번호</td>
			<td>작성자</td>
			<td>글제목</td>
			<td>작성일자</td>
			<td>조회수</td>
		</tr>
		<c:forEach items="${boardList}" var="board">
			<tr>
				<td>${board.bNumber}</td>
				<td>${board.bWriter}</td>
				<td><a
					href="boardView?bNumber=${board.bNumber}&page=${paging.page}">${board.bTitle}</a></td>
				<td>${board.bDate}</td>
				<td>${board.bHits}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5"><a href="boardWriteForm">글쓰기</a></td>
		</tr>
	</table>

	<!-- 페이징 처리 -->
	<c:if test="${paging.page<=1}">
	[이전]&nbsp;
	</c:if>
	
	<c:if test="${paging.page>1}">
		<a href="boardListPaging?page=${paging.page-1}">[이전]</a>&nbsp;
	</c:if>
	
	<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i" step="1">
		<c:choose>
			<c:when test="${i eq paging.page}">
			${i}
			</c:when>
			<c:otherwise>
				<a href="boardListPaging?page=${i}">${i}</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>

	<c:if test="${paging.page>=paging.maxPage}">
		[다음]
	</c:if>
	
	<c:if test="${paging.page<paging.maxPage}">
		<a href="boardListPaging?page=${paging.page+1}">[다음]</a>
	</c:if>


</body>
</html>