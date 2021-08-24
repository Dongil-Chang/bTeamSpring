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
<h3>공지글 안내</h3>
	<table>
		<tr>
			<th class='w-px120'>제목</th>
			<td class='left' colspan='5'>${vo.board_title }</td>			
		</tr>	
		<tr>
			<th>작성자</th>
			<td>${vo.name }</td>
			<th class='w-px100'>작성일자</th>
			<td class='w-px100'>${vo.board_write_date }</td>			
			<th class='w-px80'>조회수</th>
			<td class='w-px80'>${vo.readcnt }</td>			
		</tr>	
		<tr>
			<th>내용</th>
			<td class='left' colspan='5'>${fn:replace(vo.board_content, crlf, '<br>') }</td>
			<!-- ${fn:replace(vo.board_content, crlf, '<br>') } 내용 중 엔터에 해당하는 부분을 <br> 태그로 치환  -->			
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
		<a class='btn-fill' 
		href='list.no?curPage=${page.curPage}&search=${page.search}&keyword=${page.keyword}'>목록으로</a>
		<!-- 목록 버튼 클릭시 현재 선택한 페이지 값과 검색 항목과 키워드를 가진 상태에서 리스트 화면으로 이동  -->
		
		<!-- 1. 관리자 로그인된 경우에만 수정, 삭제 버튼 표시
			 2. 로그인한 관리자가 쓴 글인 경우 -->
			 
		<c:if test="${vo.board_writer eq loginInfo.id }">	 		
			<a class='btn-fill' href='modify.no?id=${vo.board_num }'>수정</a>
			<a class='btn-fill' onclick=" if(confirm('정말 삭제?')) { href='delete.no?id=${vo.board_num}' } ">삭제</a>
		</c:if>
		<!-- 로그인되어 있는 경우 답글 쓰기 가능 -->
		<c:if test="${!empty loginInfo }">
			<a class='btn-fill' href='reply.no?id=${vo.board_num }'>답글쓰기</a>
		</c:if>
	</div>	
</body>
</html>