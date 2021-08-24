<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
   <title>Home</title>
</head>
<body>
  <div class="main_img">
    <img src="imgs/web_main.png" alt="메인">
    <div class="main_font">
      <h1>ADD SPACE<br> FOR YOUR LIFE</h1>
      <a class="book" href="list.rv">예약하기</a>
    </div>
  </div>
     <section id="main">
         <div id="business-bg">
            <div class="business-wrap">
               <article>
                  <h3>select * from storage </h3>
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
                           <img src="imgs/busimg3.jpg" alt="promotion" onclick="alert('로그인 후 이용 가능합니다')"/>
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
      <h3 class="hide">원마일 브랜드, 특징</h3>
         <div id="features">
         <h4>보관 <span class= "point-color">금지금지</span></h4>
            <ul>
               <li><img src= "imgs/danger_fire.png" alt="휴대성"></li>
               <li><img src= "imgs/danger_temperature.png" alt="휴대성"></li>
               <li><img src= "imgs/danger_attention.png" alt="휴대성"></li>
            </ul>
         </div>
      </article>
   </section>
   <div id="btnTop">
      <a href="#">
         <img src="imgs/btn_top.png" alt="맨 위로">
      </a>
   </div>
</body>
</html>