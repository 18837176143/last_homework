<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/18
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>后台管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/layui/layui.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-1.9.js" type="text/javascript"></script>
    <style type="text/css">
        .layui-tab-content {
            padding: 0;/*layui-tab-content:默认有padding: 10px;的值，因为iframe的绝对定位脱离文档流，所以会存在20px的空白空间*/
        }
        .show-frame {
            top: 50px!important;
            /*默认.layui-layout-admin .layui-body {
                top: 60px;
                bottom: 44px;
            }*/
            overflow: hidden;/*消除浏览器最右边的滚动条*/
        }
        .frame {
            position: absolute;
            padding: 10px;/*与layui-footer隔开一段距离*/
            width: 100%;
            height: 100%;
        }
    </style>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin ">
    <div class="layui-header layui-bg-blue">
        <div class="layui-logo" style="color:#fff9ec">后台管理系统</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">控制台</a></li>
            <li class="layui-nav-item"><a href="">商品管理</a></li>
            <li class="layui-nav-item"><a href="">用户</a></li>
        </ul>
        <ul class="layui-nav layui-layout-right ">
            <li class="layui-nav-item">

                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a id="exit">退了</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test" id="test">

            </ul>
        </div>
    </div>


    <div class="layui-body">
        <div class="layui-tab" lay-filter="demo" lay-allowclose="true">
            <ul class="layui-tab-title">
                <li class="layui-this">欢迎登陆</li>
            </ul>
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">欢迎登陆系统</div>
            </div>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © yangy.com - 底部固定区域
    </div>
</div>
<script>
    $.ajax({
        type:"post",
        async:true,
        url:"${pageContext.request.contextPath}/cmfz_menu/createMenu",
        dataType:"json",
        success:function (result) {
            console.log(result);
            var html1="";
            var html2="";
            for (var i=0;i<result.length;i++){
                html1= "<li class='layui-nav-item' lay-filter='test'>" +
                    "<a class='' href='javascript:;' id=''>"+result[i].menuName+"</a>" +
                    " <dl class='layui-nav-child' id='"+result[i].menuId+"'>";
                for (var j=0;j<result[i].menus.length;j++){
                    html1+="<dd class='test'><a href='javascript:;'url='"+result[i].menus[j].menuUrl+"' id='"+result[i].menus[j].menuId+"'>"+result[i].menus[j].menuName+"</a></dd>";
                }
                html1+="</dl></li>";
                html2+=html1;
            }
            $("#test").append(html2);
            layui.use('element', function(){
                var element = layui.element;
                $("#test dd a").click(function(){
                    if($("[lay-id="+$(this).attr("id")+"]").size()<1) {
                        element.tabAdd("demo", {
                            title: $(this).html()
                            , content: '<iframe class="frame" src="' + $(this).attr("url") + '"></iframe>' //支持传入html
                            , id: $(this).attr("id")
                        });
                        //切换到该选项卡里面
                        element.tabChange("demo",$(this).attr("id"));
                    }
                });
            });
        }
    });
    $("#exit").click(function () {
            layui.use('layer',function () {
                var layer=layui.layer;
                  layer.confirm("确定退出",function (index) {
                      $.get("${pageContext.request.contextPath}/cmfz_menu/exit",function () {
                          location.href="${pageContext.request.contextPath}/login.jsp";
                          layer.close(index);
                      });

                  });

            })

    });
</script>

</body>
</html>
