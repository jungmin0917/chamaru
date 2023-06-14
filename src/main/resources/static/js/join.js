//아이디 입력되었으면 오류메세지 사라지게 만들기
/*function idCheck(f) {
    var userId = f.userId.value;
    if (userId != "") {
        document.getElementById("id_input_re_1").style.display = 'none';
        *//*document.getElementsByClassName("IdErrors").style.display = 'none';*//*
    }
    if (userId == "") {
        document.getElementById("id_input_re_1").style.display = 'block';
        *//*document.getElementsByClassName("IdErrors").style.display = 'block';*//*
    }
}*/


/*function emailSend(f) {
    var userEmail = f.userEmail.value;
    var userEmailCheck = f.userEmailCheck.value;

    if (userEmail == "") {
        alert("이메일을 입력하세요");
        return;
    }

    //이메일 형식이 맞는지 체크
    if (!mailFormCheck(userEmail)) {
        alert("이메일 형식이 아닙니다");
        return;
    }
    //이메일 형식이 맞으면
    alert("인증메일을 보냈습니다!\n인증번호를 입력하세요!\n"+userEmail);
    f.method="get";
    f.action="/member/mail;
    f.submit();
}*/


//이메일 정규식
function mailFormCheck(email) {
    var form = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
    return form.test(email);
}


//회원가입 유효성 검사
function join(f) {
    var userId = f.userId.value;
    var userPw = f.userPw.value;
    var userPwRe = f.userPwRe.value;
    var userNm = f.userNm.value;
    var userEmail = f.userEmail.value;
    var userEmailCheck = f.userEmailCheck.value;
    var userPhone = f.userPhone.value;
    if (userId == "") {
        alert("아이디를 입력하세요");
        return;
    }
    if (userId.length < 8) {
        alert("아이디는 8자리 이상으로 입력하세요.");
        return;
    }
    if (userPw == "") {
        alert("비밀번호를 입력하세요");
        return;
    }
    if (userPwRe == "") {
        alert("비밀번호 확인을 입력하세요");
        return;
    }
    if (userNm == "") {
        alert("이름을 입력하세요");
        return;
    }
    if (userEmail == "") {
        alert("이메일을 입력하세요");
        return;
    }
    /*if (userEmailCheck == "") {
        alert("인증번호를 입력하세요");
        return;
    }*/
    if (userPhone == "") {
        alert("휴대전화번호를 입력하세요");
        return;
    }
}
