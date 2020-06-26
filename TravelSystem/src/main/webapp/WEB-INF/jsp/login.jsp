<%@ page language="java" contentType="text/html; charset=UTF-8"
    isELIgnored="false" pageEncoding="UTF-8"%>
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
    
    <script  src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
    
    <style type="text/css">
        #a{
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%,-80%);
            background-color:RGB(219,220,228);
            opacity:0.7;
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
            background: rgba(41, 50, 39, 1) url("${pageContext.request.contextPath}/img/bg1.jpg") no-repeat fixed center center;
        }
    </style>
<title>登陆界面</title>
</head>
<body>
	<div id="a" style="width: 340px;height: 240px">

        <table style="width: 340px;height: 240px;"  >
            <tr style="text-align:center">
                <td colspan="2">
                    在此开启您的旅程，<a style="color: red" href="${pageContext.request.contextPath}/registerPage">点击这里免费注册！</a>
                </td>
            </tr>
            <tr>
                <td style="text-align: center"><label>用户名</label></td>
                <td class="form-inline" > <input type="text" class="form-control" id="userName" name="userName" style="width: 190px;" placeholder="请输入用户名">

                </td>
            </tr>
            <tr>
                <td style="text-align: center;">  <label>密码</label></td>
                <td class="form-inline" >
                	<input type="password" class="form-control" id="password" name="password" style="width: 190px;" placeholder="请输入密码" >
                </td>
            </tr>

            <tr style="text-align: center">
                <td colspan="2">
                   <span id="loginfail" name="loginfail" style="color: red;">用户名或密码错误</span>
                </td>
            </tr>
             <tr style="text-align: center">
                <td colspan="2">
                  	<input type="checkbox" name="rememberUserAndPwd" id="rememberUserAndPwd">记住密码
                  	 &nbsp;&nbsp;&nbsp;&nbsp;
                  	<input type="checkbox" name="autoLogin" id="autoLogin" >自动登陆
                </td>
            </tr>
            <tr style="text-align: center">
                <td colspan="2">
                    <input  id="submit" name="submit" type="submit" class="btn btn-default" value="登陆">
                   &nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="reset" id="reset" class="btn btn-default" value="重置">
                </td>
            </tr>

            <tr style="text-align:center">
                <td colspan="2">
                    <a style="color: black" href="${pageContext.request.contextPath}/openFindPwdPage">忘记密码？</a>
                </td>
            </tr>
        </table>

</div>

<script type="text/javascript">
    // getCookie这个方法就是根据参数中的名字去cookie中找到对应的值
    // 有必要说一下document.cookie是什么意思 js的方法,作用是获取cookie中的数据。而cookie中的数据存储方式是这样的cookie="userId=828; userName=hulk"
	function getCookie(cname)
	{
	  var name = cname + "=";//加上一个等号，作用一会儿就知道了。主要是为了方便拿到value值。
	  var ca = document.cookie.split(';');//根据；分隔，得到一个数组。
	  for(var i=0; i<ca.length; i++) //遍历所有的数据
	  {
	    var c = ca[i].trim();//去除多余的空格
	    if (c.indexOf(name)==0) return c.substring(name.length,c.length);//如果查找到了想要找的cookie数据名字，就截取出来并返回
	  }
	  return "";
	}


    $(function () {
    	$("#loginfail").hide();//隐藏用户名或密码错误

        /*$("#form1").validate({
        	rules:{
        		userName:{
        			required:true
        		},
        		password:{
        			required:true,
        		}
        	},
        	messages:{
        		userName:{
        			required:"该项必填哦"
        		},
        		password:{
        			required:"该项必填哦"
        		}
        	}
        });*/

        var rememberUser=getCookie("rememberUser");//从cookie中查找是否有记住的用户名和密码并填写到表单上去
		var rememberPwd=getCookie("rememberPwd");

		var rememberUser2=decodeURIComponent(rememberUser);//因为用户名可能有中文，为了避免乱码。我们在向cookie中存放用户名的时候，是经过了URLEncoder进行编码的。这里需要解开。
        $("#userName").val(rememberUser2);//cookie中的用户名自动填充，即记住用户名和密码功能
		$("#password").val(rememberPwd);//cookie中的密码自动填充，即记住用户名和密码功能

        $("#submit").click(function () {
			$.post("${pageContext.request.contextPath}/login",
					{"userName":$("#userName").val(),"password":$("#password").val(),"rememberUserAndPwd":$("#rememberUserAndPwd").prop("checked"),"autoLogin":$("#autoLogin").prop("checked")},function(data){
				if(data=="loginFail"){
					$("#loginfail").show();
				}else if(data=="commonUserLoginSuccess"||data=="loginSuccess"){
					window.location.href = "${pageContext.request.contextPath}/index.jsp";
				}else if(data=="managerLoginSuccess"){
                    window.location.href = "${pageContext.request.contextPath}/TravelManagerSystem";
                }
			},"text");
		});

        $("#reset").click(function (){
            $("#userName").val("");
            $("#password").val("");
        });

    });
</script>

</body>
</html>