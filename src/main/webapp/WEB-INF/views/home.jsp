<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
   <title>Home</title>
   <script src="js/home.js"></script>
   <style type="text/css">
/* Animation Canvas */
.animation_canvas {
	overflow: hidden;
	position: relative;
	width: 1000px;
	height: 600px;
	/* 	width: 600px; */
	/* 	height: 400px; */
	margin: 0 auto;
	margin-top: 50px;
}

/* Slider Panel */
.slider_panel {
	/* 	width: 3000px; */
	/* 	width: 5000px; */
	height: 3600px;
	position: relative;
}

.slider_image {
	/* 	float: left;
	display: block;
	/* 	width: 600px; */
	/* 	height: 400px; */
	width: 1000px;
	height: 600px;
}

/* Slider Text Panel */
.slider_text_panel {
	position: absolute;
	/* 	top: 300px; */
	/* 	left: 50px; */
	top: 450px;
	left: 50px;
}

.slider_text {
	position: absolute;
	width: 300px;
	height: 150px;
	color: #ff006e;
	font-weight: bold;
	/* 	color: #292929; */
}

/* Control Panel */
.control_panel {
	position: absolute;
	/* 	top: 380px; */
	/* 	left: 270px; */
	top: 450px;
	right: 3px;
	width: 13px;
	/* 	height: 13px; */
	overflow: hidden;
}
.control_button {
	width: 46px;
	height: 12px;
	/* 	width: 12px; */
	/* 	height: 46px; */
	position: relative;
	cursor: pointer;
	margin: 5px 0px;
	/* 	display : block; */
	background-image: url("../images/point_button_r.png");
}
.control_button:hover {
	left: -16px; 
}
.control_button.active {
	left: -31px;
}
</style>
   
</head>
<body>
  <!-- <div class="main_img">
  	<img alt="메인" src="imgs/web_mainimg.png">
    <img src="imgs/web_main.png" alt="메인">
    <div class="main_font">
      <h1>ADD SPACE<br> FOR YOUR LIFE</h1>
      <a class="book" href="list.rv">예약하기</a>
    </div>
  </div> -->
<!--   <div>
  	<a href="list.rv"> <img alt="예약" src="imgs/res_img.png"> </a>
  </div> -->
     <section id="main">
     <div class="animation_canvas">
		<div class="slider_panel">
			<img  src="imgs/web_mainimg.png" class="slider_image" title="사람살려" />
			<img src="imgs/image01.png" class="slider_image" title="storage_img1" /> 
			<img src="imgs/image02.png" class="slider_image" title="storage_img2" /> 
			<img src="imgs/image03.png" class="slider_image" title="storage_img3" /> 
		</div>
		<!-- <div class="slider_text_panel">
			<div class="slider_text">
				<h2>소소한 스토리지 이벤트 1</h2>
				<p>서비스 이용료 30% 할인</p>
			</div>
			<div class="slider_text">
				<h2>소소한 스토리지 이벤트 2</h2>
				<p>박스 소 이용시 1+1</p>
			</div>
			<div class="slider_text">
				<h2>소소한 스토리지 이벤트 3</h2>
				<p>서비스 추천시 20% 할인 쿠폰 증정</p>
			</div>
		</div> -->
		<div class="control_panel">
			<!-- control_button과 같은 요소는 div태그로 만들고 
			스타일시트에서 background속성으로 이미지를 설정 
			이렇게 하면 스타일시트의 hover필터와 active필터 사용 가능-->
			<div class="control_button"></div>
			<div class="control_button"></div>
			<div class="control_button"></div>
		</div>
	</div>
	<div>
			<img alt="advantage" src="imgs/ad_img.png">
	</div>
	<div>
		<img src="imgs/mainpageguide.png" title="main_info" />
	</div>
    		
         <div id="business-bg">
            <div class="business-wrap">
               <article>
                  <h3><img alt="select" src="imgs/sf_img.png"> </h3>
                  <ul class="biz-type">
                     <li> 
                
                        <figure>
                           <img src="imgs/busimg1.jpg" alt="cabinetModel" onclick="alert('로그인 후 이용 가능합니다')"/>
                           <figcaption>캐비닛 모델</figcaption>
                        </figure>
                     
                   </li>
                     <li>
                      
                        <figure>
                                 <img src="imgs/busimg2.jpg" alt="convention" onclick="alert('로그인 후 이용 가능합니다')"/>
                                 <figcaption>박스 모델</figcaption>
                        </figure>
                      
                     </li>
                     <li>
                      
                        <figure>
                           <img src="imgs/busimg3.png" alt="promotion" onclick="alert('로그인 후 이용 가능합니다')"/>
                           <figcaption>배송서비스</figcaption>
                        </figure>
                     
                    </li>
                  </ul>
               
               </article>
            </div>         	
         </div>
   </section>
   <section id="main">
      <h2 class="hide">본문</h2>
      <article>
      <h3><img alt="금지 주의사항" src="imgs/ca_img.png"> </h3>
         <div id="features">
            <ul>
               <li><img src= "imgs/danger_fire.png" alt="휴대성"></li>
               <li><img src= "imgs/danger_temperature.png" alt="휴대성"></li>
               <li><img src= "imgs/danger_skull.png" alt="휴대성"></li>
            </ul>
         </div>
         <div>
         	<img alt="금지품목안내" src="imgs/caution.png">
         </div>
      </article>
   </section>
   
</body>
</html>