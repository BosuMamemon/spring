<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>
		
		<div class="container mt-5">
			<h2>BoardView</h2>
			<input type="hidden" name="bNum" id="bNum" value="${ board.num }">
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
			<button type="button" class="btn btn-primary" onclick="location.href='update?num=${board.num}'">수정</button>
			<button type="button" class="btn btn-secondary" id="btnDelete" onclick="location.href='delete?num=${board.num}'">삭제</button>
		</div>
		<br>
		<div class="container mt-3">
			<div class="mt-3"><strong>Comments(<span id="cntSpan"></span>)</strong></div>
			<div id="result"></div>
			<textarea class="form-control" id="comment" name="comment" placeholder="Comment goes here."></textarea>
			<button class="btn btn-success btn-sm" id="btnComment">댓글 작성</button>
		</div>
	</body>
</html>