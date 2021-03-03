<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/18
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加题目信息</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>添加题目信息</small>
                </h1>
            </div>
        </div>
    </div>


    <form action="${pageContext.request.contextPath}/Class/addExamFinal" method="post">

        <input type="hidden" name="id" value="${exam.id}">
        <input type="hidden" name="name" value="${exam.name}">
        <input type="hidden" name="classid" value="${exam.classid}">
        <input type="hidden" name="time" value="${exam.time}">
        <table id="questionTable" class="table table-hover table-striped">
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
            <c:forEach var="i" begin="1" end="${number}" step="1" varStatus="loop">
                <tr>
                    <td>${i}</td>
                    <input type="hidden" name="list[${loop.count-1}].examid" value="${exam.id}">
                    <input type="hidden" name="list[${loop.count-1}].qustionid" value="${loop.count}">
                    <td><input type="number" name="list[${loop.count-1}].score" required></td>
                    <td>
                        <input type="text" name="list[${loop.count-1}].point" required>
                    </td>
                    <td>
                        <select id="diff_select">
                            <c:forEach var="diff" items="${questionDiffs}">
                                <option value="${diff.diff}">${diff.diff}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <input type="text" name="list[${loop.count-1}].difficulty" required>

                    <td>
                        <select id="ability_select">
                            <c:forEach var="ability" items="${questionAbilities}">
                                <option value="${ability.name}">${ability.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <input type="text" name="list[${loop.count-1}].ability" required>

                    <td>
                        <select id="scope_select">
                            <c:forEach var="scope" items="${questionScopes}">
                                <option value="${scope.name}">${scope.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <input type="text" name="list[${loop.count-1}].scope" required>

                    <td>
                        <select id="type_select">
                            <c:forEach var="type" items="${questionTypes}">
                                <option value="${type.qtype}">${type.qtype}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <input type="text" name="list[${loop.count-1}].type" required>
                    <td><img onclick="delRow(${i})" src="/WEB-INF/image/delete.jpg" style="width: 18px;height:18px;cursor:pointer"></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <p><button onclick="addTr()">增加一题</button></p>
        <script>
            function addTr(){
                var rows = document.getElementById("questionTable").rows.length;
                rows -= 1;
                var newTr = questionTable.insertRow();           //添加一行
                var td0 = newTr.insertCell();
                td0.innerHTML = rows+1;
                var td1 = newTr.insertCell();
                td1.innerHTML = '<input type="number" name="list['+rows+'].score" required>';
                var td2 = newTr.insertCell();
                td2.innerHTML = '<input type="text" name="list['+rows+'].point" required>';
                var td3 = newTr.insertCell();
                td3.innerHTML = '<input type="text" name="list['+rows+'].difficulty" required>';
                var td4 = newTr.insertCell();
                td4.innerHTML = '<input type="text" name="list['+rows+'].ability" required>';
                var td5 = newTr.insertCell();
                td5.innerHTML = '<input type="text" name="list['+rows+'].scope" required>';
                var td6 = newTr.insertCell();
                td6.innerHTML = '<input type="text" name="list['+rows+'].type" required>';
                var td7 = newTr.insertCell();
                td7.innerHTML = '<img onclick="delRow('+rows+')" src="/WEB-INF/image/delete.jpg" style="width: 18px;height:18px;cursor:pointer"> ';
            }

            function delRow(rowIndex){
                var tbobj = document.getElementById("questionTable");
                if(tbobj == -1){
                    if(tbobj.rows.length>1){
                        tbobj.deleteRow(tbobj.rows.length-1);
                    }
                }else{
                    tbobj.deleteRow(rowIndex);
                }
            }
        </script>
        <input type="submit" value="添加">
    </form>
</div>
</body>
</html>
