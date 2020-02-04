<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>DispatchResult.jsp 파일</h2>
	<!-- EL 태그를 이용하여 request 영역에 저장된 값 출력 -->
	reqData1에 저장된 값 : ${requestScope.reqData1} <br>
	reqData2에 저장된 값 : ${requestScope.reqData2} <br>
	reqData3에 저장된 값 : ${requestScope.reqData3} <br>
	<!-- EL 태그를 이용하여 session 영역에 저장된 값 출력 -->
	seData1에 저장된 값 : ${sessionScope.seData1} <br>
	seData2에 저장된 값 : ${sessionScope.seData2} <br>
	seData3에 저장된 값 : ${sessionScope.seData3} <br>
</body>
</html>







