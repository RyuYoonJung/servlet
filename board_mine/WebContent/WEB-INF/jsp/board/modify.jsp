<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kor">
<head>
	<jsp:include page="../common/head.jsp"/>  
		<style>
		.text {text-align: center;}
		.text input {width: 906px; padding: 10px;}
		.text textarea {width: 908px; resize: none; padding: 10px;}
		.text hr {width: 950px; margin: 25px; border: 1px solid rgb(245, 184, 164, 0.4);}
		.text textarea {height: 400px;}
		.button-write {width: 960px;}
	</style>
</head>
<body>
	<div class="my-container">
		<jsp:include page="../common/nav.jsp"/>
			<div>
				<h2>공지사항</h2><h4>[회원 권한 페이지] 공지관련 글을 남겨주세요.</h4>
			</div>
			<form method="post">
			<div class="text">
				<hr>
				${board.bno} ${board.title} ${board.content}
				<input type="hidden" name="bno" value="${board.bno}">
				<input type="text" class="input" id="title" name="title" value="${board.title}">
				<hr>
				<input type="text" class="input" id="content" name="content" value="${board.content}">
				<hr>
				<div class="button-write text-center">
					<div>
						<button>수정</button>
						<a href="${cp}board/list"><button type="button">목록으로</button></a>
					</div>
				</div>
			</div>
			</form>
		<jsp:include page="../common/footer.jsp"/> 
	</div>
</body>
</html>