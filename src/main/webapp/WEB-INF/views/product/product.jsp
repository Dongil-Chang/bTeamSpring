<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
	.aside_type { font-size : 50px; color : #fff;  }
	.ma_category { 
	font-size:18px; float : left; 	line-height : 56px; color : #fff;
}
.ma_category ul li a:hover, header .ma_category ul li a.active{
	font-weight: bold; color: #0000cd;
</style>
<div class='aside_type'>
<pre>
소소한
관리자
</pre>
</div>
<div class='ma_category' style="margin-left: 100px;">
	<ul>
		<li><a href='list.ma' class='${ma_category eq "list" ? "active" : "" }'>회원목록</a></li>
		<li><a href='list.pd' class='${ma_category eq "list" ? "active" : "" }'>상품정보</a></li>
		<li><a href='booking.ma' class='${ma_category eq "booking" ? "active" : "" }'>예약현황</a></li>
		<li><a href='new.no' class="${ma_category eq 'no' ? 'active' : ''}">공지사항</a></li>
		<li><a href='faq_list.ma' class="${ma_category eq 'faq_list' ? 'active' : ''}">FAQ</a></li>
		<li><a href='provision.ma' class="${ma_category eq 'provision' ? 'active' : ''}">이용약관</a></li>
	</ul>
</div>