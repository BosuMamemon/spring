<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file ="../includes/header.jsp" %>
<div class="container mt-3">
    <form action="/file/uploadFile" method="post" enctype="multipart/form-data">
        <h3>파일 업로드</h3>
        <div class="mb-3 mt-3">
            <label for="file1">File 1: </label>
            <input type="file" class="form-control" id="file1" name="uploads">
        </div>
        <div class="mb-3 mt-3">
            <label for="file2">File 2: </label>
            <input type="file" class="form-control" id="file2" name="uploads">
        </div>
        <div class="mb-3 mt-3">
            <label for="file3">File 3: </label>
            <input type="file" class="form-control" id="file3" name="uploads">
        </div>
        <div class="mt-3">
            <button type="submit" class="btn btn-primary" id="btnUpload">File Submit</button>
        </div>
    </form>
</div>
</body>