<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file ="../includes/header.jsp" %>
<div class="container mt-3">
    <form action="/file/fileBoardInsert" method="post" enctype="multipart/form-data">
        <h3>File Board Write</h3>
        <div class="mb-3 mt-3">
            <label for="title">Title: </label>
            <input type="text" class="form-control" placeholder="Title goes here." id="title" name="title">
        </div>
        <div class="mb-3 mt-3">
            <label for="writer">Writer: </label>
            <input type="text" class="form-control" placeholder="Writer goes here." id="writer" name="writer">
        </div>
        <div class="mb-3 mt-3">
            <label for="content">Content: </label>
            <textarea class="form-control" rows="5" placeholder="Content goes here." id="content" name="content"></textarea>
        </div>
        <div class="mb-3 mt-3">
            <label for="file">File: </label>
            <input type="file" class="form-control" id="file" name="upload">
        </div>
        <div class="mt-3">
            <button type="submit" class="btn btn-primary btn-sm" id="btnUpload">File Submit</button>
        </div>
    </form>
</div>
</body>