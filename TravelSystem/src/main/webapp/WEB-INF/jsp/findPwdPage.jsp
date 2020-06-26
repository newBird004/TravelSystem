<%--
  Created by IntelliJ IDEA.
  User: 陽
  Date: 2020/4/29
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>头部</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap 101 Template</title>

    <link href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">

    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <style type="text/css">
        #a{
            position: absolute;
            top: 60%;
            left: 50%;
            transform: translate(-50%,-80%);
            border-radius:16px;
        }
        body {
            width:100%;
            height: 100%;
            /* 加载背景图 */
            /* 背景图垂直、水平均居中 */
            /* 当内容高度大于图片高度时，背景图像的位置相对于viewport固定 */
            /* 让背景图基于容器大小伸缩 */
            background-size: cover;
            /* 设置背景颜色，背景图加载过程中会显示背景色 */

        }
    </style>
</head>
<body>
    <div id="page"> </div>
    <script>
        $("#page").load("header.jsp");
    </script>

    <div style="text-align: center;margin-top: 30px">

        <P style="font-size: large">邮箱找回密码</P>

    </div>


    <div id="a" style="width: 400px;height: 340px;margin-top: 30px" >
        <form class="form-horizontal" id="findPwdByEmailForm">
            <div class="form-group">
                <label for="findPwdEmail"  class="col-sm-4 control-label">注册邮箱:</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="findPwdEmail" name="findPwdEmail"  placeholder="请输入邮箱">
                    <span id="validateEmailMsg" class="help-block"></span>
                </div>
                <div class="col-sm-3">
                    <button type="button" id="sendEmailBtn" class="btn btn-default">发送验证码</button>
                </div>
            </div>

            <div class="form-group">
                <label for="receiveCode"  class="col-sm-4 control-label">收到的验证码:</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="receiveCode" name="receiveCode" placeholder="请输入收到的验证码...">
                    <span id="validateCodeMsg" class="help-block"></span>
                </div>
            </div>

            <!-- 新密码 -->
            <div class="form-group">
                <label for="newPwd"  class="col-sm-4 control-label">新密码:</label>
                <div class="col-sm-8">
                    <input type="password" class="form-control" id="newPwd" name="newPwd" placeholder="请输入新密码...">
                    <span id="validatePasswordMsg" class="help-block"></span>
                </div>
            </div>
            <!-- 新密码 -->
            <div class="form-group">
                <label for="newPwdAgain"  class="col-sm-4 control-label">新密码:</label>
                <div class="col-sm-8">
                    <input type="password" class="form-control" id="newPwdAgain" name="newPwdAgain" placeholder="请再次输入新密码...">
                    <span id="validatePasswordAgainMsg" class="help-block"></span>
                </div>
            </div>

            <div class="form-group" style="text-align: center">
                <button type="button" id="submitBtn" class="btn btn-success">确认提交</button>
                <button type="button" id="returnLoginBtn" class="btn btn-default">返回登陆</button>
            </div>

        </form>
    </div>


    <script type="text/javascript">


        $(function(){

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
            function checkEmailData() {
                //校验邮箱
                var findPwdEmail=$("#findPwdEmail").val();
                var regexEmail=	/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
                if(!regexEmail.test(findPwdEmail)){
                    /* alert("不符合邮箱格式!"); */
                    showValidateMsg("#findPwdEmail","error","不符合邮箱格式!");
                    return false;
                }else {
                    showValidateMsg("#findPwdEmail","success","发送成功,请注意查收！");
                };
                //如果没有触发到上面的条件，就返回true，表示符合规范
                return true;
            }

            $("#sendEmailBtn").click(function () {
                //1、正则表达式校验邮箱格式
                if(!checkEmailData()){
                    return false;
                };

                $.ajax({
                    url:"${pageContext.request.contextPath}/sendEmail",
                    data:"emailAddress="+$("#findPwdEmail").val()+"",
                    type:"POST",
                    success:function(result){
                        alert("发送成功！");
                    }
                });
            });

            /*前端正则表达式校验密码*/
            function checkPwdData() {
                //校验密码格式
                var newPwd=$("#newPwd").val();
                var regexPwd=/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{7,}$/;
                if(!regexPwd.test(newPwd)){
                    /* alert("不符合密码格式!"); */
                    showValidateMsg("#newPwd","error","密码长度要大于7位，由数字和字母组成!");
                    return false;
                }else {
                    showValidateMsg("#newPwd","success","可以使用！");
                };
                //如果没有触发到上面的条件，就返回true，表示符合规范
                return true;
            }

            //校验再次输入的密码是否一致
            function checkPwdAgain(){
                var newPwd=$("#newPwd").val();
                var newPwdAgain=$("#newPwdAgain").val();
                    if(newPwd!=newPwdAgain){
                        showValidateMsg("#newPwdAgain","error","两次密码不一致！");
                        return false;
                    }
                showValidateMsg("#newPwdAgain","success","");
                return  true;
            }
            //发送ajax检查验证码是否正确
            function checkCode() {
                $.ajax({
                    url:"${pageContext.request.contextPath}/checkCode",
                    data:"checkCode="+$("#receiveCode").val()+"",
                    type:"POST",
                    success:function(result){
                        if(result.result==1){
                            $("#submitBtn").attr("codeResult","true");
                            showValidateMsg("#receiveCode","success","");
                        }else{
                            $("#submitBtn").attr("codeResult","false");
                            showValidateMsg("#receiveCode","error","验证码错误！");
                        }
                    }
                });
            }

            $("#submitBtn").click(function () {
                //1、正则表达式校验密码格式
                if(!checkPwdData()){
                    return false;
                };

                //2、前端校验两次密码一致
                if(!checkPwdAgain()){
                    return false;
                };

                //3、校验验证码是否一致
                checkCode();
                if($("#submitBtn").attr("codeResult")==false){
                    return false;
                };

                $.ajax({
                    url:"${pageContext.request.contextPath}/changePwdByEmail",
                    data:"emailAddress="+$("#findPwdEmail").val()+"&newPWd="+$("#newPwd").val()+"",
                    type:"POST",
                    success:function(result){
                        if(result.result==1){
                            alert("修改成功！");
                        }else{
                            alert("修改失败！");
                        }
                    }
                });
            });


            $("#returnLoginBtn").click(function () {
                window.location.href="${pageContext.request.contextPath}/loginPage";
            });
        });

    </script>
</body>

</html>
