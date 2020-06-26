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

</head>
<body>
<div id="head"></div>
<script>
	$("#head").load("header.jsp");
</script>

<%--   <div class="col-md-1 col-md-offset-2" style="background-color: #3C4049">--%>
<%--      <p>hotelService.deleteHotelById(Integer.parseInt(ids));</p>x--%>

<%--   </div>--%>
<div class="container-fluid">
	<div class="row" id="taoCanRow">
		<%--         <div class="col-md-2 col-md-offset-1" style="text-align: center">--%>
		<%--            <img alt="" src="${pageContext.request.contextPath}/img/1.jpg" width="192px" height="128px">--%>
		<%--            <p>酒店名称</p>--%>
		<%--            <p>酒店价格:</p>--%>
		<%--            <a class="btn btn-sm btn-success" href="${pageContext.request.contextPath}/taoCan/taoCanId">查看详情</a>--%>
		<%--         </div>--%>
	</div>
</div>

<!-- 分页信息 -->
<div class="row" style="margin-top: 40px">

	<div class="col-md-offset-8 col-md-4" id="pageNav">

	</div>
</div>


<script>
	$(function () {
		to_page(1);//默认显示第一页的数据
	});
	function build_TaoCanList(data) {//将json中的数据通过jquery遍历添加到table上显示出来
		$("#taoCanRow").empty();//清空上一次查询到的数据，防止重叠

		var taoCans=data.extend.pageInfo.list;
		$.each(taoCans,function (index,item) {
			var taoCanImg=$("<img width='610px' height=\"360px\"></img>").attr("src","${pageContext.request.contextPath}/img/TaoCan/"+item.taoCanImage+"");
			var taoCanName=$("<p style=''></p>").append("套餐名称："+item.taoCanName);
			var taoCanPrice=$("<p style=''></p>").append("价格："+item.taoCanPrice);
			var taoCanIntroduce=$("<p style=''></p>").append("套餐详情："+item.taoCanIntroduce);
			var taoCanText2=$("<p style=''></p>").append("温馨提示：景区门票当日一次进入有效！");
			var taoCanView=$("<a class='btn btn-sm btn-default'></a>").append("查看详情").attr("href","${pageContext.request.contextPath}/openTaoCanDetailPage"+"?taoCanId="+item.taoCanId+"");
			var div1=$("<div class=\"col-md-5 col-md-offset-2\" style=\"text-align:right;margin-top: 40px;\"></div>").append(taoCanImg).appendTo("#taoCanRow");;
			var div2=$("<div class=\"col-md-5 \" style=\" border:1px solid;width: 400px;height: 360px;margin-top: 40px\"></div>").append(taoCanName).append(taoCanPrice).append(taoCanIntroduce).append(taoCanText2).append(taoCanView).appendTo("#taoCanRow");;

		});
	}


	function build_PageNav(result) {
		$("#pageNav").empty();//清空上一次查询到的数据，防止重叠

		var ul=$("<ul></ul>").addClass("pagination");

		var firstPage=$("<li></li>").append($("<a></a>").attr("href","#").append("首页"));
		var previousPage=$("<li></li>").append($("<a></a>").attr("href","#").append("&laquo;"));
		if(result.extend.pageInfo.hasPreviousPage==false){//判断前面是否还有页数，如果没有，就禁用首页和上一页按钮
			firstPage.addClass("disabled");
			previousPage.addClass("disabled");
		}else{
			firstPage.click(function(){
				to_page(1);
			});
			previousPage.click(function(){
				to_page(result.extend.pageInfo.pageNum-1);
			});
		}
		ul.append(firstPage).append(previousPage);


		$.each(result.extend.pageInfo.navigatepageNums,function (index, item) {
			var numPage=$("<li></li>").append($("<a></a>").attr("href","#").append(item));
			if(result.extend.pageInfo.pageNum==item){
				numPage.addClass("active");
			}
			numPage.click(function () {
				to_page(item);
			});
			ul.append(numPage);
		});

		var nextPage=$("<li></li>").append($("<a></a>").attr("href","#").append("&raquo;"));
		var lastPage=$("<li></li>").append($("<a></a>").attr("href","#").append("尾页"));
		if(result.extend.pageInfo.hasNextPage==false){
			nextPage.addClass("disabled");
			lastPage.addClass("disabled");
		}else {
			lastPage.click(function(){
				to_page(result.extend.pageInfo.pages);
			});
			nextPage.click(function(){
				to_page(result.extend.pageInfo.pageNum+1);
			});
		}
		ul.append(nextPage).append(lastPage);

		var nav=$("<nav></nav>").append(ul);
		nav.appendTo("#pageNav");
	}

	/* 传入页数，就能够发送ajax请求，然后获取到数据，并调用方法分别构建数据表，分页信息，分页条 */
	function to_page(pn) {
		$.ajax({
			url:"${pageContext.request.contextPath}/loadTaoCanList",
			data:"pn="+pn,
			type:"get",
			success:function(data){
				/*
                    1、解析json数据，显示所有员工
                    2、解析json数据，显示分页信息
                    3、解析json数据，显示分页条
                */
				build_TaoCanList(data);
				build_PageNav(data);
			}
		});
	}

</script>
</body>
</html>