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

    <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
</head>
<body>
<!-- 标题 -->
<div class="row">
    <div class="col-md-12" style="font-size: 20px;background-color:black; border-radius:20px;margin-bottom: 5px">
        <span style="color: #FFFFFF">&nbsp;&nbsp;个人订单</span>&nbsp;&nbsp;
    </div>
</div>
<!-- 按钮 -->
<div class="row">
    <div class="col-md-4 col-md-offset-8">
        <input type="text" placeholder="输入要搜索的订单ID" id="inputOrderIdToSearch">
        <button type="button" class="btn btn-default" id="selectOrderByCondition">按条件搜索</button>
    </div>
</div>
<!-- 表格数据 -->
<div class="row">
    <div class="col-md-12">
        <table class="table" id="orderTable">
            <thead>
            <tr>
                <th>订单编号</th>
                <th>购买用户</th>
                <th>下单日期</th>
                <th>订单价格</th>
                <th>支付状态</th>
            </tr>
            </thead>

            <tbody>

            </tbody>
        </table>
    </div>

</div>
<!-- 分页信息 -->
<div class="row">
    <div class="col-md-6" id="pageInfo" style="font-size: 20px">

    </div>
    <div class="col-md-6" id="pageNav">

    </div>
</div>


<%--点击查看详情打开这个模态框显示子订单详情--%>
<div class="modal fade"  id="orderUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2">
    <div class="modal-dialog" style="width: 1000px" role="document">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel2">订单详情</h4>
            </div>

            <div class="modal-body">

                <table class="table" id="orderDetailTable" >
                    <thead>
                        <tr>
                            <th>子订单编号</th>
                            <th>实名信息</th>
                            <th>商品名称</th>
                            <th>子订单价格</th>
                            <th>预定开始日期</th>
                            <th>预定到期日期</th>
                            <th>子订单生成日期</th>
                            <th>支付状态</th>
                        </tr>
                    </thead>

                    <tbody>

                    </tbody>
                </table>

            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
            </div>

        </div>
    </div>
</div>




<script type="text/javascript">

    var currentPage;
    var lastPage;

    $(function () {//默认显示第一页的数据
        to_page(1);
    });

    /*加载所有订单数据*/
    function build_OrderList(data) {//将json中的数据通过jquery遍历添加到table上显示出来
        $("#orderTable tbody").empty();//清空上一次查询到的数据，防止重叠

        var orders=data.extend.pageInfo.list;
        $.each(orders,function (index,item) {
            var orderIdTd=$("<td></td>").append(item.orderId);
            var travelUserIdTd=$("<td></td>").append(item.travelUserId_FK_Orders);
            var orderDateTd=$("<td></td>").append(item.orderDate);
            var orderPriceTd=$("<td></td>").append(item.orderPrice);
            var orderStatusTd=$("<td></td>").append(item.orderStatus==1?"已支付":"仍未支付");

            if(item.orderStatus==0){
                var editBtnTd=$("<button></button>")
                    .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).addClass("btn btn-primary btn-sm edit_btn").append("查看详情").attr("orderId_Update",item.orderId);
                var cancelBtnTd=$("<button></button>")
                    .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).addClass("btn btn-danger btn-sm cancelOrder_btn").append("取消订单").attr("orderId_CancelOrder",item.orderId);
                var btnTd=$("<td></td>").append(editBtnTd).append(" ").append(cancelBtnTd);
            }else if(item.orderStatus==1){
                var editBtnTd=$("<button></button>")
                    .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).addClass("btn btn-primary btn-sm edit_btn").append("查看详情").attr("orderId_Update",item.orderId);
                var btnTd=$("<td></td>").append(editBtnTd);
            }


            $("<tr></tr>").append(orderIdTd).append(travelUserIdTd).append(orderDateTd).append(orderPriceTd).append(orderStatusTd).append(btnTd).appendTo("#orderTable tbody");
        });
    }

    /*根据订单编号和用户编号搜索该用户自己的订单*/
    $("#selectOrderByCondition").click(function () {
        if($("#inputOrderIdToSearch").val()==""){
            alert("请输入要查询的订单编号！");
            return false;
        }
        $.ajax({
            url:"${APP_PATH}/selectPersonalOrderById?orderId="+$("#inputOrderIdToSearch").val()+"&travelUserId=${travelUser.travelUserId}",
            type:"GET",
            success:function(result){//根据拿到的信息显示到模态框中
                if(result.extend.orderById.orderId==undefined){
                    alert("未查找到结果！");
                    to_page(currentPage);
                }else {
                    build_OrderListByOrderId(result);
                }
            }
        });
    });

    /*根据订单编号查询到的数据显示到页面上*/
    function build_OrderListByOrderId(data) {//将json中的数据通过jquery遍历添加到table上显示出来
        $("#orderTable tbody").empty();//清空上一次查询到的数据，防止重叠

        var orderById=data.extend.orderById;

            var orderIdTd=$("<td></td>").append(orderById.orderId);
            var travelUserIdTd=$("<td></td>").append(orderById.travelUserId_FK_Orders);
            var orderDateTd=$("<td></td>").append(orderById.orderDate);
            var orderPriceTd=$("<td></td>").append(orderById.orderPrice);
            var orderStatusTd=$("<td></td>").append(orderById.orderStatus==1?"已支付":"仍未支付");

        if(orderById.orderStatus==0){
            var editBtnTd=$("<button></button>")
                .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).addClass("btn btn-primary btn-sm edit_btn").append("查看详情").attr("orderId_Update",orderById.orderId);
            var cancelBtnTd=$("<button></button>")
                .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).addClass("btn btn-danger btn-sm cancelOrder_btn").append("取消订单").attr("orderId_CancelOrder",orderById.orderId);
            var btnTd=$("<td></td>").append(editBtnTd).append(" ").append(cancelBtnTd);
        }else if(orderById.orderStatus==1){
            var editBtnTd=$("<button></button>")
                .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).addClass("btn btn-primary btn-sm edit_btn").append("查看详情").attr("orderId_Update",orderById.orderId);
            var btnTd=$("<td></td>").append(editBtnTd);
        }

        $("<tr></tr>").append(orderIdTd).append(travelUserIdTd).append(orderDateTd).append(orderPriceTd).append(orderStatusTd).append(btnTd).appendTo("#orderTable tbody");
    }


    //显示分页信息（左下角的那个）
    function build_PageInfo(result) {
        $("#pageInfo").empty();//清空上一次查询到的数据，防止重叠

        var info=result.extend.pageInfo;
        $("#pageInfo").append("当前在"+info.pageNum+"页,总共"+info.pages+"页,共"+info.total+"条数据");

        currentPage=info.pageNum;//为全局变量赋值。是为了修改模态框中修改完数据跳转到对应的页面去。
        lastPage=info.pages;
    }

    /*构建分页条*/
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
            url:"${APP_PATH}/loadPersonOrderList",
            data:"pn="+pn+"&travelUserId=${travelUser.travelUserId}",
            type:"get",
            success:function(data){
                /*
                     1、解析json数据，显示该用户的所有订单
                     2、解析json数据，显示分页信息
                     3、解析json数据，显示分页条
                */
                build_OrderList(data);
                build_PageInfo(data);
                build_PageNav(data);
            }
        });
    }


    /* 打开订单详情模态框 */
    $(document).on("click",".edit_btn",function() {

        /* 数据回显 */
        selectByIdAndShow($(this).attr("orderId_Update"));//从修改按钮的自定义属性中拿到id值。

        /* 打开修改模态框 */
        $('#orderUpdateModal').modal(
            {
                backdrop:false
            });
    });

    /* 根据id查找对应的子订单信息并进行回显 */
    function selectByIdAndShow(id) {
        $.ajax({
            url:"${APP_PATH}/order/"+id,
            type:"GET",
            success:function(result){//根据拿到的信息显示到模态框中
                build_OrderDetailList(result);
            }
        });
    }

    /*向模态框中的那个表格中动态添加子订单的数据*/
    function build_OrderDetailList(data) {//将json中的数据通过jquery遍历添加到table上显示出来

        $("#orderDetailTable tbody").empty();//清空上一次查询到的数据，防止重叠

        var orderItems=data.extend.orderItems;

            $.each(orderItems,function (index,item) {
                var orderItemIdTd=$("<td></td>").append(item.orderItemId);
                var realNameTd=$("<td></td>").append(item.realName);
                var goodsNameTd=$("<td></td>").append(item.goodsName);
                var orderItemPrice=$("<td></td>").append(item.orderItemPrice);
                var orderItemStartDate=$("<td></td>").append(item.orderItemStartDate);
                var orderItemEndDate=$("<td></td>").append(item.orderItemEndDate);
                var orderItemCreateDate=$("<td></td>").append(item.orderItemCreateDate);
                var orderItemStatus=$("<td></td>").append(item.orderItemPayStatus==1?"已支付":"仍未支付");

                $("<tr></tr>").append(orderItemIdTd).append(realNameTd).append(goodsNameTd).append(orderItemPrice).append(orderItemStartDate).append(orderItemEndDate).append(orderItemCreateDate).append(orderItemStatus).appendTo("#orderDetailTable tbody");
            });

    }


    /* 用户点击取消未支付订单时 */
    $(document).on("click",".cancelOrder_btn",function() {

        if(confirm("您确认要取消该订单吗？")){
            $.ajax({
                url:"${APP_PATH}/cancelUnPaidOrder/"+$(this).attr("orderId_CancelOrder"),
                type:"DELETE",
                success:function(result){
                    if(result.result==1){
                        alert("订单取消成功");
                        to_page(currentPage);
                    }else {
                        alert("取消失败！")
                    }
                }
            });
        }


    });
</script>
</body>
</html>