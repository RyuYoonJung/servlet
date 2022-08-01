<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<jsp:include page="../common/head.jsp"/>  
	<style>
		.gallery > div {background-color: rgb(245, 184, 164, 0.3); margin: 5px 0; padding: 10px 100px;}
		.gallery > div::after {clear: both; display: block; content: '';}
		.gallery > div > div {float: left; margin: 10px 40px 10px 0;}
		.gallery img {width: 150px; height: 150px; float: left;}
		.gallery img + p {border-radius: 20px; text-align: center; width: 150px; padding: 43px 25px; margin: 0 5px; float: left; background-color: white;} 
		.gallery h3 {text-align: center; font-weight: lighter;}
		.mini-tab {border: 1px solid rgb(245, 184, 164, 0.7); background: rgb(245, 184, 164, 0.3); display: inline-block; padding: 10px;}
		.admission {border: 1px solid rgb(245, 184, 164, 0.7);}
		.admission h2 {border: 1px solid rgb(245, 184, 164, 0.7); border-radius: 10px; width: 900px; padding: 30px; margin: 20px 15px;}
		.admission #b {text-align: right; margin: 10px 50px 50px; }
		.admission div {text-align: center;}
		.ad img {width: 200px; height: 200px; float: unset; margin: 10px;}
		.button-write text-center hr {width: 950px; margin: 25px; border: 2px solid lightgrey;}
		.event,.classimg,.map {margin: 0 45px; background: rgb(245, 184, 164, 0.3);}
		.main p {font-size: 17px; text-align: center; font-weight: bold;}
		#a {width: 500px;}
		.pagination {text-align: center; margin-bottom: 50px}
		.pagination li {list-style-type: none; display:inline; margin-left: 20px}
	</style>
</head>
<body>

	<div class="my-container">
		<jsp:include page="../common/nav.jsp"/>
		<div class="board">
			<h2>공지사항</h2>
				${boards}

			<div class="col-2">
               <select class="form-select form-amount">
				  <option ${page.cri.amount == 5 ? 'selected' : '' } value="5">5개씩 보기</option>
				  <option ${page.cri.amount == 10 ? 'selected' : '' } value="10">10개씩 보기</option>
				  <option ${page.cri.amount == 25 ? 'selected' : '' } value="25">25개씩 보기</option>
				  <option ${page.cri.amount == 50 ? 'selected' : '' } value="50">50개씩 보기</option>
			   </select>
			</div>
			<div class="card-body">
				<div class="gallery-list row p-5">
					<c:forEach items="${boards}" var="board">
						<div class="col-4 card p-3 border-0"> 
							<a href="get${page.cri.params2}&bno=${board.bno}" >
							<div class="border p-1">
								<img onerror="this.src='${cp}images/noimage.png'" class="card-img-top" src="${cp}display?uuid=s_${board.attachs[0].uuid}&path=${board.attachs[0].path}" alt="${board.attachs[0].origin}">
								<div class="card-body">
									<h4 class="card-title small text-truncate">${board.title}</h4>
									<p class="card-text small text-truncate">
										<span>${board.writer}</span>
										<span class="small float-end">${board.regDate}</span>
									</p>
								</div>
							</div>
							</a>
						</div>
					</c:forEach>
				</div>				
			</div>
			<div class="button-write text-center">
				<a href="${cp}board/register${page.cri.params}"><button class="btn" >글쓰기</button></a>
			</div>
			<div class="">
				<ul class="pagination">
				<c:if test="${page.prev}">
                	<li class="page-item"><a class="page-link" href="list${page.cri.params}&pageNum=${page.cri.pageNum-1}">prev</a></li>
                </c:if>
				<c:forEach begin="${page.start}" end="${page.end}" var="p">
					<li class="page-item ${p == page.cri.pageNum ? 'active' : '' }">
						<a class="page-link" href="list${page.cri.params}&pageNum=${p}">${p}</a>
					</li>
				</c:forEach>
				<c:if test="${page.next}">
                	<li class="page-item"><a class="page-link" href="list${page.cri.params}&pageNum=${page.cri.pageNum+1}">next</a></li>
                </c:if>
				</ul>
			</div>
		</div>
		<jsp:include page="../common/footer.jsp"/>
		<script>
        $(function() {
	        $(".form-amount").change(function() {
	        	location.href = 'list?amount=' + $(this).val() + "&category=${page.cri.category}&pageNum=${page.cri.pageNum}"; 
	        });
        });
        </script>
	</div>
</body>
</html>