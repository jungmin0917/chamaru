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