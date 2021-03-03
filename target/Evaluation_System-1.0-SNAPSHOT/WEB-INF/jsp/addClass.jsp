<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/18
  Time: 0:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加班级</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>添加班级</small>
                </h1>
            </div>
        </div>
    </div>


    <form action="${pageContext.request.contextPath}/Class/addClass" method="post">
        <div class="form-group">
            <label>班级名称：</label>
            <input type="text" name="name" class="form-control" placeholder="请输入考试名称" required>
            <label>科目：</label>
            <input type="text" name="subject" class="form-control" placeholder="请输入科目" required>
            <label>年级：</label>
            <input type="text" name="grade" class="form-control" placeholder="请输入年级" required>
            <label>老师：</label>
            <input type="text" name="teachername" class="form-control" placeholder="请输入老师名字" required>
        <input type="submit" value="添加">
        </div>

    </form>

</div>
</body>
</html>
