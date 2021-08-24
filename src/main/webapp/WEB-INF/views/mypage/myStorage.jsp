<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<h3>나의 창고</h3>
<body>
	
	<table class='w-pct50'>
		<tr class>
			<th class='w-px250'>온도</th>
			<th class='w-px250'>습도</th>
			<th>측정시간</th>
		</tr>
		<tr>
			<td>${vo.temperature }</td>
			<td>${vo.humidity }</td>
			<td>${vo.temhum_date }</td>
		</tr>
	</table>
	<br>
	<iframe src = "http://192.168.0.121:8000/index.html" width = "700" height = "600" ></iframe>

</body>
</html>