<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
.error-header::after {
	clear : both;
	content :'';
	display : block;
}
.error-img {
	float : left;	
	}
.category ul li {
	float : right;		
	line-height : 100px;	
	font-size : 18px;
	color : #4d2ebd;
	margin : 0 20px;
	font-weight : 700;
}	
.category ul li a:hover{
	color : #ffdc64;
}
</style>
<div class='center' style='width: 800px; margin: 0 auto'>
	<div class='error-header'>
		<div class='error-img'>
			<a href='<c:url value="/" />'><img src='imgs/error_01.png' width="100px" height="100px" /></a>
		</div>
		<div class='category' style='background : #8ecce6'>
			<ul>
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
	<hr>
	<div class='left'>
		<h3>내부적인 오류가 발생했습니다.</h3>
		<pre>빠른 시일내에 오류를 해결해 복구시키도록 하겠습니다.
관련 문의사항은 '소소한 스토리지' 고객센터에 알려주시면 친절하게 안내해 드리겠습니다.</pre>
		<hr>
		<div style='font-size:14px'>${msg }</div>
	</div>
</div>