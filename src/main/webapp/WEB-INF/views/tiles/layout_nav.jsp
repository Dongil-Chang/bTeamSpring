<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- tiles 라이브러리를 사용할 수 있도록 선언 -->
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
	<c:when test="${category eq 'cu' }"><c:set var='title' value='고객관리' /></c:when>
	<c:when test="${category eq 'hr' }"><c:set var='title' value='사원관리' /></c:when>
	<c:when test="${category eq 'no' }"><c:set var='title' value='공지사항' /></c:when>
	<c:when test="${category eq 'bo' }"><c:set var='title' value='방명록' /></c:when>
	<c:when test="${category eq 'da' }"><c:set var='title' value='공공데이터' /></c:when>
	<c:when test="${category eq 'vi' }"><c:set var='title' value='시각화' /></c:when>
	<c:when test="${category eq 'join' }"><c:set var='title' value='회원가입' /></c:when>
	
</c:choose>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>소소한 스토리지 > ${title}</title>

<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"></script>
<style type="text/css">
	#wrap {display: flex; flex-direction: column; height:100%;}
	/* flex 방향 지정 flex-direction: column(가로) */
	#article {display: flex; flex-direction: row; height:800px;}
</style>
<link rel="icon" type="image/x-icon" href="imgs/hanul.ico" />
<link rel="stylesheet" type="text/css" href="css/common.css?v=<%=new Date().getTime()%>">
<!-- css, js 등의 리소스 내 파일이 수정되었을 때 마다 v 값을 바꿀 수 있도록 시간으로 적용 --> 

<!-- jQuery 연결 -->
<script src='https://code.jquery.com/jquery-3.6.0.min.js'></script>
<!--  -->
<script type="text/javascript" src='js/common.js'></script>
</head>
<body>
	<div id='wrap'>
		<tiles:insertAttribute name="header" />
		
		<div id='article'>		
		<!-- 타일 조각을 붙일 xml -->
			<div class='aside'>
				<tiles:insertAttribute name="aside" />
			</div>
			<div class='content'>
				<tiles:insertAttribute name="content" />
			</div>
		</div>
		
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>