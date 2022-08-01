<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<jsp:include page="../common/head.jsp"/>  
	<style>
		.text input {width: 435px;}
		.text-title {text-align: center; margin: 40px;}
		.text-title h3, p {margin: 0;}
		.head > h3 {margin: 10px 17px;}
		.content {text-align: center; width: 400px; margin: auto; padding: 150px 0;}
		.content > label {padding: 80px;}
		.content ul {list-style: none;}
		.content > input {padding: 10px;} 
		.text hr,.button-write text-center hr {width: 950px; margin: 25px; border: 2px solid lightgrey;}
		.text hr {width: 950px; margin: 25px; border: 1px solid rgb(245, 184, 164, 0.4);}
	</style>
</head>
<body>

	<div class="my-container">
		<jsp:include page="../common/nav.jsp"/>
		<div>
			<h2>자유게시판</h2><h4>고양이 관련 정보 공유 게시판 입니다.</h4>
		</div>
		<form method="post">
			<div class="text">
				<hr>
				<div class="text-title">${board.title}</div>
				<hr>
				<div class="text-content">${board.content}</div>
				<div class="button-write">
					<div class="mb-3">
					    <c:forEach items="${board.attachs}" var="attach">
					    <c:if test="${attach.image}">
						  <img class="mw-100" src="${cp}download${attach.params}" alt="${attach.origin}">
						 </c:if>
						</c:forEach>
					<hr>
					</div>
					<div>
						<div class="col-15" >
							<textarea class="w-100" id="replyContent" name="reply"></textarea>
						</div>
						<div class="text-end"  >
							<button class="btn btn-primary" id="btnReplyReg" type="button">댓글 등록</button>
						</div>
						<ul class="list-group list-group-flush my-3 small replies">
	
					    </ul>
						<div class="text-center">
							<%-- <a href="get?bno=${board.bno}"><button>수정</button></a> --%>
							<a href="modify?bno=${board.bno}&${page.cri.params}"><button type="button">수정</button></a>
							<a href="remove?bno=${board.bno}&${page.cri.params}"><button type="button">삭제</button></a>
							<a href="list${page.cri.params}&pageNum=${page.cri.pageNum}"><button type="button">목록으로</button></a>
						</div>
					</div>
				</div>	
			</div>	
		</form>
		<script src="${cp}js/reply.js"></script>
		<script>
		$(function() {
			const bno = '${board.bno}';
			const cp = '${cp}';
			var writer = '${member.id}' 
			showList();

			function showList() {
				replyService.list(bno, function(data) {
					console.log(data);
					var str = "";
					for(var i in data) {
						str+='				<li class="list-group-item" data-rno="' + data[i].rno +'">'
						str+='					<div class="list-group-item list-group-item-secondary small">'
						str+='						<span >' + data[i].writer +'</span>'
						str+='						<span class="small float-end mx-2"><a href="">삭제</a></span>'
						str+='						<span class="small float-end">' + data[i].regDate +'</span>'
						str+='					</div>'
						str+='					<div class="list-group-item">' + data[i].content +'</div>'
						str+='				</li>'
					}
					$(".replies").html(str);
				}, cp);
			}
			
			// 댓글 등록 버튼 클릭 이벤트
			$("#btnReplyReg").click(function() {
				var reply = {bno:bno, content:$("#replyContent").val(), writer:writer};
				console.log(reply)
				replyService.add(reply,function(data) {
					showList();
				}, cp);
			});
			
			$(".replies").on("click", "a", function(){
				event.preventDefault()
				console.log(this)
				console.log($(this).closest("li").data("rno"))
				var rno = $(this).closest("li").data("rno");
				var reply={rno:rno}
				replyService.remove(reply,function(data) {
					showList();
				}, cp);
			})
		})
		</script>
		<jsp:include page="../common/footer.jsp"/>
	</div>
</body>
</html>