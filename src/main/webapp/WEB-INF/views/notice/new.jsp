<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src='js/file_check.js'></script>	<!-- 태그보다 위 쪽에 선언된 경우   -->
<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<!-- include summernote css/js-->
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.js"></script>
<!-- include summernote-ko-KR -->
<script src="js/summernote-ko-KR.js"></script>

<script>
$(document).ready(function() {
	  $('#summernote').summernote({
 	    	/* placeholder: 'content', */
	        minHeight: 370,
	        maxHeight: null,
	        fontNames : [ '맑은고딕', 'Arial', 'Arial Black', 'Comic Sans MS', 'Courier New', ],
 	    	fontNamesIgnoreCheck : [ '맑은고딕' ],
	        focus: true, 
	        lang : 'ko-KR',
	        callbacks : { 
	        	onImageUpload : function(files){
	        		for (var i = files.length - 1; i >= 0; i--) {
	        			sendFile(files[i]);
		           	}
	    			/* sendFile(files[0]); */
	    		}
        	}
	  });
});
function sendFile(file){
	var data = new FormData();	
	data.append("file",file);
	$.ajax({
		url: "uploadSummernoteImageFile", //////여기 본인 주소! 
		type: "POST",
		enctype: 'multipart/form-data',
		data: data,
		cache: false,
		contentType : false,
		processData : false,
		success: function(image){
			console.log( image.url );
			var url = "<c:url value='"+image.url+"' />" 
			$('#summernote').summernote('insertImage',url);
		},
		error: function(e){console.log(e);}  
	});	
}
</script>
</head>
<body>
	<h3>신규 공지글</h3>
	<!-- 파일 첨부하여 submit 하는 경우
		1. method 는 post 로 지정
		2. form 에는 반드시 enctype='multipart/form-data' 지정
	 -->
	<form action="insert.no" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<th class='w-px120'>제목</th>
				<td>
					<input type='text' name='board_title' class='chk' title='제목' />
				</td>			
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea id="summernote" name="board_content" class='chk' title='내용'></textarea>
				</td>			
			</tr>
			<tr>
				<th>첨부파일</th>
				<td class='left'>
					<label>
					<a><img src="imgs/select.png" class='file-img' /></a>
					<input type="file" id='attach-file' name='file' />
					</label>
					<span id='file-name'></span>
					<a id='delete-file'><i class="font-img fas fa-minus-circle"></i></a>
				</td>
			</tr>
		</table>
	</form>
	<div class='btnSet'>
		<a class='btn-fill' onclick= "if ( emptyCheck() ) $('form').submit()">저장하기</a>
		<a class='btn-empty' href='list.no'>취소</a>
	</div>
</body>
</html>