<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8"> 
		<title>View</title>
	</head>
	
	<body>
		<h2>상세보기</h2>
		<form action="/address/aUpdate" method="post">
			<table border=1>
				<tr>
					<th>번호</th>
					<td><input type="text" name="num" value="${ address.num }" readonly="readonly" ></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" value="${ address.name }"></td>
				</tr>
				<tr>
					<th>우편번호</th>
					<td>
						<input type="text" name="zipcode" value="${ address.zipcode }" size=15 id="zipcode">
					</td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" name="addr" value="${ address.addr }" size=40 id="address"></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="text" name="tel" value="${ address.tel }"></td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="submit">수정</button>
						<button type="reset">초기화</button>
						<button type="button" onclick="location.href = '/address/aDelete?num=${address.num}'">삭제</button>
						<button type="button" onclick="location.href = '/address/aList'">전체 보기</button>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>