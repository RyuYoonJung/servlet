<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<jsp:include page="../common/head.jsp"/>  
	<style>
		.gallery > div {background-color: rgb(245, 184, 164, 0.3); margin: 5px 0; padding: 10px 100px;}
		.gallery > div::after {clear: both; display: block; content: '';}
		.gallery > div > div {float: left; margin: 10px 40px 10px 0;}
		.gallery img {width: 150px; height: 150px; float: left;}
		.gallery img + p {border-radius: 20px; text-align: center; width: 150px; padding: 43px 25px; margin: 0 5px; float: left; background-color: white;} 
		.gallery h3 {text-align: center; font-weight: lighter;}
		#mini-tab {border: 1px solid rgb(245, 184, 164, 0.7); background: rgb(245, 184, 164, 0.3); display: inline-block; padding: 10px;}
		.admission {border: 1px solid rgb(245, 184, 164, 0.7);}
		.admission h2 {border: 1px solid rgb(245, 184, 164, 0.7); border-radius: 10px; width: 900px; padding: 30px; margin: 20px 15px;}
		.admission #b {text-align: right; margin: 10px 50px 50px; }
		.admission div {text-align: center;}
		.ad img {width: 200px; height: 200px; float: unset; margin: 10px;}
		.main p {font-size: 17px; text-align: center; font-weight: bold;}
		#a {width: 500px;}
	</style>
</head>
<body>
	<div class="my-container">
		<jsp:include page="../common/nav.jsp"/>
			<div class="main">
				<div class="ad">
					<div class="event">
						<p style="margin:15px;">이달의 행사</p><img src="images/test.png">
					</div>
					<div class="classimg"> 
						<p style="margin:15px;">유치원 내부 둘러보기</p><img src="images/innerbg.jpg">
					</div> 
					<div class="map">
						<p style="margin:15px;">오시는 길</p><img src="images/maplogo.png">
					</div>
				</div>
				<div class="gallery">
					<h3 class="p-4" style="font-family:sans-serif; font-weight:bold; font-size: x-large;">국내 최고 수준의 훈련사와 함께하는 고양이 유치원 [kinder kitten]</h3>
					<div>
						<h3>kinder kitten 갤러리</h3>
						<div class="p">
							<div class="a1">
								<img src="images/cat1.jpg" alt="크림이"> 
								<p>오전반 / 크림이 <br>3살 <br> 스코티쉬폴드</p>
							</div>
							<div class="a2">
								<img src="images/cat2.jpg" alt="레오">
								<p>오후반 / 레오 <br> 3살 <br> 아비시니안</p>
							</div>
							<div class="a3">
								<img src="images/cat3.jpg" alt="앵두">
								<p>오후반 / 앵두 <br> 2살 <br> 아메리칸 쇼트헤어</p>
							</div>
							<div class="a4">
								<img src="images/cat4.jpg" alt="솜이">
								<p>종일반 / 솜이<br> 4살 <br> 터키시앙</p>
							</div>
						</div>
					</div>
				</div>
				<form action="admission">
					<button id="mini-tab" >입학상담신청</button>
					<div class="admission">
						<div>
							<h2 class="half">오후반 입학 상담 신청하기</h2>
							<h2 class="day">종일반 입학 상담 신청하기</h2>
						</div>
						<p id="a">🐈 킨더키튼  상담센터  02-3667-3688</p>
						<p id="b">🐈 상담 가능시간    09:00 ~ 18:00 <br>  
							점심시간 12:00 ~ 13:00  <br>
							토요일, 일요일, 공휴일 휴무</p>
					</div>
				</form>
			</div>
		<jsp:include page="../common/footer.jsp"/>
	</div>
</body>
</html>