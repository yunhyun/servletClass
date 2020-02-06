<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>회원가입폼(가로형)</title>
    <script type="text/javascript" src="js/JoinForm.js"></script>
    <script src="https://kit.fontawesome.com/bd39ee1686.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/JoinForm.css">
    <!-- <link href="https://fonts.googleapis.com/css?family=Do+Hyeon&display=swap" rel="stylesheet"> -->
    <link href="https://fonts.googleapis.com/css?family=Jua&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Gugi&display=swap&subset=korean" rel="stylesheet">
    
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>


 
</head>

<body>
    <h2>회원가입</h2>
<form action="memberJoin" method="post" id="joinForm">
<table>
    <tr>
    <td><i class="far fa-id-badge" style="font-size: 20px; color: grey;"></i></td>
        <td><span class="items">아이디 : </span></td>
        <td><input type="text" id="idForm" name="id" placeholder="6~10자리, 소문자,숫자포함" onkeyup="idCheck()">
        <span id="idCkResult"></span></td>
    </tr>

    <tr>
    <td><i class="fas fa-lock" style="font-size: 20px; color: grey;"></i></td>
        <td><span class="items">비밀번호 : </span></td>
        <td><input type="text" id="pwd" name="pwdName" placeholder="8~16자리,숫자,대소문자,특수문자포함" onkeyup="pwdCheck()" onblur="checkReset()">
        <span id="pwdCkResult"></span></td>
    </tr>

    <tr>
    <td><i class="far fa-check-circle" style="font-size: 20px; color: grey;"></i></td>
        <td><span class="items">비밀번호 확인 : </span></td>
        <td><input type="text" id="pwdConfirmId" onkeyup="pwdConfirm()">
        <span id="confirmMsg"></span></td>
    </tr>

    <tr>
    <td><i class="fas fa-user" style="font-size: 20px; color: grey;"></i></td>
        <td><span class="items">이름 : </span></td>
        <td><input type="text" id="name" name="name"><br></td>
    </tr>

    <tr>
    <td><i class="far fa-calendar-alt" style="font-size: 20px; color: grey;"></i></td>
        <td><span class="items">생년월일 : </span></td>
        <td><input type="date" id="birth" name="birth"><br></td>
    </tr>

    <tr>
    <td><i class="far fa-envelope" style="font-size: 20px; color: grey;"></i></td>
        <td><span class="items">이메일 : </span></td>
        <td><input type="text" id="email" name="emailId">@
        <input type="text" id="emailSelected">
        <select id="emailSelId" onchange="emailSel(this.value)">
            <option value="">직접입력</option>
            <option value="naver.com">naver.com</option>
            <option value="hanmail.net">hanmail.net</option>
            <option value="gmail.com">gmail.com</option>
        </select></td>
    </tr>

    <tr>
        <td><i class="fas fa-map-marked-alt" style="font-size: 20px; color: grey;"></i></td>
            <td><span class="items">주소 : </span></td>
            <td>
                <input type="text" id="sample6_postcode" placeholder="우편번호" name="postcode">
                <input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
                <input type="text" id="sample6_address" placeholder="주소" name="address"><br>
                <input type="text" id="sample6_detailAddress" placeholder="상세주소" name="detailAddress">
                <input type="text" id="sample6_extraAddress" placeholder="참고항목">
            </td>
        </tr>

    <tr>
    <td><i class="fas fa-mobile-alt" style="font-size: 20px; color: grey;"></i></td>
        <td><span class="items">휴대폰번호 : </span></td>
        <td><input type="text" id="phone" name="phone" onkeyup="phoneCheck()">
        <span id="phoneCheck"></span></td>
    </tr>

    <tr>
    <td colspan="3" style="text-align: center;">
        <button class="button" onclick="join()">회원가입</button></td>
    </tr>
</table>
</form>
</body>
</html>