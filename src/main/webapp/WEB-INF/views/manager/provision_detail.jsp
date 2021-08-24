<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>이용약관 안내</h3>
	<table>
		<tr>
			<th class='w-px80'>제목</th>
			<td>${vo.provision_nm }</td>
		</tr>
		<tr>
			<th>내용</th>			
			<td colspan='2' class='left'>${fn:replace(vo.provision_content, crlf, '<br>')}</td>
		</tr>
	</table>
	<div class='btnSet'>
		<a class='btn-fill' href='provision_modify.ma?id=${vo.provision_code }'>수정</a>
		<a class='btn-fill' onclick=" if(confirm('정말 삭제하시겠습니까?')) { href='provision_delete.ma?id=${vo.provision_code}' } ">삭제</a>
	</div>	
</body>
</html>