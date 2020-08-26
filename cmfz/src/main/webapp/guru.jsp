<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/19
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/layui/layui.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-1.9.js" type="text/javascript"></script>
</head>
<body>
<okToolbar>
<button id="take_out" class="layui-btn layui-btn-radius layui-btn-normal">导出</button>
<button id="take_in" class="layui-btn layui-btn-radius layui-btn-normal"><i class="iconfont icon-export"></i> 导入</button>
</okToolbar>
    <table  id="guru"></table>

<script>
    layui.use(['table','upload','layer'], function(){
        var table = layui.table;
        var upload=layui.upload;
        var layer=layui.layer;
        table.render({
            elem: '#guru'
            ,url:'${pageContext.request.contextPath}/cmfz_guru/selectAllGuru'
            ,cols: [[
                {field:'guruId',  title: '编号'}
                ,{field:'guruName',  title: '上师姓名'}
                ,{field:'guruImage', title: '图片',templet:function (data) {
                            return " <img id='photo' onclick='showImg($(this))' style='max-height:100px;max-width:100px;' src='${pageContext.request.contextPath}/"+data.guruImage+"' class='layui-upload-img'/>"
                    }}
                ,{field:'guruNickname',  title: '上师法名'}
                ,{field:'guruStatus', title: '状态',templet:function (data) {
                        if (data.guruStatus==0){
                            return "存在"
                        }else {
                            return "不存在"
                        }
                    }}
            ]]
            ,page: true
            ,limit: 5
        });
        $("#take_out").click(function(){
            layer.open({
                content:"导出全部数据",
                yes:function () {
                   window.location.href="${pageContext.request.contextPath}/cmfz_guru/excelOut";
                }
            })
        })
        upload.render({
            elem: '#take_in'
            ,url: '${pageContext.request.contextPath}/cmfz_guru/inPort'
            ,accept: 'file' //普通文件
            ,exts: 'xls|excel|xlsx'
            ,done: function(res){
                layer.msg(res.msg);
                table.reload("guru");
            }
        });

    });
</script>
<script type="text/javascript">
    function showImg(imgData){
        var img = new Image();
        img.src = imgData.attr("src");
        var height = img.height; // 原图片大小
        var width = img.width; //原图片大小

        var winHeight = $(window).height() - 80;  // 浏览器可视部分高度
        var winWidth = $(window).width() - 100;  // 浏览器可视部分宽度

        // 如果图片高度或者宽度大于限定的高度或者宽度则进行等比例尺寸压缩
        if (height > winHeight || width > winWidth) {
            // 1.原图片宽高比例 大于等于 图片框宽高比例
            if (winWidth/ winHeight <= width / height) {
                width = winWidth;   //以框的宽度为标准
                height = winWidth * (height / width);
            }

            // 2.原图片宽高比例 小于 图片框宽高比例
            if (winWidth/ winHeight > width / height) {
                width = winHeight  * (width / height);
                height = winHeight  ;   //以框的高度为标准
            }
        }

        var imgHtml = "<img src='" + img.src + "' width='" + width + "px' height='" + height + "px' />";
        //弹出层
        layer.open({
            type: 1,
            shade: 0.8,
            offset: 'auto',
            // area: [500 + 'px',550+'px'],
            area: [width + 'px',(height + 50) + 'px'],  //原图显示,高度+50是为了去除掉滚动条
            shadeClose:true,
            scrollbar: false,
            title: "图片预览", //不显示标题
            content: imgHtml, //捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响
            cancel: function () {
                //layer.msg('捕获就是从页面已经存在的元素上，包裹layer的结构', { time: 5000, icon: 6 });
            }
        });
    }
</script>
</body>
</html>
