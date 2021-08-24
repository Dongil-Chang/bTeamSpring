<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header style="padding:15px 0; text-align:left; border-bottom: 1px solid #ccc">
	<div class="header-bg">
		<div id = 'headerMain'>
			<div id = 'headerLeft'>
				<div class='header_logo'>
					<a href='<c:url value="/"/>'>
						<img src="imgs/logo_open_box2.png" />
					</a>
				</div>
				<div class='category' style="margin-left: 100px;">
				<ul>
					<li><a href='guide.gu'class="${category eq 'gu' ? 'active' : ''}">이용안내</a></li>
					<li><a href='list.rv' class='${category eq "rv" ? "active" : "" }'>예약하기</a></li>
					<li><a href='list.no'class="${category eq 'no' ? 'active' : ''}">공지사항</a></li>
					<c:if test="${!empty loginInfo }">
						<li><a href='cu_new.qa'class="${category eq 'qa' ? 'active' : ''}">1:1문의</a></li>
					</c:if>
					<li><a href='list.QnA' class='${category eq "QnA" ? "active" : "" }'>FAQ</a></li>
					
	<%-- 				<c:if test="${loginInfo.subcode eq '1' || loginInfo.subcode eq '3'}">
						<li><a href='mypage.my'class="${category eq 'my' ? 'active' : ''}">마이페이지</a></li>
					</c:if> --%>
					
					<c:if test="${loginInfo.subcode eq '3'}">
						<li><a href='master.ma'class="${category eq 'ma' ? 'active' : ''}">관리자</a></li>
					</c:if>
				</ul>
				</div>
			</div>	
			<div id = 'headerRight'>
<!-- 				<div class='user_nav' style="position: absolute; right: 0; top: 20px; margin-right: 100px;"> -->
				   <div	class='user_nav'>
				   <ul>
				  		<!-- 로그인 하지 않는 상태 -->
				  		<c:if test="${empty loginInfo }">
						<li>
							<a class="main_login" href="login">로그인</a>
							<a class="main_sign" href="member">회원가입</a>
						</li>
						</c:if>
				  		<!-- 로그인한 상태 -->
				  		<c:if test="${!empty loginInfo }">
				  		<li>
				  			<a href='mypage.my'class="${category eq 'my' ? 'active' : ''}"><span class='log_name'>${loginInfo.name }</span> 님</a>
				  			<a href="logout" >로그아웃</a>
<!-- 				  			<a href="logout" class="btn-fill">로그아웃</a> -->
				  		</li>
				  		</c:if>
				   </ul>
				   </div>
			</div>
		</div>   
	</div>
</header>
<style>
.header-bg {
   background-color : #;
    position : fixed;
   width : 100%;
   height : 80px;
   top : 0;
   left : 0;
/*    padding : 10px 0; */
   z-index:1000;
}

#headerMain {
/*    width : 100%; */
   line-height : 80px;
   margin : 0 auto;
}

#headerMain::after {
   clear : both;
   content : '';
   display : block;
}

#headerLeft {
   width : 70%;
   padding : 0 80px;
   background-color : #e8fccf;
/*    border-bottom : 1px solid #000; */
   position : fixed;
   float:left;
   margin : 0 auto;
}

#headerRight {
   width : 30%;
   padding : 0 80px;
/*    border-bottom : 1px solid #000; */
   background-color : #72ddf7;
   float: right;
   font-weight: bold;
}

.header_logo {float : left }

header ul, header ul li {
margin:0; padding:0; display:inline; 
}

header .category { 
font-size:18px; float : left;    line-height : 80px;
}

header .category ul li:not(:first-child){
padding-left: 20px;
}

header .category ul li a:hover, header .category ul li a.active{
   font-weight: bold; color: #5c7aff;
}

.user_nav { float : right; line-height : 80px; }

.user_nav ul li a { color : #fff; }

.user_nav ul li a:not(:first-child){
   padding-left: 20px;
}
.user_nav ul li a:hover, .user-nav ul li a.active{
   font-weight: bold; color: #ff5d8f;
}

.log_name {font-size : 18px; font-weight: 800; color : #fff; }
.log_name:hover {color : #5fa7d3; }
</style>
<link rel="stylesheet" type="text/css" href="css/common.css?v=<%=new java.util.Date().getTime()%>">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>