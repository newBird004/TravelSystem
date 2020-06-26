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

<%--	为了引入日期插件--%>
	<link href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/daterangepicker.css" />


    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	<script src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>

	<%--	为了引入日期插件--%>
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
				<img style="" src="${pageContext.request.contextPath}/img/Hotel/${hotel.hotelImage}" width="460px" height="360px">
			</div>

			<div class="col-md-6" style="margin-top: 40px;">
				<p style="font-size:large;margin-bottom: 10px">酒店名称：${hotel.hotelName}</p>
				<p style="font-size:large;margin-bottom: 10px">酒店简介：${hotel.hotelIntroduce}</p>
				<p style="font-size:large;margin-bottom: 10px">酒店房型：
					<select class="form-control" id="showRoomTypeSelect" style="width: 140px;margin-left: 90px">
					</select>
				</p>
				<p style="font-size:large;margin-bottom: 10px">价格：￥<span id="showRoomPrice"></span></p>

				<p style="font-size:large;margin-bottom: 10px">旅客信息：
					<select class="form-control" id="showRealNamesSelect" style="width: 140px;margin-left: 90px">
					</select>
				</p>
				<p style="font-size:large;margin-bottom: 10px">  预约日期：
                    <div class="input-group" style="width: 260px;margin-left: 90px">
                        <div class="input-group-addon"><span class="glyphicon glyphicon-calendar" aria-hidden="true"></span></div>
                        <input type="text" class="form-control" id="date" name="date" placeholder="date">
                        <span id="validateHasRoomMsg" class="help-block"></span>
                    </div>
				</p>


                <p style="font-size:large;margin-bottom: 10px">温馨提示：<span style="color: red">请注意您的出行日期！</span></p>
				<button id="purchaseHotel" class="btn btn-danger" style="margin-left: 80px">立即付款</button>
                <button id="addToCart" class="btn btn-success" style="margin-left: 10px">添加购物车</button>
			</div>
		</div>
	</div>

	<div class="container-fluid" style="margin-top: 26px">

		<div class="row" id="div1" style="margin-bottom: 20px;z-index: 1;font-weight: bolder;font-size: large;" >
			<div class="col-md-offset-2 col-md-8 col-md-offset-2" style="background-color: #e5e5e5;border-radius: 3px">
				<ul class="nav nav-tabs">
					<li role="presentation"><a href="#jdxq" style="color: black">酒店详情</a></li>
					<li role="presentation"><a href="#rzxz" style="color: black">入住须知</a></li>
					<li role="presentation"><a href="#jdpj" style="color: black">酒店评价</a></li>
				</ul>
			</div>
		</div>

		<div class="row" id="jdxq" style="margin-top: 20px">
			<div class="col-md-offset-2 col-md-8 col-md-offset-2" >
				<span style="font-weight: bold;font-size: large;">【酒店详情】：</span>
					${hotel.hotelIntroduce}
			</div>
		</div>


		<div class="row" id="rzxz" style="margin-top: 20px">
			<div class="col-md-offset-2 col-md-8 col-md-offset-2" >
				<span style="font-weight: bold;font-size: large;">【入住须知】：</span><br>


				1、酒店入住实行实名预约审核制，游客凭本人有效身份证件，提前1天以上填写“入住客人信息登记表”。<br>

				2、请您在到达景区前，提前通过“北京健康宝”小程序申领“健康码”，并请携带好本人身份证。本景区按照北京市相关部门不时发布的疫情防控要求核验相关资料，请您自行确认完全符合入园条件或入住条件。<br>

				3、建议您自驾前往古北水镇景区(司马台长城景区），以免因乘坐公共交通工具等原因而引起“健康码”的异常，影响您的入住。<br>

				4、请您在办理入住手续时，主动出示“健康码”及客房预订短信，接受体温检测和身份证核验，核验合格后，方可入理入住手续。对证件和核检证明缺失、不戴口罩、体温检测异常或不配合现场管理的游客景区将禁止入住。<br>

				5、游客游览过程中，请务必做好个人防护工作，离开客房即自觉戴口罩，配合景区工作人员的引领和管理，严禁扎堆聚集，保持1米距离，游玩后回到房间先洗手，房间内建议每2小时开窗通风。<br>

				6、请您就餐时不相对而坐，入住期间酒店/客栈可提供早餐送房服务，其余用餐需求可预约点餐和送餐服务。<br>

				7、古北水镇暂停使用已开放酒店、客栈和餐厅的中央空调和非独立循环的空气系统。<br>

				8、因疫情防控需要，景区将会采取更完善严密的管理措施，入住期间每天需至酒店前台测量体温，请予以理解并配合。<br>

				9、请您对本人所提供信息真实性负责，在游览途中一旦出现发热、咳嗽等身体不适情况的，请第一时间告知景区工作人员，也可拨打景区热线010-81009999咨询或拨打120请求救治。<br>

				10、根据疫情防控需要，景区管控措施、景区开放区域可能会有调整，并可能根据景区承载量实施限流措施，请关注景区官方公告，并配合工作人员的安排。<br>

				11、请广大游客朋友认真阅读《北京密云·古北水镇（司马台长城）国际旅游度假区游览须知》及防疫期间景区其他须知，遵守相关的法律法规，有序游览。<br>
				<br>
			</div>
		</div>




		<div class="row" id="jdpj" style="margin-top: 20px;margin-bottom: 100px">
			<div class="col-md-offset-2 col-md-8 col-md-offset-2" id="jdpjArea">
				<span style="font-weight: bold;font-size: large;">【酒店评价】：</span><br>

				<table class="table" width="600px" id="commentTable" >
					<thead>
						<th>评价编号</th>
						<th>评价内容</th>
						<th>评价星级</th>
						<th>评价日期</th>
					</thead>
					<tbody>
					<tr>

					</tr>

					</tbody>
				</table>

			</div>
		</div>
	</div>



	<script>
		$(function () {
            var roomId=null;

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

            //为了设置日历上的起始时间获取当前时间
            var today = new Date();
            var ddToday = String(today.getDate()).padStart(2,'0');//padStart是指要固定两位数字，如果不够，在前面补充0
            var mmToday = String(today.getMonth() +1 ).padStart(2,'0');
            var yyyyToday = today.getFullYear();
            var currentDate =mmToday+'/'+ddToday+'/'+yyyyToday;


            //为日期表中设置默认的结束日期，即开始日期的后一天
            var tomorrowTime=today.getTime()+24*60*60*1000;
            var tomorrow=new Date(tomorrowTime);
            var ddEndDate = String(tomorrow.getDate()).padStart(2,'0');//padStart是指要固定两位数字，如果不够，在前面补充0
            var mmEndDate = String(tomorrow.getMonth() +1 ).padStart(2,'0');
            var yyyyEndDate = tomorrow.getFullYear();
            var endDate =mmEndDate+'/'+ddEndDate+'/'+yyyyEndDate;


            //为日期表设置最大日期，默认是两个月后
            var maxTime=today.getTime()+60*24*60*60*1000;
            var maxDate=new Date(maxTime);
            var ddMaxDate = String(maxDate.getDate()).padStart(2,'0');//padStart是指要固定两位数字，如果不够，在前面补充0
            var mmMaxDate = String(maxDate.getMonth() +1 ).padStart(2,'0');
            var yyyyMaxDate = maxDate.getFullYear();
            var maxDateFinal =mmMaxDate+'/'+ddMaxDate+'/'+yyyyMaxDate;


            //初始化日历插件
            $('#date').daterangepicker({
                "startDate":currentDate,
                "endDate":endDate,
                "minDate":currentDate,
                "maxDate":maxDateFinal
            },function () {

            });
            // alert($("#date").val());

			/* 此方法查询所有的实名认证信息并将信息放入到页面中 */
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
            if(loginUser){//如果登陆了，就查询该用户对应的实名信息都有哪些并显示在页面上
                selectRealName("#showRealNamesSelect");//将查询到的数据回显到下拉框中。
            }


			/* 此方法查询所有的房型信息并将信息放入到页面中 */
			function selectRoomTypeByHotelId(element) {
				$.ajax({
					url:"${pageContext.request.contextPath}/selectRoomTypeByHotelId?hotelId=${hotel.hotelId}",
					type:"get",
                    async:false,
					success:function(result){
						$.each(result.extend.roomTypes,function(index,item){
							var option=$("<option></option>").append(item).attr("value",item);
							$(element).append(option);
						});

						/*不知道为啥，在这里就能获取到那个房间类型下拉框的value值，一到了这个方法外面就获取不到*/
                        // alert($(element).val());
                        // selectPriceByHotelIdAndRoomType("#showRoomPrice");//这个代码放在这里就是根据酒店id和房间类型查询价格并显示出来。
					}
				});
			}
            selectRoomTypeByHotelId("#showRoomTypeSelect");//将查询到的数据回显到下拉框中。

            // alert($("#showRoomTypeSelect").val());//很奇怪。在这里就拿不到房型下拉框中的值。但是在selectRoomTypeByHotelId这个方法中就能拿到。
			/*我好像知道了。因为selectRoomTypeByHotelId这个方法发出ajax请求，速度很慢。
			所以在方法外面alert下拉框的值的时候，这个下拉框还没有从controller中得到数据。所以为null。
			可以通过设置该ajax请求为同步请求，即 设置async:false 这样就会在ajax请求外也能拿到数据了
			*/



            /* 此方法根据房型信息和酒店id查询到对应价格并显示 */
            function selectPriceByHotelIdAndRoomType(element) {
                $.ajax({
                    url:"${pageContext.request.contextPath}/selectPriceByHotelIdAndRoomType?hotelId=${hotel.hotelId}&roomType="+$("#showRoomTypeSelect").val()+"",
                    type:"get",
                    success:function(result){
                        $(element).text(result);
                    }
                });
            }
            $("#showRoomTypeSelect").change(function () {//如果点击更换房型就触发
                // alert($("#showRoomTypeSelect").val());
                selectPriceByHotelIdAndRoomType("#showRoomPrice");
            });
            selectPriceByHotelIdAndRoomType("#showRoomPrice");



            /* 此方法根据所选日期和房间类型进行查看，看是否有空房 */
            function checkHasRoom(element) {
                $.ajax({
                    url:"${pageContext.request.contextPath}/checkHasRoom?hotelId=${hotel.hotelId}&roomType="+$("#showRoomTypeSelect").val()+"&date="+$("#date").val()+"",
                    type:"get",
                    success:function(result){
                        if(result==0){
                            showValidateMsg(element,"error","该时间段没有空房！");
                            $("#purchaseHotel").attr("disabled",true);
							$("#addToCart").attr("disabled",true);
                        }else{
                            showValidateMsg(element,"success","");
                            $("#purchaseHotel").attr("disabled",false);
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
			$("#purchaseHotel").click(function () {
			    var isLogin="${travelUser}";
			    if(!isLogin){//如果没有登陆，就跳转到登录页面
			        window.location.href="${pageContext.request.contextPath}/loginPage";
                }else{
                    $.ajax({
                        url:"${pageContext.request.contextPath}/purchaseHotel",
                        type:"post",
                        data:"travelUserId=${travelUser.travelUserId}&price="+$("#showRoomPrice").text()+"&realNameId="+$("#showRealNamesSelect").val()+"&roomId="+roomId+"&date="+$("#date").val()+"",
                        success:function(result){
                            if(result.result==1){
                                window.location.href="${pageContext.request.contextPath}/openPayPage";
                            }else{
                                alert("失败！");
                            }
                        }
                    });
                }
            });


            //点击加入购物车
            $("#addToCart").click(function () {
                var isLogin="${travelUser}";
                if(!isLogin){//如果没有登陆，就跳转到登录页面
                    window.location.href="${pageContext.request.contextPath}/loginPage";
                }else{
                    $.ajax({
                        url:"${pageContext.request.contextPath}/addHotelToCart",
                        type:"post",
                        data:"travelUserId=${travelUser.travelUserId}&price="+$("#showRoomPrice").text()+"&realNameId="+$("#showRealNamesSelect").val()+"&hotelId=${hotel.hotelId}&roomType="+$("#showRoomTypeSelect").val()+"&date="+$("#date").val()+"",
                        success:function(result){
                            if(result.result==1){
                                alert("添加成功！");
                            }else{
                                alert("失败！");
                            }
                        }
                    });
                }
            });

		});


		$.ajax({
			url:"${pageContext.request.contextPath}/commentsByHotelId",
			type:"get",
			data:"hotelId=${hotel.hotelId}",
			success:function(result){
				build_CommentList(result);
			}
		});

		function build_CommentList(data) {//将json中的数据通过jquery遍历添加到table上显示出来
			$("#commentTable tbody").empty();//清空上一次查询到的数据，防止重叠

			var comments=data.extend.comments;
			$.each(comments,function (index,item) {
				var realNameTd=$("<td></td>").append(item.commentId);
				var commentTextTd=$("<td></td>").append(item.commentText);
				var commentStarTd=$("<td></td>").append(item.commentStar);
				var commentDateTd=$("<td></td>").append(item.commentDate);


				$("<tr></tr>").append(realNameTd).append(commentTextTd).append(commentStarTd).append(commentDateTd).appendTo("#commentTable tbody");
			});
		}
	</script>

	<%--	随着鼠标下滑，到达一定高度之后，导航栏就固定在顶部--%>
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