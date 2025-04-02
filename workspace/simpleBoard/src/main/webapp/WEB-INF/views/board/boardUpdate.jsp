<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../includes/header.jsp" %>
		<div class="container mt-5">
			<h3>Board Update</h3>
			<input type="hidden" id="num" name="num" value="${ board.num }">
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
				<button type="button" class="btn btn-primary" id="btnSend">수정</button>
			</div>
		</div>
	</body>

	<script>
		$("#btnSend").click(function() {
			dataVal = {
				"num": $("#num").val(),
				"title": $("#title").val(),
				"content": $("#content").val()
			};

			$.ajax({
				type: "put",
				url: "/board/update",
				contentType: "application/json;charset=utf-8",
				data: JSON.stringify(dataVal),
				success: function(resp) {
					alert("수정이 완료되었습니다.");
					location.href = "/board/list";
				},
				error: function(e) {
					alert("수정에 실패했습니다.");
					location.href = "/board/list";
				}
			})
		})
	</script>
</html>