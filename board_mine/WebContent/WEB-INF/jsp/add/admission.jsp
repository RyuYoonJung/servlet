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
        .text hr {width: 950px; margin: 25px;
                    border: 1px solid rgb(245, 184, 164, 0.4);}
        .text textarea {height: 400px;}
        .button-write {width: 960px;}
    </style>
</head>
<body>
<div class="my-container">
		<jsp:include page="../common/nav.jsp"/>
        <div>
            <h2>상담신청</h2><h4>입학 상담 관련 문의 공간입니다.</h4>
        </div>
        <div class="text">
            <hr>
            <input type="text" class="input" placeholder="제목을 입력해주세요" id="id">
            <hr>
            <textarea placeholder="내용을 입력해주세요" cols="60" rows="5"></textarea>
            <hr>
            <div class="button-write text-center">
                <div>
                    <a href="notice.html">글쓰기</a>
                    <a href="notice.html">목록으로</a>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="../common/footer.jsp"/>
</body>
</html>