<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/8
  Time: 1:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加考试</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>添加考试</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/Class/addExam" method="post">
        <div class="form-group">
            <label>考试名称：</label>
            <input type="text" name="name" class="form-control" placeholder="请输入考试名称" required>

            <input type="hidden" name="classid" class="form-contol" value="${classId}">

            <label>考试时间：</label>
            <input type="date" name="time" class="form-control" id="examTime"  >


        </div>
        <div>
            <label>题目数量:</label>
            <input type="number" value="20" id="num" required>
        </div>
        <script>
            var num = document.getElementById("num").value;
            console.log(num);


        </script>
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>题号</th>
                    <th>分值</th>
                    <th>知识点</th>
                    <th>难易程度</th>
                    <th>核心能力</th>
                    <th>知识范围</th>
                    <th>题型</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="i" begin="1" end="29" step="1">
                    <tr>
                        <td>${i}</td>
                        <input type="hidden" name="examid" >
                        <input type="hidden" name="questionid" value="${i}">
                        <td><input type="number" name="score" required></td>
                        <td><input type="text" name="point" required></td>
                        <td><input type="text" name="difficulty" required></td>
                        <td><input type="text" name="ability" required></td>
                        <td><input type="text" name="scope" required></td>
                        <td><input type="text" name="type" required></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        <input type="submit" value="添加">


    </form>

</div>

</body>
</html>
