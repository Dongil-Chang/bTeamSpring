<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
.error-header::after {
	clear : both;
	content :'';
	display : block;
}

.category ul li {
	float : right;		
	line-height : 30px;	
	font-size : 18px;
	color : #4d2ebd;
	margin : 0 20px;
	font-weight : 700;
}	
.category ul li a:hover{
	color : #ffdc64;
}
</style>

<div class='center' style='width: 600px; margin: 0 auto'>
	<div class='left' style='height: 100px;'>
		<a href='<c:url value="/" />'><img src='imgs/404_error.png'
			width="100px" height="100px" /></a>
		<div style='float: right'>
			<h2>죄송합니다. 요청하신 페이지를 찾을 수 없습니다.</h2>
			<pre>아래 메뉴를 통해 서비스를 이용하실 수 있습니다.</pre>
		</div>
	</div>
	<br>
	<hr>
	<div class='error-header'>
		<div class='category'>
			<ul style="float: left;">
				<li><a href='guide.gu'
					class="${category eq 'gu' ? 'active' : ''}">이용안내</a></li>
				<li><a href='list.rv'
					class='${category eq "rv" ? "active" : "" }'>예약하기</a></li>
				<li><a href='list.no'
					class="${category eq 'no' ? 'active' : ''}">공지사항</a></li>
				<c:if test="${!empty loginInfo }">
					<li><a href='cu_new.qa'
						class="${category eq 'qa' ? 'active' : ''}">1:1문의</a></li>
				</c:if>
				<li><a href='list.QnA'
					class='${category eq "QnA" ? "active" : "" }'>FAQ</a></li>

				<%-- 				<c:if test="${loginInfo.su	bcode eq '1  ' || loginInfo.subcode eq '3  '}">
					<li><a href='mypage.my'class="${category eq 'my' ? 'active' : ''}">마이페이지</a></li>
				</c:if> --%>

			</ul>
		</div>
	</div>
</div>
