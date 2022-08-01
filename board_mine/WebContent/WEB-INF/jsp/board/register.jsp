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
			<form method="post" enctype="multipart/form-data">
			<div class="text">
				<hr>
				<input type="text" class="input" placeholder="제목을 입력해주세요" id="title" name="title">
				<input type="hidden" name="writer" value="${member.id}">
				<hr>
				<textarea placeholder="내용을 입력해주세요" cols="60" rows="5" name="content"></textarea>
				<hr> 
				<div class="button-write text-center">
					<label for="file" class="form-label"></label>
					<input type="file" class="form-control" id="file" name="file" multiple accept=".gif, .jpg, .png">
				 	<input type="hidden" name="amount" value="${cri.amount}">
				    <input type="hidden" name="category" value="${cri.category}">
				    <input type="hidden" name="pageNum" value="${cri.pageNum}">
				</div>
				<div>
					<button>글등록</button>
					<a href="${cp}board/list"><button type="button">목록으로</button></a>
				</div>
			</div>
			</form>
		<jsp:include page="../common/footer.jsp"/> 
	</div>
</body>
</html>