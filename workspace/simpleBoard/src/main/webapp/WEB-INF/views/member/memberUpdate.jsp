<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file ="../includes/header.jsp" %>
        <div class="container mt-3">
            <form action="join" method="post" id="form">
                <div class="row">
                    <div class="col mb-3">
                        <label for="id">id:</label>
                        <input type="text" class="form-control" id="id" placeholder="Enter Userid" name="id" value="${sessionMember.id}" readonly>
                    </div>
                    <div class="col mb-3 align-self-end">
                        <span id="idcheck"></span>
                    </div>
                </div>
                <div class="mb-3 mt-3">
                    <label for="name">Name:</label>
                    <input type="text" class="form-control" id="name" placeholder="Enter name" name="name" value="${sessionMember.name}">
                </div>
                <div class="mb-3">
                    <label for="password">Password:</label>
                    <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
                </div>

                <div class="mb-3">
                    <label for="pwdCheck">Password_Check:</label>
                    <input type="password" class="form-control" id="pwdCheck" placeholder="Check Password" name="pwdCheck">
                </div>
                <div class="mb-3">
                    <label for="address">Address:</label>
                    <input type="text" class="form-control" id="address" placeholder="Enter Address" name="address" value="${sessionMember.address}">
                </div>
                <div class="mt-3">
                    <button type="button" class="btn btn-primary" id="btnUpdate">수정</button>
                </div>
            </form>
        </div>
    </body>
    <script>
        $("#btnUpdate").click(function() {
            if($("#password").val() == "") {
                alert("비밀번호를 입력해주십시오.");
                $("#password").focus();
                return false;
            }
            if($("#password").val() != $("#pwdCheck").val()) {
                alert("비밀번호가 맞지 않습니다.");
                $("#pwdCheck").focus();
                return false;
            }

            const data = {
                "id": $("#id").val(),
                "name": $("#name").val(),
                "password": $("#password").val(),
                "address": $("#address").val()
            }

            $.ajax({
                type: "put",
                url: "/member/update",
                contentType: "application/json;charset=utf-8",
                data: JSON.stringify(data)
            }).done(function(resp) {
                alert("회원정보를 수정했습니다.");
                location.href = "/board/list";
            }).fail(function(e) {
                alert("회원정보 수정 실패: " + e);
            })
        })
    </script>
</html>
