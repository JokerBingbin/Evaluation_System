<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/20
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生考试列表</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>学生考试列表</small>
                </h1>
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
                <c:forEach var="exam" items="${exams}" varStatus="loop">
                    <tr>
                        <td>${loop.count}</td>
                        <td>${exam.name}</td>
                        <td>${exam.time}</td>
                        <td>
                            <c:choose>
                                <c:when test="${scoreWrite[loop.count-1].iswrite == 0}">
                                    <a href="/Class/writeScore?examId=${exam.id}&studentId=${scoreWrite[loop.count-1].studentid}">未导入</a>
                                </c:when>
                                <c:when test="${scoreWrite[loop.count-1].iswrite == 1}">
                                    <a href="/Class/showScore?examId=${exam.id}&studentId=${scoreWrite[loop.count-1].studentid}">查看</a>
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
