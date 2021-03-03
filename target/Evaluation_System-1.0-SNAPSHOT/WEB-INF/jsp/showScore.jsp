<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/12
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测评结果</title>
    <script src="https://cdn.staticfile.org/echarts/4.3.0/echarts.min.js"></script>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <style>
        #total,main{
            display: inline;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1 align="center">
                    <b>评测结果</b>
                </h1>
            </div>
            <div>
                <h3 align="center">
                    <b>姓名：<u>&ensp;${student.name}&ensp;</u></b>&emsp;
                    <b>年级：<u>&ensp;${classinfo.grade}&ensp;</u></b>&emsp;
                    <b>考试：<u>&ensp;${exam.name}&ensp;</u></b>&emsp;
                    <b>科目：<u>&ensp;${classinfo.subject}&ensp;</u></b>&emsp;
                    <b>成绩：<u>&ensp;${sum}&ensp;</u></b>
                </h3>
            </div>
        </div>
        <div class="col-md-12 column">
            <div class="page-header">
                <h2>
                    <b>1.成绩整体情况</b>
                </h2>
            </div>
            <%--echart的Dom--%>

            <div style="width: 0px;display: table">
                <div id="total" style="width: 500px;height:400px;display:table-cell;" ></div>
                <script type="text/javascript">
                    var totalChart = echarts.init(document.getElementById("total"));

                    var option = {
                        title:{

                        },
                        series: [{
                            type : "pie",
                            radius: ['48%','60%'],
                            roseType: 'angle',
                            avoidLabelOverlap: false,
                            label: {
                                normal:{
                                    show:true,
                                    position:'center',
                                    color: '#4c4a4a',
                                    formatter:'{sum|'+'${sum}'+'}',
                                    rich:{
                                        sum:{
                                            fontSize: 35,
                                            fontFamily:"微软雅黑",
                                            color:'#454c5c'
                                        }
                                    }
                                },
                                emphasis: {
                                    show: true
                                }
                            },
                            labelLine: {
                                normal: {
                                    show: false
                                },
                                emphasis: {
                                    show: true
                                },
                                tooltip: {
                                    show: false
                                }
                            },
                            data:[
                                {
                                    value:${sum},
                                    name:'得分',
                                    itemStyle:{
                                        color:new echarts.graphic.LinearGradient(
                                            1,0,0,0,
                                            [
                                                {offset:0,color:'#FF1493'},
                                                {offset:1,color:'#00FFFF'},
                                            ]
                                        )


                                    }},
                                {value:${examSum - sum},
                                    name:'丢分',
                                    itemStyle: {
                                        color:'rgba(0,0,0,0)',
                                    }
                                },
                            ]

                        }]

                    }
                    totalChart.setOption(option);
                </script>
                <div id="main" style="width: 600px;height:400px;display:table-cell;"></div>
                <script type="text/javascript">
                    //基于准备好的dom，初始化echarts实例
                    var mychart = echarts.init(document.getElementById('main'));
                    var diffName = [];
                    var diffscore = [];
                    <c:forEach var="diff" items="${diffs}" varStatus="loop">
                    diffName.push("${diff.name}");
                    var rate = ${studentDiffs[loop.count-1].score/diff.score};
                    rate *= 100;
                    rate = rate.toFixed(2);
                    diffscore.push(rate);
                    </c:forEach>
                    //指定图表的配置和数据
                    var option = {
                        title: {

                        },
                        tooltip: {
                            formatter:'{c}%',
                        },
                        legend: {
                            data:['得分百分比']
                        },
                        xAxis: {
                            data: diffName,
                        },
                        yAxis: {
                            type: 'value',
                            axisLabel:{
                                show : true,
                                interval: 'auto',
                                formatter: '{value}%'
                            },
                            show : true,
                            min:0,
                            max:100,
                        },
                        series: [{
                            itemStyle: {

                                normal: {

                                    color:new echarts.graphic.LinearGradient(
                                        0,0,0,1,
                                        [
                                            {offset:0,color:'#FFD700'},
                                            {offset:1,color:'#DAA520'},
                                        ]
                                    ),  
                                    label: {
                                        show: true, //开启显示
                                        position: 'top', //在上方显示
                                        formatter: '{c}%',
                                        textStyle: { //数值样式
                                            color: 'black',
                                            fontSize: 16
                                        }
                                    }
                                },

                            },
                            name: '得分百分比',
                            type: 'bar',
                            data: diffscore,
                        }]
                    }

                    mychart.setOption(option);
                </script>
            </div>

        </div>
        <div class="col-md-12 column">
            <div class="page-header">
                <h2>
                    <b>2.知识范围得分评价</b>
                </h2>
            </div>
            <div style="height: 350px;">
                <div style="width: 600px;height: 350px;position: absolute">
                    <table class="table table-hover table-striped" >
                        <thead>
                        <tr>
                            <th>知识范围</th>
                            <th>满分</th>
                            <th>得分</th>
                            <th>成就度</th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach var="scope" items="${scopes}" varStatus="loop">
                            <tr>
                                <td>${scope.name}</td>
                                <td>${scope.score}</td>
                                <td>${studentScope[loop.count-1].score}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${studentScope[loop.count-1].score/scope.score >0.9 }">优秀</c:when>
                                        <c:when test="${studentScope[loop.count-1].score/scope.score >0.75 }">良好</c:when>
                                        <c:when test="${studentScope[loop.count-1].score/scope.score >0.6 }">合格</c:when>
                                        <c:when test="${studentScope[loop.count-1].score/scope.score >0.4 }">待提高</c:when>
                                        <c:when test="${studentScope[loop.count-1].score/scope.score >0 }">薄弱</c:when>
                                    </c:choose>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div id="scopeChart" style="width: 1800px;height:300px;position:absolute;" ></div>
                <script type="text/javascript">
                    var scopeChart = echarts.init(document.getElementById("scopeChart"));
                    var scopeName = [];
                    var scopeScore = [];
                    var scopeStudentScore = [];
                    var scopeAverage = [];
                    <c:forEach var="scope" items="${scopes}" varStatus="loop">
                        scopeName.push("${scope.name}");
                        scopeScore.push(${scope.score});
                        scopeStudentScore.push(${studentScope[loop.count-1].score});
                        scopeAverage.push(${scopeAverage[loop.count-1]});
                    </c:forEach>
                    var option = {
                        title:{

                        },
                        grid:{
                          position:'center',
                        },
                        tooltip:{
                          shape:'circle',
                        },
                        radar:{
                            splitNumber:diffName.length,            //雷达圈数
                            name:{
                                textStyle: {
                                    color:"#838D9E",
                                },
                            },
                            axisLine: {
                                lineStyle: {
                                    color: 'rgba(131,141,158,.1)',
                                },
                            },
                            indicator:[{
                                name:'${scopes[0].name}',max:${scopes[0].score},
                                axisLabel: {
                                    show: true,
                                    fontSize: 12,
                                    color: '#838D9E',
                                    showMaxLabel: false, //不显示最大值，即外圈不显示数字
                                    showMinLabel: true, //显示最小数字，即中心点显示0
                                },
                            },
                                <c:forEach var="scope" items="${scopes}" varStatus="loop" begin="1">
                                {name:'${scope.name}',max:${scope.score}},
                                </c:forEach>
                                /*{name:'${scopes[1].name}',max:${scopes[1].score}},
                                {name:'${scopes[2].name}',max:${scopes[2].score}},
                                {name:'${scopes[3].name}',max:${scopes[3].score}},
                                {name:'${scopes[4].name}',max:${scopes[4].score}},
                                {name:'${scopes[5].name}',max:${scopes[5].score}},
                                {name:'${scopes[6].name}',max:${scopes[6].score}},*/
                            ],
                            splitArea : {
                                show : false,
                                areaStyle : {
                                    color: 'rgba(255,0,0,0)', // 图表背景的颜色
                                },
                            },
                            splitLine : {
                                show : true,
                                lineStyle : {
                                    width : 1,
                                    color : 'rgba(131,141,158,.1)', // 设置网格的颜色
                                },
                            },
                        },
                        series:[{
                            name:'雷达图',
                            type:'radar',
                            symbol:'circle',
                            symbolSize:8,

                            areaStyle:{
                                normal:{
                                    width: 1,
                                    opacity:0.2,
                                },
                            },
                            data:[
                                {
                                    value: scopeScore,
                                    name: '满分',
                                    // 设置区域边框和区域的颜色
                                    itemStyle: {
                                        normal: {
                                            color: 'rgba(255,225,0,.3)',
                                            lineStyle: {
                                                color: 'rgba(255,225,0,.3)',
                                            },
                                        },
                                    },
                                    //在拐点处显示数值
                                    /*label: {
                                        normal: {
                                            show: true,
                                            formatter: (params: any) => {
                                                return params.value
                                            },
                                        },
                                    },*/
                                },
                                {
                                    value: scopeStudentScore,
                                    name: '得分',
                                    // 设置区域边框和区域的颜色
                                    itemStyle: {
                                        normal: {
                                            color: 'rgba(255,0,0,.8)',
                                            lineStyle: {
                                                color: 'rgba(255,0,0,.8)',
                                            },
                                        },
                                    },
                                },
                                {
                                    value: scopeAverage,
                                    name: '平均分',
                                    // 设置区域边框和区域的颜色
                                    itemStyle: {
                                        normal: {
                                            color: 'rgba(0,0,255,.8)',
                                            lineStyle: {
                                                color: 'rgba(0,0,255,.8)',
                                            },
                                        },
                                    },
                                },
                            ]
                        }]
                    }
                    scopeChart.setOption(option);
                </script>
            </div>
        </div>
        <div class="col-md-12 column">
            <div class="page-header">
                <h2>
                    <b>3.核心能力得分评价</b>
                </h2>
            </div>
            <div style="height: 350px">
                <div style="position:absolute;width: 600px;">
                    <table class="table table-hover table-striped">
                        <thead>
                        <tr>
                            <th>核心能力</th>
                            <th>满分</th>
                            <th>得分</th>
                            <th>成就度</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="ability" items="${abilities}" varStatus="loop">
                            <tr>
                                <td>${ability.name}</td>
                                <td>${ability.score}</td>
                                <td>${studentAbilities[loop.count-1].score}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${studentAbilities[loop.count-1].score/ability.score > 0.9}">优秀</c:when>
                                        <c:when test="${studentAbilities[loop.count-1].score/ability.score > 0.75}">良好</c:when>
                                        <c:when test="${studentAbilities[loop.count-1].score/ability.score > 0.6}">合格</c:when>
                                        <c:when test="${studentAbilities[loop.count-1].score/ability.score > 0.4}">待提高</c:when>
                                        <c:when test="${studentAbilities[loop.count-1].score/ability.score > 0}">薄弱</c:when>
                                    </c:choose>
                                </td>
                            </tr>

                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div id="abilityChart" style="position:absolute;width: 1800px;height:300px;"></div>
                <script type="text/javascript">
                    var abilityChart = echarts.init(document.getElementById("abilityChart"));
                    var abilityName = [];
                    var abilityScore = [];
                    var abilityStudentScore = [];
                    var abilityAverage = [];
                    <c:forEach var="ability" items="${abilities}" varStatus="loop">
                       abilityName.push("${ability.name}");
                       abilityScore.push(${ability.score});
                       abilityStudentScore.push(${studentAbilities[loop.count-1].score});
                       abilityAverage.push(${abilityAverage[loop.count-1]});
                    </c:forEach>
                    var option = {
                        title:{

                        },
                        grid:{
                            position:'center',
                        },
                        tooltip:{
                            shape:'circle',
                        },
                        radar: {
                            splitNumber: abilityName.length,
                            name:{
                                textStyle: {
                                    color:"#838D9E",
                                },
                            },
                            axisLine: {
                                lineStyle: {
                                    color: 'rgba(131,141,158,.1)',
                                },
                            },

                            indicator: [{
                                name:'${abilities[0].name}',max:${abilities[0].score},
                                axisLabel:{
                                    show: true,
                                    fontSize: 12,
                                    color: '#838D9E',
                                    showMaxLabel: false, //不显示最大值，即外圈不显示数字
                                    showMinLabel: true, //显示最小数字，即中心点显示0
                                },
                            },
                                <c:forEach var="ability" items="${abilities}" varStatus="loop" begin="1">
                                {name:'${ability.name}',max:${ability.score}},
                                </c:forEach>
                            ],
                            splitArea : {
                                show : false,
                                areaStyle : {
                                    color: 'rgba(255,0,0,0)', // 图表背景的颜色
                                },
                            },
                            splitLine : {
                                show : true,
                                lineStyle : {
                                    width : 1,
                                    color : 'rgba(131,141,158,.1)', // 设置网格的颜色
                                },
                            },
                        },
                        series:[{
                            name:'雷达图',
                            type:'radar',
                            symbol:'circle',
                            symbolSize:8,

                            areaStyle:{
                                normal:{
                                    width: 1,
                                    opacity:0.2,
                                },
                            },
                            data:[
                                {
                                    value:abilityScore,
                                    name:"满分",
                                    itemStyle: {
                                        normal: {
                                            color: 'rgba(255,225,0,.3)',
                                            lineStyle: {
                                                color: 'rgba(255,225,0,.3)',
                                            },
                                        },
                                    },
                                },
                                {
                                    value:abilityStudentScore,
                                    name:"得分",
                                    itemStyle: {
                                        normal: {
                                            color: 'rgba(255,0,0,.8)',
                                            lineStyle: {
                                                color: 'rgba(255,0,0,.8)',
                                            },
                                        },
                                    },
                                },
                                {
                                    value:abilityAverage,
                                    name:"平均分",
                                    itemStyle: {
                                        normal: {
                                            color: 'rgba(0,0,255,.8)',
                                            lineStyle: {
                                                color: 'rgba(0,0,255,.8)',
                                            },
                                        },
                                    },
                                },
                            ]
                        }]
                    }
                    abilityChart.setOption(option);
                </script>
            </div>

        </div>
        <div class="col-md-12 column">
            <div class="page-header">
                <h2>
                    <b>4.各试题得分情况</b>
                </h2>
            </div>
            <div>
                <h3 align="center">
                    <b>题目总量:<u>&ensp;${questionInfos.size()}&ensp;</u></b>&emsp;
                    <b>试卷总分:<u>&ensp;${examSum}&ensp;</u></b>&emsp;
                    <b>学生得分:<u>&ensp;${sum}&ensp;</u></b>&emsp;
                    <b>本卷平均得分:<u>&ensp;${averageSum}&ensp;</u></b>
                </h3>
            </div>
            <div>
                <table class="table table-hover table-striped">
                    <thead>
                    <tr>
                        <th>题号</th>
                        <th>分值</th>
                        <th>得分</th>
                        <th>平均得分</th>
                        <th>难易程度</th>
                        <th>知识点</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="qustion" items="${questionInfos}" varStatus="loop">
                        <tr>
                            <td>${qustion.qustionid}</td>
                            <td>${qustion.score}</td>
                            <td>${studentScore[loop.count-1].score}</td>
                            <td>${average[loop.count-1]}</td>
                            <td>${qustion.difficulty}</td>
                            <td>${qustion.point}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
