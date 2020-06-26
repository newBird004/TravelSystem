<%@ page import="cn.yy.pojo.TaoCan" %>
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

	<%--   为了引入日期插件--%>
	<link href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/daterangepicker.css" />


	<script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	<script src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>

	<%--   为了引入日期插件--%>
	<script src="${pageContext.request.contextPath}/assets/js/moment.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/daterangepicker.js"></script>

</head>
<body>
<div id="head"></div>
<script>
	$("#head").load("header.jsp");
</script>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-4 col-md-offset-2" style="margin-top: 40px">
			<img style="" src="${pageContext.request.contextPath}/img/TaoCan/${taoCan.taoCanImage}" width="460px" height="360px">
		</div>

		<div class="col-md-6" style="margin-top: 40px;">
			<p style="font-size:large;margin-bottom: 10px">套餐名称：古北小镇${taoCan.taoCanName}</p>
			<p style="font-size:large;margin-bottom: 10px">套餐详情：${taoCan.taoCanIntroduce}</p>
			<%
				//根据七折后的价格，计算出原价，并放入域中
				TaoCan t= (TaoCan) request.getAttribute("taoCan");
				int priceOld=t.getTaoCanPrice()*10/7;
				pageContext.setAttribute("priceOld",priceOld);
			%>
			<p style="font-size:large;margin-bottom: 10px">套餐价格：<span style="text-decoration:line-through;">￥${priceOld}</span><span style="color: red">￥${taoCan.taoCanPrice}</span></p>

			<p style="font-size:large;margin-bottom: 10px">选择旅客：
				<select class="form-control" id="showRealNamesSelect" style="width: 140px;margin-left: 90px">
				</select>
			</p>

			<p style="font-size:large;margin-bottom: 10px">  预约日期：
			<div class="input-group" style="width: 140px;margin-left: 90px">
				<div class="input-group-addon"><span class="glyphicon glyphicon-calendar" aria-hidden="true"></span></div>
				<input type="text" class="form-control" id="date" name="date" placeholder="date">
				<span id="validateHasRoomMsg" class="help-block"></span>
			</div>
			</p>

			<p style="font-size:large;margin-bottom: 10px">温馨提示：<span style="color: red">请注意您的出行日期！</span></p>
			<button id="purchaseTaoCan" class="btn btn-danger" style="margin-left: 100px">立即付款</button>
		</div>
	</div>
</div>




<div class="container-fluid" style="margin-top: 26px">

	<div class="row" id="div1" style="margin-bottom: 20px;z-index: 1;font-weight: bolder;font-size: large;" >
		<div class="col-md-offset-2 col-md-8 col-md-offset-2" style="background-color: #e5e5e5;border-radius: 3px">
			<ul class="nav nav-tabs">
				<li role="presentation"><a href="#ydxz" style="color: black">预定须知</a></li>
				<li role="presentation"><a href="#tcpj" style="color: black">套餐评价</a></li>
			</ul>
		</div>
	</div>

	<div class="row" id="ydxz">
		<div class="col-md-offset-2 col-md-8 col-md-offset-2" >

			<span style="font-weight: bold;font-size: large">【预订须知】：</span><br>

			1.预订前如有疑问，建议您在线咨询或拨打咨询热线0359-2525126；<br>
			2.网上预订需支付全额套餐费，如需取消订单，请至少提前3天；若在3天（含）内取消，需收取订单总额的20%作为违约金；当天取消，需收取订单总额的100%作为违约金；<br>
			3.所有客人保证入住时间为当日15:00之后，退房时间为次日12:00之前，如迟退房，需跟酒店前台沟通，并另行收取相应房费；<br>
			4.订单提交成功后，请在30分钟内完成网上支付，超时订单将作无效处理；<br>
			购买套餐，您将尊享套餐里包括的所有项目，凭套餐卡到指定点进行消费体验即可。具体使用规则如下：<br>
			1.使用套餐卡之前，请您仔细查看套餐短信上标注的使用地点、时段、人数，并在开放时间内参与体验 ;<br>
			2.套餐卡仅作为您所购买的套餐的消费凭证，所有套餐卡在您本次入住期间有效，若您在有效期内不消费套餐中所含的某项，我们将视您主动放弃体验该项目，不提供兑换现金的服务 ;<br>
			3.若您购买多个套餐，相同卡种单独使用有效，不可累加使用 ;<br>
			4.套餐内活动项目需凭套餐卡使用，请随身携带套餐卡，套餐卡损坏视为无效，使用时请出示您的套餐卡 ;<br>
			5.在店期间，请妥善保管好您的套餐卡，以免丢失 ;<br>
			6.如遇房间临时变更情况，需到前台按当日房间现付价格补差价升级房间 ;<br>
			7.套餐卡使用仅住宿期间有效。<br>
			<br>
		</div>
	</div>


</div>


<div class="row" id="tcpj" style="margin-top: 20px;margin-bottom: 100px">
	<div class="col-md-offset-2 col-md-8 col-md-offset-2" id="jdpjArea">
		<span style="font-weight: bold;font-size: large;">【套餐评价】：</span><br>

		<table class="table" width="600px" id="commentTable" >
			<thead>
			<th>评价编号</th>
			<th>评价内容</th>
			<th>评价星级</th>
			<th>评价日期</th>
			</thead>

			<tbody>

			</tbody>
		</table>


	</div>
</div>



<script>

	var roomId;
	$(function () {


		//为了设置日历上的起始时间获取当前时间
		var today = new Date();
		var ddToday = String(today.getDate()).padStart(2,'0');//padStart是指要固定两位数字，如果不够，在前面补充0
		var mmToday = String(today.getMonth() +1 ).padStart(2,'0');
		var yyyyToday = today.getFullYear();
		var currentDate =mmToday+'/'+ddToday+'/'+yyyyToday;


		//为日期表设置最大日期，默认是两个月后
		var maxTime=today.getTime()+60*24*60*60*1000;
		var maxDate=new Date(maxTime);
		var ddMaxDate = String(maxDate.getDate()).padStart(2,'0');//padStart是指要固定两位数字，如果不够，在前面补充0
		var mmMaxDate = String(maxDate.getMonth() +1 ).padStart(2,'0');
		var yyyyMaxDate = maxDate.getFullYear();
		var maxDateFinal =mmMaxDate+'/'+ddMaxDate+'/'+yyyyMaxDate;


		//初始化日历插件
		$('#date').daterangepicker({
			"singleDatePicker": true,
			"startDate":currentDate,
			"minDate":currentDate,
			"maxDate":maxDateFinal
		},function () {

		});


		/* 此方法查询所有的实名信息并将信息放入到页面中 */
		function selectRealName(element) {
			$.ajax({
				url:"${pageContext.request.contextPath}/selectRealNameByTravelUserId?travelUserId=${travelUser.travelUserId}",
				type:"get",
				success:function(result){
					$.each(result.extend.realNames,function(index,item){
						var option=$("<option></option>").append(item.realName).attr("value",item.realNameId);
						$(element).append(option);
					});
				}
			});
		}
		var loginUser="${travelUser}";//查看用户是否登录
		if(loginUser){//如果登陆了，就查询该用户对应的实名信息都有哪些
			selectRealName("#showRealNamesSelect");//将查询到的数据回显到下拉框中。
		}


		/* 这个方法专门负责根据状态改变输入框的颜色并且显示提示信息 */
		function showValidateMsg(ele,status,msg) {
			//清空上次的状态信息，否则会导致提示信息异常
			$(ele).parent().removeClass("has-success has-error");
			$(ele).next("span").text("");

			//判断参数然后做出响应
			if(status=="success"){
				$(ele).parent().addClass("has-success");
				$(ele).next("span").text(msg);
			}
			if(status=="error"){
				$(ele).parent().addClass("has-error");
				$(ele).next("span").text(msg);
			}
		}



		/* 此方法根据所选日期和房间类型进行查看，看是否有空房 */
		function checkHasRoom(element) {
			$.ajax({
				url:"${pageContext.request.contextPath}/checkHasRoomTaoCan?taoCanId=${taoCan.taoCanId}&date="+$("#date").val()+"",
				type:"get",
				success:function(result){
					if(result==0){

						showValidateMsg(element,"error","该时间段没有空房！");
						$("#purchaseTaoCan").attr("disabled",true);
						$("#addToCart").attr("disabled",true);
					}else{
						showValidateMsg(element,"success","");
						$("#purchaseTaoCan").attr("disabled",false);
						$("#addToCart").attr("disabled",false);
						roomId=result;//如果有空放，将返回的空房id用js全局变量保存起来
					}
				}
			});
		}
		$("#date").change(function () {//如果点击更换房型就触发
			checkHasRoom("#date");
		});
		$("#date").change();//进入页面就自动检查一次。


		//点击确认预约后生成订单
		$("#purchaseTaoCan").click(function () {
			var isLogin="${travelUser}";
			if(!isLogin){//如果没有登陆，就跳转到登录页面
				window.location.href="${pageContext.request.contextPath}/loginPage";
			}else{
				$.ajax({
					url:"${pageContext.request.contextPath}/purchaseTaoCan",
					type:"post",
					data:"travelUserId=${travelUser.travelUserId}&price=${taoCan.taoCanPrice}&realNameId="+$("#showRealNamesSelect").val()+"&taoCanId=${taoCan.taoCanId}&date="+$("#date").val()+"&roomId="+roomId+"",
					success:function(result){
						if(result.result==1){
							window.location.href="${pageContext.request.contextPath}/openPayPage";
						}else{
							alert("预定失败！");
						}
					}
				});
			}

		});
	});




	<%--/*发送ajax请求获取评价信息*/--%>
	<%--$.ajax({--%>
	<%--	url:"${pageContext.request.contextPath}/commentsByTaoCanId",--%>
	<%--	type:"get",--%>
	<%--	data:"taoCanId=${taoCan.taoCanId}",--%>
	<%--	success:function(result){--%>
	<%--		build_CommentList(result);--%>
	<%--	}--%>
	<%--});--%>


	<%--function build_CommentList(data) {//将json中的数据通过jquery遍历添加到table上显示出来--%>
	<%--	$("#commentTable tbody").empty();//清空上一次查询到的数据，防止重叠--%>

	<%--	var comments=data.extend.comments;--%>
	<%--	$.each(comments,function (index,item) {--%>
	<%--		var realNameTd=$("<td></td>").append(item.commentId);--%>
	<%--		var commentTextTd=$("<td></td>").append(item.commentText);--%>
	<%--		var commentStarTd=$("<td></td>").append(item.commentStar);--%>
	<%--		var commentDateTd=$("<td></td>").append(item.commentDate);--%>

	<%--		$("<tr></tr>").append(realNameTd).append(commentTextTd).append(commentStarTd).append(commentDateTd).appendTo("#commentTable tbody");--%>
	<%--	});--%>
	<%--}--%>




	</script>



<%--   随着鼠标下滑，到达一定高度之后，导航栏就固定在顶部--%>
<script type="text/javascript">
	$(function(){
		//获取要定位元素距离浏览器顶部的距离
		var navH = $("#div1").offset().top;
		// console.log(navH);
		//滚动条事件
		$(window).scroll(function(){
			//获取滚动条的滑动距离
			var scroH = $(this).scrollTop();
			// console.log(scroH);
			//滚动条的滑动距离大于等于定位元素距离浏览器顶部的距离，就固定，反之就不固定
			if(scroH>=navH){
				$("#div1").css({"position":"sticky","top":0});
			}else if(scroH<navH){
				$("#div1").css({"position":"static"});
			}
		})
	});
</script>
</body>
</html>