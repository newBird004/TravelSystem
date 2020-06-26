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
    <form id="personalForm" class="form-horizontal" style="margin-top: 50px">
        <div class="form-group">
            <label for="travelUserId" class="col-md-4 control-label">用户编号</label>
            <div class="col-md-4">
                <input type="text" class="form-control" name="travelUserId" id="travelUserId" disabled="disabled" placeholder="ID">
            </div>
        </div>
        <div class="form-group">
            <label for="userName" class="col-md-4 control-label">用户名</label>
            <div class="col-md-4">
                <input type="text" class="form-control" name="userName" id="userName" disabled="disabled" placeholder="userName">
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-md-4 control-label">密码</label>
            <div class="col-md-4">
                <input type="password" class="form-control"  name="password" id="password" disabled="disabled"  placeholder="password">
            </div>
        </div>
        <div class="form-group" id="sexDiv">
            <label class="col-md-4 control-label">性别</label>
            <div class="col-sm-4">
                <label>
                    <input type="radio" name="sex" id="sex" value="男">男
                </label>
                <label>
                    <input type="radio" name="sex" id="sex2" value="女">女
                </label>
            </div>
        </div>
        <div class="form-group">
            <label for="email" class="col-md-4 control-label">邮箱</label>
            <div class="col-md-4">
                <input type="email" class="form-control" name="email" id="email" disabled="disabled" placeholder="email">
            </div>
        </div>
        <div class="form-group">
            <label for="address" class="col-md-4 control-label">地址</label>
            <div class="col-md-4">
                <input type="text" class="form-control" name="address" id="address" placeholder="address">
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-offset-5 col-md-7">
                <button id="personalBtn" type="button" class="btn btn-default">确认提交</button>
            </div>
        </div>
    </form>

    <script type="text/javascript">
        $(function () {
            function showData(){
                //回调显示该用户信息
                $.ajax({
                    url:"${pageContext.request.contextPath}/loadPersonalMsg",
                    data:"travelUserId=${travelUser.travelUserId}",
                    type:"post",
                    success:function(data){
                        $("#travelUserId").val(data.extend.travelUser.travelUserId);
                        $("#userName").val(data.extend.travelUser.userName);
                        $("#password").val(data.extend.travelUser.password);
                        $("#sexDiv input[name=sex]").val([data.extend.travelUser.sex]);
                        $("#email").val(data.extend.travelUser.email);
                        $("#address").val(data.extend.travelUser.address);

                    }
                });
            }
            showData();//调用该函数进行回显

            $("#personalBtn").click(function () {
                $.ajax({
                    url:"${pageContext.request.contextPath}/savePersonalMsg",
                    data:$("#personalForm").serialize()+"&travelUserId=${travelUser.travelUserId}",
                    type:"post",
                    success:function(data){
                        if(data==1){
                            showData();//调用该函数进行回显
                            alert("修改成功！");
                        }else{
                            alert("修改失败！");
                        }
                    }
                });
            });

        });
    </script>
</body>
</html>
