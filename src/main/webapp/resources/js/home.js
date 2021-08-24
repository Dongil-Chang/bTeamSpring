$(document).ready(function() {
	/* 함수를 먼저 선언해야 후위에서 사용가능 */
	
	var timer = null;							// 변수 초기화
	var refreshInterVal = null;
	var imgCnt = $(".slider_panel").children().length;   // 슬라이드 이미지 개수 확인 및 개수를 imgCnt 변수에 할당
	var imgIdx = 0;								// 선택한 index 값을 기억하는 변수(imgIdx)
	

	function moveSlider(index) {
		/*var willMoveLeft = -(1000 * index); // 위쪽으로 옮길 위치값 계산*/
 		var willMoveTop = -(600 * index); // 위쪽으로 옮길 위치값 계산
		$(".slider_panel").animate({
		// 3600px 패널을 위쪽으로 애니메이션으로 움직이게 하는 부분
			top : willMoveTop // 세미콜론 없음
		},"slow"); //animate
		
		$(".control_button[data-index =" + index + "]").addClass("active");
		// 버튼 클릭시 버튼 이미지를 위로 올리는 효과
		$(".control_button[data-index !=" + index + "]").removeClass("active");
		// 버튼 클릭되지 않은 버튼 이미지는 올리지 않도록 클래스 제거
		
		$(".slider_text[data-index =" + index + "]").show("fast").animate({
			left : 0
		}, "slow");//show, animate
		// 버튼 클릭시 텍스트를 보여주는 효과
		$(".slider_text[data-index !=" + index + "]").hide("fast").animate({
			left : -350
		}, "slow");//show, animate
		// 버튼 클릭되지 않은 텍스트는 보여주지 않도록 함.
		
/* // 		자동 슬라이드시 위 주석에선 빨라지는 현상이 있어 아래와 같이 기술함
		$(".slider_text[data-index =" + index + "]").show("fast", function() {
			$(this).css("left", 0);
		});	
		
		$(".slider_text[data-index !=" + index + "]").show("fast", function() {
			$(this).css("left", -300);
		}); */
		
		
	} // moveSlider
	

// 	timer 함수 정의
		timer = function() {
		moveSlider(imgIdx); // 선택한 index 값부터 moveSlider 함수를 호출
//	ex) imgIdx = 4 → (4 < (4-1))
		if (imgIdx < (imgCnt - 1)) {
			imgIdx++;			
		} else {
 			imgIdx = 0; // index 값을 0으로 초기화
//			imgIdx--; // index 값을 0으로 초기화
		}
	} 
	

	
	
	
	// 마우스를 이미지에 올렸을 때 멈추고 빠지면 재생
	// mouseenter 
	$(".animation_canvas").on({
		"mouseenter" : function() {
			clearInterval(refreshInterVal);	
		},
		"mouseleave" : function() {
			refreshInterVal = setInterval(timer, 3000);
		}
	});
	
	
	// 초기 버튼 위치 지정 및 data-index
	// control_panel : height 13px;
	$(".control_button ").each(function(index) {
		$(this).attr("data-index",index);
	}).click(function() { // 클릭시 이미지와 텍스트 가져오기
		var index = $(this).attr("data-index")
		imgIdx = index;  // 내가 임의로 클릭한 컨트롤 버튼의 index값을 할당
		moveSlider(index); // 슬라이더 및 텍스트 움직이게 하는 함수
	}); // each, click

	
	// 초기 텍스트 위치 지정 및 data-index
	// slider_text : 250px * 150px
	$(".slider_text").css("left", -350).each(function(index) {
		$(this).attr("data-index",index);
	}); // each

	
	// 초기 슬라이드 이미지의 텍스트와 컨트롤 버튼 표시를 위하여 아래 2가지 선언
	// 초기 0번째 슬라이더 텍스트 가져오기
	$(".slider_text[data-index=" + 0 + "]").show("fast").animate({
		left : 0 // 컴마, 세미콜론 없음
	},"slow");
	
	// 초기 0번째 컨트롤 버튼 가져오기
	$(".control_button[data-index=" + 0 + "]").addClass("active");
	
	// 3초마다 움직이는 timer 함수 호출
	refreshInterVal = setInterval(timer, 3000);
	
	
/* ============= 팝업 동작부 ================*/	
	
	let openBtn = document.querySelector("#openPop");
	let closeBtn = document.querySelector("#closePop");
	openBtn.onclick = function(){
	let popup = document.getElementById("popup");
	popup.style.display = "block";
	}
	closeBtn.onclick = function(){
	let popup = document.getElementById("popup");
	popup.style.display = "none";
	}
	
	
});