<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="google-signin-client_id" content="1020138534296-c4itm32e1q58c2ggrqfkod81b4b4cntt.apps.googleusercontent.com">
<title>Insert title here</title>
<style type="text/css">
body{
background-color: #E0FBFC;
}
#login {width: 100%; height:calc(100% - 170px); padding: 40px 0; border: 1px  dashed #8b8c89; border-radius: 1em; }
#userid, #userpw {width: 48%; padding:5px 10%; margin-bottom: 10px }
.btn-fill {
	margin:auto; width:60.5%; height:42px !important; line-height: 42px;
	box-shadow:none !important;  /* !important 우선순위 지정 */
}

img.social { width:275px; height: 47px; }
img.social:first-child {margin-bottom:10px;}

</style>
<script src="https://apis.google.com/js/platform.js" async defer></script>
</head>
<body>
	<div style="width:400px;" class='center'>
		<div style="height:70px">
			<a href='<c:url value="/" />'><img src='imgs/logo_open_box2.png' /></a>
		</div>
	
		<div id ='login'>
			<input type="text" placeholder="아이디" id='userid' onkeydown="onlyAlphabet(this)" autofocus  />
			<input type="password" placeholder="비밀번호" id='userpw' 
					onkeypress="if( event.keyCode == 13) go_login()" />
				<!-- onkeypress : Enter 키를 눌렀을 때 go_login() -->
			<a class='btn-fill' onclick="go_login()">로그인</a>
			<div style='width:69%; margin:25px auto; border:1px dashed #8b8c89'></div>
			
			<a href='naverLogin'><img src='imgs/naver_login1.png' class='social' /></a>
			<a href='kakaoLogin'><img src='imgs/kakao_login1.png' class='social' /></a>
<!-- 			<a href='googleLogin'><img src='imgs/google_signin.png' class='social' /></a> -->
		</div>
	</div>
	
	
<script type="text/javascript">
function go_login() {
	if($('#userid').val() == '') { // 아이디 입력값이 없으면
		alert('아이디를 입력하세요!');
		$('#userid').focus();
		return;
	} else if ($('#userpw').val() == '') { // 비밀번호 입력값이 없으면
		alert('비밀번호를 입력하세요!');
		$('#userpw').focus();
		return;
	}
	
	$.ajax({	// login 을 위한 ajax 통신 설정
		url: 'webLogin',
		data: {id:$('#userid').val(), pw:$('#userpw').val()},
		success: function(response) {
			if (response) {
				location = '<c:url value="/" />';
			} else {
				alert("아이디나 비밀번호가 일치하지 않습니다!");
			}
			
		}, error : function(req, text) {
			alert(text + ':' + req.status);
		}
	});
}

function onlyAlphabet(ele) {
	  ele.value = ele.value.replace(/[^\\!-z]/gi,"");
}
</script>	
</body>
</html>