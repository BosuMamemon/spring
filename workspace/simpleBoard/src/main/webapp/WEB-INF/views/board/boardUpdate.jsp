<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../includes/header.jsp" %>
		<div class="container mt-5">
			<form action="update" method="post" id="form" name="form">
				<h3>Board Update</h3>
				<input type="hidden" name="num" value="${ board.num }">
				<div class="row mb-3">
					<div class="col">
						<label for="writer">Writer: </label>
						<input type="text" class="form-control" id="writer" name="writer" placeholder="Enter Writer" value="${ board.writer }" readonly>
					</div>
				</div>
				<div class="mb-3">
					<label for="title">Title: </label><br>
					<input type="text" class="form-control" id="title" name="title" placeholder="Enter Title" value="${ board.title }">
				</div>
				<div class="mb-3">
					<label for="content">Content:</label>
					<textarea class="form-control" id="content" name="content" placeholder="Content goes here." rows=5>${ board.content }</textarea>
				</div>
				<div class="mt-3">
					<button type="submit" class="btn btn-primary" id="btnSend">수정</button>				
				</div>
			</form>
		</div>
	</body>
</html>