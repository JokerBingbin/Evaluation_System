<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/3
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>班级信息</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>学生列表</small>
                </h1>
            </div>

        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>学生编号</th>
                    <th>学生姓名</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="student" items="${student}">
                    <tr>
                        <td>${student.id}</td>
                        <td>${student.name}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>考试列表</small>
                </h1>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 column">
                <a href="${pageContext.request.contextPath}/Class/ToAddExam?classid=${classId}">添加考试</a>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>考试编号</th>
                    <th>考试名称</th>
                    <th>考试时间</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="exam" items="${exam}">
                    <tr>
                        <td>${exam.id}</td>
                        <td><a href="/Class/examInfo?id=${exam.id}">${exam.name}</a></td>
                        <td>${exam.time.toString()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>


</div>
</body>
</html>
