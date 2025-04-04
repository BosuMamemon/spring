<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file ="../includes/header.jsp" %>
<div class="container mt-3">
    <c:forEach items="${fileArr}" var="file">
        Saved File Name: ${file} <br>
    </c:forEach>
</div>
