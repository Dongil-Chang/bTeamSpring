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
	<h3>이용약관 수정화면</h3>
	<form method="post" action="provision_update.ma">
	<input type="hidden" name="provision_code" value="${vo.provision_code}" />
		<table>
			<tr>
				<th class='w-px80'>제목</th>
				<td>
					<input type="text" name="provision_nm" value="${vo.provision_nm }" class='chk' title='제목' />
				</td>
			</tr>
			<tr>
				<th>내용</th>			
				<td colspan='2' class='left'>
					<textarea name="provision_content" title='내용' class='chk'>${fn:replace(vo.provision_content, crlf, '<br>')}</textarea>
				</td>
			</tr>
		</table>
	</form>
	<div class='btnSet'>
		<a class='btn-fill' onclick='$("form").submit()'>수정</a>
		<a class='btn-empty' href='provision_detail.ma?id=${vo.provision_code}'>취소</a>
	</div>	
</body>
</html>