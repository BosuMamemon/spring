<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file ="../includes/header.jsp" %>
        <div class="container mt-3">
            <form action="join" method="post" id="form">
                <div class="row">
                    <div class="col mb-3">
                        <label for="id">id:</label>
                        <input type="text" class="form-control" id="id" placeholder="Enter Userid" name="id">
                    </div>
                    <div class="col mb-3 align-self-end">
                        <span id="idcheck"></span>
                    </div>
                </div>
                <div class="mb-3 mt-3">
                    <label for="name">Name:</label>
                    <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
                </div>
                <div class="mb-3">
                    <label for="password">Password:</label>
                    <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
                </div>

                <div class="mb-3">
                    <label for="pwd_check">Password_Check:</label>
                    <input type="password" class="form-control" id="pwd_check" placeholder="Enter pwd_check" name="pwd_check">
                </div>
                <div class="mb-3">
                    <label for="address">Address:</label>
                    <input type="text" class="form-control" id="address" placeholder="Enter Address" name="address">
                </div>
                <div class="mt-3">
                    <button type="button" class="btn btn-primary" id="btnJoin">회원가입</button>
                </div>
            </form>
        </div>
    </body>
    <script>
        $("#btnJoin").click(function() {
            const data = {
                "id": $("#id").val(),
                "name": $("#name").val(),
                "password": $("#password").val(),
                "address": $("#address").val()
            }

            $.ajax({
                type: "post",
                url: "/member/join",
                contentType: "application/json;charset=utf-8",
                data: JSON.stringify(data)
            }).done(function(resp) {
                if(resp == "done") {
                    alert("회원가입에 성공했습니다.");
                    $("#idcheck").html("")
                    location.href = "/member/login";
                } else if(resp == "fail") {
                    $("#idcheck").html("<b>중복된 아이디입니다.</b>")
                    $("#id").val("");
                }
            }).fail(function(e) {
                alert("회원가입 실패: " + e);
            })
        })
    </script>
</html>
