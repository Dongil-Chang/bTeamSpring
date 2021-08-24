	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
	<c:when test="${category eq 'rv' }"><c:set var="title" value="예약하기"/></c:when>
	<c:when test="${category eq 'QnA' }"><c:set var="title" value="Q&A"/></c:when>
	<c:when test="${category eq 'no' }"><c:set var="title" value="공지사항"/></c:when>
	<c:when test="${category eq 'gu' }"><c:set var="title" value="이용안내"/></c:when>
	<c:when test="${category eq 'da' }"><c:set var="title" value="공공데이터"/></c:when>
	<c:when test="${category eq 'vi' }"><c:set var="title" value="시각화"/></c:when>
	<c:when test="${category eq 'join' }"><c:set var="title" value="회원가입"/></c:when>
</c:choose>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>소소한 스토리지 > ${title }</title>
<style type="text/css">
#wrap {
display:flex;
flex-direction:column;
height:100%;
}
</style>
<link rel="icon" type="image/x-icon" href="imgs/hanul.ico">
<link rel="stylesheet" type="text/css" href="css/common.css?v=<%=new java.util.Date().getTime()%>">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- 생년월일 옆에 ICON 생성을 위한 라이브러리 -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"></script>

<!--  js 파일의 common.js을 가져오기-->
<script type="text/javascript" src="js/common.js"></script>

</head>
<body>
	<div id="wrap">
		<tiles:insertAttribute name="header" />
		<div id="content">
			<tiles:insertAttribute name="content" />
		</div>
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>