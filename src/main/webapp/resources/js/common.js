/**
 *  공통 스크립트 : 입력항목 확인
 */
 
 // 내용이 없을 경우 저장 불가 처리
 function emptyCheck() {
	var ok = true;
	$('.chk').each(function() {
		if( $(this).val() == '' ) { // 입력 값이 없다면
			alert($(this).attr('title') + '을 입력하세요!');
			$(this).focus();
			ok = false;
			return ok;
		}		
	});
	return ok;
	
}