<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Insert title here</title>

<style>

.reser_form {

 margin: auto;

  width: 40%;

  height : 100%;

  padding: 10px;

	

}

.leftContent{

	 float:left; width:200px; height:100px; text-align: center;

 

}

.rightContent{

	text-align:center; float:right; width:300px; height:100px; 

 

}

#btnReser{

	float:right; width: 80px;

}

.

</style>

</head>

<body>

<h3>예약하기</h3>

<div class="reser_form">

	<div class="leftContent" ">

		<h3>STEP 1. 날짜 선택</h3>

			<ul>

				<li>시작일 <br><input type="date"  style="border: 2px solid #199e27;"></li>

				<li>종료일 <br><input type="date"  style="border: 2px solid #ff0000;"></li>

			</ul>

		<h3>STEP 2. 상품 선택</h3>

			<select class="w-px170">

				<option>상품 선택</option>

				<option>박스</option>

			</select>

		

		<h3>STEP 3. 사이즈 선택</h3>

			<select class="w-px170">

				<option>사이즈 선택</option>

				<option>S</option>

			</select>

		<h3>STEP 4. 품목 선택</h3>

			<select class="w-px170">

				<option>품목 선택</option>

			</select>

		

	</div>

	<div class="rightContent">

		<h3>STEP 5. 예약 내역 확인</h3>

		<table>

			<tr>

				<th>예약 시작일</th><td>2021-09-01</td>

			</tr>

			<tr>

				<th>예약 종료일</th><td>2021-09-28</td>

			</tr>

			<tr>

				<th>예약 상품명</th><td>박스</td>

			</tr>

			<tr>

				<th>상품사이즈</th><td>S</td>

			</tr>

			<tr>

				<th>예약 품목명</th><td>BS0011</td>

			</tr>

		</table>

	</div>

	<!-- <input type="button" value="예약 완료" id="btnReser"> -->

</div>

</body>

</html>