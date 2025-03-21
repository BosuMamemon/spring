<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Insert</title>
    </head>
    <body>
       <h2>개인 정보 입력</h2>
        <form method="POST" action="pInsert">
            이름       : <input type="text" name="name"><br>
            아이디      : <input type="text" name="id"><br>
            패스워드    : <input type="password" name="password"><br>
            성별       :
            <label for="man">남</label>
            <input type="radio" name="gender" id="man" value="남" checked>
            <label for="woman">여</label>
            <input type="radio" name="gender" id="woman" value="여"><br>
            직업       :
            <select name="job">
                <option value="회사원">회사원</option>
                <option value="학생">학생</option>
                <option value="기타">기타</option>
            </select><br><br>
            <button type="submit">확인</button>
            <button type="reset">취소</button>
        </form>
    </body>
</html>