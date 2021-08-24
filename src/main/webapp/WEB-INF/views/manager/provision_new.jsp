<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>이용약관 글</h3>
	<form action="provision_insert.ma" method="post" >
		<table>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name='provision_nm' class='chk' title='제목' />
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea name='provision_content' class='chk' title='내용'></textarea>
				</td>
			</tr>
		</table>
	</form>
	<div class='btnSet'>
		<a class='btn-fill' onclick= "if ( emptyCheck() ) $('form').submit()">저장하기</a>
		<a class='btn-empty' href='provision.ma'>취소</a>
	</div>
</body>
</html>