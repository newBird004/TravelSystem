<%@ page language="java" contentType="text/html; charset=UTF-8"
    isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta charset="UTF-8">
    <title>头部</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap 101 Template</title>

    <link href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">

    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>


</head>
<body>
<nav class="navbar-inverse">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header" style="margin-left: 70px;margin-bottom: 5px;margin-top: 5px">
                <span id="" style="color: white;">欢迎来到北古小镇！&nbsp;&nbsp;</span>
                <span class="glyphicon glyphicon-phone-alt"  style="color: white" aria-hidden="true" >
                    <a href="#" style="color: white">联系电话|&nbsp;0359-2525126</a>
                </span>
            </div>

            <div style="margin-bottom: 5px;margin-top: 5px;margin-right: 70px;" class=" navbar-right">
                <a id="login" href="${pageContext.request.contextPath}/loginPage" style="color: white;margin-right: 14px" >登陆</a>
                <a href="${pageContext.request.contextPath}/registerPage" style="color: white;margin-right: 14px">注册新用户</a>
               	<span id="huanying" style="color: white;">欢迎您！</span><a id="travelUserName" href="${pageContext.request.contextPath}/openPersonalPage">${travelUser.userName}</a>
               	<a id="zhuxiao" href="${pageContext.request.contextPath}/logout" style="color: white;margin-right: 14px">注销</a>
                <span class="glyphicon glyphicon-shopping-cart" style="color: white" aria-hidden="true" >
                    <a id="openBuyCartPage" href="#" style="color: white">购物车</a>
                </span>
            </div><!-- /.container-fluid -->
        </div>
</nav>


    <nav class="navbar">
        <div class="container-fluid">

            <div style="margin-top: 10px" class="navbar-header">
                <img src="${pageContext.request.contextPath}/img/tubiao.jpg"  alt="图标" style="margin-left: 90px;width: 60px;height: 60px">

            </div>

            <div id="GoodsType" style="padding-top: 20px;margin-left: 200px;">
                <a href="${pageContext.request.contextPath}/" style="color: black;font-size: large;margin-right: 20px">首页</a>
                <a href="${pageContext.request.contextPath}/history.jsp" style="color: black;font-size: large;margin-right: 20px">景区概览</a>
                <a href="${pageContext.request.contextPath}/openAllTaoCanPage" style="color: black;font-size: large;margin-right: 20px">套餐预定</a>
                <a href="${pageContext.request.contextPath}/openAllScenicPage" style="color: black;font-size: large;margin-right: 20px">票务预定</a>
                <a href="${pageContext.request.contextPath}/openAllHotelPage" style="color: black;font-size: large;margin-right: 20px">预定酒店</a>
                <a href="${pageContext.request.contextPath}/" style="color: black;font-size: large;margin-right: 20px">景区地图</a>

            </div>

            <div class="navbar-right"style="margin-top: -30px;margin-right: 70px;" >
                <input type="text" style="height: 40px;width: 200px;" placeholder="&nbsp;请搜索...">

                <button type="button" class="btn btn-default btn-lg">
                    <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                </button>
            </div>
        </div>
    </nav>
<p style="background-color: #9d9d9d;height:2px;width: 1335px;margin-left: 100px"></p>

	<script type="text/javascript">

		$(function () {
		    if("${travelUser.userName}"){
		        $("#login").hide();
            }else{
                $("#huanying").hide();
                $("#zhuxiao").hide();
            }
		    //发送ajax请求获取到商品类别
			// $.get("/XiaoMiShopping/GoodsTypeServlet?method=selectAll",{},function(data){
			// 	for(var i=0;i<data.length;i++){
			// 		var s=data[i];
			// 		$("#GoodsType").append("<a href='/XiaoMiShopping/GoodsServlet?method=selectGoodsByPage&typeid="+data[i].id+"' style='color: black;font-size: large;margin-right: 20px'>"+data[i].name+"</a>");
			// 	}
			// },"json");

            openBuyCartPage

            $("#openBuyCartPage").click(function () {
                if("${travelUser}"){
                    window.location.href="${pageContext.request.contextPath}/openBuyCartPage";
                }else{
                    window.location.href="${pageContext.request.contextPath}/loginPage";
                }
            });

		});

	</script>
</body>
</html>