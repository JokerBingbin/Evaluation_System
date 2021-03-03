<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/3
  Time: 1:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎页面</title>
    <style>
        a{
            text-decoration: none;
            color: black;
            font-size: 18px;
        }
        h3{
            width:180px;
            height: 38px;
            margin: 100px auto;
            text-align: center;
            line-height: 38px;
            background: deepskyblue;
            border-radius: 5px;

        }
    </style>
</head>
<body>
<h3>
    <a href="${pageContext.request.contextPath}/Class/allClass">进入系统</a>
</h3>
</body>
</html>
