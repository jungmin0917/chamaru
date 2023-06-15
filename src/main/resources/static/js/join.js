
/*인증코드 보내기*/
function emailSend(f) {
    var userEmail = f.userEmail.value;
    var userEmailCheck = f.userEmailCheck.value;

    if (userEmail == "") {
        alert("이메일을 입력하세요");
        f.userEmail.focus();
        return;
    }

    //이메일 형식이 맞는지 체크
    if (!mailFormCheck(userEmail)) {
        alert("이메일 형식이 아닙니다");
        f.userEmail.focus();
        return;
    } else {
        //이메일 형식이 맞으면
        alert("인증메일을 보냈습니다!\n인증번호를 입력하세요!\n"+userEmail);
        f.userEmailCheck.focus();

        $.ajax({
                type:"GET",
                url:"/member/sendmail?userEmail=" + userEmail
        });
    }
}


//이메일 정규식
function mailFormCheck(email) {
    var form = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
    return form.test(email);
}

//다음 주소록 연동하기
function execution_daum_address() {

    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.

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
                // 주소변수 문자열과 참고항목 문자열 합치기
                addr += extraAddr;

            } else {
                addr += ' ';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            $(".address1_input").val(data.zonecode);
/*            document.getElementById("address_input_re_1").style.display = 'block';
            document.getElementById("address_input_re_2").style.display = 'none';*/
            //$("[name=memberAddr1]").val(data.zonecode);    // 대체가능
            $(".address2_input").val(addr);
            //$("[name=memberAddr2]").val(addr);            // 대체가능

            // 상세주소 입력란 disabled 속성 변경 및 커서를 상세주소 필드로 이동한다.
            $(".address3_input").attr("readonly",false);
            $(".address3_input").attr("placeholder", "상세주소를 입력해주세요");
            $(".address3_input").focus();
        }
    }).open();
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
    var userAddr1 = f.userAddr1.value;
    var userAddr2 = f.userAddr2.value;
    var userAddr3 = f.userAddr3.value;
    if (userId == "") {
        alert("아이디를 입력하세요");
        return;
    }
    if (userId.length < 8) {
        alert("아이디는 8자리 이상으로 입력하세요.");
        return;
    }
    if (userPw == "") {
        alert("비밀번호를 입력하세요.");
        return;
    }
    if (userPw.length < 8) {
        alert("비밀번호는 8자리 이상으로 입력하세요.");
        return;
    }
    if (userPwRe == "") {
        alert("비밀번호 확인을 입력하세요.");
        return;
    }

    if (userPw != userPwRe) {
        alert("비밀번호가 일치하지 않습니다.");
        return;
    }

    if (userNm == "") {
        alert("이름을 입력하세요.");
        return;
    }
    if (userEmail == "") {
        alert("이메일을 입력하세요.");
        return;
    }
    if (userEmailCheck == "") {
        alert("인증번호를 입력하세요.");
        return;
    }
    if (userPhone == "") {
        alert("전화번호를 입력하세요.");
        return;
    }
    if (userAddr1 == "") {
        alert("주소찾기를 눌러서 주소를 입력하세요.");
        return;
    }
    if (userAddr2 == "") {
        alert("주소를 입력하세요.");
        return;
    }
    if (userAddr3 == "") {
        alert("상세주소를 입력하세요.");
        return;
    }

}
