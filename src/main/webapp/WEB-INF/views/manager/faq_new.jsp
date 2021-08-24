<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>FAQ 작성</h3>
	<form action="faq_insert.ma" method="post">
		<table>
			<tr>
				<th class='w-px120'>제목</th>
				<td class='left'>
					<input type="text" name="faq_title" class='chk' title='제목'/>
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea name="faq_content" class='chk' title="내용"></textarea>
				</td>
			</tr>
		</table>
	</form>
	
	<div class='btnSet'>
		<a class='btn-fill' onclick=" if( emptyCheck() ) $('form').submit() ">저장</a>
		<a class='btn-empty' href = 'faq_list.ma'>취소</a>
	</div>
	
</body>
</html>