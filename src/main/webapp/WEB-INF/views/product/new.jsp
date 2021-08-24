<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src='js/file_check.js'></script>	<!-- 태그보다 위 쪽에 선언된 경우   -->
</head>
<body>
	<h3>상품 등록</h3>
	<form action="insert.pd" method="post">
	<input type="hidden" name='id' value="${loginInfo.id }" />	
		<table>
			<tr>
				<th class='w-px120'>상품구분</th>
				<td>
					<input type="radio" id="product_id" name="product_id" value='C' checked >캐비닛
					<input type="radio" id="product_id" name="product_id" value='B' >박스
				</td>
			</tr>
			<tr>
				<th>상품형태</th>
				<td>
					<input type="radio" id="product_type" name="product_type" value='G' checked >대
					<input type="radio" id="product_type" name="product_type" value='M' >중
					<input type="radio" id="product_type" name="product_type" value='S' >소
				</td>
			</tr>
			<tr>
				<th>입고수량</th>
				<td>
					<input type="number" name='su' title="수량" min="0" />
				</td>
			</tr>
			<tr>
				<th>서비스 금액</th>
				<td>
					<input type="number" name='product_cost' class='right' title="단가" min="0" />
<!-- 					<input type="text" name='product_cost' id="price"  class='right' onkeyup="inputNumberFormat(this)" title="단가" min="0" /> -->
				</td>
			</tr>
		</table>
	</form>
	<div class='btnSet'>
		<a class='btn-fill' onclick= "if ( emptyCheck() ) $('form').submit()">저장하기</a>
		<a class='btn-empty' href='list.pd'>취소</a>
	</div>
 <script type="text/javascript" src='js/file_check.js'></script>
<!--  
 <script type="text/javascript">
	 function inputNumberFormat(obj) {
	     obj.value = comma(uncomma(obj.value));
	 }
	 function comma(str) {
	     str = String(str);
	     return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
	 }
	 function uncomma(str) {
	     str = String(str);
	     return str.replace(/[^\d]+/g, '');
	 }
 </script> -->

</body>
</html>