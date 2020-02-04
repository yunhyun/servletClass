<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>InputDB.jsp 파일</h2>
data1, data2라는 파라미터에 각각 jsp, servlet 이라는 정보를 담아서 
inputServer 라는 주소로 전송하고 콘솔에 전송받은 값을 출력하세요. 
<form action="inputServer" method="get">
	첫번째 입력 : <input type="text" name="data1">
	두번째 입력 : <input type="text" name="data2">
	<input type="submit" value="서버로 전송">
</form>
</body>
</html>





