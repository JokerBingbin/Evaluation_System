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
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>评测结果</small>
                </h1>
            </div>
            <div>
                <h3>
                    <small>姓名：${student.name}</small><br>
                    <small>年级：${classinfo.grade}</small><br>
                    <small>考试：${exam.name}</small><br>
                    <small>科目：${classinfo.subject}</small><br>
                    <small>成绩：${sum} </small>
                </h3>
            </div>
        </div>
        <div class="col-md-12 column">
            <div class="page-header">
                <h2>
                    <small>1.成绩整体情况</small>
                </h2>
            </div>
            <%--echart的Dom--%>
            <div id="total" style="width: 600px;height:400px;"></div>
            <script type="text/javascript">
                var totalChart = echarts.init(document.getElementById("total"));

                var option = {
                    title:{

                    },
                    series: [{
                        type : "pie",
                        radius: '55%',
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
                            {value:${sum},name:'得分'},
                            {value:${examSum - sum},name:'丢分'},
                        ]

                    }]

                }
                totalChart.setOption(option);
            </script>
            <div id="main" style="width: 600px;height:400px;"></div>
            <script type="text/javascript">
                //基于准备好的dom，初始化echarts实例
                var mychart = echarts.init(document.getElementById('main'));
                //指定图表的配置和数据
                var option = {
                    title: {

                    },
                    tooltip: {},
                    legend: {
                        data:['得分百分比']
                    },
                    xAxis: {
                        data: ['${diffs[0].name}','${diffs[1].name}','${diffs[2].name}']
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
                        max:1,
                    },
                    series: [{
                        itemStyle: {
                            normal: {
                                label: {
                                    show: true, //开启显示
                                    position: 'top', //在上方显示
                                    formatter: '{c}%',
                                    textStyle: { //数值样式
                                        color: 'black',
                                        fontSize: 16
                                    }
                                }
                            }
                        },
                        name: '得分百分比',
                        type: 'bar',
                        data: [${studentDiffs[0].score/diffs[0].score},${studentDiffs[1].score/diffs[1].score},${studentDiffs[2].score/diffs[2].score}]
                    }]
                }
                mychart.setOption(option);
            </script>
        </div>
        <div class="col-md-12 column">
            <div class="page-header">
                <h2>
                    <small>2.知识范围得分评价</small>
                </h2>
            </div>
            <div>
                <table class="table table-hover table-striped">
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
                            <td></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div id="scopeChart" style="width: 600px;height:400px;"></div>
                <script type="text/javascript">
                    var scopeChart = echarts.init(document.getElementById("scopeChart"));

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
                            splitNumber:8,            //雷达圈数
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
                                {name:'${scopes[1].name}',max:${scopes[1].score}},
                                {name:'${scopes[2].name}',max:${scopes[2].score}},
                                {name:'${scopes[3].name}',max:${scopes[3].score}},
                                {name:'${scopes[4].name}',max:${scopes[4].score}},
                                {name:'${scopes[5].name}',max:${scopes[5].score}},
                                {name:'${scopes[6].name}',max:${scopes[6].score}},
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
                                    value: [${scopes[0].score},${scopes[1].score},${scopes[2].score},${scopes[3].score},${scopes[4].score},${scopes[5].score},${scopes[6].score}],
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
                                    value: [${studentScope[0].score},${studentScope[1].score},${studentScope[2].score},${studentScope[3].score},${studentScope[4].score},${studentScope[5].score},${studentScope[6].score}],
                                    name: '得分',
                                    // 设置区域边框和区域的颜色
                                    itemStyle: {
                                        normal: {
                                            color: 'rgba(255,225,0,.3)',
                                            lineStyle: {
                                                color: 'rgba(255,225,0,.3)',
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
                    <small>3.核心能力得分评价</small>
                </h2>
            </div>
            <div>
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
                            </td>
                        </tr>

                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col-md-12 column">
            <div class="page-header">
                <h2>
                    <small>4.各试题得分情况</small>
                </h2>
            </div>
            <div>
                <h3>
                    <small>题目总量:${questionInfos.size()}</small><br>
                    <small>试卷总分:${examSum}</small><br>
                    <small>学生得分:${sum}</small><br>
                    <small>本卷平均得分</small><br>
                </h3>
            </div>
            <div>
                <table class="table table-hover table-striped">
                    <thead>
                    <tr>
                        <th>题号</th>
                        <th>分值</th>
                        <th>得分</th>
                        <th>平均得分率</th>
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
                            <td></td>
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
