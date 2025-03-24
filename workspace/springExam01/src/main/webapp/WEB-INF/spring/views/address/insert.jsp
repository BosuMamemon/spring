<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert</title>
	</head>
	
	<body>
		<form action="/address/aInsert" id="form" method="post">
			<table border=1>
				<tr>
					<th colspan="2">주소록 등록하기</th>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" id="name"></td>
				</tr>
				<tr>
					<td>우편번호</td>
					<td>
						<input type="text" name="zipcode" id="zipcode" size=5>
						<button type="button" id="zipcodeButton">검색</button>
					</td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="addr" id="address" size=50></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="tel" name="tel" id="tel"></td>
				</tr>
				<tr>
					<td colspan="2">
						<button id="submitButton">등록</button>
						<button type="reset" id="resetButton">취소</button>
					</td>
				</tr>
			</table>
			<br><hr><br>
			<div>
				<a href="/address/aList">전체보기</a>
			</div>
		</form>
	</body>
</html>