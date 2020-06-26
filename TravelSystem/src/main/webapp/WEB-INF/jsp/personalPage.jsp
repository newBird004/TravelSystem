<%--
  Created by IntelliJ IDEA.
  User: 陽
  Date: 2020/4/26
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap/-->
    <link href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>

    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>

    <script  src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
</head>
<body>

    <%--导航栏--%>
    <nav class="navbar navbar-default" style="margin-bottom: 5px">
        <div class="container-fluid" style="background-color: black">
            <div class="navbar-header">
                <a  class="navbar-brand" href="#"  style="color: white;font-size: xx-large">个人中心&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
                <a  class="navbar-brand" href="${pageContext.request.contextPath}"  style="color: white;font-size: xx-large"><span class="glyphicon glyphicon-home" aria-hidden="true"></span></a>
            </div>
            <ul class="nav navbar-nav navbar-right">
                <li><a  class="navbar-brand" id="manager" href="#" style="color: white;font-size: 18px;">欢迎:${travelUser.userName}！</a></li>
                <li><a  class="navbar-brand" id="logout" href="${pageContext.request.contextPath}/logout" style="color: white;font-size: 18px;">注销</a></li>
            </ul>
        </div>
    </nav>

<%--    左边垂直导航栏--%>
    <div class="container-fluid">
        <div class="row" >
            <div class="col-md-2" >
                <ul class="nav nav-tabs nav-stacked">
                    <li role="presentation"><a id="personalMsg" href="#" style="font-size: large">个人信息</a></li>
                    <li role="presentation"><a id="realNameMsg" href="#"style="font-size: large">实名认证信息</a></li>
                    <li role="presentation"><a id="orderMsg" href="#"style="font-size: large">订单查看</a></li>
                    <li role="presentation"><a id="couldToComment" href="#"style="font-size: large">可评价订单</a></li>
                </ul>
            </div>
            <div class="col-md-10">
                <iframe id="iframeTest" src="${pageContext.request.contextPath}/openPersonalMsgPage" style="width: 1250px;height: 680px">主窗口</iframe>
            </div>
        </div>
    </div><!-- /.container-fluid -->
<script>
    $(function() {
        $("#personalMsg").click(function () {
            $("#iframeTest").attr("src","${pageContext.request.contextPath}/openPersonalMsgPage");
        });
        $("#realNameMsg").click(function () {
            $("#iframeTest").attr("src","${pageContext.request.contextPath}/openRealNamePage");
        });
        $("#orderMsg").click(function () {
            $("#iframeTest").attr("src","${pageContext.request.contextPath}/openOrderPage");
        });
        $("#couldToComment").click(function () {
            $("#iframeTest").attr("src","${pageContext.request.contextPath}/openCommentPage");
        });


    });
</script>
</body>
</html>
