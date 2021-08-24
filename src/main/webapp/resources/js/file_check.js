/**
 *	첨부 파일 관련 처리 함수 
 */
 
 // $(function() {
 
 	$(document).on('change','#attach-file', function() { // 첨부 파일 선택시
	// $('#attach-file').on('change', function() {
		var attached = this.files[0];	
		if ( attached ) { // 첨부된 파일이 있을 경우
			$('#file-name').text(attached.name);
			$('#delete-file').css('display', 'inline');
			
			// 이미지 파일인 경우 미리보기에 보여지게 처리
			if ($('#preview').length > 0 ) {	// id=preview 가 있으면
				if(isImage(attached.name)) {	// 이미지 파일이면 미리보기 처리하고
					$('#preview').html(' <img src="" id="preview-img" /> ');
					
					var reader = new FileReader();
					reader.onload = function(e) {	// 파일 읽기 처리
						$('#preview-img').attr('src', e.target.result);
					}
					reader.readAsDataURL( attached );
				} else 
					$('#preview').html(''); // 이미지 파일이 아니면 미리보기 처리하지 않음.
			}
					
		} else {
			$('#file-name').text('');
			$('#delete-file').css('display', 'none');
		}
		
	}).on ('click', '#delete-file',function() {		// 첨부 파일 삭제시
		if ($('#preview').length > 0) $('#preview').html('');	// id=preview 가 있으면
		$('#file-name').text('');
		$('#delete-file').css('display', 'none');
		
		$('#attach-file').val('');	// 파일 태그의 첨부된 파일 정보 없애기
	})
;

/* 이미지 파일 여부 확인 함수 */
function isImage(filename) {
	// abc.txt, abc.png, abc.jpg, abc.hwp, ....
	// 오른쪽에서부터 . 의 위치까지 문자열을 가져옴.
	var ext = filename.substring( filename.lastIndexOf('.')+1 ).toLowerCase();
	// 확장자 jpg, png, tiff, gif 등을 이미지 파일로 처리
	var imgs = ['png', 'jpg', 'gif', 'jpeg', 'bmp', 'pcx', 'tiff'];
	/* -1 보다 크면 이미지임... */
	if( imgs.indexOf(ext) > -1 ) return true;
	else return false; 
}


// });