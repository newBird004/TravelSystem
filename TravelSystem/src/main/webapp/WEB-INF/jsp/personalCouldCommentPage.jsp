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

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/commentStarUtil/starability-minified/starability-all.min.css"/>
    <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
</head>
<body>
<!-- 标题 -->
<div class="row">
    <div class="col-md-12" style="font-size: 20px;background-color:black; border-radius:20px;margin-bottom: 5px">
        <span style="color: #FFFFFF">&nbsp;&nbsp;可评价订单</span>&nbsp;&nbsp;
    </div>
</div>

<!-- 表格数据 -->
<div class="row">
    <div class="col-md-12">
        <table class="table" id="orderTable" >
            <thead>
            <tr>
                <th>订单编号</th>
                <th>实名信息</th>
                <th>商品名称</th>
                <th>子订单价格</th>
                <th>预定开始日期</th>
                <th>预定到期日期</th>
                <th>子订单生成日期</th>
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
<div class="modal fade"  id="commentModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2">
    <div class="modal-dialog" style="width: 1000px" role="document">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel2">评价内容</h4>
            </div>

            <div class="modal-body">
                <form id="commentForm">
                    <div class="form-group">
                        <label >评论星级</label>
                        <%--                        <input id="inputCommentStar" class="form-control" >--%>
                        <fieldset class="starability-basic">
                            <input type="radio" id="first-rate5" name="rating" value="5" />
                            <label for="first-rate5" title="Amazing">5 stars</label>
                            <input type="radio" id="first-rate4" name="rating" value="4" />
                            <label for="first-rate4" title="Very good">4 stars</label>
                            <input type="radio" id="first-rate3" name="rating" value="3" />
                            <label for="first-rate3" title="Average">3 stars</label>
                            <input type="radio" id="first-rate2" name="rating" value="2" />
                            <label for="first-rate2" title="Not good">2 stars</label>
                            <input type="radio" id="first-rate1" name="rating" value="1" />
                            <label for="first-rate1" title="Terrible">1 star</label>
                        </fieldset>

                    </div>

                    <div class="form-group">
                        <label for="inputComment">评论内容</label>
                        <textarea name="inputComment"  id="inputComment" class="form-control" style="resize:none;height: 200px" placeholder="请在此输入您的评论"></textarea>
                    </div>
                </form>

            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-default" id="submitComment">确定提交</button>
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


    /*加载所有可以评价的订单数据*/
    function build_OrderList(data) {//将json中的数据通过jquery遍历添加到table上显示出来
        $("#orderTable tbody").empty();//清空上一次查询到的数据，防止重叠

        var orders=data.extend.orderItemCustoms;
        $.each(orders,function (index,item) {
            var orderId_FK_OrderItemTd=$("<td></td>").append(item.orderId_FK_OrderItem);
            var realNameTd=$("<td></td>").append(item.realName);
            var goodsNameTd=$("<td></td>").append(item.goodsName);
            var orderItemPrice=$("<td></td>").append(item.orderItemPrice);
            var orderItemStartDate=$("<td></td>").append(item.orderItemStartDate);
            var orderItemEndDate=$("<td></td>").append(item.orderItemEndDate);
            var orderItemCreateDate=$("<td></td>").append(item.orderItemCreateDate);

            var commentBtnTd=$("<button></button>")
                    .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).addClass("btn btn-primary btn-sm edit_btn").append("立即评价").attr("orderId_Update",item.orderItemId);
            var btnTd=$("<td></td>").append(commentBtnTd);

            $("<tr></tr>").append(orderId_FK_OrderItemTd).append(realNameTd).append(goodsNameTd).append(orderItemPrice).append(orderItemStartDate).append(orderItemEndDate).append(orderItemCreateDate).append(btnTd).appendTo("#orderTable tbody");
        });
    }

    /* 传入页数，就能够发送ajax请求，然后获取到数据，并调用方法分别构建数据表，分页信息，分页条 */
    function to_page() {
        $.ajax({
            url:"${APP_PATH}/loadCouldCommentOrderList",
            data:"travelUserId=${travelUser.travelUserId}",
            type:"get",
            success:function(data){
                /*
                     1、解析json数据，显示该用户可以评价的所有订单
                */
                build_OrderList(data);
            }
        });
    }


    /* 打开评价模态框 */
    $(document).on("click",".edit_btn",function() {

        $("#submitComment").attr("commentOrderItemId",$(this).attr("orderId_Update"));

        /*重置表单，清空上一次输入的数据*/
        $("#commentForm")[0].reset();
        /* 打开评价模态框 */
        $('#commentModal').modal(
            {
                backdrop:false
            });

    });


   $("#submitComment").click(function () {

       $.ajax({
           url:"${APP_PATH}/commentSubmit",
           data:$("#commentForm").serialize()+"&orderItemId="+$(this).attr("commentOrderItemId")+"",
           type:"post",
           success:function(data){
              if(data==1){
                  //修改成功后关闭模态框
                  alert("评价成功！");
                  $("#commentModal").modal("hide");
                  to_page();
              }else if(data==0){
                  alert("评价失败！请仔细查看评价！");
              }
           }
       });
   });
</script>
</body>
</html>