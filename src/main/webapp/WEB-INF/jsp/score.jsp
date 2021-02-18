<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/12
  Time: 1:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>考试成绩</title>
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
                    <th>成绩</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="student" items="${student}" varStatus="loop" >
                    <tr>
                        <td>${student.id}</td>
                        <td>${student.name}</td>

                        <td>
                            <c:choose>
                                <c:when test="${score[loop.count-1].iswrite == 0}">
                                    <a href="/Class/writeScore?examId=${examId}&studentId=${student.id}">未导入</a>
                                </c:when>
                                <c:when test="${score[loop.count-1].iswrite == 1}">
                                    <a href="/Class/showScore?examId=${examId}&studentId=${student.id}">查看</a>
                                </c:when>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>


                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
