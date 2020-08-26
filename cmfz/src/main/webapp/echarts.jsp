<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/20
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/layui/layui.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-1.9.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/echarts.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/china.js" type="text/javascript"></script>
</head>
<body>
   <div class="layui-layout-login">
       <div id="main" style="width:600px;height: 400px"></div>
       <div id="main2" style="width:600px;height: 400px"></div>
       <div id="main3" style="width:600px;height: 400px"></div>
   </div>


<script>
    var myChat=echarts.init(document.getElementById('main'));
    var myChat2=echarts.init(document.getElementById('main2'));
    var myChat3=echarts.init(document.getElementById('main3'));
    // 指定图表的配置项和数据
    $.ajax({
        url:"${pageContext.request.contextPath}/cmfz_user/selectAllSex"
        ,type:"post",
        success:function (result) {
            console.log(result)
            var option = {
                //图表的标题
                title: {
                    text: '持明法洲男女人数对比'
                },
                // 工具栏
                tooltip: {},
                // legend 传奇 在数学中指的是 系列
                // 在代码中 代表数据的类型
                legend: {
                    data:['人数']
                },
                // xAxis x轴坐标
                xAxis: {
                    data: ['男','女']
                },
                // y 轴坐标 自动生成
                yAxis: {},
                // 给x轴赋值
                series: [{
                    // name 必须和 legend 中的配置一样
                    name: '人数',
                    // 定义是展示类型 bar柱状图 line折线图 pie 饼状图
                    type: 'bar',
                    // x轴坐标对应的坐标值
                    data: [result.sex[1].VALUE,result.sex[0].VALUE]
                }]
            };
            var option2 = {
                //图表的标题
                title: {
                    text: '三周内注册量变化'
                },
                // 工具栏
                tooltip: {},
                // legend 传奇 在数学中指的是 系列
                // 在代码中 代表数据的类型
                legend: {
                    data:['注册量']
                },
                // xAxis x轴坐标
                xAxis: {
                    data: ['14-21','7-14','0-7']
                },
                // y 轴坐标 自动生成
                yAxis: {},
                // 给x轴赋值
                series: [{
                    // name 必须和 legend 中的配置一样
                    name: '注册量',
                    // 定义是展示类型 bar柱状图 line折线图 pie 饼状图
                    type: 'line',
                    // x轴坐标对应的坐标值
                    data: [result.date[2].total,result.date[1].total,result.date[0].total]
                }]
            };
            var option3 = {
                title : {
                    text: '用户地区分布',
                    left: 'center'
                },
                tooltip : {
                    trigger: 'item'
                },
                legend: {
                    orient: 'vertical',
                    left: 'left',
                    data:['用户人数']
                },
                visualMap: {
                    min: 0,
                    max: 25000,
                    left: 'left',
                    top: 'bottom',
                    text:['高','低'],           // 文本，默认为数值文本
                    calculable : true
                },
                toolbox: {
                    show: true,
                    orient : 'vertical',
                    left: 'right',
                    top: 'center',
                    feature : {
                        mark : {show: true},
                        dataView : {show: true, readOnly: false},
                        restore : {show: true},
                        saveAsImage : {show: true}
                    }
                },
                series : [
                    {
                        name: '用户人数',
                        type: 'map',
                        mapType: 'china',
                        roam: false,
                        label: {
                            normal: {
                                show: false
                            },
                            emphasis: {
                                show: true
                            }
                        },
                        data:result.province

                    }
                ]
            };

            myChat.setOption(option);
            myChat2.setOption(option2);
            myChat3.setOption(option3);
        }
    })


</script>
</body>
</html>
