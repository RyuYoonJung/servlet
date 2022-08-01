<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kor">
<head>
	<jsp:include page="../common/head.jsp"/>  
	<style>
	.bannerh1 { text-align: center; margin-top: 150px;}
	.login {width: 300px; margin: auto; padding: 1px 64px 106px; background-color: rgb(245, 184, 164, 0.2);}
	.login h3 {margin-top: 30px;}
	.input {padding: 8px; width: 275px;}
	input#midNum {width: 30%;}
	input#lastNum {width: 30%;}
	#kindOfCat {width: 90%;}
	.button-joininput {padding: 8px; width: 273px;}
	#cat , #staticNum {padding: 8px;}
	#cat {width: 292px;}
	#id {width: 200px;}
	#duplication-check {padding: 7px 7px 6px; position: relative; top: 2px;}
	</style>
</head>
<body>
	<div class="my-container">
   
		<jsp:include page="../common/nav.jsp"/>
		<div class="main">
			<form method="post">
				<h3>회원 정보 입력</h3>
				<label for="id"><h3>아이디</h3></label>	
				<input type="text" name="id"/>
				<label for="pw"><h3>password</h3></label>
				<input type="password" name="pw"/>
				<label for="name"><h3>name</h3></label>
				<input type="text" class="input" id="name" name="name"/>
				<!-- <h3>고양이 종</h3>
				<div class="form-kind">
					<label class="kind" for="cat"></label>
					<select id="cat">
					<option label="스코티쉬폴드"></optgroup>
					<option label="아비시니안"></optgroup>
					<option label="터키시앙"></optgroup>
					<option label="아메리칸쇼트헤어"></optgroup>
					</select>    
				</div> -->
				<button class="btn" >가입하기</button>
			</form>
		</div>
	</div>
	<jsp:include page="../common/footer.jsp"/>
	<script>
		$(function(){
			var cp = '${pageContext.request.contextPath}';
			
			$("#btnId").click(function() {
				console.log("clicked");
				var id = {id : $("#id").val()}
				$.ajax(cp + "/member/findMember", {
					data : id,
					method : "get",
					success : function(data){
						console.log(data);
						$("#chkId").val(data);
					}
				})
			});
			
			$("#btnEmail").click(function() {
				console.log("clicked");
				var email = {email : $("#email").val()}
				$.ajax(cp + "/member/findMember", {
					data : email,
					method : "get",
					success : function(data){
						console.log(data);
						$("#chkEmail").val(data);
					}
				})
			});
			
			$("#email").change(function () {
				$("#chkEmail").val(1);
			});

			$("form").submit(function () {
				if($("#chkId").val()){
					alert("id 중복 체크")
					return false;
				}
				if($("#chkEmail").val()){
					alert("emalil 중복 체크")
					return false;
				}
			})
		})
	</script>
</body>
</html>