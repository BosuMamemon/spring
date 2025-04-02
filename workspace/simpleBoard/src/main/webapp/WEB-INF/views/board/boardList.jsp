<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../includes/header.jsp" %>
		
		<div class="container mt-5">
			<h2>Board List(${count})</h2>
			<div class="mt-5 mb-3">
				<button class="btn btn-secondary" id=btnWrite>글쓰기</button>
			</div>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${bArr}" var="board" varStatus="st">
						<tr>
							<td>${ board.num }</td>
							<td><a href="/board/view?num=${board.num}">${board.title}</a></td>
							<td><b>${ board.writer }</b></td>
							<td><fmt:formatDate value="${ board.regdate }" pattern="yyyy-MM-dd"/></td>
							<td>${ board.hitCount }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="d-flex justify-content-between mt-3">
				<form action="/board/list" class="d-inline-flex">
					<select class="form-select" id="field" name="field">
						<option value="title">제목</option>
						<option value="content">내용</option>
					</select>
					<input type="text" class="form-control" id="word" name="word">
					<button type="submit" class="btn btn-success btn-sm">SEARCH</button>
				</form>
			</div>
		</div>
	</body>
</html>