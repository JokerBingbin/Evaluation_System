<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/16
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>添加学生</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/Class/addStudent" method="post">
        <div class="form-group">
            <label>学生姓名：</label>
            <input type="text" name="name" class="form-control" placeholder="请输入学生姓名" required>
            <input type="hidden" name="classid" class="form-contol" value="${classId}">
        </div>


        <input type="submit" value="添加">


    </form>
</div>
</body>
</html>
