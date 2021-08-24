<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>FAQ 1</title>

<style>
/* FAQ */


.faq{
border-bottom:0px solid #ddd;margin:1em 0;
width: 100%;
height: 100%;
}

.faq .faqHeader{
position:relative;
/* zoom:1 */
}

.faq .faqHeader {
position:absolute;
bottom:0;
right:0;
border:0;
padding:0;
overflow:visible;
/* background: #00D4FF; */
cursor:pointer
}

.faqBody{
margin:0;padding:0
}

.faqBody::after {
	clear : both;
	content : '';
	display : block;
}

.faq_left {
	width : 35%;
	height : 650px;
	line-height : 650px;
	background : #05668d;
	float: left;
	font-size : 60pt;
	font-weight: 800;
	color : #fff;
}

.faq_right {
	width : 65%;
	height : 400px;
	background : #fff;
	float: right;
}


.faq .faqBody .article{
list-style:none;
margin-top: 50px;
}

.faq .q{
/* margin:10px 0; */
padding : 10px 10px;
background: #00a896;
}

.faq .q .a{
	display:block;text-align:left; 
    background:url("faq1_icon_q.png") no-repeat 0 0;
    padding:0 0 0 35px;
    font-size:18px;
    color:#5e5e5e;
    font-weight:bold;
    line-height: 27px;
    cursor:pointer;
    margin: 10px 0; !important
}
    
.faq .q a:hover, .faq .q a:active, .faq .q a:focus{}
.faq .a{background:#e7ecef; padding: 10px 75px 10px 75px;
    font-size: 16px;
    color: #444444;
    line-height: 22px;
    padding : 10px 10px;
    border-top: 1px solid #bdbdbd;
    /* margin:-10px 0 0 0; */
}
.q{
	max-width : 100%;
	text-align : left;
	font-size: 20px;
	border-bottom: 1px solid #bdbdbd;
	margin-top: 10px;
}

.a{
	max-width : 100%;
	text-align : left;
	font-size: 18px;
	
}	
summary { cursor: pointer; }

/* 삼각형 없애기 */
summary { list-style: none; }	
summary::-webkit-details-marker {
	display: none;
}	
*/	


</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-latest.js"></script>

</head>
<body>
<!-- <h3>소소한 FAQ</h3> -->
<div class='faq'>
	<div class="faqHeader">
    	<ul>
			<!-- 로그인 시 정보를 담고 있는 session.setAttribute("loginInfo", vo)을 통해 admin 값을 가져와 비교함.		
			<c:if test="${loginInfo.subcode eq '3'}">
				<li><a class='btn-fill' href='new.no'>글쓰기</a></li>
			</c:if> -->	
		</ul>
    </div>
	<div class='faqbody'>
		<c:forEach items="${page.list}" var="vo">
			<details>
				<summary class='q'>${vo.faq_title }
					<i class="fas fa-angle-double-down"></i>
				</summary>
				<pre class='a'>${vo.faq_content }</pre>
			</details>
		</c:forEach>
	</div>
</div>
</body>
</html>
