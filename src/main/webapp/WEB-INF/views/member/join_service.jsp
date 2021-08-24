<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id='service_body' class='w-pct50 center' >
		<div class='service_title' style="margin-top: 10px;">
			<h3>${vo.provision_nm }</h3>
		</div>
		<div class='service_content' style="margin-top: 5px;">
			<div>
				<textarea class='p_textarea'>${vo.provision_content }</textarea>
			</div>
		</div>
	</div>	
</body>
</html>