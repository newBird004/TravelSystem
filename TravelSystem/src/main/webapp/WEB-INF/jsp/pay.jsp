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
    

<title>支付界面</title>
</head>
<body>

    <div class="jumbotron" style="text-align: center">
        <h1>您共需要支付${price}元!</h1>
        <h1>订单号码为${orderId}!</h1>
        <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/changeOrderToPaied?orderId=${orderId}" role="button">点击支付完成！</a>

    </div>
</body>
</html>