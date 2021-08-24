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
	<h3>1:1 문의 수정화면</h3>
	<form action="cu_update.qa" method="post">
	<input type='hidden' name='board_num' value="${vo.board_num }" />
		<table class='w-pct70'>
			<tr>
				<th class='w-px120'>문의종류</th>
				<td>
					<select name="type" class='w-px150 left'>
						<option value="customer" ${vo.type eq 'customer' ? 'selected' : '' } >고객정보</option>
						<option value="product" ${vo.type eq 'product' ? 'selected' : '' }>상품/상품평</option>
						<option value="booking" ${vo.type eq 'booking' ? 'selected' : '' }>예약관련</option>
						<option value="service" ${vo.type eq 'service' ? 'selected' : '' }>서비스/불편사항</option>
					</select>				
				</td>
				<th class='w-px120'>문의일</th>
				<td>${vo.board_write_date }</td>
				<th class='w-px120'>답변일</th>
				<td>${vo.board_edit_date }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="5" class='left'>
					<input name='board_title' title='제목' class='chk' value="${vo.board_title }"/>
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan='5' class='left'>
					<textarea name="board_content" title="내용" class='chk'>${fn:replace(vo.board_content, crlf, '<br>')}</textarea>
				</td>
			</tr>
		</table>
		<div class='btnSet'>
			<a class='btn-fill' onclick="if( emptyCheck() ) $('form').submit()">저장</a>
			<a class='btn-fill'
				onclick=" if(confirm('정말 삭제하시겠습니까?')) { href='cu_delete.qa?id=${vo.board_num}' } ">삭제</a>
			<a class='btn-fill' href='cu_list.qa'>목록</a>
		</div>
	</form>
</body>
</html>