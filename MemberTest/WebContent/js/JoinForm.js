function join(){
	joinForm.submit();
}

function idCheck(){
var exp = /^(?=.*[a-z])(?=.*\d)[a-z\d]{6,10}$/;
var id = document.getElementById("idForm");
var idResult = document.getElementById("idCkResult");
if(id.value.length==0){
    idResult.style.color = "red";
    idResult.innerHTML = "아이디는 필수 입니다."
} else if(id.value.length<6 || id.value.length>10 || !id.value.match(exp)){
    idResult.style.color = "red";
    idResult.innerHTML = "유효하지 않은 형식입니다."
} else if(id.value.length>=6 && id.value.length<=10 && id.value.match(exp)){
    idResult.style.color = "green";
    idResult.innerHTML = "좋아요 Good"
} 
}

function pwdCheck(){
// 정규식(RegularExpression)
var exp = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$/;
var pwd = document.getElementById("pwd");
var pwdCheck = document.getElementById("pwdCkResult");
if(pwd.value.match(exp)){
    pwdCheck.style.color="green";
    pwdCheck.innerHTML = "유효한 비밀번호형식";
} else{
    pwdCheck.style.color="red";
    pwdCheck.innerHTML = "유효한 비밀번호형식이 아닙니다.";
}
}

function checkReset(){
document.getElementById("pwdCkResult").innerHTML = "";
}

function pwdConfirm(){
var pwd = document.getElementById("pwd").value;
var pwdConfirm = document.getElementById("pwdConfirmId").value;
var confirmMsg = document.getElementById("confirmMsg");
if(pwd==pwdConfirm){
    confirmMsg.style.color = "green";
    confirmMsg.innerHTML = "비밀번호 일치!!";
} else{
    confirmMsg.style.color = "red";
    confirmMsg.innerHTML = "비밀번호 불일치!!";
}
}

function phoneCheck(){
var exp = /^\d{3}-\d{4}-\d{4}$/;
var phone = document.getElementById("phone");
var phoneCheck = document.getElementById("phoneCheck");
if(phone.value.match(exp)){
    phoneCheck.style.color = "green";
    phoneCheck.innerHTML = "유효한 전화번호 형식";
} else {
    phoneCheck.style.color = "red";
    phoneCheck.innerHTML = "유효하지 않은 전화번호 형식";
}
}

function emailSel(value){
document.getElementById("emailSelected").value = value;
}

function sample6_execDaumPostcode() {
new daum.Postcode({
    oncomplete: function(data) {
        // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

        // 각 주소의 노출 규칙에 따라 주소를 조합한다.
        // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
        var addr = ''; // 주소 변수
        var extraAddr = ''; // 참고항목 변수

        //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
        if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
            addr = data.roadAddress;
        } else { // 사용자가 지번 주소를 선택했을 경우(J)
            addr = data.jibunAddress;
        }

        // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
        if(data.userSelectedType === 'R'){
            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
                extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraAddr !== ''){
                extraAddr = ' (' + extraAddr + ')';
            }
            // 조합된 참고항목을 해당 필드에 넣는다.
            document.getElementById("sample6_extraAddress").value = extraAddr;
        
        } else {
            document.getElementById("sample6_extraAddress").value = '';
        }

        // 우편번호와 주소 정보를 해당 필드에 넣는다.
        document.getElementById('sample6_postcode').value = data.zonecode;
        document.getElementById("sample6_address").value = addr;
        // 커서를 상세주소 필드로 이동한다.
        document.getElementById("sample6_detailAddress").focus();
    }
}).open();
}

