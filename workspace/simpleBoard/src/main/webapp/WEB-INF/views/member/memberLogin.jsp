<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../includes/header.jsp" %>
		<div class="container mt-5">
			<h2>로그인</h2>
			<div class="mb-3">
				<label for="id">ID: </label><br>
				<input type="text" class="form-control" id="id" name="id" placeholder="ID를 입력하세요.">
			</div>
			<div class="mb-3">
				<label for="password">Password: </label><br>
				<input type="password" class="form-control" id="password" name="password" placeholder="비밀번호를 입력하세요.">
			</div>
			<button type="button" class="btn btn-primary" id="btnLogin">로그인</button>
		</div>
	</body>

	<script>
		$("#btnLogin").click(function() {
			if($("#id").val() == "") {
				alert("아이디를 입력하세요.");
				$("#userID").focus();
				return false;
			}
			
			if($("#password").val() == "") {
				alert("비밀번호를 입력하세요.");
				$("#password").focus();
				return false;
			}
			
			$.ajax({
				type: "post",
				url: "/member/login",
				contentType: "application/json;charset=utf-8",
				data: JSON.stringify({"id": $("#id").val(), "password": $("#password").val()}),
			}).done(function(resp) {
				if(resp == "notExist") {
					alert("존재하지 않는 아이디입니다.");
					location.href = "/member/join";
				} else if(resp == "fail") {
					alert("비밀번호가 일치하지 않습니다.");
				} else if(resp == "done") {
					alert("로그인되었습니다.");
					location.href = "/board/list";
				}
			}).fail(function(e) {
				alert("로그인 오류");
			})
		})
	</script>
</html>