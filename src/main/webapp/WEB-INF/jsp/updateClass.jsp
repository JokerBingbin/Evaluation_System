<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/24
  Time: 1:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改班级信息</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>更新书籍</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/Class/updateClass" method="post">
        <div class="form-group">
            <input type="hidden" name="id" value="${classInfo.id}">

            <label>班级名称:</label>
            <input type="text" name="name" value="${classInfo.name}" required>
            <label>班级科目:</label>
            <input type="text" name="subject" value="${classInfo.subject}" required>
            <label>年级:</label>
            <input type="text" name="grade" value="${classInfo.grade}" required>
            <label>老师:</label>
            <input type="text" name="teachername" value="${classInfo.teachername}" required>
        </div>

        <input type="submit" value="修改">

    </form>
</div>
</body>
</html>
