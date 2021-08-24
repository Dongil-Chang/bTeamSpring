<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>1:1 문의 목록</h3>
	<form method="post" action="${uri}">
		<input type="hidden" name='curPage' value="1" />
		<input type="hidden" name='id' />		
		<div id='list-top'>
			<div>
				<ul>
					<li><select name='search' class='w-px90'>
							<option value="all" ${page.search eq 'all' ? 'selected' : '' }>전체</option>
							<option value="title" ${page.search eq 'title' ? 'selected' : '' }>제목</option>
							<option value="content"	${page.search eq 'content' ? 'selected' : '' }>내용</option>
							<c:if test="${loginInfo.subcode eq '3'}">
								<option value="writer" ${page.search eq 'writer' ? 'selected' : '' }>작성자</option>
							</c:if>
					</select></li>
					<li><input type="text" name='keyword' value='${page.keyword }'
						class='w-px300' /></li>
					<li><a class='btn-fill' onclick='$("form").submit()'>검색</a></li>
				</ul>

				<ul>
					<!-- 로그인되어 있는 경우 글쓰기 가능 -->
					<!-- 로그인 시 정보를 담고 있는 session.setAttribute("loginInfo", vo)을 통해 admin 값을 가져와 비교함. -->
					<c:if test="${not empty loginInfo}">
						<li><a class='btn-fill' href='cu_new.qa'>글쓰기</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</form>
	<table class='w-pct80'>
		<thead>
			<tr>
				<th>NO</th>
				<th>문의종류</th>
				<th>문의제목</th>
				<c:if test="${loginInfo.subcode eq '3'}">
					<th>작성자</th>
				</c:if>
				<th>문의일</th>
				<th>답변일</th>
				<th>첨부파일</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty page.list }">
				<tr>
					<td colspan='6'>문의 내역이 존재하지 않습니다.</td>
				</tr>
			</c:if>
			<c:forEach items="${page.list }" var="vo">
				<tr>
					<td>${vo.no }</td>
					<td>
						<c:choose>	
							<c:when test="${vo.type eq 'customer'}">고객정보</c:when>
							<c:when test="${vo.type eq 'product'}">상품/상품평</c:when>
							<c:when test="${vo.type eq 'booking'}">예약관련</c:when>
							<c:when test="${vo.type eq 'service'}">서비스/불편사항</c:when>
						</c:choose>
					</td>
					
					<td class='left'>
						<c:forEach begin="1" end ="${vo.indent }" var="i">
							${i eq vo.indent ? "<img src='imgs/re.gif' />" : "&nbsp;&nbsp;" } 
						</c:forEach>
						<a onclick='go_detail(${vo.board_num})'>${vo.board_title }</a></td>
					<c:if test="${loginInfo.subcode eq '3'}">
						<td>${vo.name }</td>
					</c:if>								
					<td>${vo.board_write_date }</td>
					<td>${vo.board_edit_date }</td>
					<td>${empty vo.filename ? '' : '<img src="imgs/attach.png" class="file-img" />' }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class='btnSet'>
		<jsp:include page="/WEB-INF/views/include/page.jsp" />
	</div>
<script type="text/javascript">
	function go_detail(board_num){
		$('[name = id]').val( board_num );
		$('form').attr('action', 'cu_detail.qa');
		$('form').submit();
	}
</script>
	
</body>
</html>