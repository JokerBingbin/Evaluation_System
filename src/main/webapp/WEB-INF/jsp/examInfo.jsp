<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/9
  Time: 1:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>题目详情</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>题目列表</small>
                </h1>
            </div>

        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
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
                <c:forEach var="question" items="${question}">
                    <tr>
                        <td>${question.qustionid}</td>
                        <td>${question.score}</td>
                        <td>${question.point}</td>
                        <td>${question.difficulty}</td>
                        <td>${question.ability}</td>
                        <td>${question.scope}</td>
                        <td>${question.type}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
