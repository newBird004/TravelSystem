<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
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
    <%--	为了引入日期插件--%>
    <script src="${pageContext.request.contextPath}/assets/js/moment.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/daterangepicker.js"></script>

    <%--	为了引入日期插件--%>
    <link href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/daterangepicker.css" />
    <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
</head>
<body>

    <div id="head"></div>
    <script>
        $("#head").load("header.jsp");
    </script>

    <!-- 按钮 -->
    <div class="row">
        <div class="col-md-3 col-md-offset-9">&nbsp;&nbsp;
            <button type="button" class="btn btn-default" id="cartDeleteModalBtn">批量删除</button>
        </div>
    </div>

    <!-- 表格数据 -->
    <div class="row">
        <div class="col-md-11 col-md-offset-1">
            <table class="table" id="cartTable" >
                <thead>
                <tr>
                    <th>
                        <input type="checkbox" id="checkAll">
                    </th>
                    <th>购物车编号</th>
                    <th>商品名称</th>
                    <th>出行旅客</th>
                    <th>出行日期</th>
                    <th>结束日期</th>
                    <th>价格</th>
                </tr>
                </thead>

                <tbody>

                </tbody>
            </table>
        </div>

    </div>


    <div class="row" style="margin-bottom: 100px">
        <div class="col-md-offset-8 col-md-4" >
            <span style="font-weight: bold" >所选择商品共￥<span id="cartPrice"></span>元</span>&nbsp;&nbsp;
            <button id="cartToPay"  type="button" class="btn btn-success">去结算</button>
        </div>
    </div>


    <%--负责修改酒店信息模态框--%>
    <div class="modal fade" id="cartUpdateModalHotel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2">
        <div class="modal-dialog" role="document">
            <div class="modal-content">

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel2">修改酒店预定信息</h4>
                </div>

                <div class="modal-body">
                    <form class="form-horizontal" id="updateCartModalHotel">
<%--                        修改出行人信息--%>
                        <div class="form-group">
                            <label for="updateRealNameHotel"  class="col-sm-2 control-label">出行旅客</label>
                            <div class="input-group col-sm-10" style="width: 260px;margin-left: 100px">
                                <select class="form-control" id="updateRealNameHotel" name="realNameId_FK_Cart" >
                                </select>
                            </div>
                        </div>
                        <!-- 修改出行日期 -->
                        <div class="form-group">
                            <label for="updateDateHotel"  class="col-sm-2 control-label">出行日期</label>

                            <div class="input-group col-sm-10" style="width: 260px;margin-left: 100px">
                                <div class="input-group-addon"><span class="glyphicon glyphicon-calendar" aria-hidden="true"></span></div>
                                <input type="text" class="form-control" id="updateDateHotel" name="date" placeholder="date">
                                <span id="validateHasRoomMsg" class="help-block"></span>
                            </div>
                        </div>

                        <!-- 房间类型 -->
                        <div class="form-group" >
                            <label for="updateRoomTypeHotel"  class="col-sm-2 control-label">房间类型</label>
                            <div class="input-group col-sm-10" style="width: 260px;margin-left: 100px">
                                <select class="form-control" id="updateRoomTypeHotel" name="roomType">
                                </select>
                            </div>
                        </div>
                    </form>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="cartUpdateSaveBtnHotel">保存</button>
                </div>

            </div>
        </div>
    </div>


    <%--负责修改景点信息模态框--%>
    <div class="modal fade" id="cartUpdateModalScenic" tabindex="-1" role="dialog" aria-labelledby="myModalLabel3">
        <div class="modal-dialog" role="document">
            <div class="modal-content">

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel3">修改酒店预定信息</h4>
                </div>

                <div class="modal-body">
                    <form class="form-horizontal" id="updateCartModalScenic">
                        <%--                        修改出行人信息--%>
                        <div class="form-group">
                            <label for="updateRealNameHotel"  class="col-sm-2 control-label">出行旅客</label>
                            <div class="input-group col-sm-10" style="width: 260px;margin-left: 100px">
                                <select class="form-control" id="updateRealNameScenic" name="realNameId_FK_Cart" >
                                </select>
                            </div>
                        </div>
                        <!-- 修改出行日期 -->
                        <div class="form-group">
                            <label for="updateDateScenic"  class="col-sm-2 control-label">出行日期</label>

                            <div class="input-group col-sm-10" style="width: 260px;margin-left: 100px">
                                <div class="input-group-addon"><span class="glyphicon glyphicon-calendar" aria-hidden="true"></span></div>
                                <input type="text" class="form-control" id="updateDateScenic" name="cartStartDate" placeholder="date">
                            </div>
                        </div>

                    </form>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="cartUpdateSaveBtnScenic">保存</button>
                </div>

            </div>
        </div>
    </div>



    <script type="text/javascript">
        var hotelId;

        $(function () {//默认显示第一页的数据
            to_page();


            function build_CartList(data) {//将json中的数据通过jquery遍历添加到table上显示出来

                $("#cartTable tbody").empty();//清空上一次查询到的数据，防止重叠

                var carts=data.extend.cartMsgs;

                $.each(carts,function (index,item) {
                    var checkTd=$("<td><input type='checkbox' class='cart_check'/></td>");
                    var cartId=$("<td></td>").append(item.cartId);
                    var realName=$("<td></td>").append(item.realName);
                    var goodsName=$("<td></td>").append(item.goodsName);

                    var startDate=$("<td></td>").append(item.startDate);
                    var endDate=$("<td></td>").append(item.endDate);
                    var goodsPrice=$("<td></td>").append(item.goodsPrice);


                    var editBtnTd=$("<button></button>")
                        .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).addClass("btn btn-primary btn-sm edit_btn").append("修改").attr("cartId_Update",item.cartId);
                    var deleteBtnTd=$("<button></button>")
                        .append($("<span></span>").addClass("glyphicon glyphicon-trash")).addClass("btn btn-danger btn-sm delete_btn").append("删除").attr("cartId_Delete",item.cartId);
                    var btnTd=$("<td></td>").append(editBtnTd).append(" ").append(deleteBtnTd);

                    $("<tr></tr>").append(checkTd).append(cartId).append(goodsName).append(realName).append(startDate).append(endDate).append(goodsPrice).append(btnTd).appendTo("#cartTable tbody");
                });
            }


            /* 发送ajax请求，然后获取到数据，并调用方法构建数据表*/
            function to_page() {
                $.ajax({
                    url:"${APP_PATH}/loadCartList",
                    data:"travelUserId=${travelUser.travelUserId}",
                    type:"get",
                    success:function(data){
                        build_CartList(data);
                    }
                });
            }




            /* 此方法查询所有的实名信息并将信息放入到修改模态框中 */
            function selectRealName(element) {
                $("#updateRealNameHotel").empty();//每次加载前清空以下之前的数据。
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
                selectRealName("#updateRealNameHotel");//将查询到的数据回显到下拉框中。
                selectRealName("#updateRealNameScenic");//将查询到的数据回显到下拉框中。
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



            /*修改酒店信息模态框中的日历表*/
            $('#updateDateHotel').daterangepicker({
                "startDate":currentDate,
                "endDate":endDate,
                "minDate":currentDate,
                "maxDate":maxDateFinal
            },function () {

            });
            /*修改景点信息模态框中的日历表*/
            $('#updateDateScenic').daterangepicker({
                "singleDatePicker": true,
                "startDate":currentDate,
                "minDate":currentDate,
                "maxDate":maxDateFinal
            },function () {

            });


            /* 打开修改信息的模态框 */
            $(document).on("click",".edit_btn",function() {
                /*将id放入确认修改按钮的自定义属性中，一会儿点击确定修改需要这个cartId属性值 */
                $("#cartUpdateSaveBtnHotel").attr("cartId",$(this).attr("cartId_Update"));
                $("#cartUpdateSaveBtnScenic").attr("cartId",$(this).attr("cartId_Update"));


                /*为了根据所点击的修改按钮获取到酒店id*/
                $.ajax({
                    url:"${pageContext.request.contextPath}/selectHotelIdByCartId?cartId="+$(this).attr("cartId_Update")+"",
                    type:"post",
                    async:false,
                    success:function(result){
                        hotelId=result;
                    }
                });

                /* 此方法查询所有的房型信息并将信息放入到模态框中 */
                $("#updateRoomTypeHotel").empty();//每次向房型信息下拉框中添加数据前，清空之前的数据，防止叠加。
                $.ajax({
                    url:"${pageContext.request.contextPath}/selectRoomTypeByCartId?cartId="+$(this).attr("cartId_Update")+"",
                    type:"get",
                    async:false,
                    success:function(result){
                        $.each(result.extend.roomTypes,function(index,item){
                            var option=$("<option></option>").append(item).attr("value",item);
                            $("#updateRoomTypeHotel").append(option);
                        });
                    }
                });


                /* 数据回显 */
                $.ajax({
                    url:"${APP_PATH}/selectCartMsgById?cartId="+$(this).attr("cartId_Update")+"",
                    type:"post",
                    async:false,
                    success:function(result){//根据拿到的信息显示到模态框中
                        var goodsType=result.extend.goodsType;
                        var data=result.extend.cart;
                        if(goodsType==1){//景点信息

                            /*进行数据回显*/
                            $("#updateRealNameScenic").val(data.realNameId_FK_Cart);
                            $("#updateDateScenic").val(data.cartStartDate);
                            /* 打开景点信息修改模态框 */
                            $('#cartUpdateModalScenic').modal(
                                {
                                    backdrop:false
                                });

                        }else {//酒店信息

                            /*进行数据回显*/
                            $("#updateRealNameHotel").val(data.realNameId_FK_Cart);
                            $("#updateDateHotel").val(data.cartStartDate+" - "+data.cartEndDate);
                            $("#updateRoomTypeHotel").val(data.roomType);


                            // alert($("#updateDateHotel").val());


                            /* 打开酒店信息修改模态框 */
                            $('#cartUpdateModalHotel').modal(
                                {
                                    backdrop:false
                                });
                        }

                    }
                });

                checkHasRoom("#updateDateHotel");

            });
            /* 此方法根据所选日期和房间类型进行查看，看是否有空房 */
            function checkHasRoom(element) {
                $.ajax({
                    url:"${pageContext.request.contextPath}/checkHasRoom?hotelId="+hotelId+"&roomType="+$("#updateRoomTypeHotel").val()+"&date="+$("#updateDateHotel").val()+"",
                    type:"get",
                    async:false,
                    success:function(result){

                        if(result==0){
                            showValidateMsg(element,"error","该时间段没有空房！");
                            $("#cartUpdateSaveBtnHotel").attr("disabled",true);
                        }else{
                            showValidateMsg(element,"success","");
                            $("#cartUpdateSaveBtnHotel").attr("disabled",false);
                            roomId=result;//如果有空放，将返回的空房id用js全局变量保存起来
                        }
                    }
                });
            }

            $("#updateDateHotel").change(function () {//如果点击更换房型就触发
                checkHasRoom("#updateDateHotel");
            });



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






            /*
            *   修改模态框中点击保存完成信息的修改
            *
            * */
            //点击保存时候发送ajax进行保存
            $("#cartUpdateSaveBtnHotel").click(function() {//修改用户时点击保存

                $.ajax({
                    url:"${APP_PATH}/cartHotel/"+$(this).attr("cartId"),
                    type:"PUT",
                    data:$("#cartUpdateModalHotel form").serialize(),//这个方法能够将表单中的数据全部转换成字符串。不用我们一个一个获取了

                    success:function(result){
                        alert("修改成功！");
                        //修改成功后关闭模态框
                        $("#cartUpdateModalHotel").modal("hide");
                        //跳转到对应的页面
                        to_page();
                    }
                });
            });
            //点击保存时候发送ajax进行保存
            $("#cartUpdateSaveBtnScenic").click(function() {//修改用户时点击保存
                $.ajax({
                    url:"${APP_PATH}/cartScenic/"+$(this).attr("cartId"),
                    type:"PUT",
                    data:$("#cartUpdateModalScenic form").serialize(),//这个方法能够将表单中的数据全部转换成字符串。不用我们一个一个获取了

                    success:function(result){
                        alert("修改成功！");
                        //修改成功后关闭模态框
                        $("#cartUpdateModalScenic").modal("hide");
                        //跳转到对应的页面
                        to_page();
                    }
                });
            });










            /* 打开删除信息 */
            $(document).on("click",".delete_btn",function() {
                var deleteName=$(this).parents("tr").find("td:eq(2)").text();
                var deleteId=$(this).attr("cartId_Delete");
                if(confirm("确认要删除"+deleteName+"吗？")){
                    $.ajax({
                        url:"${APP_PATH}/cart/"+deleteId,
                        type:"DELETE",
                        success:function(result){//根据拿到的信息显示到模态框中
                            if(result.result==1){//删除成功
                                alert(result.message);
                            }else {
                                alert(result.message);
                            }
                            to_page();
                        }
                    });
                }
            });

            /* 全选全不选的功能 */
            $("#checkAll").click(function() {
                $(".cart_check").prop("checked",$(this).prop("checked"));
            });

            /* 继续完善全选全不选的功能 */
            $(document).on("click",".cart_check",function (){
                if($(".cart_check:checked").length==$(".cart_check").length){
                    $("#checkAll").prop("checked",true);
                }else{
                    $("#checkAll").prop("checked",false);
                }
            });

            /*
            * 点击删除按钮进行的动作，删除多个
            * */
            $("#cartDeleteModalBtn").click(function () {
                var deleteNameStr="";
                var deleteIdStr="";
                $.each($(".cart_check:checked"),function(){//遍历已经勾选的每个元素，并将勾选中的元素中的名字和id分别放入字符串中
                    deleteNameStr+=$(this).parents("tr").find("td:eq(2)").text()+",";
                    deleteIdStr+=$(this).parents("tr").find("td:eq(1)").text()+"-";
                });
                //去除多余的最后一个逗号
                deleteNameStr=deleteNameStr.substring(0,deleteNameStr.length-1);
                //去除多余的最后一个-号
                deleteIdStr=deleteIdStr.substring(0,deleteIdStr.length-1);

                //弹出确认框
                if(confirm("你确认要删除【"+deleteNameStr+"】嘛?")){
                    //发出删除的ajax请求
                    $.ajax({
                        url:"${APP_PATH}/cart/"+deleteIdStr,
                        type:"DELETE",
                        success:function(result){//根据拿到的信息显示到模态框中
                            if(result.result==1){//删除成功
                                alert(result.message);//弹出操作信息
                            }else {
                                alert(result.message);//弹出操作信息
                            }

                            $("#checkAll").prop("checked",false);//取消勾选全选按钮
                            to_page();
                        }
                    });
                }
            });





            /* 发送请求获取价格 */
            $(document).on("click",".cart_check",function (){
                var checkedIdStr="";
                $.each($(".cart_check:checked"),function(){//遍历已经勾选的每个元素，并将勾选中的元素中的名字和id分别放入字符串中
                    checkedIdStr+=$(this).parents("tr").find("td:eq(1)").text()+"-";
                });
                //去除多余的最后一个-号
                checkedIdStr=checkedIdStr.substring(0,checkedIdStr.length-1);

                $.ajax({
                    url:"${APP_PATH}/computeCheckedCartPrice?checkedIdStr="+checkedIdStr+"",
                    type:"post",
                    success:function(result){//根据拿到的信息显示到模态框中
                        $("#cartPrice").text(result);
                    }
                });

            });

            /*全选时的价格 */
            $("#checkAll").click(function() {
                $.ajax({
                    url:"${APP_PATH}/computeAllCheckedCartPrice?travelUserId=${travelUser.travelUserId}",
                    type:"post",
                    success:function(result){//根据拿到的信息显示到模态框中
                        $("#cartPrice").text(result);
                    }
                });

            });



            $("#cartToPay").click(function () {
                var checkedIdStr="";
                $.each($(".cart_check:checked"),function () {
                    checkedIdStr+=$(this).parents("tr").find("td:eq(1)").text()+"-";
                });

                /*防止什么都没勾选*/
                if(checkedIdStr==""){
                    alert("请勾选要购买的商品！");
                    return false;
                }
                //去除多余的最后一个-号
                checkedIdStr=checkedIdStr.substring(0,checkedIdStr.length-1);

                $.ajax({
                    url:"${APP_PATH}/cartToPay?checkedIdStr="+checkedIdStr+"",
                    type:"post",
                    success:function(result){//根据拿到的信息显示到模态框中
                        if(result==1){
                            window.location.href="${pageContext.request.contextPath}/openPayCartPage";
                            to_page();//刷新页面
                        }else {
                            alert(result);
                        }
                    }
                });
            });

        });

    </script>
    </body>
</html>