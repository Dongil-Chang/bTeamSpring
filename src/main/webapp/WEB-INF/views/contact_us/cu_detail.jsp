<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>1:1 문의 상세 화면</h3>
	<form method="post" action="cu_list.qa">
		<input type="hidden" name='curPage' value="1" />
		<input type="hidden" name='id' value="${vo.board_num }" />
		<input type="hidden" name='type' value="${vo.type }" />
	</form>
	
	<table class='w-pct70'>
		<tr>
			<th class='w-px80'>문의종류</th>
			<td>
				<c:choose>
					<c:when test="${vo.type eq 'customer'}">고객정보</c:when>
					<c:when test="${vo.type eq 'product'}">상품/상품평</c:when>
					<c:when test="${vo.type eq 'booking'}">예약관련</c:when>
					<c:when test="${vo.type eq 'service'}">서비스/불편사항</c:when>
				</c:choose>
			</td>
			<th class='w-px80'>문의일</th>
			<td>${vo.board_write_date }</td>
			<th class='w-px80'>답변일</th>
			<td>${vo.board_edit_date }</td>
		</tr>
		<tr>
			<th class='w-px80'>제목</th>
			<td colspan="5">${vo.board_title }</td>
		</tr>
		<tr>
			<th>내용</th>			
			<td colspan='5' class='left'>${fn:replace(vo.board_content, crlf, '<br>')}</td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td class='left' colspan='5'>${vo.filename }
				<c:if test="${not empty vo.filename }">	<!-- 첨부 파일이 없지 않으면 아이콘 표시  -->
					<a href='download.no?id=${vo.board_num }'><i class="font-img fas fa-download"></i></a>
				</c:if>
			</td>			
		</tr>
	</table>
	<div class='btnSet'>
		<!-- 글쓴이만 수정/삭제 권한을 가짐  -->		
		<c:if test="${loginInfo.id eq vo.board_writer }">
			<a class='btn-fill' onclick="$('form').attr('action', 'cu_modify.qa'); $('form').submit()">수정</a>
			<a class='btn-fill' onclick=" if(confirm('정말 삭제하시겠습니까?')) { href='cu_delete.qa?id=${vo.board_num}' } ">삭제</a>
		</c:if>
		<a class='btn-fill' href='cu_list.qa'>목록</a>
		
		<!-- 로그인되어 있는 경우 답글 쓰기 가능 -->
		<c:if test="${!empty loginInfo }">
			<a class='btn-fill' href='cu_reply.qa?id=${vo.board_num }'>답글쓰기</a>
		</c:if>
	</div>	

</body>
</html>