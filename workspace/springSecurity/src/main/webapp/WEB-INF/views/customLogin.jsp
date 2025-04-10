<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Login</title>
  </head>
  <body>
    <form action="/login" method="post">
      id: <input type="text" name="username" id="username" placeholder="Enter ID"><br>
      pw: <input type="password" name="password" id="password" placeholder="Enter Password"><br>
      <button type="submit">로그인</button>
    </form>
  </body>
</html>