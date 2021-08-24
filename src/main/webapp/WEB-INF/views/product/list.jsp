<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>상품목록</h3>
<form action="list.pd" method="post">
<input type="hidden" name="curPage" value="1" />
<div id = 'list-top'>
	<div>
		<ul>
			<li>
				<select name='search' class='w-px90'>
					<option value="all"  ${page.search eq 'all' ? 'selected' : '' }>전체</option>
					<option value="product_id" ${page.search eq 'product_id' ? 'selected' : '' }>상품형태</option>
					<option value="product_type" ${page.search eq 'product_type' ? 'selected' : '' }>상품사이즈</option>
				</select>
			</li>
			<li><input type="text" name='keyword' value='${page.keyword }' class='w-px300' /></li>
			<li><a class='btn-fill' onclick='$("form").submit()'>검색</a></li>
		</ul>
	
		<ul>
			<!-- 관리자로 로그인된 경우만 글쓰기 가능 -->
			<!-- 로그인 시 정보를 담고 있는 session.setAttribute("loginInfo", vo)을 통해 admin 값을 가져와 비교함. -->			
			<c:if test="${loginInfo.subcode eq '3'}">
				<li><a class='btn-fill' href='new.pd'>상품등록</a></li>
			</c:if>
		</ul>
	</div>
</div>
</form>

<table class='tb_list'>
	<thead>
		<tr>
			<th class='w-px120'>번호</th>
			<th>상품구분</th>
			<th>상품사이즈</th>
			<th class='w-px120'>상품코드</th>
			<th class='w-px120'>서비스이용료</th>
			<th class='w-px120'>상품예약여부</th>
			<th class='w-px120'>기타</th>
		</tr>
	</thead>
	<tbody>	
		<c:if test="${empty page.list }">
			<tr>
				<td colspan='7'>상품 정보가 없습니다.</td>
			</tr>
		</c:if>
		<c:forEach items = '${page.list }' var='vo'>
			<tr>
				<td>${vo.no }</td>
				<td>
					<c:choose>	
						<c:when test="${vo.product_id eq 'C'}">캐피닛(C)</c:when>
						<c:when test="${vo.product_id eq 'B'}">박스(B)</c:when>
					</c:choose>
				</td>
				<td>
					<c:choose>	
						<c:when test="${vo.product_type eq 'G'}">대(G)</c:when>
						<c:when test="${vo.product_type eq 'M'}">중(M)</c:when>
						<c:when test="${vo.product_type eq 'S'}">소(S)</c:when>
					</c:choose>
				</td>
				<td>
					<a href='detail.pd?product_code=${vo.product_code}'>${vo.product_code }</a>
					</td>
				<td>${vo.product_cost }</td>
				<td>${vo.product_using }</td>
				<td></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<div class='btnSet'>
<jsp:include page="/WEB-INF/views/include/page.jsp" />
</div>
</body>
</html>