<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.aside_type { font-size : 50px; color : #fff;  }
.my_category { 
	font-size:20px; float : left; 	line-height : 56px; color : #f0f3bd;
}
.my_category ul li a:hover, header .my_category ul li a.active{
	font-weight: bold; color: #0000cd;
}
</style>
</head>
<div class='aside_type'>
	<pre>
소소한
나의 공간
</pre>
</div>
<div class='my_category' style="margin-left: 100px;">
	<ul>
		<li><a href='storage.my?id=${loginInfo.id }'
			class='${my_category eq "storage" ? "active" : "" }'>내 창고</a></li>
		<li><a href='booking.my'
			class='${my_category eq "booking" ? "active" : "" }'>예약내역</a></li>
		<li><a href='cu_list.qa'
			class="${my_category eq 'cu_list' ? 'active' : ''}">1:1 문의</a></li>
		<li><a href='myinfo.my'
			class="${my_category eq 'myinfo' ? 'active' : ''}">정보수정</a></li>
		<li><a href='leave.my'
			class="${my_category eq 'leave' ? 'active' : ''}">회원탈퇴</a></li>
	</ul>
</div>