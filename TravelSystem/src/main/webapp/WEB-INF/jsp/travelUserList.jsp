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
			<span style="color: #FFFFFF">&nbsp;&nbsp;旅游用户管理</span>&nbsp;&nbsp;
		</div>
	</div>
	<!-- 按钮 -->
	<div class="row">
		<div class="col-md-6 col-md-offset-6">
			<button type="button" class="btn btn-primary" id="travelUserAddModalBtn">添加用户</button>&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="button" class="btn btn-danger" id="travelUserDeleteModalBtn">删除用户</button>

            &nbsp;&nbsp;
            <input type="text" placeholder="输入用户编号..." id="inputUserIdToSearch">
            <button type="button" class="btn btn-default" id="selectUserMsgByUserId"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
		</div>
	</div>
	<!-- 表格数据 -->
	<div class="row">
		<div class="col-md-12">
			<table class="table" id="travelUserTable">
				<thead>
					<tr>
						<th>
							<input type="checkbox" id="checkAll">
						</th>
						<th>编号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>邮箱</th>
						<th>地址</th>
						<th>用户类型</th>
                        <th>用户状态</th>
						<th>操作</th>
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
	<div class="modal fade" id="travelUserAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="myModalLabel">添加用户</h4>
				</div>

				<div class="modal-body">
					<form class="form-horizontal" id="addTravelUserModal">
						<!-- 姓名 -->
						<div class="form-group">
							<label for="inputTravelUserName"  class="col-sm-2 control-label">用户名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="inputTravelUserName" name="userName" placeholder="请输入用户名...">
								<span id="validateNameMsg" class="help-block"></span>
							</div>
						</div>
                        <!-- 密码 -->
                        <div class="form-group">
                            <label for="inputTravelUserPassword"  class="col-sm-2 control-label">密码</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" id="inputTravelUserPassword" name="password" placeholder="请输入密码...">
                                <span id="validatePasswordMsg" class="help-block"></span>
                            </div>
                        </div>

                        <!-- 性别 -->
                        <div class="form-group">
                            <label class="col-sm-2 control-label">性别</label>
                            <div class="col-sm-10">
                                <label>
                                    <input type="radio" name="sex" id="inputTravelUserSex1" value="男" checked>男
                                </label>
                                <label>
                                    <input type="radio" name="sex" id="inputTravelUserSex2" value="女">女
                                </label>
                            </div>
                        </div>
						<!-- 邮箱 -->
						<div class="form-group">
							<label for="inputTravelUserEmail" class="col-sm-2 control-label">邮箱</label>
							<div class="col-sm-10">
								<input type="email" class="form-control" id="inputTravelUserEmail" name="email" placeholder="请输入邮箱....">
								<span id="validateEmailMsg" class="help-block"></span>
							</div>
						</div>

                        <!-- 地址 -->
                        <div class="form-group">
                            <label for="inputTravelUserAddress" class="col-sm-2 control-label">地址</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputTravelUserAddress" name="address" placeholder="请输入地址....">
                                <span id="validateAddressMsg" class="help-block"></span>
                            </div>
                        </div>

                        <!-- 用户类型 -->
                        <div class="form-group">
                            <label class="col-sm-2 control-label">用户类型</label>
                            <div class="col-sm-10">
                                <label>
                                    <input type="radio" name="role" id="inputTravelUserRole1" value=1 >管理员
                                </label>
                                <label>
                                    <input type="radio" name="role" id="inputTravelUserRole2" value=0 checked>游客
                                </label>
                            </div>
                        </div>

					</form>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="travelUserAddSaveBtn">保存</button>
				</div>

			</div>
		</div>
	</div>


    <!-- Modal修改的模态框 -->
    <div class="modal fade" id="travelUserUpdateModal" tabindex="-1" role="dialog" aria-labelledby="travelUserUpdateModal2">
        <div class="modal-dialog" role="document">
            <div class="modal-content">

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="travelUserUpdateModal2">编辑用户</h4>
                </div>

                <div class="modal-body">
                    <form class="form-horizontal" id="updateTravelUserModal">
                        <!-- 姓名 -->
                        <div class="form-group">
                            <label for="updateTravelUserName"  class="col-sm-2 control-label">用户名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="updateTravelUserName" name="userName" placeholder="请输入用户名..." disabled="disabled" >
                                <span id="validateNameMsg_Update" class="help-block"></span>
                            </div>
                        </div>
                        <!-- 密码 -->
                        <div class="form-group">
                            <label for="updateTravelUserPassword"  class="col-sm-2 control-label">密码</label>
                            <div class="col-sm-10">
<%--                                <p class="form-control-static" id="updateTravelUserPassword" name="password"></p>--%>
                                <input type="password" class="form-control" id="updateTravelUserPassword" name="password" placeholder="请输入密码..."  disabled="disabled">
                                <span id="validatePasswordMsg_Update" class="help-block"></span>
                            </div>
                        </div>

                        <!-- 性别 -->
                        <div class="form-group">
                            <label class="col-sm-2 control-label">性别</label>
                            <div class="col-sm-10">
                                <label>
                                    <input type="radio" name="sex" id="updateTravelUserSex1" value="男" checked>男
                                </label>
                                <label>
                                    <input type="radio" name="sex" id="updateTravelUserSex2" value="女">女
                                </label>
                            </div>
                        </div>
                        <!-- 邮箱 -->
                        <div class="form-group">
                            <label for="updateTravelUserEmail" class="col-sm-2 control-label">邮箱</label>
                            <div class="col-sm-10">
                                <input type="email" class="form-control" id="updateTravelUserEmail" name="email" placeholder="请输入邮箱....">
                                <span id="validateEmailMsg_Update" class="help-block"></span>
                            </div>
                        </div>

                        <!-- 地址 -->
                        <div class="form-group">
                            <label for="updateTravelUserAddress" class="col-sm-2 control-label">地址</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="updateTravelUserAddress" name="address" placeholder="请输入地址....">
                                <span id="validateAddressMsg_Update" class="help-block"></span>
                            </div>
                        </div>

                        <!-- 用户类型 -->
                        <div class="form-group">
                            <label class="col-sm-2 control-label">用户类型</label>
                            <div class="col-sm-10">
                                <label>
                                    <input type="radio" name="role" id="updateTravelUserRole1" value=1 >管理员
                                </label>
                                <label>
                                    <input type="radio" name="role" id="updateTravelUserRole2" value=0 checked>游客
                                </label>
                            </div>
                        </div>

                    </form>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="travelUserUpdateSaveBtn">保存</button>
                </div>

            </div>
        </div>
    </div>

    <script type="text/javascript">

        var currentPage;
        var lastPage;

		$(function () {
			to_page(1);//默认显示第一页的数据
		});

		function build_UserList(data) {//将json中的数据通过jquery遍历添加到table上显示出来
			$("#travelUserTable tbody").empty();//清空上一次查询到的数据，防止重叠

			var users=data.extend.pageInfo.list;
			$.each(users,function (index,item) {
				var checkTd=$("<td><input type='checkbox' class='travelUser_check'/></td>");
				var userIdTd=$("<td></td>").append(item.travelUserId);
				var userNameTd=$("<td></td>").append(item.userName);
				var sexTd=$("<td></td>").append(item.sex);
				var emailTd=$("<td></td>").append(item.email);
				var addressTd=$("<td></td>").append(item.address);
				var roleTd=$("<td></td>").append(item.role==1?"管理员":"游客");
                var userExistTd=$("<td></td>").append(item.travelUserExist==1?"<span style='color: mediumseagreen'>存在</span>":"<span style='color: red'>已被删除！</span>");

                if(item.travelUserExist==1){
                    var editBtnTd=$("<button></button>")
                            .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).addClass("btn btn-primary btn-sm edit_btn").append("修改").attr("travelUserId_Update",item.travelUserId);
                    var deleteBtnTd=$("<button></button>")
                            .append($("<span></span>").addClass("glyphicon glyphicon-trash")).addClass("btn btn-danger btn-sm delete_btn").append("删除").attr("travelUserId_Delete",item.travelUserId);
                    var btnTd=$("<td></td>").append(editBtnTd).append(" ").append(deleteBtnTd);

                }else if(item.travelUserExist==0){
                    var btnTd=$("<td></td>");
                }

				$("<tr></tr>").append(checkTd).append(userIdTd).append(userNameTd).append(sexTd).append(emailTd).append(addressTd).append(roleTd).append(userExistTd).append(btnTd).appendTo("#travelUserTable tbody");
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
				url:"${APP_PATH}/loadTravelUserList",
				data:"pn="+pn,
				type:"get",
				success:function(data){
					/*
						 1、解析json数据，显示所有员工
						 2、解析json数据，显示分页信息
						 3、解析json数据，显示分页条
					*/
					build_UserList(data);
					build_PageInfo(data);
					build_PageNav(data);
				}
			});
		}

		/* 负责点击添加按钮打开添加用户的模态框 */
		$("#travelUserAddModalBtn").click(function() {
			// 清空模态框，消除上一次的数据
			cleanModal("#travelUserAddModal form");
			//打开模态框
			$("#travelUserAddModal").modal(
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

        /*前端正则表达式校验数据*/
        function checkData() {
            //校验用户名
            var inputName=$("#inputTravelUserName").val();
            var regexName=/(^[a-zA-Z0-9_-]{4,16}$)|(^[\u2E80-\u9FFF]{1,5})/;
            if(!regexName.test(inputName)){
                /* alert("用户名必须为4~16个英文或者字母的组合或者1~5个汉字!"); */
                showValidateMsg("#inputTravelUserName","error","用户名必须为4~16个英文或者字母的组合或者1~5个汉字!");
                return false;
            }else {
                showValidateMsg("#inputTravelUserName","success","可以使用");
            };

            //校验邮箱
            var inputEmail=$("#inputTravelUserEmail").val();
            var regexEmail=	/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
            if(!regexEmail.test(inputEmail)){
                /* alert("不符合邮箱格式!"); */
                showValidateMsg("#inputTravelUserEmail","error","不符合邮箱格式!");
                return false;
            }else {
                showValidateMsg("#inputTravelUserEmail","success","可以使用");
            };

            //校验密码
            var inputPassword=$("#inputTravelUserPassword").val();
            var regexPassword=/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{7,}$/;
            if(!regexPassword.test(inputPassword)){
                /* alert("密码长度要大于7位，由数字和字母组成!"); */
                showValidateMsg("#inputTravelUserPassword","error","密码长度要大于7位，由数字和字母组成!");
                return false;
            }else {
                showValidateMsg("#inputTravelUserPassword","success","可以使用");
            };

            //校验地址
            var inputAddress=$("#inputTravelUserAddress").val();
            var regexAddress=/\S/;
            if(!regexAddress.test(inputAddress)){
                /* alert("地址不能为空!"); */
                showValidateMsg("#inputTravelUserAddress","error","地址不能为空!");
                return false;
            }else {
                showValidateMsg("#inputTravelUserAddress","success","可以使用");
            };

            //如果没有触发到上面的条件，就返回true，表示符合规范
            return true;
        }


        /* 当输入用户名的输入框有变化时就发送ajax请求去查看用户名是否已经存在 */
        /* 后端校验数据 */
        $("#inputTravelUserName").change(function() {
            var name=this.value;
            $.ajax({
                url:"${APP_PATH}/checkNameReapt",
                type:"POST",
                data:"name="+name,
                success:function(result){
                    if(result==1){
                        showValidateMsg("#inputTravelUserName","error","该用户名已被注册！");
                        $("#travelUserAddSaveBtn").attr("checkNameResult","error");//存放自定义属性，用于在输入的数据有错误的时候阻止保存
                    } else if(result==2){
                        showValidateMsg("#inputTravelUserName","error","用户名必须为4~16个英文或者字母的组合或者1~5个汉字！");
                        $("#travelUserAddSaveBtn").attr("checkNameResult","notRegex");//存放自定义属性，用于在输入的数据有错误的时候阻止保存
                    }else if(result==0){
                        showValidateMsg("#inputTravelUserName","success","该用户名可以使用！");
                        $("#travelUserAddSaveBtn").attr("checkNameResult","success");//存放自定义属性，用于在有错误的时候阻止保存
                    }
                }
            });
        });

        /* 当输入邮箱的输入框有变化时就发送ajax请求去查看邮箱是否已经存在 */
        /* 后端校验数据 */
        $("#inputTravelUserEmail").change(function() {
            var email=this.value;
            $.ajax({
                url:"${APP_PATH}/checkEmailReapt",
                type:"POST",
                data:"email="+email,
                success:function(result){
                    if(result==1){
                        showValidateMsg("#inputTravelUserEmail","error","该邮箱已被注册！");
                        $("#travelUserAddSaveBtn").attr("checkEmailResult","error");//存放自定义属性，用于在输入的数据有错误的时候阻止保存
                    } else if(result==0){
                        showValidateMsg("#inputTravelUserEmail","success","该邮箱可以使用！");
                        $("#travelUserAddSaveBtn").attr("checkEmailResult","success");//存放自定义属性，用于在有错误的时候阻止保存
                    }
                }
            });
        });


        //点击保存时候发送ajax进行保存
        $("#travelUserAddSaveBtn").click(function() {//添加用户时点击保存

            //1、对输入的数据格式利用正则表达式进行前端校验
            if(!checkData()){//进行前端验证
                return false;//结束，不会向下进行保存
            };

            //2、对输入的数据进行后端校验
            if($("#travelUserAddSaveBtn").attr("checkNameResult")=="error"){
                showValidateMsg("#inputTravelUserName","error","该用户名已经被使用！");
                return false;
            };
            if($("#travelUserAddSaveBtn").attr("checkNameResult")=="notRegex"){
                showValidateMsg("#inputTravelUserName","error","用户名必须为4~16个英文或者字母的组合或者1~5个汉字！");
                return false;
            };
            if($("#travelUserAddSaveBtn").attr("checkEmailResult")=="error"){
                showValidateMsg("#inputTravelUserEmail","error","该邮箱已经被使用！");
                return false;
            };

            $.ajax({
                url:"${APP_PATH}/travelUser",
                type:"POST",
                data:$("#travelUserAddModal form").serialize(),//这个方法能够将这个form表单中的数据全部转换成字符串。不用我们一个一个获取了

                success:function(result){
                    if(result.result==1){//JSR303检验数据通过
                        //添加成功后关闭模态框
                        $("#travelUserAddModal").modal("hide");
                        //跳转到当前页
                        to_page(lastPage);
                    } else{//JSR303校验数据没有通过，将错误信息显示出来
                        if(undefined!=result.extend.errorMap.name){//如果是name属性校验出了问题，就在用户名的输入框上显示错误信息
                            showValidateMsg("#inputTravelUserName","error",result.extend.errorMap.userName);
                        }
                        if(undefined!=result.extend.errorMap.email){//如果是email属性校验出了问题，就在邮箱的输入框上显示错误信息
                            showValidateMsg("#inputTravelUserEmail","error",result.extend.errorMap.email);
                        }
                    }
                }
            });

        });



        /* 打开修改信息的模态框 */
        $(document).on("click",".edit_btn",function() {
            /* 数据回显 */
            selectByIdAndShow($(this).attr("travelUserId_Update"));//从修改按钮的自定义属性中拿到id值。
            /*将id放入修改按钮的自定义属性中 */
            $("#travelUserUpdateSaveBtn").attr("travelUserId_updateBtn",$(this).attr("travelUserId_Update"));

            /* 打开修改模态框 */
            $('#travelUserUpdateModal').modal(
                {
                    backdrop:false
                });
        });

        /* 根据id查找对应的员工信息并进行回显 */
        function selectByIdAndShow(id) {
            $.ajax({
                url:"${APP_PATH}/travelUser/"+id,
                type:"GET",
                success:function(result){//根据拿到的信息显示到模态框中
                    var travelUserData=result.extend.travelUser;
                    $("#updateTravelUserName").val(travelUserData.userName);
                    $("#updateTravelUserPassword").val(travelUserData.email);
                    $("#updateTravelUserModal input[name=sex]").val([travelUserData.sex]);//注意选择的方式有点特殊
                    $("#updateTravelUserEmail").val(travelUserData.email);
                    $("#updateTravelUserAddress").val(travelUserData.address);
                    $("#updateTravelUserModal input[name=role]").val([travelUserData.role]);//注意选择的方式有点特殊
                }
            });
        }


        //点击保存时候发送ajax进行保存
        $("#travelUserUpdateSaveBtn").click(function() {//添加用户时点击保存

            //正则表达式校验用户名
            var updateName=$("#updateTravelUserName").val();
            var regexName=/(^[a-zA-Z0-9_-]{4,16}$)|(^[\u2E80-\u9FFF]{1,5})/;
            if(!regexName.test(updateName)){
                /* alert("用户名必须为4~16个英文或者字母的组合或者1~5个汉字!"); */
                showValidateMsg("#updateTravelUserName","error","用户名必须为4~16个英文或者字母的组合或者1~5个汉字!");
                return false;
            }else {
                showValidateMsg("#inputTravelUserName","success","可以使用");
            };

            //正则表达式校验邮箱
            var updateEmail=$("#updateTravelUserEmail").val();
            var regexEmail=	/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
            if(!regexEmail.test(updateEmail)){
                /* alert("不符合邮箱格式!"); */
                showValidateMsg("#updateTravelUserEmail","error","不符合邮箱格式!");
                return false;
            }else {
                showValidateMsg("#updateTravelUserEmail","success","可以使用");
            };

            //正则表达式校验地址
            var updateAddress=$("#updateTravelUserAddress").val();
            var regexAddress=/\S/;
            if(!regexAddress.test(updateAddress)){
                /* alert("地址不能为空!"); */
                showValidateMsg("#updateTravelUserAddress","error","地址不能为空!");
                return false;
            }else {
                showValidateMsg("#updateTravelUserAddress","success","可以使用");
            };


              // alert($("#travelUserUpdateModal form").serialize());
            $.ajax({
                url:"${APP_PATH}/travelUser/"+$(this).attr("travelUserId_updateBtn"),
                type:"PUT",
                data:$("#travelUserUpdateModal form").serialize(),//这个方法能够将表单中的数据全部转换成字符串。不用我们一个一个获取了
                success:function(result){
                    //修改成功后关闭模态框
                    $("#travelUserUpdateModal").modal("hide");
                    //跳转到对应的页面
                    to_page(currentPage);
                }
            });
        });

        /* 删除 */
        $(document).on("click",".delete_btn",function() {
            var deleteName=$(this).parents("tr").find("td:eq(2)").text();
            var deleteId=$(this).attr("travelUserId_Delete");
            if(confirm("确认要删除"+deleteName+"吗？")){
                $.ajax({
                    url:"${APP_PATH}/travelUser/"+deleteId,
                    type:"DELETE",
                    success:function(result){//根据拿到的信息显示到模态框中
                        to_page(currentPage);
                    }
                });
            }
        });

        /* 全选全不选的功能 */
        $("#checkAll").click(function() {
            $(".travelUser_check").prop("checked",$(this).prop("checked"));
        });

        /* 继续完善全选全不选的功能 */
        $(document).on("click",".travelUser_check",function (){
            if($(".travelUser_check:checked").length==$(".travelUser_check").length){
                $("#checkAll").prop("checked",true);
            }else{
                $("#checkAll").prop("checked",false);
            }
        });

        /*
        * 点击删除按钮进行的动作，删除多个
        * */
        $("#travelUserDeleteModalBtn").click(function () {
            var deleteNameStr="";
            var deleteIdStr="";
            $.each($(".travelUser_check:checked"),function(){//遍历已经勾选的每个元素，并将勾选中的元素中的名字和id分别放入字符串中
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
                    url:"${APP_PATH}/travelUser/"+deleteIdStr,
                    type:"DELETE",
                    success:function(result){//根据拿到的信息显示到模态框中
                        alert(result.message);//弹出操作信息

                        $("#checkAll").prop("checked",false);//取消勾选全选按钮

                        to_page(currentPage);//跳转回原页面
                    }
                });
            }
        });





        /* 点击按照用户编号搜索时 */
        $("#selectUserMsgByUserId").click(function() {
            if($("#inputUserIdToSearch").val()==""){
                alert("用户编号不能为空！");
                return false;
            }
            $.ajax({
                url:"${APP_PATH}/selectUserMsgByUserId",
                data:"userId="+$("#inputUserIdToSearch").val()+"",
                type:"get",
                success:function(result){//根据拿到的信息显示到模态框中
                    $("#pageInfo").empty();
                    $("#pageNav").empty();
                    build_UserListByUserId(result);
                }
            });
        });


        function build_UserListByUserId(data) {//将json中的数据通过jquery遍历添加到table上显示出来
            $("#travelUserTable tbody").empty();//清空上一次查询到的数据，防止重叠

            var item=data.extend.travelUser;

            var checkTd=$("<td><input type='checkbox' class='travelUser_check'/></td>");
            var userIdTd=$("<td></td>").append(item.travelUserId);
            var userNameTd=$("<td></td>").append(item.userName);
            var sexTd=$("<td></td>").append(item.sex);
            var emailTd=$("<td></td>").append(item.email);
            var addressTd=$("<td></td>").append(item.address);
            var roleTd=$("<td></td>").append(item.role==1?"管理员":"游客");
            var userExistTd=$("<td></td>").append(item.travelUserExist==1?"<span style='color: mediumseagreen'>存在</span>":"<span style='color: red'>已被删除！</span>");

            if(item.travelUserExist==1){
                var editBtnTd=$("<button></button>")
                    .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).addClass("btn btn-primary btn-sm edit_btn").append("修改").attr("travelUserId_Update",item.travelUserId);
                var deleteBtnTd=$("<button></button>")
                    .append($("<span></span>").addClass("glyphicon glyphicon-trash")).addClass("btn btn-danger btn-sm delete_btn").append("删除").attr("travelUserId_Delete",item.travelUserId);
                var btnTd=$("<td></td>").append(editBtnTd).append(" ").append(deleteBtnTd);

            }else if(item.travelUserExist==0){
                var btnTd=$("<td></td>");
            }

            $("<tr></tr>").append(checkTd).append(userIdTd).append(userNameTd).append(sexTd).append(emailTd).append(addressTd).append(roleTd).append(userExistTd).append(btnTd).appendTo("#travelUserTable tbody");
        }
    </script>
</body>
</html>