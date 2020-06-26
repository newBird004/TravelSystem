<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    
    <script  src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
    
    <style type="text/css">
        #a{
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%,-50%);
            background-color:RGB(219,220,228);
            opacity:0.7;/*透明度*/
            border-radius:16px;/*边缘看起来圆润*/
        }
        body {
            width:100%;
            height: 100%;
            /* 加载背景图 */
            background: url("${pageContext.request.contextPath}/img/bg1.jpg") no-repeat;
            /* 背景图垂直、水平均居中 */
            background-position: center center;
            /* 当内容高度大于图片高度时，背景图像的位置相对于viewport固定 */
            background-attachment: fixed;
            /* 让背景图基于容器大小伸缩 */
            background-size: cover;
            /* 设置背景颜色，背景图加载过程中会显示背景色 */
            　　background-color: rgba(41, 50, 39, 1);
        }
    </style>
</head>
<body>
<div id="a" style="width: 440px;height: 350px">
    <form action="${pageContext.request.contextPath}/register" method="post" id="form1">
        <table style="width: 440px;height: 350px;" >
            <tr>
                <td style="text-align: right;"><label>用户名&nbsp;&nbsp;&nbsp;&nbsp;</label></td>
                <td class="form-inline" > <input type="text" class="form-control" id="userName" name="userName" style="width: 190px;" placeholder="请输入用户名">
                  <span id="msg1"  style="color: red;">该用户名已被注册！</span><span id="msg2"  style="color: red;"> 必须为4~16个字母或者1~5个汉字！</span>
                </td>
            </tr>
            <tr>
                <td style="text-align: right;">  <label>密码&nbsp;&nbsp;&nbsp;&nbsp;</label></td>
                <td class="form-inline" > 
                	<input type="password" class="form-control" id="password" name="password" style="width: 190px;" placeholder="请输入密码" >
                </td>
            </tr>
            <tr>
                <td style="text-align: right">  <label>确认密码&nbsp;&nbsp;&nbsp;&nbsp;</label></td>
                <td class="form-inline" > <input type="password" class="form-control" id="repassword" name="repassword" style="width: 190px;" placeholder="请再次输入密码">
                </td>
            </tr>
            <tr>
                <td style="text-align: right">  <label >邮箱&nbsp;&nbsp;&nbsp;&nbsp;</label></td>
                <td class="form-inline" ><input type="text" class="form-control" id="email" name="email" style="width: 190px;" placeholder="请输入邮箱">
                    <span id="msg3"  style="color: red;">该邮箱已被注册！</span>
                </td>
            </tr>
            <tr>
                <td style="text-align: right">  <label>地址&nbsp;&nbsp;&nbsp;&nbsp;</label></td>
                <td class="form-inline">
                    <input type="text" class="form-control" id="address" name="address" style="width: 190px;" placeholder="请输入地址">
                </td>
            </tr>

            <tr>
                <td style="text-align: right">  <label>性别&nbsp;&nbsp;&nbsp;&nbsp;</label></td>
                <td>
                    <input type="radio" name="sex" id="sex" value="男" checked="checked">男
                    <input type="radio" name="sex" id="sex1" value="女">女
                </td>
            </tr>
            <tr style="text-align: center;">
                <td colspan="2">
                    <input  id="submit" name="submit" type="submit" class="btn btn-default" value="注册">&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="reset" id="reset" class="btn btn-default" value="重置">
                </td>
            </tr>

            <tr style="text-align: center;">
                <td colspan="2">
                    <a style="color: red" href="${pageContext.request.contextPath}/loginPage">返回登陆</a>
                </td>
            </tr>
        </table>
    </form>
    
</div>

<script type="text/javascript">
    $(function () {
    	$("#reset").click();//每次都清空注册表。解决一些问题，比如没填写验证码就能注册成功


        $("#msg1").hide();
        $("#msg2").hide();
        $("#msg3").hide();
        $("#userName").change(function() {
			$.get("${pageContext.request.contextPath}/checkNameReapt","name="+$("#userName").val()+"",function(data){
					if (data=="1") {//已经存在该用户
						  $("#msg1").show();
                          $("#msg2").hide();//去掉这个信息，防止两个信息同时存在
						  $("#submit").prop("disabled","disabled");
					}else if(data=="2")  {//该用户名不符合规范，不可以使用
                        $("#msg2").show();
                        $("#msg1").hide();
                        $("#submit").prop("disabled","disabled");
                    }else if(data=="0")  {//不存在该用户，且命名符合规范，可以使用
                        $("#msg1").hide();
                        $("#msg2").hide();
                        $("#submit").prop("disabled","");
					}
			},"text");
		});
        $("#email").change(function() {
            $.get("${pageContext.request.contextPath}/checkEmailReapt","email="+$("#email").val()+"",function(data){
                if (data=="1") {//已经存在该邮箱
                    $("#msg3").show();
                    $("#submit").prop("disabled","disabled");
                }else if(data=="0")  {//不存在该邮箱，且命名符合规范，可以使用
                    $("#msg3").hide();
                    $("#submit").prop("disabled","");
                }
            },"text");
        });

        $("#form1").validate({
        	rules:{
        		userName:{
        			required:true
        		},
        		password:{
        			required:true,
        			minlength:7
        		},
        		repassword:{
        			required:true,
        			equalTo:"#password"
        		},
        		email:{
        			email:true
        		},
        		address:{
        			required:true
        		}
        	},
        	messages:{
        		userName:{
        			required:"该项必填哦"
        		},
        		password:{
        			required:"该项必填哦",
        			minlength:"长度至少{0}位"
        		},
        		repassword:{
        			required:"该项必填哦",
        			equalTo:"两次输入密码不一致！"
        		},
        		email:{
        			email:"请填写邮箱格式"
        		},
                address:{
        			required:"该项必填哦"
        		}
        	}
        });
    });
</script>
</body>
</html>