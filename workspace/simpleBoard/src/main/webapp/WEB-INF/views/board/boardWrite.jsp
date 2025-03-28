<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../includes/header.jsp" %>
		<div class="container mt-5">
			<form action="insert" method="post" id="form" name="form">
				<h3>Board Write</h3>

				<div class="row mb-3">
					<div class="col">
						<label for="writer">Writer: </label>
						<input type="text" class="form-control" id="writer" name="writer" placeholder="Enter Writer">
					</div>
				</div>
				<div class="mb-3">
					<label for="title">Title: </label><br>
					<input type="text" class="form-control" id="title" name="title" placeholder="Enter Title">
				</div>
				<div class="mb-3">
					<label for="content">Content:</label>
					<textarea class="form-control" id="content" name="content" placeholder="Content goes here." rows=5></textarea>
				</div>
				<div class="mt-3">
					<button type="submit" class="btn btn-primary" id="btnSend">SUBMIT</button>
				</div>
			</form>
		</div>
	</body>
</html>