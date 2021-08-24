<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
/* .cn{ */
/* margin:0;padding:0 */
/* } */

/* .cn::after { */
/* 	clear : both; */
/* 	content : ''; */
/* 	display : block; */
/* } */

/* .cn_left { */
/* 	width : 35%; */
/* 	height : 650px; */
/* 	line-height : 650px; */
/* 	background : #05668d; */
/* 	float: left; */
/* 	font-size : 50pt; */
/* 	font-weight: 800; */
/* 	color : #fff; */
/* } */

/* .cn_right { */
/* 	width : 65%; */
/* 	height : 400px; */
/* 	background : #fff; */
/* 	float: right; */
/* }	 */
</style>
</head>
<body>
<!-- <h3>공지사항</h3> -->

<form action="list.no" method="post">
<input type="hidden" name="curPage" value="1" />
<div id = 'list-top'>
	<div>
		<ul>
			<li>
				<select name='search' class='w-px90'>
					<option value="all"  ${page.search eq 'all' ? 'selected' : '' }>전체</option>
					<option value="board_title" ${page.search eq 'board_title' ? 'selected' : '' }>제목</option>
					<option value="board_content" ${page.search eq 'board_content' ? 'selected' : '' }>내용</option>
					<option value="board_writer" ${page.search eq 'board_writer' ? 'selected' : '' }>작성자</option>
				</select>
			</li>
			<li><input type="text" name='keyword' value='${page.keyword }' class='w-px300' /></li>
			<li><a class='btn-fill' onclick='$("form").submit()'>검색</a></li>
		</ul>
	
		<ul>
			<!-- 관리자로 로그인된 경우만 글쓰기 가능 -->
			<!-- 로그인 시 정보를 담고 있는 session.setAttribute("loginInfo", vo)을 통해 admin 값을 가져와 비교함. -->			
			<c:if test="${loginInfo.subcode eq '3'}">
				<li><a class='btn-fill' href='new.no'>글쓰기</a></li>
			</c:if>
		</ul>
	</div>
</div>
</form>

<table class='tb_list'>
	<thead>
		<tr>
			<th class='w-px70'>번호</th>
			<th>제목</th>
			<th class='w-px100'>작성자</th>
			<th class='w-px100'>작성일자</th>	
			<th class='w-px80'>첨부파일</th>
		</tr>
	</thead>
	<tbody>	
		<c:if test="${empty page.list }">
			<tr>
				<td colspan='5'>공지사항 정보가 없습니다.</td>
			</tr>
		</c:if>
		<c:forEach items = '${page.list }' var='vo'>
			<tr>
				<td>${vo.no }</td>
				<td class='left'>
					<c:forEach begin="1" end ="${vo.indent }" var="i">
						${i eq vo.indent ? "<img src='imgs/re.gif' />" : "&nbsp;&nbsp;" } 
					</c:forEach>
					<a href='detail.no?id=${vo.board_num}'>${vo.board_title }</a>
					</td>
				<td>${vo.name }</td>
				<td>${vo.board_write_date }</td>
				<td>${empty vo.filename ? '' : '<img src="imgs/attach.png" class="file-img" />' }</td>				
			</tr>
		</c:forEach>
	</tbody>
</table>
<div class='btnSet'>
<jsp:include page="/WEB-INF/views/include/page.jsp" />
</div>
</body>
</html>