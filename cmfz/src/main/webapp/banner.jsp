<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/21
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title> <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/layui/layui.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-1.9.js" type="text/javascript"></script>

</head>
<body>
   <table class="layui-hide" id="banner" lay-filter="banner"></table>

 <script>
     layui.use(['table','date','form','layer',function () {
         var table=layui.table;
         var date=layui.date;
         var form=layui.form;
         var layer=layui.layer;
         table.render({
             elem:"#banner"
             ,url:"${pageContext.request.contextPath}/cmfz_banner/selectBanner"
             ,cols: [[
                 {field:'bannerId',  title: '编号'}
                 ,{field:'bannerImageUrl', title: '轮播图图片',templet:function (data) {
                         return " <img id='photo' onclick='showImg($(this))' style='max-height:100px;max-width:100px;' src='${pageContext.request.contextPath}/"+data.bannerImageUrl+"' class='layui-upload-img'/>"
                     }}
                 ,{field:'bannerOldName',  title: '原有名称'}
                 ,{field:'bannerState', title: '状态',templet:function (data) {
                         if (data.bannerState==0){
                             return "不展示"
                         }else {
                             return "展示"
                         }
                     }}
                 ,{field:'bannerDate',title:'上传时间'}
                 ,{field:'bannerDescription',title:'描述'}
             ]]
             ,page: true
             ,limit: 5
         });
     }])

 </script>
</body>
</html>
