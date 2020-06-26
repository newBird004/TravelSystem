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

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/icheck-material.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/icheck-material-custom.min.css" />

    <%
  		pageContext.setAttribute("APP_PATH",request.getContextPath());
  	%>
  </head>
<body>
    <!-- 标题 -->
    <div class="row">
        <div class="col-md-12" style="font-size: 20px;background-color:black; border-radius:20px;margin-bottom: 5px">
            <span style="color: #FFFFFF">&nbsp;&nbsp;套餐管理</span>&nbsp;&nbsp;
        </div>
    </div>
	<!-- 按钮 -->
	<div class="row">
		<div class="col-md-6 col-md-offset-6">
			<button type="button" class="btn btn-primary" id="taoCanAddModalBtn">添加套餐</button>&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="button" class="btn btn-danger" id="taoCanDeleteModalBtn">删除套餐</button>

            <input type="text" placeholder="输入套餐编号..." id="inputTaoCanIdToSearch">
            <button type="button" class="btn btn-default" id="selectTaoCanMsgById"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
		</div>
	</div>
	<!-- 表格数据 -->
	<div class="row">
		<div class="col-md-12">
			<table class="table" id="taoCanTable">
				<thead>
					<tr>
						<th>
							<input type="checkbox" id="checkAll">
						</th>
						<th>编号</th>
						<th>套餐名称</th>
						<th>套餐介绍</th>
						<th>套餐价格</th>
						<th>图片描述</th>
                        <th>状态</th>
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
	<div class="modal fade" id="taoCanAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="myModalLabel">添加套餐</h4>
				</div>

				<div class="modal-body">
					<form class="form-horizontal" id="addTaoCanModal">
						<div class="form-group">
							<label for="inputTaoCanName"  class="col-sm-2 control-label">套餐名称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="inputTaoCanName" name="taoCanName" placeholder="请输入套餐名称...">
								<span id="validateNameMsg" class="help-block"></span>
							</div>
						</div>
                        <!-- 套餐介绍 -->
                        <div class="form-group">
                            <label for="inputTaoCanIntroduce"  class="col-sm-2 control-label">套餐介绍</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputTaoCanIntroduce" name="taoCanIntroduce" placeholder="请输入套餐介绍 ...">
                                <span id="validateIntroduceMsg" class="help-block"></span>
                            </div>
                        </div>

                        <!-- 价格 -->
                        <div class="form-group">
                            <label for="inputTaoCanPrice"  class="col-sm-2 control-label">价格</label>
                            <div class="col-sm-10">
                                <input type="text" disabled="disabled" class="form-control" id="inputTaoCanPrice" name="taoCanPrice" placeholder="套餐价格默认是七折，需要改变请生成后修改！">
                                <span id="validatePriceMsg" class="help-block"></span>
                            </div>
                        </div>

                        <!-- 图片 -->
                        <div class="form-group">
                            <label for="inputTaoCanImage" class="col-sm-2 control-label">图片</label>
                            <div class="col-sm-10">
                                <input type="hidden" class="form-control" id="inputTaoCanImage" name="taoCanImage" placeholder="">
                                <span id="validateImageMsg" class="help-block"></span>
                            </div>
                        </div>
					</form>

                    <div style="margin-left: 100px">
                        <!-- 上传图片 -->
                        <form id="uploadForm" enctype="mutipart/form-data">
                            选择上传图片:<input type="file" name="fileName" id="fileName"/>
                        </form>
                        <button id="upload" class="btn btn-sm btn-success">上传</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                        <!-- 加载上传上来的图片 -->
                            预览：
                            <img id="imagePreview" src=""  width="96px" height="64px">
                    </div>

                    <p style="font-weight: bold;color: #ac2925">注意！由于业务问题，套餐包含的票务和酒店信息在添加之后不允许修改，请谨慎选择！<p>
                    <div style="margin-top: 10px">

                        <p style="font-weight: bold">请选择套餐所包含的景点门票：<p>

                        <div id="scenicToTaoCan">

                        </div>

                    </div>
                    <div style="margin-top: 10px">

                        <p style="font-weight: bold">请选择套餐所包含的酒店以及房间类型：<p>

                        <select id="hotelIdToTaoCan" class="form-control" style="width: 140px;float: left;">

                        </select>

                        <select id="roomTypeToTaoCan" class="form-control" style="width: 140px;float: left;margin-left: 20px">

                        </select>

                    </div>


				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="taoCanAddSaveBtn">保存</button>
				</div>

			</div>
		</div>
	</div>

<%--负责修改的模态框--%>
    <div class="modal fade" id="taoCanUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2">
        <div class="modal-dialog" role="document">
            <div class="modal-content">

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel2">添加套餐</h4>
                </div>

                <div class="modal-body">
                    <form class="form-horizontal" id="updateTaoCanModal">
                        <div class="form-group">
                            <label for="updateTaoCanName"  class="col-sm-2 control-label">套餐名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="updateTaoCanName" name="taoCanName" placeholder="请输入套餐名称...">
                                <span id="validateNameMsg_update" class="help-block"></span>
                            </div>
                        </div>
                        <!-- 套餐介绍 -->
                        <div class="form-group">
                            <label for="updateTaoCanIntroduce"  class="col-sm-2 control-label">套餐介绍</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="updateTaoCanIntroduce" name="taoCanIntroduce" placeholder="请输入套餐介绍 ...">
                                <span id="validateIntroduceMsg_update" class="help-block"></span>
                            </div>
                        </div>

                        <!-- 价格 -->
                        <div class="form-group">
                            <label for="updateTaoCanPrice"  class="col-sm-2 control-label">价格</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="updateTaoCanPrice" name="taoCanPrice" placeholder="请输入套餐价格 ...">
                                <span id="validatePriceMsg_update" class="help-block"></span>
                            </div>
                        </div>
                        <!-- 图片 -->
                        <div class="form-group">
                            <label for="updateTaoCanImage" class="col-sm-2 control-label">图片</label>
                            <div class="col-sm-10">
                                <input type="hidden" class="form-control" id="updateTaoCanImage" name="taoCanImage" placeholder="">
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
                    <button type="button" class="btn btn-primary" id="taoCanUpdateSaveBtn">保存</button>
                </div>

            </div>
        </div>
    </div>




    <script type="text/javascript">

        var currentPage;
        var lastPage;
        var str = new Array();//存储景点复选框选中的值。

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
                        url: "${APP_PATH}/uploadTaoCan",
                        data: formData,
                        cache: false,//文件不设置缓存
                        processData: false,//数据不被转换为字符串
                        contentType: false,//上传文件时使用，避免 JQuery 对其操作
                    }).success(function (data) {
                        alert("上传成功!");
                        $("img").empty();
                        $("#imagePreview").attr("src","${pageContext.request.contextPath}/img/TaoCan/"+data+"");//将图片显示出来

                        $("#inputTaoCanImage").val(data);
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
                        url: "${APP_PATH}/upload_updateTaoCan",
                        data: formData,
                        cache: false,//文件不设置缓存
                        processData: false,//数据不被转换为字符串
                        contentType: false,//上传文件时使用，避免 JQuery 对其操作
                    }).success(function (data) {
                        alert("上传成功"+data);
                        $("img").empty();
                        $("#imagePreview_update").attr("src","${pageContext.request.contextPath}/img/TaoCan/"+data+"");//将图片显示出来

                        $("#updateTaoCanImage").val(data);
                    }).error(function () {
                        alert("上传失败");
                    });
                }

            });
        });


		$(function () {//默认显示第一页的数据
			to_page(1);
		});

		function build_TaoCanList(data) {//将json中的数据通过jquery遍历添加到table上显示出来
			$("#taoCanTable tbody").empty();//清空上一次查询到的数据，防止重叠

			var taoCans=data.extend.pageInfo.list;
			$.each(taoCans,function (index,item) {
				var checkTd=$("<td><input type='checkbox' class='taoCan_check'/></td>");
				var taoCanIdTd=$("<td></td>").append(item.taoCanId);
				var taoCanName=$("<td></td>").append(item.taoCanName);
				var taoCanIntroduce=$("<td></td>").append(item.taoCanIntroduce);
				var taoCanPrice=$("<td></td>").append(item.taoCanPrice);
                // var taoCanImage=$("<td></td>").append(item.taoCanImage);
				var taoCanImage=$("<td><img src=\"${pageContext.request.contextPath}/img/TaoCan/"+item.taoCanImage+"\" width=\"96px\" height=\"64px\"/></td>");
                var taoCanExist=$("<td></td>").append(item.taoCanExist==1?"<span style='color: mediumseagreen'>存在</span>":"<span style='color: red'>已被删除！</span>");

                if(item.taoCanExist==1){
                    var editBtnTd=$("<button></button>")
                            .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).addClass("btn btn-primary btn-sm edit_btn").append("修改").attr("taoCanId_Update",item.taoCanId);
                    var deleteBtnTd=$("<button></button>")
                            .append($("<span></span>").addClass("glyphicon glyphicon-trash")).addClass("btn btn-danger btn-sm delete_btn").append("删除").attr("taoCanId_Delete",item.taoCanId);
                    var btnTd=$("<td></td>").append(editBtnTd).append(" ").append(deleteBtnTd);
                }else{
                    var btnTd=$("<td></td>");
                }

				$("<tr></tr>").append(checkTd).append(taoCanIdTd).append(taoCanName).append(taoCanIntroduce).append(taoCanPrice).append(taoCanImage).append(taoCanExist).append(btnTd).appendTo("#taoCanTable tbody");
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
				url:"${APP_PATH}/loadTaoCanList",
				data:"pn="+pn,
				type:"get",
				success:function(data){
					/*
						 1、解析json数据，显示所有员工
						 2、解析json数据，显示分页信息
						 3、解析json数据，显示分页条
					*/
                    build_TaoCanList(data);
					build_PageInfo(data);
					build_PageNav(data);
				}
			});
		}


		/* 负责点击添加按钮打开添加用户的模态框 */
		$("#taoCanAddModalBtn").click(function() {
			// 清空模态框，消除上一次的数据
			cleanModal("#taoCanAddModal form");

            /*打开模态框之前向模态框中加载门票信息*/
            $.ajax({
                url:"${pageContext.request.contextPath}/loadScenicToTaoCan",
                type:"get",
                success:function(data){
                    var scenics=data.extend.scenics;
                    $.each(scenics,function (index,item) {
                        // alert(item.scenicId);
                        // alert(item.scenicName);
                        var scenicCheck=$("<div class='icheck-material-teal icheck-inline'><input type='checkbox' name='checkScenicCheckBox' id='"+item.scenicName+"' value='"+item.scenicId+"'/><label for='"+item.scenicName+"'>"+item.scenicName+"</label></div>");
                        $("#scenicToTaoCan").append(scenicCheck);
                    });
                }
            });

            /*打开模态框之前向模态框中加载酒店信息*/
            $.ajax({
                url:"${pageContext.request.contextPath}/loadHotelToTaoCan",
                type:"get",
                success:function(data){
                    var hotels=data.extend.hotels;
                    $.each(hotels,function (index,item) {
                        var hotelIdSelected=$("<option value='"+item.hotelId+"'>"+item.hotelName+"</option>");
                        $("#hotelIdToTaoCan").append(hotelIdSelected);
                    });
                    // alert($("#hotelIdToTaoCan").val());//在这里面能拿到选择的酒店id，在这个ajax请求外面就拿不到。
                    loadRoomTypeBySelectedHotelId();//放在这里，加载酒店对应的房型信息。如果不在这里，就会报错。因为ajax请求慢，如果这句话放在ajax请求之外，就还没拿到酒店id，所以就会传过去一个null值。
                }
            });
            // alert($("#hotelIdToTaoCan").val());//在ajax请求外面拿不到所选择的酒店id。

			//打开模态框
			$("#taoCanAddModal").modal(
					{
						backdrop:false
					});

		});

        /*根据酒店id加载房间类型信息*/
        function loadRoomTypeBySelectedHotelId(){
            $("#roomTypeToTaoCan").empty();
            $.ajax({
                url:"${pageContext.request.contextPath}/selectRoomTypeByHotelId?hotelId="+$("#hotelIdToTaoCan").val()+"",
                type:"get",
                success:function(data){
                    var roomTypes=data.extend.roomTypes;
                    $.each(roomTypes,function (index,item) {

                        var roomTypeSelected=$("<option value='"+item+"'>"+item+"</option>");
                        $("#roomTypeToTaoCan").append(roomTypeSelected);
                    });
                }
            });
        }
        //每修改一次酒店id，重新加载一次房间类型。
        $("#hotelIdToTaoCan").change(function () {
            loadRoomTypeBySelectedHotelId();
        });


        /* 打开模态框的时候负责清空模态框的内容和样式。主要是为了解决上一次打开模态框添加之后信息未清空便能够再次进行添加的问题 */
        function cleanModal(ele) {
            $(ele)[0].reset();//根据ele得到的是一个标签数组，重置第一个的值
            $(ele).find("*").removeClass("has-error has-success");
            $(ele).find(".help-block").text("");
            $("#scenicToTaoCan").empty();//清空这个元素内部的所有标签。
            $("#hotelIdToTaoCan").empty();
            $("#roomTypeToTaoCan").empty();
        }

        /*前端正则表达式校验数据*/
        function checkData() {
            //校验价格输入框，只能输入数字
            var inputPrice=$("#inputTaoCanPrice").val();
            var regexPrice=/^\d+$|^\d+[.]?\d+$/;
            if(!regexPrice.test(inputPrice)){
                /* alert("只能输入数字！"); */
                showValidateMsg("#inputTaoCanPrice","error","只能输入数字！");
                return false;
            }else {
                showValidateMsg("#inputTaoCanPrice","success","");
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
        $("#inputTaoCanName").change(function() {
            var name=this.value;
            $.ajax({
                url:"${APP_PATH}/checkTaoCanNameReapt",
                type:"POST",
                data:"name="+name,
                success:function(result){
                    if(result==1){
                        showValidateMsg("#inputTaoCanName","error","该名称已被注册！");
                        $("#taoCanAddSaveBtn").attr("checkNameResult","error");//存放自定义属性，用于在输入的数据有错误的时候阻止保存
                    } else if(result==0){
                        showValidateMsg("#inputTaoCanName","success","该名称可以使用！");
                        $("#taoCanAddSaveBtn").attr("checkNameResult","success");//存放自定义属性，用于在有错误的时候阻止保存
                    }
                }
            });
        });


        /*
        * 获取勾选上的景点复选框
        * */
        function getScenicCheckValue() {
            str.splice(0,str.length);//清空数组

            //根据name拿到所有复选框元素
            var results = document.getElementsByName("checkScenicCheckBox");
            //然后我们去得到复选框的个数
            var thisLength = results.length;
            //使用字符串数组，用于存放选择好了的数据
            for(var i = 0;i < thisLength;i++) {
                if (results[i].checked == true) {
                    str[i] = results[i].value;//这个是获取多选框中的值
                    // alert(results[i].value);
                }
            }
        }


        //点击保存时候发送ajax进行保存
        $("#taoCanAddSaveBtn").click(function() {//添加用户时点击保存

            // //对输入的数据格式利用正则表达式进行前端校验
            // if(!checkData()){//进行前端验证
            //     return false;//结束，不会向下进行保存
            // };

            //1、对输入的数据进行后端校验
            if($("#taoCanAddSaveBtn").attr("checkNameResult")=="error"){
                showValidateMsg("#inputTaoCanName","error","该名称已经被使用！");
                return false;
            };

            //获取勾选上的景点复选框的id
            getScenicCheckValue();
            var checkedScenicIdStr="";
            for(var i=0;i<str.length;i++){//将得到的值组合成字符串
                // alert(str[i]);
                if(str[i]){
                    checkedScenicIdStr=checkedScenicIdStr+str[i]+"-";
                }
            }
            checkedScenicIdStr=checkedScenicIdStr.substring(0,checkedScenicIdStr.length-1);//去掉最后一个-


            $.ajax({
                url:"${APP_PATH}/taoCan",
                type:"POST",
                data:$("#addTaoCanModal").serialize()+"&checkedScenicIdStr="+checkedScenicIdStr+"&hotelId="+$("#hotelIdToTaoCan").val()+"&roomType="+$("#roomTypeToTaoCan").val()+"",//这个方法能够将这个form表单中的数据全部转换成字符串。不用我们一个一个获取了
                success:function(result){
                    if(result.result==1){
                        alert("当前套餐默认价格为："+result.extend.taoCanPrice);

                        //添加成功后关闭模态框
                        $("#taoCanAddModal").modal("hide");
                        //跳转到当前页
                        to_page(lastPage);
                    } else{
                        alert("添加失败！");
                    }
                }

            });

        });



        /* 打开修改信息的模态框 */
        $(document).on("click",".edit_btn",function() {
            /* 数据回显 */
            selectByIdAndShow($(this).attr("taoCanId_Update"));//从修改按钮的自定义属性中拿到id值。

            /*将id放入修改按钮的自定义属性中 */
            $("#taoCanUpdateSaveBtn").attr("taoCanId",$(this).attr("taoCanId_Update"));

            /* 打开修改模态框 */
            $('#taoCanUpdateModal').modal(
                {
                    backdrop:false
                });
        });

        /* 根据id查找对应的员工信息并进行回显 */
        function selectByIdAndShow(id) {
            $.ajax({
                url:"${APP_PATH}/taoCan/"+id,
                type:"GET",
                success:function(result){//根据拿到的信息显示到模态框中
                    var taoCanData=result.extend.taoCan;
                    $("#updateTaoCanName").val(taoCanData.taoCanName);
                    $("#updateTaoCanIntroduce").val(taoCanData.taoCanIntroduce);
                    $("#updateTaoCanPrice").val(taoCanData.taoCanPrice);
                    $("#updateTaoCanImage").val(taoCanData.taoCanImage);
                }
            });
        }


        //点击保存时候发送ajax进行保存
        $("#taoCanUpdateSaveBtn").click(function() {//添加用户时点击保存
             // alert($("#taoCanUpdateModal form").serialize());
            $.ajax({
                url:"${APP_PATH}/taoCan/"+$(this).attr("taoCanId"),
                type:"PUT",
                data:$("#taoCanUpdateModal form").serialize(),//这个方法能够将表单中的数据全部转换成字符串。不用我们一个一个获取了

                success:function(result){
                    //修改成功后关闭模态框
                    $("#taoCanUpdateModal").modal("hide");
                    //跳转到对应的页面
                    to_page(currentPage);
                }
            });
        });

        /* 打开删除信息 */
        $(document).on("click",".delete_btn",function() {
            var deleteName=$(this).parents("tr").find("td:eq(2)").text();
            var deleteId=$(this).attr("taoCanId_Delete");
            if(confirm("确认要删除"+deleteName+"吗？")){
                $.ajax({
                    url:"${APP_PATH}/taoCan/"+deleteId,
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
            $(".taoCan_check").prop("checked",$(this).prop("checked"));
        });

        /* 继续完善全选全不选的功能 */
        $(document).on("click",".taoCan_check",function (){
            if($(".taoCan_check:checked").length==$(".taoCan_check").length){
                $("#checkAll").prop("checked",true);
            }else{
                $("#checkAll").prop("checked",false);
            }
        });

        /*
        * 点击删除按钮进行的动作，删除多个
        * */
        $("#taoCanDeleteModalBtn").click(function () {
            var deleteNameStr="";
            var deleteIdStr="";
            $.each($(".taoCan_check:checked"),function(){//遍历已经勾选的每个元素，并将勾选中的元素中的名字和id分别放入字符串中
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
                    url:"${APP_PATH}/taoCan/"+deleteIdStr,
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


        /* 点击按照套餐编号搜索时 */
        $("#selectTaoCanMsgById").click(function() {
            if($("#inputTaoCanIdToSearch").val()==""){
                alert("编号不能为空！");
                return false;
            }
            $.ajax({
                url:"${APP_PATH}/selectTaoCanMsgById",
                data:"taoCanId="+$("#inputTaoCanIdToSearch").val()+"",
                type:"get",
                success:function(result){//根据拿到的信息显示到模态框中
                    $("#pageInfo").empty();
                    $("#pageNav").empty();
                    build_TaoCanListByTaoCanId(result);
                }
            });
        });


        function build_TaoCanListByTaoCanId(data) {//将json中的数据通过jquery遍历添加到table上显示出来
            $("#taoCanTable tbody").empty();//清空上一次查询到的数据，防止重叠

            var item=data.extend.taoCan;

            var checkTd=$("<td><input type='checkbox' class='taoCan_check'/></td>");
            var taoCanIdTd=$("<td></td>").append(item.taoCanId);
            var taoCanName=$("<td></td>").append(item.taoCanName);
            var taoCanIntroduce=$("<td></td>").append(item.taoCanIntroduce);
            var taoCanPrice=$("<td></td>").append(item.taoCanPrice);
            // var taoCanImage=$("<td></td>").append(item.taoCanImage);
            var taoCanImage=$("<td><img src=\"${pageContext.request.contextPath}/img/TaoCan/"+item.taoCanImage+"\" width=\"96px\" height=\"64px\"/></td>");
            var taoCanExist=$("<td></td>").append(item.taoCanExist==1?"<span style='color: mediumseagreen'>存在</span>":"<span style='color: red'>已被删除！</span>");

            if(item.taoCanExist==1){
                var editBtnTd=$("<button></button>")
                    .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).addClass("btn btn-primary btn-sm edit_btn").append("修改").attr("taoCanId_Update",item.taoCanId);
                var deleteBtnTd=$("<button></button>")
                    .append($("<span></span>").addClass("glyphicon glyphicon-trash")).addClass("btn btn-danger btn-sm delete_btn").append("删除").attr("taoCanId_Delete",item.taoCanId);
                var btnTd=$("<td></td>").append(editBtnTd).append(" ").append(deleteBtnTd);
            }else{
                var btnTd=$("<td></td>");
            }

            $("<tr></tr>").append(checkTd).append(taoCanIdTd).append(taoCanName).append(taoCanIntroduce).append(taoCanPrice).append(taoCanImage).append(taoCanExist).append(btnTd).appendTo("#taoCanTable tbody");

        }

    </script>
</body>
</html>