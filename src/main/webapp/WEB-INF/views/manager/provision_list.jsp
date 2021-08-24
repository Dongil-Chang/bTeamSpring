<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>이용약관 목록</h3>
	<div id='list-top'>
		<form method="post" action="list.bo">
			<input type="hidden" name='id' />	<!-- detail 에 보내질 id -->
			<div>
				<ul>
					<li><a class='btn-fill' href='provision_new.ma'>글쓰기</a></li>
				</ul>
			</div>
		</form>
	</div>
	<table class='tb_list'>
		<thead>
			<tr>
				<th class='w-px120'>약관코드</th>
				<th>약관명</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty provision }">
				<tr>
					<td colspan='2'>이용약관 정보가 없습니다.</td>
				</tr>
			</c:if>
			<c:forEach items="${provision}" var="vo">
				<tr>
					<td>${vo.provision_code }</td>
					<td class='left'><a onclick='go_detail(${vo.provision_code})'>${vo.provision_nm }</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script type="text/javascript">
	function go_detail(provision_code){
		$('[name = id]').val( provision_code );
		$('form').attr('action', 'provision_detail.ma');
		$('form').submit();
	}
	</script>

</body>
</html>