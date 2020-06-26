<%--
  Created by IntelliJ IDEA.
  User: 陽
  Date: 2020/4/30
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    <script  src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
</head>
<body>
<!-- 标题 -->
<div class="row">
    <div class="col-md-12" style="font-size: 20px;background-color:black; border-radius:20px;margin-bottom: 5px">
        <span style="color: #FFFFFF">&nbsp;&nbsp;个人实名信息管理</span>&nbsp;&nbsp;
    </div>
</div>
    <!-- 按钮 -->
    <div class="row">
        <div class="col-md-4 col-md-offset-8">
            <button type="button" class="btn btn-primary" id="addRealNameBtn">添加实名认证信息</button>&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="button" class="btn btn-danger" id="deleteRealNameBtn">删除实名认证信息</button>
        </div>
    </div>
    <!-- 表格数据 -->
    <div class="row">
        <div class="col-md-12">
            <table class="table" id="realNameTable">
                <thead>
                    <tr>
                        <th>
                            <input type="checkbox" id="checkAll">
                        </th>
                        <th>姓名</th>
                        <th>身份证号码</th>
                        <th>性别</th>
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
    <div class="modal fade" id="realNameAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">添加实名信息</h4>
                </div>

                <div class="modal-body">
                    <form class="form-horizontal" id="addRealNameModal">
                        <!-- 姓名 -->
                        <div class="form-group">
                            <label for="inputRealName"  class="col-sm-2 control-label">姓名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputRealName" name="realName" placeholder="请输入真实姓名...">
                                <span id="validateNameMsg" class="help-block"></span>
                            </div>
                        </div>
                        <!-- 身份证 -->
                        <div class="form-group">
                            <label for="inputRealNameIdCard"  class="col-sm-2 control-label">身份证</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputRealNameIdCard" name="idCard" placeholder="请输入身份证...">
                                <span id="validateIdCardMsg" class="help-block"></span>
                            </div>
                        </div>

                        <!-- 性别 -->
                        <div class="form-group">
                            <label class="col-sm-2 control-label">性别</label>
                            <div class="col-sm-10">
                                <label>
                                    <input type="radio" name="sex" id="inputRealNameSex1" value="男" checked>男
                                </label>
                                <label>
                                    <input type="radio" name="sex" id="inputRealNameSex2" value="女">女
                                </label>
                            </div>
                        </div>
                    </form>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="realNameAddSaveBtn">保存</button>
                </div>

            </div>
        </div>
    </div>

    <!-- Modal修改的模态框 -->
    <div class="modal fade" id="realNameUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2">
        <div class="modal-dialog" role="document">
            <div class="modal-content">

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel2">修改实名信息</h4>
                </div>

                <div class="modal-body">
                    <form class="form-horizontal" id="updateRealNameModal">
                        <!-- 姓名 -->
                        <div class="form-group">
                            <label for="updateRealName"  class="col-sm-2 control-label">姓名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="updateRealName" name="realName" placeholder="请输入真实姓名...">
                                <span id="validateNameMsg_update" class="help-block"></span>
                            </div>
                        </div>
                        <!-- 身份证 -->
                        <div class="form-group">
                            <label for="updateRealNameIdCard"  class="col-sm-2 control-label">身份证</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="updateRealNameIdCard" name="idCard" placeholder="请输入身份证...">
                                <span id="validateIdCardMsg_update" class="help-block"></span>
                            </div>
                        </div>

                        <!-- 性别 -->
                        <div class="form-group">
                            <label class="col-sm-2 control-label">性别</label>
                            <div class="col-sm-10">
                                <label>
                                    <input type="radio" name="sex" id="updateRealNameSex1" value="男" checked>男
                                </label>
                                <label>
                                    <input type="radio" name="sex" id="updateRealNameSex2" value="女">女
                                </label>
                            </div>
                        </div>
                    </form>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="realNameUpdateSaveBtn">保存</button>
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
        function build_RealNameList(data) {//将json中的数据通过jquery遍历添加到table上显示出来
            $("#realNameTable tbody").empty();//清空上一次查询到的数据，防止重叠

            var realNames=data.extend.pageInfo.list;
            $.each(realNames,function (index,item) {
                var checkTd=$("<td><input type='checkbox' class='realName_check'/></td>");
                var realNameIdTd=$("<td></td>").append(item.realNameId);
                var realNameTd=$("<td></td>").append(item.realName);
                var idCardTd=$("<td></td>").append(item.idCard);
                var sexTd=$("<td></td>").append(item.sex);

                var editBtnTd=$("<button></button>")
                    .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).addClass("btn btn-primary btn-sm edit_btn").append("修改").attr("realNameId_Update",item.realNameId);
                var deleteBtnTd=$("<button></button>")
                    .append($("<span></span>").addClass("glyphicon glyphicon-trash")).addClass("btn btn-danger btn-sm delete_btn").append("删除").attr("realNameId_Delete",item.realNameId);
                var btnTd=$("<td></td>").append(editBtnTd).append(" ").append(deleteBtnTd);

                $("<tr></tr>").append(checkTd).append(realNameIdTd).append(realNameTd).append(idCardTd).append(sexTd).append(btnTd).appendTo("#realNameTable tbody");
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
                url:"${pageContext.request.contextPath}/loadRealNameList",
                data:"pn="+pn+"&travelUserId=${travelUser.travelUserId}",
                type:"get",
                success:function(data){
                    /*
                         1、解析json数据，显示所有员工
                         2、解析json数据，显示分页信息
                         3、解析json数据，显示分页条
                    */
                    build_RealNameList(data);
                    build_PageInfo(data);
                    build_PageNav(data);
                }
            });
        }



        /* 打开模态框的时候负责清空模态框的内容和样式。主要是为了解决上一次打开模态框添加之后信息未清空便能够再次进行添加的问题 */
        function cleanModal(ele) {
            $(ele)[0].reset();
            $(ele).find("*").removeClass("has-error has-success");
            $(ele).find(".help-block").text("");
        }

        /* 负责点击添加按钮打开添加用户的模态框 */
        $("#addRealNameBtn").click(function() {
            // 清空模态框，消除上一次的数据
            cleanModal("#realNameAddModal form");
            //打开模态框
            $("#realNameAddModal").modal(
                {
                    backdrop:false
                });
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

        /*前端正则表达式校验数据*/
        function checkData() {
            //校验姓名
            var inputName=$("#inputRealName").val();
            var regexName=/^[\u4e00-\u9fa5]{2,4}$/;
            if(!regexName.test(inputName)){
                /* alert("姓名必须为2~4个汉字!"); */
                showValidateMsg("#inputRealName","error","姓名必须为2~4个汉字!");
                return false;
            }else {
                showValidateMsg("#inputRealName","success","");
            };

            //校验身份证
            var inputIdCard=$("#inputRealNameIdCard").val();
            var regexIdCard=/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
            if(!regexIdCard.test(inputIdCard)){
                /* alert("不符合身份证格式!"); */
                showValidateMsg("#inputRealNameIdCard","error","不符合身份证格式!");
                return false;
            }else {
                showValidateMsg("#inputRealNameIdCard","success","");
            };
            //如果没有触发到上面的条件，就返回true，表示符合规范
            return true;
        }


        //点击保存时候发送ajax进行保存
        $("#realNameAddSaveBtn").click(function() {//添加用户时点击保存

            //1、对输入的数据格式利用正则表达式进行前端校验
            if(!checkData()){//进行前端验证
                return false;//结束，不会向下进行保存
            };

            $.ajax({
                url:"${pageContext.request.contextPath}/realName",
                type:"POST",
                data:$("#realNameAddModal form").serialize()+"&travelUserId=${travelUser.travelUserId}",//这个方法能够将这个form表单中的数据全部转换成字符串。不用我们一个一个获取了
                success:function(result){
                    if(result.result==1){
                        //添加成功后关闭模态框
                        $("#realNameAddModal").modal("hide");
                        //跳转到最后一页
                        to_page(lastPage);
                    } else{
                       alert("添加失败！");
                    }
                }
            });

        });

        /* 根据id查找对应的实名信息并进行回显 */
        function selectByIdAndShow(id) {
            $.ajax({
                url:"${pageContext.request.contextPath}/realName/"+id,
                type:"GET",
                success:function(result){//根据拿到的信息显示到模态框中
                    var realName=result.extend.realName;
                    $("#updateRealName").val(realName.realName);
                    $("#updateRealNameIdCard").val(realName.idCard);
                    $("#updateRealNameModal input[name=sex]").val([realName.sex]);//注意选择的方式有点特殊
                }
            });
        }

        /* 打开修改信息的模态框 */
        $(document).on("click",".edit_btn",function() {
            /* 数据回显 */
            selectByIdAndShow($(this).attr("realNameId_Update"));//从修改按钮的自定义属性中拿到id值。
            /*将所点击行的编辑按钮的id属性放入修改按钮的自定义属性中 */
            $("#realNameUpdateSaveBtn").attr("realNameId_updateBtn",$(this).attr("realNameId_Update"));

            /* 打开修改模态框 */
            $('#realNameUpdateModal').modal(
                {
                    backdrop:false
                });
        });

        //点击保存时候发送ajax进行保存
        $("#realNameUpdateSaveBtn").click(function() {//添加用户时点击保存

            //校验姓名
            var updateName=$("#updateRealName").val();
            var regexName=/^[\u4e00-\u9fa5]{2,4}$/;
            if(!regexName.test(updateName)){
                /* alert("姓名必须为2~4个汉字!"); */
                showValidateMsg("#updateRealName","error","姓名必须为2~4个汉字!");
                return false;
            }else {
                showValidateMsg("#updateRealName","success","");
            };

            //校验身份证
            var updateIdCard=$("#updateRealNameIdCard").val();
            var regexIdCard=/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
            if(!regexIdCard.test(updateIdCard)){
                /* alert("不符合身份证格式!"); */
                showValidateMsg("#updateRealNameIdCard","error","不符合身份证格式!");
                return false;
            }else {
                showValidateMsg("#updateRealNameIdCard","success","");
            };

            // alert($("#travelUserUpdateModal form").serialize());
            $.ajax({
                url:"${pageContext.request.contextPath}/realName/"+$(this).attr("realNameId_updateBtn"),
                type:"PUT",
                data:$("#realNameUpdateModal form").serialize(),//这个方法能够将表单中的数据全部转换成字符串。不用我们一个一个获取了
                success:function(result){
                    //修改成功后关闭模态框
                    $("#realNameUpdateModal").modal("hide");
                    //跳转到对应的页面
                    to_page(currentPage);
                }
            });
        });


        /* 删除 */
        $(document).on("click",".delete_btn",function() {
            var deleteName=$(this).parents("tr").find("td:eq(2)").text();
            var deleteId=$(this).attr("realNameId_Delete");
            if(confirm("确认要删除"+deleteName+"吗？")){
                $.ajax({
                    url:"${pageContext.request.contextPath}/realName/"+deleteId,
                    type:"DELETE",
                    success:function(result){//根据拿到的信息显示到模态框中
                        to_page(currentPage);
                    }
                });
            }
        });


        /* 全选全不选的功能 */
        $("#checkAll").click(function() {
            $(".realName_check").prop("checked",$(this).prop("checked"));
        });

        /* 继续完善全选全不选的功能 */
        $(document).on("click",".realName_check",function (){
            if($(".realName_check:checked").length==$(".realName_check").length){
                $("#checkAll").prop("checked",true);
            }else{
                $("#checkAll").prop("checked",false);
            }
        });


        /*
        * 点击删除按钮进行的动作，删除多个
        * */
        $("#deleteRealNameBtn").click(function () {
            var deleteNameStr="";
            var deleteIdStr="";
            $.each($(".realName_check:checked"),function(){//遍历已经勾选的每个元素，并将勾选中的元素中的名字和id分别放入字符串中
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
                    url:"${pageContext.request.contextPath}/realName/"+deleteIdStr,
                    type:"DELETE",
                    success:function(result){//根据拿到的信息显示到模态框中
                        alert(result.message);//弹出操作信息

                        $("#checkAll").prop("checked",false);//取消勾选全选按钮

                        to_page(currentPage);//跳转回原页面
                    }
                });
            }
        });

    </script>
</body>
</html>
