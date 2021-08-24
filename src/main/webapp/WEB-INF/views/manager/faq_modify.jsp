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
	<h3>FAQ 수정</h3>
	<form action="faq_update.ma" method="post">
		<input type="hidden" name='faq_code' value="${vo.faq_code }" />
		<table>
			<tr>
				<th class="w-px120">제목</th>
				<td class='left'>
					<input type="text" name='faq_title' class='chk' title='제목' value='${vo.faq_title }'/>
				</td>
			</tr>
			<tr>
				<th>내용</th>			
				<td colspan='2' class='left'>
					<textarea name="faq_content" class="chk" title='내용' >${fn:replace(vo.faq_content, crlf, '<br>')}</textarea>
				</td>
			</tr>		
		</table>	
	</form>
	<div class='btnSet'>
		<a class='btn-fill' onclick='$("form").submit()'>수정</a>
		<a class='btn-empty' onclick="history.go(-1)">취소</a> <!-- 이전 화면으로 이동 -->
	</div>
</body>
</html>