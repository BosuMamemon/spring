<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>
		
		<div class="container mt-5">
			<h2>BoardView</h2>
			<input type="hidden" name="bnum" id="bnum" value="${ board.num }">
			<table class="table table-hover">
				<tr>
					<th>글 번호</th>
					<td>${ board.num }</td>
					<th>조회수</th>
					<td>${ board.hitCount }</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${ board.writer }</td>
					<th>작성일</th>
					<td>${ board.regdate }</td>
				</tr>
				<tr>
					<th>글 제목</th>
					<td colspan="3">${ board.title }</td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="3">${ board.content }</td>
				</tr>
			</table>
			<button type="button" class="btn btn-primary" onclick="location.href='/board/update/${board.num}'">수정</button>
			<button type="button" class="btn btn-secondary" id="btnDelete">삭제</button>
		</div>
		<br>
		<div class="container mt-3">
			<div class="mt-3"><strong>Comments(<span id="cntSpan"></span>)</strong></div>
			<div id="result"></div>
			<textarea class="form-control" id="content" name="content" placeholder="Comment goes here."></textarea>
			<button class="btn btn-success btn-sm" id="btnComment">댓글 작성</button>
		</div>
	</body>

	<script>
		let init = function() {
			$.ajax({
				type: "get",
				url: "/reply/list/${board.num}"
			}).done(function(resp) {
				let str = "";
				$.each(resp.cList, function(key, val) {
					str += val.userid + " / ";
					str += val.content + " / ";
					str += val.regdate + " ";
					// str += "<a href='javascript:fdel("+ val.cnum + ")'>삭제</a><br>"
					str += "<button type='button' id='btnDel' data-cnum=" + val.cnum + ">삭제</button><br>";
				});
				$("#result").html(str);
				$("#cntSpan").html(resp.count);
			}).fail(function(e) {
				alert("실패: " + e);
			})
		}

		function fdel(cnum) {
			$.ajax({
				type: "delete",
				url: "/reply/delete/" + cnum,
			}).done(function(resp) {
				alert(resp + "번 댓글 삭제 성공");
				init();
			}).fail(function(e) {
				alert("삭제 실패: " + e);
				init();
			})
		}

		let delfun = function() {
			$.ajax({
				type: "delete",
				url: "/reply/delete/" + $(this).data("cnum")
			}).done(function(resp) {
				alert(resp + "번 댓글 삭제 성공");
				init();
			}).fail(function(e) {
				alert("삭제 실패: " + e);
				init();
			})
		}

		$("#result").on("click", "#btnDel", delfun)

		$("#btnDelete").click(function() {
			if(!confirm("정말 삭제할까요?")) {
				return false;
			}

			$.ajax({
					type: "DELETE",
					url: "/board/delete/${board.num}", // REST 방식(패러미터가 아니라 주소창 경로에 값을 집어넣는 것)
					success: function(resp) {
						alert("삭제에 성공했습니다.");
						location.href = "/board/list";
					},
					error: function(e) {
						alert("삭제에 실패했습니다.");
					}
			})
		})

		$("#btnComment").click(function() {
			if($("#comment").val()=="") {
				alert("댓글 내용을 입력하세요.");
				return false;
			}

			let dataVal = {
				"bnum": $("#bnum").val(),
				"content": $("#content").val()
			}

			$.ajax({
				type: "post",
				url: "/reply/insert",
				contentType: "application/json;charset=utf-8",
				data: JSON.stringify(dataVal),
				success: function(resp) {
					alert("댓글을 달았습니다.");
					init();
					$("#content").val("");
				},
				error: function(e) {
					alert("오류가 발생했습니다.");
				}
			})
		})

		init();
	</script>
</html>