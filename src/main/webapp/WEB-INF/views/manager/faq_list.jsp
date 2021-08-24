<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>FAQ 목록</h3>
	<div id='list-top'>
		<form method="post" action="faq_list.ma">
			<input type="hidden" name="curPage" value="1" />
			<input type="hidden" name='id' />	<!-- detail 에 보내질 id -->
			<div>
				<ul>
					<li><select name='search' class='w-px90'>
							<option value="all" ${page.search eq 'all' ? 'selected' : '' }>전체</option>
							<option value="title" ${page.search eq 'faq_title' ? 'selected' : '' }>제목</option>
							<option value="content" ${page.search eq 'faq_content' ? 'selected' : '' }>내용</option>
					</select></li>
					<li><input type="text" name='keyword' value='${page.keyword }' class='w-px300' /></li>
					<li><a class='btn-fill' onclick='$("form").submit()'>검색</a></li>
				</ul>

				<ul>
					<li><a class='btn-fill' href='faq_new.ma'>글쓰기</a></li>
				</ul>
			</div>
		</form>
	</div>
	<table>
		<thead>
			<tr>
				<th class='w-px120'>번호</th>
				<th>제목</th>
				<th class='w-px180'>작성일자</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty page.list }">
				<tr>
					<td colspan='3'>FAQ 정보가 없습니다.</td>
				</tr>
			</c:if>
			<c:forEach items="${page.list}" var="vo">
				<tr>
					<td>${vo.no }</td>
					<td class='left'><a onclick='go_detail(${vo.faq_code})'>${vo.faq_title }</a></td>
					<td>${vo.faq_regist_date }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

<div class='btnSet'>
	<jsp:include page="/WEB-INF/views/include/page.jsp" />
</div>
	
</body>
<script type="text/javascript">
	function go_detail(faq_code){
		$('[name = id]').val( faq_code );
		$('form').attr('action', 'faq_detail.ma');
		$('form').submit();
	}
</script>
</html>