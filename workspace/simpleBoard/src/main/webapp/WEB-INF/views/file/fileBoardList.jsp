<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file ="../includes/header.jsp" %>
<body>
    <div class="container mt-5">
        <h2>File List</h2>
        <div class="row" >
            <c:forEach items="${ fArr }" var="file">
                <div class="card col-4 mt-3" style="width:400px;">
                    <img class="card-img-top" src="/resources/images/${file.fileImage}" alt="${file.fileImage}">
                    <div class="card-body">
                        <h4 class="card-title">${file.title}</h4>
                        <p class="card-text">${file.writer}</p>
                        <p class="card-text">${file.content}</p>
                        <a href="#" class="btn btn-primary">상세보기</a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>
