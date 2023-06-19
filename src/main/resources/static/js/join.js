code = "";

/*인증코드 보내기*/
function emailSend(f) {
    var userEmail = f.userEmail.value;
    var userEmailCheck = f.userEmailCheck.value;

    if (userEmail == "") {
        alert("이메일을 입력하세요.");
        f.userEmail.focus();
        return;
    }

    //이메일 형식이 맞는지 체크
    if (!mailFormCheck(userEmail)) {
        alert("이메일 형식이 아닙니다.");
        f.userEmail.focus();
        return;
    } else {
        //이메일 형식이 맞으면
        $.ajax({
                type:"GET",
                url:"/member/sendmail?userEmail=" + userEmail,
                success:function(data){
                    code = data;
                    console.log("code : " + code);
                    $("#codeNum").attr("value", code);
                }
        });
        alert("인증메일을 보냈습니다!\n인증코드를 입력하세요!\n");
        f.userEmailCheck.focus();
        document.getElementById('realEmail').value = userEmail;
        /*document.getElementById('mail').readOnly = true; // readonly 활성화*/
    }
}



//이메일 정규식
function mailFormCheck(email) {
    var form = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
    return form.test(email);
}

//비밀번호 정규식
function chkPW(){

    var pw = $("#userPw").val();
    var num = pw.search(/[0-9]/g);
    var eng = pw.search(/[a-z]/ig);
    var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

    /*if (pw.length < 8 || pw.length > 20) {
        *//*alert("비밀번호는 8자리 ~ 20자리 이내로 입력해주세요.");*//*
        return false;
    } else if (pw.search(/\s/) != -1) {
        *//*alert("비밀번호는 공백 없이 입력해주세요.");*//*
        return false;
    }*/
    if (num < 0 || eng < 0 || spe < 0 ) {
        /*alert("비밀번호는 영문, 숫자, 특수문자를 혼합하여 입력해주세요.");*/
        return false;
    } else {
        console.log("통과");
        return true;
    }
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
            /*$(".address3_input").attr("readonly",false);*/
            /*$(".address3_input").attr("placeholder", "상세주소를 입력해주세요.");*/
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
    var codeNum = f.codeNum.value;
    var realEmail = f.realEmail.value;

    try {
        const requiredFields = {
            userId : "아이디를 입력하세요.",
            userPw : "비밀번호를 입력하세요.",
            userPwRe : "비밀번호 확인을 입력하세요.",
            userNm : "이름을 입력하세요.",
            userEmail : "이메일을 입력하세요.",
            userEmailCheck : "이메일 인증코드를 입력하세요.",
            userPhone : "전화번호를 입력하세요.",
            userAddr1 : "주소찾기를 통해 주소를 입력하세요.",
            userAddr3 : "상세주소를 입력하세요.",
        };

        const formData = new FormData(f);
        for (const key in requiredFields) {
            const value = formData.get(key);
            const fieldData = requiredFields[key];
            if (!value.trim()) {
               throw new Error(fieldData);
            } else if (key == "userId" && value.trim().length < 8 || value.trim().length > 20) {
                throw new Error("아이디는 8자리 ~ 20자리 이내로 입력해주세요.");
            } else if (key == "userPw" && value.trim().length < 8 || value.trim().length > 20) {
                throw new Error("비밀번호는 8자리 ~ 20자리 이내로 입력해주세요.");
            } else if (key == "userPw" && !chkPW()) {
                throw new Error("비밀번호는 영문, 숫자, 특수문자를 혼합하여 입력해주세요.");
            } else if (key == "userPw" && chkPW() && value != formData.get("userPwRe")) {
                throw new Error("비밀번호가 일치하지 않습니다.");
            } else if (key == "userEmail" && !mailFormCheck(value)) {
                throw new Error("이메일 형식이 아닙니다.");
            } else if (key == "userEmail" && formData.get("codeNum") != "" && value != formData.get("realEmail")) {
                throw new Error("이메일이 변경된 상태입니다.\n이메일을 다시 확인해주세요.");
            } else if (key == "userEmailCheck" && value != formData.get("codeNum")) {
                throw new Error("인증코드가 일치하지 않습니다.\n인증코드를 확인해주세요.");
            }
        }
    } catch (e) {
        alert(e.message);
    }

}
