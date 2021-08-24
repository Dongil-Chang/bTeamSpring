<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>FAQ 상세화면</h3>
	<form method="post" action="faq_list.ma">
		<input type="hidden" name="id" value ="${vo.faq_code }"/>
	</form>
	<table>
		<tr>
			<th class="w-px120">제목</th>
			<td class='left'>${vo.faq_title }</td>
			<th class='w-px120'>작성일자</th>
			<td class='w-px180'>${vo.faq_regist_date }</td>
		</tr>
		<tr>
			<th>내용</th>			
			<td colspan='3' class='left'>${fn:replace(vo.faq_content, crlf, '<br>')}</td>
		</tr>		
	</table>	
	<div class="btnSet">
		<a class="btn-fill" onclick='$("form").submit()'>목록으로</a>
		<a class='btn-fill' onclick="$('form').attr('action', 'faq_modify.ma'); $('form').submit()">수정</a>
		<a class='btn-fill' onclick="if( confirm ('정말로 삭제하시겠습니까?') ) { href='faq_delete.ma?id=${vo.faq_code}' }">삭제</a>
	</div>
</body>
</html>