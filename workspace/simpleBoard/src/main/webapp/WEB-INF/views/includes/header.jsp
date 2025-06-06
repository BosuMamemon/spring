<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
		<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
		<title>Board</title>
	</head>
	
	<body>
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			<div class="container-fluid">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item">
						<a class="nav-link" href="#">HOME</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/board/insert">Board Insert</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/board/list">Board List</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/file/uploadFile">파일 업로드</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/file/fileBoardInsert">File Board Insert</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/file/fileBoardList">File Board List</a>
					</li>
				</ul>
				<c:choose>
					<c:when test="${empty sessionScope.sessionMember}">
						<ul class="navbar-nav">
							<li class="nav-item">
								<a class="nav-link" href="/member/login">로그인</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="/member/join">회원가입</a>
							</li>
						</ul>
					</c:when>
					<c:otherwise>
						<ul class="navbar-nav">
							<li class="nav-item">
								<a class="nav-link" href="#" id="btnLogout">로그아웃(${sessionMember.name})</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="/member/update">회원정보 수정</a>
							</li>
						</ul>
					</c:otherwise>
				</c:choose>
			</div>
		</nav>
	<script>
		$("#btnLogout").click(function() {
			$.ajax({
				type: "get",
				url: "/member/logout",
			}).done(function(resp) {
				alert("로그아웃되었습니다.");
				location.href = "/member/login";
			}).fail(function(e) {
				alert("로그아웃 오류");
			})
		})
	</script>