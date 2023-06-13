//아이디 입력되었으면 오류메세지 사라지게 만들기
/*function IdCheck(f) {
    var userId = f.userId.value;
    if (userId != "") {
        *//*document.getElementById("id_input_re_1").style.display = 'none';*//*
        document.getElementsByClassName("IdErrors").style.display = 'none';
    }
    if (userId == "") {
        document.getElementsByClassName("IdErrors").style.display = 'block';
    }
}*/


function emailSend(f) {
    var userEmail = f.userEmail.value;

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
}

//이메일 정규식
function mailFormCheck(email) {
    var form = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
    return form.test(email);
}


//회원가입 유효성 검사
function join(f) {

    alert("버튼누름!");
    return;

}