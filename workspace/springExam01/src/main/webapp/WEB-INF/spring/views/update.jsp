<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 25. 3. 24.
  Time: 오전 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Update</title>
        <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
    </head>

    <body>
        <h2> 개인 정보 수정 </h2>
        <form action="pUpdate" method="post">
            이름 : <input type="text" name="name" value="${person.name}"}><br>
            아이디 : <input type="hidden" name="id" value="${person.id}">${person.id}<br>
            패스워드 : <input type="password" name="password" value="${person.password}"><br>
            성별 :
            <label for="man"> 남</label>
            <input type="radio" name="gender" id="man" value="남">
            여 <input type="radio" name="gender" value="여"><br>
            직업 :
            <select name="job" id="job">
                <option value="회사원">회사원</option>
                <option value="학생">학생</option>
                <option value="기타">기타</option>
            </select><br><br>
            <script>
                <%-- 제이쿼리 --%>
                <%--$("input:radio[value='${person.gender}']").prop('checked', true);--%>
                <%--$("#job option").each(function(){--%>
                <%--    if($(this).val()=="${person.job}") {--%>
                <%--        $(this).prop("selected", true);--%>
                <%--    }--%>
                <%--})--%>
            //     자바스크립트
                document.querySelector("input[value='${person.gender}']").setAttribute("checked", true);
                document.querySelector("#job").value = "${person.job}";
            </script>
            <input type="submit" value="수정">
            <input type="reset" value="취소">
        </form>
    </body>
</html>
