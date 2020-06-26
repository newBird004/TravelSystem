<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta charset="UTF-8">
    <title>首页</title>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/swiper.min.css">
    <script src="${pageContext.request.contextPath}/js/swiper.min.js"></script>

</head>
<body>
	<div id="page"></div>
	<script>
        $("#page").load("header.jsp");
    </script>
    
    <div class="swiper-container">
	    <div class="swiper-wrapper" style="text-align: center;">
	        <div class="swiper-slide"><img alt="" src="${pageContext.request.contextPath}/img/1.jpg" width="1300px" height="700px"></div>
	        <div class="swiper-slide"><img alt="" src="${pageContext.request.contextPath}/img/2.jpg" width="1300px" height="700px"></div>
	        <div class="swiper-slide"><img alt="" src="${pageContext.request.contextPath}/img/3.jpg" width="1300px" height="700px"></div>
	   		<div class="swiper-slide"><img alt="" src="${pageContext.request.contextPath}/img/4.jpg" width="1300px" height="700px"></div>
	    	<div class="swiper-slide"><img alt="" src="${pageContext.request.contextPath}/img/5.jpg" width="1300px" height="700px"></div>
	    	<div class="swiper-slide"><img alt="" src="${pageContext.request.contextPath}/img/6.jpg" width="1300px" height="700px"></div>
	    	<div class="swiper-slide"><img alt="" src="${pageContext.request.contextPath}/img/7.jpg" width="1300px" height="700px"></div>
	    </div>
	    <!-- 如果需要导航按钮 -->
		<div class="swiper-button-prev"></div>
	    <div class="swiper-button-next"></div>
    	<!-- 如果需要分页器 -->
    	<div class="swiper-pagination"></div>
	</div>
	<script>        
		  var mySwiper = new Swiper ('.swiper-container', {
		    direction: 'horizontal', // 垂直切换选项
		    autoplay: true, // 循环模式选项
		    speed:1000,
		    delay:4000,
		    // 如果需要分页器
		    pagination: {
		      el: '.swiper-pagination',
		    },
		    
		    // 如果需要前进后退按钮
		    navigation: {
		      nextEl: '.swiper-button-next',
		      prevEl: '.swiper-button-prev',
		    },

		  })        
	  </script>
</body>
</html>