<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<jsp:include page="../common/head.jsp"/>  
	<style>
	.bannerh1 { text-align: center; margin-top: 150px;}
	.login {width: 300px; margin: auto; padding: 1px 64px 106px; background-color: rgb(245, 184, 164, 0.2);}
	.login h3 {margin-top: 30px;}
	.login > div {text-align: center; margin: 40px;}
	.input {padding: 8px; width: 90%;}
	input#midNum {width: 30%;}
	input#lastNum {width: 30%;}
	#kindOfCat {width: 90%;}
	.button-joininput {padding: 8px; width: 20%;}
	</style>
</head>
<body>
	<div class="my-container">
		<jsp:include page="../common/nav.jsp"/>
		<div class="main">
			<div class="login">
				<form method="post">
					<label for="id"><h3>아이디</h3></label>
					<input type="text" class="input" placeholder="아이디를 입력해주세요" id="id" name="id"/>
					<label for="pw"><h3>password</h3></label>
					<input type="password" class="input" placeholder="비밀번호를 입력해주세요" id="pw" name="pw"/>
					<div>
						<input class="form-check-input" id="inputRememberId" type="checkbox" value="" />
						<label class="form-check-label" for="inputRememberId">ID 저장</label>
						<input class="form-check-input" id="inputRememberPassword" type="checkbox" value="" />
						<label class="form-check-label" for="inputRememberPassword">PW 저장</label>
					</div>
					<div class="button-write text-center">
						<button class="btn" >로그인</button>
					</div>
				</form>
			</div>
		</div>
		<jsp:include page="../common/footer.jsp"/>
	</div>
</body>
</html>