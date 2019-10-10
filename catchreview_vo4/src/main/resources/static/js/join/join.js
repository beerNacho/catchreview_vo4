//유효성
var email = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
var password = /(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{2,50}).{8,50}$/;



//로그인 버튼 클릭시
function join(){
	
	if (($("#checkEmail").html().trim())!="사용 가능한 아이디 입니다.") {
		if (password.test( $("#upw").val())) {
			if ($("#upw").val()==$("#upw2").val()) {
				if (!$("#uname").val()=="") {
						if ( !$("#uphone").val()=="") {
								$("#join").submit();
						}
						else {
							alert("전화번호를 확인해 주십시오.");
							return;
						}
				}
				else {
					alert("이름을 확인해 주십시오.");
					return;
				}
			}
			else {
				alert("비밀번호를 확인해 주십시오.");
				return;
			}
		}
		else {
			alert("비밀번호를 확인해 주십시오.");
			return;
		}
	}
	else{
		alert("이메일을 확인해 주십시오.");
		return;
	}
}



//이메일 체크(중복체크)
function checkEmail(){
	if (email.test( $("#uemail").val())) {
		$("#checkEmail").load("../common/funcCheckEmail.jsp?email="+document.getElementById('email').value);
		return;
	}
	else {
		$("#checkEmail").text("유효한 이메일을 입력해 주십시오.");
		return;
	}

}

//비밀번호 체크
function checkPassword(){
	if (password.test( $("#upw").val())) {
		$("#checkPassword").text("사용 가능한 비밀번호 입니다.");
		return;
	}
	else {
		$("#checkPassword").text("숫자, 특문 각 1회 이상, 영문은 2개 이상 사용하여 8자리 이상 입력");
		return;
	}
}

//비밀번호 재확인
function checkPassword2(){
	if ($("#upw").val()==$("#upw2").val()) {
		$("#checkPassword2").text("비밀번호가 확인되었습니다.");
		return;
	}
	else {
		$("#checkPassword2").text("비밀번호를 확인해 주십시오.");
		return;
	}
}

//이름 체크
function checkName(){
	if ($("#uname").val()=="") {
		$("#checkName").text("이름을 입력해 주십시오.");
		return;
	}
	else {
		$("#checkName").text("");
		return;
	}
}

//폰번호 체크
function checkPhone(){
	if ( $("#uphone").val()=="") {
		$("#checkPhone").text("휴대폰 번호를 입력해 주십시오.");
		return;
	}
	else {
		$("#checkMemberPhone").text("");
		return;
	}
}

//본인인증
function certificationUser() {
	myWindow = window.open("","sample","width=200, height=200");
	myWindow.document.write("서비스 준비중");
}

//주소검색



// 회원 선택시 
function change(style) {
    
   if( style == "n" ) {
       view1.style.display = "inline"
	   view2.style.display = "none"
	   
	}
   if( style == "y" ) {
       view1.style.display = "none"
	   view2.style.display = "inline"
	  
	}
	
}


// 기록 삭제
$(document).ready(function() {
	$("input").attr("autocomplete", "off");
});

