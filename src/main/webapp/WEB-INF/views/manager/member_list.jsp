<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원 목록</h3>
	<div id='list-top'>
		<form action="list.hr" method="post">
		<input type="hidden" name="curPage" value="1" />
			<div>
				<ul>
					<li>
						<select name='search' class='w-px90'>
							<option value="all"  ${page.search eq 'all' ? 'selected' : '' }>전체</option>
							<option value="title" ${page.search eq 'title' ? 'selected' : '' }>제목</option>
							<option value="content" ${page.search eq 'content' ? 'selected' : '' }>내용</option>
							<option value="writer" ${page.search eq 'writer' ? 'selected' : '' }>작성자</option>
						</select>
					</li>
					<li><input type="text" name='keyword' value='${page.keyword }' class='w-px300' /></li>
					<li><a class='btn-fill' onclick='$("form").submit()'>검색</a></li>
				</ul>
			</div>	
		</form>
	</div>
	<table>
		<thead>
			<tr class='w-px120'>
				<th>아이디</th>
				<th>성명</th>
				<th>이메일</th>
				<th>연락처</th>
				<th>네이버_포털로그인</th>
				<th>예약여부</th>
				<th>멤버유형</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.list }" var="vo">
				<tr>
					<td>${vo.id }</td>
					<td>${vo.name }</td>
					<%-- <td><a href='detail.hr?id=${vo.employee_id}'>${vo.last_name }
							${vo.first_name }</a></td> --%>
					<td>${vo.email }</td>
					<td>${vo.tel }</td>
					<td>${vo.social_type }</td>
					<td>${vo.booking }</td>
					<td>
						<c:choose>	
							<c:when test="${vo.subcode eq '1'}">사용자</c:when>
							<c:when test="${vo.subcode eq '2'}">사업자</c:when>
							<c:when test="${vo.subcode eq '3'}">관리자</c:when>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class='btnSet'>
		<jsp:include page="/WEB-INF/views/include/page.jsp" />
	</div>
</body>
</html>