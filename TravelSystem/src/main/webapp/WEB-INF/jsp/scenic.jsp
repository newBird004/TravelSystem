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
            <span style="color: #FFFFFF">&nbsp;&nbsp;旅游景点管理</span>&nbsp;&nbsp;
        </div>
    </div>
	<!-- 按钮 -->
	<div class="row">

        <div class="col-md-offset-1 col-md-5">
            <button type="button" class="btn btn-primary" id="showAllStillExistScenic">显示所有景点</button>&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="button" class="btn btn-danger" id="showAllDontExistScenic">显示被删除景点</button>
        </div>

		<div class="col-md-6">
			<button type="button" class="btn btn-primary" id="scenicAddModalBtn">添加景点</button>&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="button" class="btn btn-danger" id="scenicDeleteModalBtn">删除景点</button>
            &nbsp;&nbsp;&nbsp;
            <input type="text" placeholder="输入景点编号..." id="inputScenicIdToSearch">
            <button type="button" class="btn btn-default" id="selectScenicMsgByScenicId"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
		</div>


	</div>
	<!-- 表格数据 -->
	<div class="row">
		<div class="col-md-12">
			<table class="table" id="scenicTable">
				<thead>
					<tr>
						<th>
							<input type="checkbox" id="checkAll">
						</th>
						<th>编号</th>
						<th>景点名称</th>
						<th>景点介绍</th>
						<th>价格</th>
						<th>图片描述</th>
                        <th>景点状态</th>
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

	<!-- Modal添加的模态框 -->
	<div class="modal fade" id="scenicAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="myModalLabel">添加景点</h4>
				</div>

				<div class="modal-body">
					<form class="form-horizontal" id="addScenicModal">
						<div class="form-group">
							<label for="inputScenicName"  class="col-sm-2 control-label">景点名称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="inputScenicName" name="scenicName" placeholder="请输入景点名称...">
								<span id="validateNameMsg" class="help-block"></span>
							</div>
						</div>
                        <!-- 景点介绍 -->
                        <div class="form-group">
                            <label for="inputScenicIntroduce"  class="col-sm-2 control-label">景点介绍</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputScenicIntroduce" name="scenicIntroduce" placeholder="请输入景点介绍 ...">
                                <span id="validateIntroduceMsg" class="help-block"></span>
                            </div>
                        </div>

                        <!-- 价格 -->
                        <div class="form-group">
                            <label for="inputScenicPrice"  class="col-sm-2 control-label">价格</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputScenicPrice" name="scenicPrice" placeholder="请输入景点价格 ...">
                                <span id="validatePriceMsg" class="help-block"></span>
                            </div>
                        </div>

                        <!-- 图片 -->
                        <div class="form-group">
                            <label for="inputScenicImage" class="col-sm-2 control-label">图片</label>
                            <div class="col-sm-10">
                                <input type="hidden" class="form-control" id="inputScenicImage" name="scenicImage" placeholder="">
                                <span id="validateImageMsg" class="help-block"></span>
                            </div>
                        </div>
					</form>

                    <div style="margin-left: 100px">
                        <!-- 上传图片 -->
                        <form id="uploadForm" enctype="mutipart/form-data">
                            选择上传图片:<input type="file" name="fileName" id="fileName"/>
                        </form>
                        <button id="upload">上传</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                        <!-- 加载上传上来的图片 -->
                            预览：
                            <img id="imagePreview" src=""  width="96px" height="64px">
                    </div>


				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="scenicAddSaveBtn">保存</button>
				</div>

			</div>
		</div>
	</div>

<%--负责修改的模态框--%>
    <div class="modal fade" id="scenicUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2">
        <div class="modal-dialog" role="document">
            <div class="modal-content">

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel2">添加景点</h4>
                </div>

                <div class="modal-body">
                    <form class="form-horizontal" id="updateScenicModal">
                        <div class="form-group">
                            <label for="updateScenicName"  class="col-sm-2 control-label">景点名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="updateScenicName" name="scenicName" placeholder="请输入景点名称...">
                                <span id="validateNameMsg_update" class="help-block"></span>
                            </div>
                        </div>
                        <!-- 景点介绍 -->
                        <div class="form-group">
                            <label for="updateScenicIntroduce"  class="col-sm-2 control-label">景点介绍</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="updateScenicIntroduce" name="scenicIntroduce" placeholder="请输入景点介绍 ...">
                                <span id="validateIntroduceMsg_update" class="help-block"></span>
                            </div>
                        </div>

                        <!-- 价格 -->
                        <div class="form-group">
                            <label for="updateScenicPrice"  class="col-sm-2 control-label">价格</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="updateScenicPrice" name="scenicPrice" placeholder="请输入景点价格 ...">
                                <span id="validatePriceMsg_update" class="help-block"></span>
                            </div>
                        </div>
                        <!-- 图片 -->
                        <div class="form-group">
                            <label for="updateScenicImage" class="col-sm-2 control-label">图片</label>
                            <div class="col-sm-10">
                                <input type="hidden" class="form-control" id="updateScenicImage" name="scenicImage" placeholder="">
                                <span id="validateImageMsg_update" class="help-block"></span>
                            </div>
                        </div>
                    </form>

                    <div style="margin-left: 100px">
                        <!-- 上传图片 -->
                        <form id="uploadForm_update" enctype="mutipart/form-data">
                            选择上传图片:<input type="file" name="fileName_update" id="fileName_update"/>
                        </form>
                        <button id="upload_update">上传</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                        <!-- 加载上传上来的图片 -->
                        预览：
                        <img id="imagePreview_update" src=""  width="96px" height="64px">
                    </div>



                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="scenicUpdateSaveBtn">保存</button>
                </div>

            </div>
        </div>
    </div>




    <script type="text/javascript">

        var currentPage;
        var lastPage;

        $(function () {
            $("#upload").click(function () {
                var fileName=$("#fileName").val();
                // alert(fileName);//fileName是要上传的文件路径以及名字
                var formData = new FormData($('#uploadForm')[0]);//序列化表单，将上传类型设置为文件对象
                if(fileName==""){
                    alert("请选择文件进行上传");
                    return false;
                }else{
                    $.ajax({
                        type: 'post',
                        url: "${APP_PATH}/upload",
                        data: formData,
                        cache: false,//文件不设置缓存
                        processData: false,//数据不被转换为字符串
                        contentType: false,//上传文件时使用，避免 JQuery 对其操作
                    }).success(function (data) {
                        alert("上传成功!");
                        $("img").empty();
                        $("#imagePreview").attr("src","${pageContext.request.contextPath}/img/Scenic/"+data+"");//将图片显示出来

                        $("#inputScenicImage").val(data);
                    }).error(function () {
                        alert("上传失败");
                    });
                }

            });
        });

        $(function () {
            $("#upload_update").click(function () {
                var fileName=$("#fileName_update").val();//获取文件位置，防止上传空文件
                var formData = new FormData($('#uploadForm_update')[0]);//序列化表单，将上传类型设置为文件对象
                if(fileName==""){
                    alert("请选择文件进行上传");
                    return false;
                }else{
                    $.ajax({
                        type: 'post',
                        url: "${APP_PATH}/upload_update",
                        data: formData,
                        cache: false,//文件不设置缓存
                        processData: false,//数据不被转换为字符串
                        contentType: false,//上传文件时使用，避免 JQuery 对其操作
                    }).success(function (data) {
                        alert("上传成功"+data);
                        $("img").empty();
                        $("#imagePreview_update").attr("src","${pageContext.request.contextPath}/img/Scenic/"+data+"");//将图片显示出来

                        $("#updateScenicImage").val(data);
                    }).error(function () {
                        alert("上传失败");
                    });
                }

            });
        });


		$(function () {//默认显示第一页的数据
			to_page(1);
		});

		function build_ScenicList(data) {//将json中的数据通过jquery遍历添加到table上显示出来
			$("#scenicTable tbody").empty();//清空上一次查询到的数据，防止重叠

			var scenics=data.extend.pageInfo.list;
			$.each(scenics,function (index,item) {
				var checkTd=$("<td><input type='checkbox' class='scenic_check'/></td>");
				var scenicIdTd=$("<td></td>").append(item.scenicId);
				var scenicName=$("<td></td>").append(item.scenicName);
				var scenicIntroduce=$("<td></td>").append(item.scenicIntroduce);
				var scenicPrice=$("<td></td>").append(item.scenicPrice);
                // var scenicImage=$("<td></td>").append(item.scenicImage);
				var scenicImage=$("<td><img src=\"${pageContext.request.contextPath}/img/Scenic/"+item.scenicImage+"\" width=\"96px\" height=\"64px\"/></td>");
                var scenicExist=$("<td></td>").append(item.scenicExist==1?"<span style='color: mediumseagreen'>存在</span>":"<span style='color: red'>已被删除！</span>");

                if(item.scenicExist==1){
                    var editBtnTd=$("<button></button>")
                            .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).addClass("btn btn-primary btn-sm edit_btn").append("修改").attr("scenicId_Update",item.scenicId);
                    var deleteBtnTd=$("<button></button>")
                            .append($("<span></span>").addClass("glyphicon glyphicon-trash")).addClass("btn btn-danger btn-sm delete_btn").append("删除").attr("scenicId_Delete",item.scenicId);
                    var btnTd=$("<td></td>").append(editBtnTd).append(" ").append(deleteBtnTd);
                }else if(item.scenicExist==0){
                    var btnTd=$("<td></td>");
                }

				$("<tr></tr>").append(checkTd).append(scenicIdTd).append(scenicName).append(scenicIntroduce).append(scenicPrice).append(scenicImage).append(scenicExist).append(btnTd).appendTo("#scenicTable tbody");
			});
		}

		//显示分页信息（左下角的那个）
		function build_PageInfo(result) {
			$("#pageInfo").empty();//清空上一次查询到的数据，防止重叠

			var info=result.extend.pageInfo;
			$("#pageInfo").append("当前在"+info.pageNum+"页,总共"+info.pages+"页,共"+info.total+"条数据");

			currentPage=info.pageNum;//为全局变量赋值。是为了修改模态框中修改完数据跳转到对应的页面去。
            lastPage=info.pages;
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
				url:"${APP_PATH}/loadScenicList",
				data:"pn="+pn,
				type:"get",
				success:function(data){
					/*
						 1、解析json数据，显示所有员工
						 2、解析json数据，显示分页信息
						 3、解析json数据，显示分页条
					*/
                    build_ScenicList(data);
					build_PageInfo(data);
					build_PageNav(data);
				}
			});
		}

		/* 负责点击添加按钮打开添加用户的模态框 */
		$("#scenicAddModalBtn").click(function() {
			// 清空模态框，消除上一次的数据
			cleanModal("#scenicAddModal form");
			//打开模态框
			$("#scenicAddModal").modal(
					{
						backdrop:false
					});
		});

        /* 打开模态框的时候负责清空模态框的内容和样式。主要是为了解决上一次打开模态框添加之后信息未清空便能够再次进行添加的问题 */
        function cleanModal(ele) {
            $(ele)[0].reset();
            $(ele).find("*").removeClass("has-error has-success");
            $(ele).find(".help-block").text("");
        }

        /*前端正则表达式校验数据*/
        function checkData() {
            //校验价格输入框，只能输入数字
            var inputPrice=$("#inputScenicPrice").val();
            var regexPrice=/^\d+$|^\d+[.]?\d+$/;
            if(!regexPrice.test(inputPrice)){
                /* alert("只能输入数字！"); */
                showValidateMsg("#inputScenicPrice","error","只能输入数字！");
                return false;
            }else {
                showValidateMsg("#inputScenicPrice","success","");
            };
            //如果没有触发到上面的条件，就返回true，表示符合规范
            return true;
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

        /* 当输入用户名的输入框有变化时就发送ajax请求去查看用户名是否已经存在 */
        /* 后端校验数据 */
        $("#inputScenicName").change(function() {
            var name=this.value;
            $.ajax({
                url:"${APP_PATH}/checkScenicNameReapt",
                type:"POST",
                data:"name="+name,
                success:function(result){
                    if(result==1){
                        showValidateMsg("#inputScenicName","error","该名称已被注册！");
                        $("#scenicAddSaveBtn").attr("checkNameResult","error");//存放自定义属性，用于在输入的数据有错误的时候阻止保存
                    } else if(result==0){
                        showValidateMsg("#inputScenicName","success","该名称可以使用！");
                        $("#scenicAddSaveBtn").attr("checkNameResult","success");//存放自定义属性，用于在有错误的时候阻止保存
                    }
                }
            });
        });


        //点击保存时候发送ajax进行保存
        $("#scenicAddSaveBtn").click(function() {//添加用户时点击保存

            //1、对输入的数据格式利用正则表达式进行前端校验
            if(!checkData()){//进行前端验证
                return false;//结束，不会向下进行保存
            };

            //2、对输入的数据进行后端校验
            if($("#scenicAddSaveBtn").attr("checkNameResult")=="error"){
                showValidateMsg("#inputScenicName","error","该名称已经被使用！");
                return false;
            };
            $.ajax({
                url:"${APP_PATH}/scenic",
                type:"POST",
                data:$("#addScenicModal").serialize(),//这个方法能够将这个form表单中的数据全部转换成字符串。不用我们一个一个获取了
                success:function(result){
                    if(result.result==1){
                        //添加成功后关闭模态框
                        $("#scenicAddModal").modal("hide");
                        //跳转到当前页
                        to_page(lastPage);
                    }
                }
            });

        });



        /* 打开修改信息的模态框 */
        $(document).on("click",".edit_btn",function() {
            /* 数据回显 */
            selectByIdAndShow($(this).attr("scenicId_Update"));//从修改按钮的自定义属性中拿到id值。

            /*将id放入修改按钮的自定义属性中 */
            $("#scenicUpdateSaveBtn").attr("scenicId",$(this).attr("scenicId_Update"));

            /* 打开修改模态框 */
            $('#scenicUpdateModal').modal(
                {
                    backdrop:false
                });
        });

        /* 根据id查找对应的员工信息并进行回显 */
        function selectByIdAndShow(id) {
            $.ajax({
                url:"${APP_PATH}/scenic/"+id,
                type:"GET",
                success:function(result){//根据拿到的信息显示到模态框中
                    var scenicData=result.extend.scenic;
                    $("#updateScenicName").val(scenicData.scenicName);
                    $("#updateScenicIntroduce").val(scenicData.scenicIntroduce);
                    $("#updateScenicPrice").val(scenicData.scenicPrice);
                    $("#updateScenicImage").val(scenicData.scenicImage);
                }
            });
        }


        //点击保存时候发送ajax进行保存
        $("#scenicUpdateSaveBtn").click(function() {//添加用户时点击保存
             // alert($("#scenicUpdateModal form").serialize());
            $.ajax({
                url:"${APP_PATH}/scenic/"+$(this).attr("scenicId"),
                type:"PUT",
                data:$("#scenicUpdateModal form").serialize(),//这个方法能够将表单中的数据全部转换成字符串。不用我们一个一个获取了

                success:function(result){
                    //修改成功后关闭模态框
                    $("#scenicUpdateModal").modal("hide");
                    //跳转到对应的页面
                    to_page(currentPage);
                }
            });
        });

        /* 打开删除信息 */
        $(document).on("click",".delete_btn",function() {
            var deleteName=$(this).parents("tr").find("td:eq(2)").text();
            var deleteId=$(this).attr("scenicId_Delete");
            if(confirm("确认要删除"+deleteName+"吗？")){
                $.ajax({
                    url:"${APP_PATH}/scenic/"+deleteId,
                    type:"DELETE",
                    success:function(result){//根据拿到的信息显示到模态框中
                        if(result.result==1){//删除成功
                            alert(result.message);
                        }else {
                            alert(result.message);
                        }
                        to_page(currentPage);
                    }
                });
            }
        });

        /* 全选全不选的功能 */
        $("#checkAll").click(function() {
            $(".scenic_check").prop("checked",$(this).prop("checked"));
        });

        /* 继续完善全选全不选的功能 */
        $(document).on("click",".scenic_check",function (){
            if($(".scenic_check:checked").length==$(".scenic_check").length){
                $("#checkAll").prop("checked",true);
            }else{
                $("#checkAll").prop("checked",false);
            }
        });

        /*
        * 点击删除按钮进行的动作，删除多个
        * */
        $("#scenicDeleteModalBtn").click(function () {
            var deleteNameStr="";
            var deleteIdStr="";
            $.each($(".scenic_check:checked"),function(){//遍历已经勾选的每个元素，并将勾选中的元素中的名字和id分别放入字符串中
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
                    url:"${APP_PATH}/scenic/"+deleteIdStr,
                    type:"DELETE",
                    success:function(result){//根据拿到的信息显示到模态框中
                        if(result.result==1){//删除成功
                            alert(result.message);//弹出操作信息
                        }else {
                            alert(result.message);//弹出操作信息
                        }

                        $("#checkAll").prop("checked",false);//取消勾选全选按钮

                        to_page(currentPage);//跳转回原页面
                    }
                });
            }
        });

        /* 点击按照景点编号搜索时 */
        $("#selectScenicMsgByScenicId").click(function() {
            if($("#inputScenicIdToSearch").val()==""){
                alert("景点编号不能为空！");
                return false;
            }
            $.ajax({
                url:"${APP_PATH}/selectScenicMsgByScenicId",
                data:"scenicId="+$("#inputScenicIdToSearch").val()+"",
                type:"get",
                success:function(result){//根据拿到的信息显示到模态框中
                    $("#pageInfo").empty();
                    $("#pageNav").empty();
                    build_ScenicListByScenicId(result);
                }
            });
        });


        function build_ScenicListByScenicId(data) {//将json中的数据通过jquery遍历添加到table上显示出来
            $("#scenicTable tbody").empty();//清空上一次查询到的数据，防止重叠

            var item=data.extend.scenics;

            var checkTd=$("<td><input type='checkbox' class='scenic_check'/></td>");
            var scenicIdTd=$("<td></td>").append(item.scenicId);
            var scenicName=$("<td></td>").append(item.scenicName);
            var scenicIntroduce=$("<td></td>").append(item.scenicIntroduce);
            var scenicPrice=$("<td></td>").append(item.scenicPrice);
            var scenicImage=$("<td><img src=\"${pageContext.request.contextPath}/img/Scenic/"+item.scenicImage+"\" width=\"96px\" height=\"64px\"/></td>");
            var scenicExist=$("<td></td>").append(item.scenicExist==1?"<span style='color: mediumseagreen'>存在</span>":"<span style='color: red'>已被删除！</span>");

            if(item.scenicExist==1){
                var editBtnTd=$("<button></button>")
                    .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).addClass("btn btn-primary btn-sm edit_btn").append("修改").attr("scenicId_Update",item.scenicId);
                var deleteBtnTd=$("<button></button>")
                    .append($("<span></span>").addClass("glyphicon glyphicon-trash")).addClass("btn btn-danger btn-sm delete_btn").append("删除").attr("scenicId_Delete",item.scenicId);
                var btnTd=$("<td></td>").append(editBtnTd).append(" ").append(deleteBtnTd);
            }else if(item.scenicExist==0){
                var btnTd=$("<td></td>");
            }

            $("<tr></tr>").append(checkTd).append(scenicIdTd).append(scenicName).append(scenicIntroduce).append(scenicPrice).append(scenicImage).append(scenicExist).append(btnTd).appendTo("#scenicTable tbody");
        }


        /* 点击显示所有仍存在景点 */
        $("#showAllStillExistScenic").click(function() {
           to_page(1);
        });

        /* 点击显示所有被删除的景点 */
        $("#showAllDontExistScenic").click(function() {
            to_pageHasDeleted(1);
        });

        /* 传入页数，就能够发送ajax请求，然后获取到数据，并调用方法分别构建数据表，分页信息，分页条 */
        function to_pageHasDeleted(pn) {
            $.ajax({
                url:"${APP_PATH}/loadHasDeletedScenicList",
                data:"pn="+pn,
                type:"get",
                success:function(data){
                    /*
                         1、解析json数据，显示所有员工
                         2、解析json数据，显示分页信息
                         3、解析json数据，显示分页条
                    */
                    build_ScenicList(data);
                    build_PageInfo(data);
                    build_PageNav(data);
                }
            });
        }

    </script>
</body>
</html>