<%--
  Created by IntelliJ IDEA.
  User: 陽
  Date: 2020/5/14
  Time: 17:00
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

    <script src="${pageContext.request.contextPath}/js/echarts.min.js"></script>

    <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
</head>
<body>

    <div class="container-fluid">
        <div class="row" style="margin-top: 40px">
            <div class="col-md-offset-1 col-md-10 col-md-offset-1">
                <div id="analyzeScenic"  style="width: 1000px;height:400px;">

                </div>
            </div>
        </div>
        <div class="row" style="margin-top: 40px">
            <div class="col-md-offset-1 col-md-10 col-md-offset-1">
                <div id="analyzeHotel"  style="width: 1000px;height:400px;">

                </div>
            </div>
        </div>
        <div class="row"  style="margin-top: 40px;margin-bottom: 90px;">
            <div class="col-md-offset-1 col-md-10 col-md-offset-1">
                <div id="analyzeMoney"  style="width: 1000px;height:400px;">

                </div>
            </div>
        </div>
    </div>


    <script type="text/javascript">

        // var scenicAnalyze=new Array();//map集合存放景点的编号和对应的销量
        var scenicName=[];//景点名称数组
        var scenicCount=[];//景点销量数组

        var hotelName=[];//酒店名称数组
        var hotelCount=[];//酒店销量数组

        var moneyDate=[];//收入时间数组
        var moneyCount=[];//收入数量数组


        $(function () {
            /*发出请求获取到景点销量数据*/
            $.ajax({
                url:"${APP_PATH}/getScenicDataToAnalyze",
                type:"get",
                async:false,
                success:function(data){
                    var i=0;
                    var j=0;
                    var datas=data.extend.scenicAnalyze;
                    $.each(datas,function (index, item) {
                        scenicName[i++]=index;
                        scenicCount[j++]=item;
                        // scenicAnalyze[index]=item;
                    });

                }
            });

            /*发出请求获取到酒店销量数据*/
            $.ajax({
                url:"${APP_PATH}/getHotelDataToAnalyze",
                type:"get",
                async:false,
                success:function(data){
                    var i=0;
                    var j=0;
                    var datas=data.extend.hotelAnalyze;
                    $.each(datas,function (index, item) {
                        hotelName[i++]=index;
                        hotelCount[j++]=item;
                        // scenicAnalyze[index]=item;
                    });

                }
            });

            /*发出请求获取到收入数据*/
            $.ajax({
                url:"${APP_PATH}/getMoneyDataToAnalyze",
                type:"get",
                async:false,
                success:function(data){
                    var i=0;
                    var j=0;
                    var datas=data.extend.moneyAnalyze;
                    $.each(datas,function (index, item) {
                        moneyDate[i++]=index;
                        moneyCount[j++]=item;
                        // scenicAnalyze[index]=item;
                    });

                }
            });



            // 基于准备好的dom，初始化echarts实例
            var myChart1 = echarts.init(document.getElementById('analyzeScenic'));
            // 指定图表的配置项和数据
            var option1 = {
                color: ['#c9e2b3'],
                title: {
                    text: '各景点门票销量柱状分析图'
                },
                tooltip: {},
                legend: {
                    data:['门票销量']
                },
                xAxis: {
                    axisLabel: {
                        interval:0,
                        rotate:30
                    },
                    // data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
                    data:scenicName
                },
                yAxis: {},
                series: [{
                    name: '销量',
                    type: 'bar',
                    data:scenicCount
                }],
            };
            // 使用刚指定的配置项和数据显示图表。
            myChart1.setOption(option1);


            // 基于准备好的dom，初始化echarts实例
            var myChart2 = echarts.init(document.getElementById('analyzeHotel'));
            // 指定图表的配置项和数据
            var option2 = {
                title: {
                    text: '各酒店入住次数柱状分析图'
                },
                tooltip: {},
                legend: {
                    data:['入住次数']
                },
                xAxis: {
                    axisLabel: {
                        interval:0,
                        rotate:30
                    },
                    // data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
                    data:hotelName
                },
                yAxis: {},
                series: [{
                    name: '销量',
                    type: 'bar',
                    data:hotelCount
                }],
            };
            // 使用刚指定的配置项和数据显示图表。
            myChart2.setOption(option2);



            // 基于准备好的dom，初始化echarts实例
            var myChart3 = echarts.init(document.getElementById('analyzeMoney'));
            // 指定图表的配置项和数据
            var option3 = {
                title: {
                    text: '最近十日内景区总收入折线图'
                },
                xAxis: {
                    type: 'category',
                    boundaryGap: false,
                    data: moneyDate
                },
                yAxis: {
                    type: 'value'
                },
                series: [{
                    data: moneyCount,
                    type: 'line',
                    areaStyle: {}
                }]
            };
            // 使用刚指定的配置项和数据显示图表。
            myChart3.setOption(option3);
        });



    </script>
</body>
</html>
