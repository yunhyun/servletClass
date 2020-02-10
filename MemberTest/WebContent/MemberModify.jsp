<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
	<script>
		function memberModify(){
			var passwordConfirm = document.getElementById("password").value;
			var password = '${memberModify.password}';
			console.log(passwordConfirm);
			console.log(password);
			if(password==passwordConfirm){
				modifyForm.submit();
			} else{
				alert('비밀번호가 틀립니다.');
			}
		}
		function goMain(){
			location.href="MemberMain.jsp";
		}
	</script>

</head>
<body>
	<h2>MemberModify.jsp 파일</h2>

<h2>회원가입</h2>
	<form action="memberModifyProcess" method="post" name="modifyForm">
		아이디 : <input type="text" name="id" id = "id" value="${memberModify.id}" readonly><br>
		확인용 비밀번호 : <input type="password" name="password" id = "password"><br>
		이름 : <input type="text" name="name" id = "name" value="${memberModify.name}"><br>
		이메일 : <input type="email" name="email" id = "email" value="${memberModify.email}"><br>
		
	</form>
	<button onclick="memberModify()">정보수정</button>
	<button onclick="goMain()">메인</button>
</body>
</html>










