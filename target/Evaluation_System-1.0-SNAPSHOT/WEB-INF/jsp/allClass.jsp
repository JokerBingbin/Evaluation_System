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
    <title>所有班级</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>班级列表</small>
                </h1>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 column">
                <a href="${pageContext.request.contextPath}/Class/toAddClass">添加班级</a>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>班级编号</th>
                    <th>班级名称</th>
                    <th>班级科目</th>
                    <th>班级年级</th>
                    <th>老师</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="classlist" items="${classlist}">
                    <tr>
                        <td>${classlist.id}</td>
                        <td><a href=${pageContext.request.contextPath}/Class/ClassInfo?id=${classlist.id}>${classlist.name}</a></td>
                        <td>${classlist.subject}</td>
                        <td>${classlist.grade}</td>
                        <td>${classlist.teachername}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/Class/toUpdateClass?classId=${classlist.id}">修改</a>
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
