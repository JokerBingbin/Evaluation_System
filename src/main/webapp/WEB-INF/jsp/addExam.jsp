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


            <%--将考试时间表格默认值设置为当天日期--%>
            <script>
                $(document).ready(function (){
                    var time = new Date();
                    var day = ("0" + time.getDate()).slice(-2);
                    var month = ("0" + (time.getMonth()) + 1).slice(-2);
                    var today = time.getFullYear() + "-" + (month) + "-" + (day);
                    $('#examTime').val(today);
                })
            </script>
        </div>


        <input type="submit" value="添加">


    </form>

</div>

</body>
</html>
