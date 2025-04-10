<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>admin</title>
  </head>
  <body>
    <h1>Admin</h1>
    <p>Principal: <sec:authentication property="principal"/></p>
    <p>Member: <sec:authentication property="principal.memberDTO"/></p>
    <p>사용자 이름: <sec:authentication property="principal.memberDTO.username"/></p>
    <p>사용자 ID: <sec:authentication property="principal.memberDTO.userid"/></p>
    <p>사용자 ID(username): <sec:authentication property="principal.username"/></p>
    <p>권한: <sec:authentication property="principal.memberDTO.authList"/></p>
  </body>
</html>