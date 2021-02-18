<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/12
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>导入成绩</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <style>
        input::-webkit-outer-spin-button,
        input::-webkit-inner-spin-button {
            -webkit-appearance: none;
        }
        input[type="number"]{
            -moz-appearance: textfield;
        }
    </style>

</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>导入成绩</small>
                </h1>
            </div>
            <div>
                <p>
                     学生姓名: ${student.name}   班级:${classInfoname}   考试名称: ${exam.name}
                </p>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/Class/write" method="post">
        <div class="form-group">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>题号</th>
                    <th>满分</th>
                    <th>学生得分</th>
                </tr>
                </thead>
                <input type="hidden" name="temp" value="111">
                <tbody>
                <c:forEach var="question" items="${question}" varStatus="loop">
                    <tr>
                        <td>${question.qustionid}</td>
                        <td>${question.score}</td>
                        <input type="hidden" name="list[${loop.count-1}].examid" value="${exam.id} "  >
                        <input type="hidden" name="list[${loop.count-1}].studentid" value="${student.id}" >
                        <input type="hidden" name="list[${loop.count-1}].questionnum" value="${question.qustionid}" >
                        <td><input type="number" name="list[${loop.count-1}].score" oninput="if(value>${question.score})value=${question.score}"  required></td>
                        <input type="hidden" name="diff[${loop.count-1}]" value="${question.difficulty}">
                        <input type="hidden" name="ability[${loop.count-1}]" value="${question.ability}">
                        <input type="hidden" name="scope[${loop.count-1}]" value="${question.scope}">
                        <input type="hidden" name="type[${loop.count-1}]" value="${question.type}">
                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </div>
        <input type="submit" value="导入">
    </form>
</div>


</body>
</html>
