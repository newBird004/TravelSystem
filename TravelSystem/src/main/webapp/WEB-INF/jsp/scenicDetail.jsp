<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <meta charset="UTF-8">
    <title>首页</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap 101 Template</title>

    <link href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">

    <%--   为了引入日期插件--%>
    <link href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/daterangepicker.css" />


    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>

    <%--    为了引入评论星级插件--%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/commentStarUtil/starability-minified/starability-all.min.css"/>

    <%--   为了引入日期插件--%>
    <script src="${pageContext.request.contextPath}/assets/js/moment.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/daterangepicker.js"></script>

</head>
<body>
<div id="head"></div>
<script>
    $("#head").load("header.jsp");
</script>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-4 col-md-offset-2" style="margin-top: 40px">
            <img style="" src="${pageContext.request.contextPath}/img/Scenic/${scenic.scenicImage}" width="460px" height="360px">
        </div>

        <div class="col-md-6" style="margin-top: 40px;">
            <p style="font-size:large;margin-bottom: 10px">票务名称：北古小镇${scenic.scenicName}联票</p>
            <p style="font-size:large;margin-bottom: 10px">景点简介：北古小镇${scenic.scenicIntroduce}</p>
            <p style="font-size:large;margin-bottom: 10px">票务价格：￥<span style="color: red">${scenic.scenicPrice}</span></p>

            <p style="font-size:large;margin-bottom: 10px">旅客信息：
                <select class="form-control" id="showRealNamesSelect" style="width: 140px;margin-left: 90px">
                </select>
            </p>

            <p style="font-size:large;margin-bottom: 10px">  预约日期：
            <div class="input-group" style="width: 140px;margin-left: 90px">
                <div class="input-group-addon"><span class="glyphicon glyphicon-calendar" aria-hidden="true"></span></div>
                <input type="text" class="form-control" id="date" name="date" placeholder="date">
            </div>
            </p>

            <p style="font-size:large;margin-bottom: 10px">温馨提示：<span style="color: red">请注意您的出行日期！</span></p>
            <button id="purchaseScenic" class="btn btn-danger" style="margin-left: 80px">立即付款</button>
            <button id="addToCart" class="btn btn-success" style="margin-left: 10px">添加购物车</button>
        </div>
    </div>
</div>


<div class="container-fluid" style="margin-top: 26px">

    <div class="row" id="div1" style="margin-bottom: 20px;z-index: 1;font-weight: bolder;font-size: large;" >
        <div class="col-md-offset-2 col-md-8 col-md-offset-2" style="background-color: #e5e5e5;border-radius: 3px">
            <ul class="nav nav-tabs">
                <li role="presentation"><a href="#ydxz" style="color: black">预定须知</a></li>
                <li role="presentation"><a href="#wxts" style="color: black">温馨提示</a></li>
                <li role="presentation"><a href="#jdpj" style="color: black">景点评价</a></li>
            </ul>
        </div>
    </div>

    <div class="row" id="ydxz">
        <div class="col-md-offset-2 col-md-8 col-md-offset-2" >

            <span style="font-weight: bold;font-size: large">【预订须知】：</span><br>
            为坚持做好疫情防控工作，保障您和他人的人身财产安全，游览前，请您仔细阅读并遵守以下须知，共建文明有序的旅游环境，有疑问请及时咨询客服或拨打电话010-81009999<br>

            1. 景区内各开放场所已按相关防疫要求做好全面消毒工作，景区工作人员已完成14天行踪轨迹排摸，无疫区和人员接触史，无发热、咳嗽等身体不适症状。<br>

            2. 北京北古小镇（司马台长城）国际旅游度假区即日起推行实名预约制购票。请您凭本人有效身份证件，通过关注“北古小镇商城”官方微信号、登陆北古小镇官方预定网站（www.wtown.com.cn）或其他官方授权渠道完成预定<br>

            （北古小镇旗下住宿客人小镇门票可享受优惠价格80元，需至游客中心大前台办理入住时购买）。<br>

            3. 游客到达景区前，应提前通过“北京健康宝”小程序申领“健康码”，并请携带好本人身份证。<br>

            4. 游客游览过程中，请务必做好个人防护工作，须全程佩戴口罩。在检票口、餐厅等人群易聚集场所须与他人保持1米以上距离，严禁扎堆，并配合景区工作人员现场引领和管理。<br>

            5. 游客对本人所提供信息的真实性负责，在游览途中一旦出现发热、咳嗽等身体不适情况，请第一时间告知景区工作人员或联系北京市密云区疾病防控控制中心（电话010-69044269）。<br>

            6. 根据疫情防控需要，景区管控措施、开放区域等可能会有调整，并可能根据景区承载量实施限流措施，请关注景区官方公告，并配合工作人员的安排。<br>

            7. 请广大游客朋友认真阅读《北京密云·北古小镇（司马台长城）国际旅游度假区游览须知》，遵守相关的法律法规，有序游览。<br><br><br>

            <span style="font-weight: bold;font-size: large">【电子票使用须知】：</span><br>

            1、北古小镇景区开放时间：9:00-22:00，北古小镇景区检票时间：9:00-14:30；司马台长城开放时间：9:00-17:00；司马台长城检票时间：9:00-16:10；请合理安排您的行程。<br>

            2、司马台长城开放区域：1楼-10楼。<br>

            3、检票地点：游客服务中心检票口及司马台长城检票口。<br>

            4、司马台长城入口及出口需再次检票，请保留好您的电子二维码。<br>

            5、门票当日一次进出有效，刷码注销，不能重复使用。<br>

            6、如游览当天无法打开二维码短信，请联系现场工作人员或者拨打010-81008136进行协助解决。<br>

            7、退改规则：该票种不可部分退款，如需退票，请在小镇门票及司马台长城门票未使用的情况下于游完日期当天24点前发起退票申请，逾期不接受退票。<br>


            <br>
            <br>


            <span style="font-weight: bold;font-size: large;margin-top: 20px">【门票优惠政策】</span>

            <br>
            <br>

            <table border="1px solid">
                <thead>
                <th>优惠类别</th>
                <th>北古小镇（市场调节价）</th>
                <th>司马台长城（政府定价）</th>
                </thead>
                <tbody>
                <tr>
                    <td>免票</td>
                    <td>
                        *身高 1.2 米（含）以下儿童<br>

                        *离休人员凭国务院、中央军委制发的离休干部荣誉证<br>

                        *残疾人凭中国残联制发《残疾人证》<br>

                        *残疾军人凭民政部制发《残疾军人证》<br>

                        *中华人民共和国伤残人民警察证<br>

                        *中华人民共和国伤残国家机关工作人员证<br>

                        *中华人民共和国伤残民兵民工证<br>

                        *记者凭新闻出版总署颁发的记者证<br>
                    </td>
                    <td>
                        *身高 1.2 米（含）以下儿童，6 周岁（含）以下儿童凭<br>

                        有效证件<br>

                        *离休人员凭国务院、中央军委制发的离休干部荣誉证<br>

                        *老年人持《北京通养老助残卡》<br>

                        *残疾人凭中国残联制发《残疾人证》<br>

                        *残疾军人凭民政部制发《残疾军人证》<br>

                        *中华人民共和国伤残人民警察证<br>

                        *中华人民共和国伤残国家机关工作人员证<br>

                        *中华人民共和国伤残民兵民工证<br>

                        *记者凭新闻出版总署颁发的记者证<br>


                        全国医务工作者自司马台长城景区恢复运营日起至2020年12月31日，凭身份证和医师证或护士证等有效证件享受免票。<br>


                    </td>
                </tr>

                <tr>
                    <td>优惠票</td>
                    <td>
                        *身高 1.2 米至 1.5 米（含）的儿童<br>

                        *中、小学生凭学生证<br>

                        *16 周岁以下凭身份证<br>

                        *60 周岁以上老年人凭身份证或优待卡<br>

                        *现役军人凭有效证件<br>

                        *国家消防救援人员<br>
                        --国家综合性消防救援队伍消防员证<br>
                        --国家综合性消防救援队伍干部证<br>
                        --国家综合性消防救援队伍学员证<br>
                    </td>
                    <td>

                        *身高 1.2 米至 1.5 米（含）的儿童<br>

                        *6 周岁（不含 6 周岁）-18 周岁（含 18 周岁）未成年<br>

                        人凭身份证<br>

                        *全日制大、中、小学生凭学生证（不含成人教育及研究

                        生）<br>

                        *香港、澳门、台湾等入境游青少年凭《港澳居民来往内

                        地通行证》、《台湾居民来往大陆通行证》或学生证件

                        等有效身份证明<br>

                        *60 周岁以上老年人凭身份证<br>

                        *现役军人凭有效证件<br>

                        *持有社会保障金领取证的人员<br>

                        *国家消防救援人员<br>
                        --国家综合性消防救援队伍消防员证<br>
                        --国家综合性消防救援队伍干部证<br>
                        --国家综合性消防救援队伍学员证<br>
                    </td>
                </tr>
                </tbody>
            </table>

            <span style="font-weight: bold">注意事项:<br>

            1、以上优惠均需出示本人真实合法有效身份证件；<br>

            2、持有旅行社经理资格证（国家旅游局颁发）、导游证（IC卡）、领队证、随团司机驾驶A1证的，仅限旅行社随团工作人员免票（凭本人有效证件及景区团购单随团进入景区）。<br>

            3、凭记者证免票需在游客服务中心咨询台办理免票登记手续方可进入景区。<br>

            <span style="color: #ac2925">4、疫情期间所有免票和优惠人员均须提前进行网络预约，同时携带相关有效证件，经现场核验有效证件并出示“健康码”后，方可享受相应政策</span><br>
            </span>
        </div>
    </div>


</div>

<div class="row" id="wxts" style="margin-top: 20px">
    <div class="col-md-offset-2 col-md-8 col-md-offset-2" >
        <span style="font-weight: bold;font-size: large;">【温馨提示】：</span><br>


        1）如换票、检票、参观等场所客流繁忙时，请按序排队进入或参观；<br>

        2）景区内河道密布，水深危险，请注意安全，未成年人必须有成人监护并保持随时照顾；<br>

        3）请尊重景区内住户及其他宾客，请勿使用不雅语言，或未经同意进入私宅及作其他无礼行为；<br>

        4）古镇街区内历史建筑多为砖木结构，请注意防火；<br>

        5）所有废弃物请分类丢弃在垃圾箱或指定地点。<br>

        6）以下物品不可携带进入景区：<br>

        ●各类易燃、易爆物和任何有害公众安全之危险物品；<br>

        ●口香糖；<br>

        ●各类导游用喇叭和扩音设备；<br>

        ●手推车或任何装有轮辘之运送用具（行李箱、婴儿推车及轮椅除外）；<br>

        ●宠物。<br>

        7）禁止以下活动：<br>

        ●售卖任何未经许可的物品或服务、展示；<br>

        ●在区内所有河道游泳、未被允许的水上活动或公众水域垂钓；<br>

        ●未经许可之游行或演说、公众集会；<br>

        ●张贴派发印刷品或其他宣传品；<br>

        ●未经许可展示任何旗帜、横幅或徽号；<br>

        ●未经授权批准作商业用途的摄影、摄像或任何形式之记录、广播或传送；<br>

        ●在桥面、街道狭窄处用三脚架进行拍摄；<br>

        ●在禁烟场所吸烟；<br>

        ●攀折树木、采摘花果，各种形式的狩猎，捕捉、打捞水生动物及植物；<br>

        ●破坏生态、污染环境、危害文物之行为；<br>

        ●在未经核准的民居或区域私自留宿；<br>

        ●其它任何有害本历史街区保护或其相关设施之运作之行为。<br>



        申明：<br>

        基于公众场合的秩序掌控及各位游客的安全，我们可能在本历史街区公共区域内拍<br>

        录制或复制任何进入人士之影像或声音而不予通知。<br>

        对于任何不遵守本历史街区管理规则或有违法、危险或无礼行为之人士，我们有权<br>

        拒绝该等人士进入或要求该等人士离开。<br>

        我们可基于以下原因不时更改本景区或景点设施的开放时间、暂停开放或控制<br>

        入内人数、暂停或取消任何游览观赏设施或项目而不事先通知：景区容纳量、恶劣天<br>

        气或特别事件；或为保障安全、治安或秩序；或修缮、保养及我们认为其它情况所需。<br>

    </div>
</div>

<div class="row" id="jdpj" style="margin-top: 20px;margin-bottom: 100px">
    <div class="col-md-offset-2 col-md-8 col-md-offset-2" id="jdpjArea">
        <span style="font-weight: bold;font-size: large;">【景点评价】：</span><br>

        <table class="table" width="600px" id="commentTable" >
            <thead>
            <th>评价编号</th>
            <th>评价内容</th>
            <th>评价星级</th>
            <th>评价日期</th>
            </thead>
            <tbody>
            <tr>
                <td>1515*5848</td>
                <td>景区很棒</td>
                <td>五星</td>
                <td>2020-5-12</td>
            </tr>

            </tbody>
        </table>


    </div>
</div>



<script>

    $(function () {

        //为了设置日历上的起始时间获取当前时间
        var today = new Date();
        var ddToday = String(today.getDate()).padStart(2,'0');//padStart是指要固定两位数字，如果不够，在前面补充0
        var mmToday = String(today.getMonth() +1 ).padStart(2,'0');
        var yyyyToday = today.getFullYear();
        var currentDate =mmToday+'/'+ddToday+'/'+yyyyToday;


        //为日期表设置最大日期，默认是两个月后
        var maxTime=today.getTime()+60*24*60*60*1000;
        var maxDate=new Date(maxTime);
        var ddMaxDate = String(maxDate.getDate()).padStart(2,'0');//padStart是指要固定两位数字，如果不够，在前面补充0
        var mmMaxDate = String(maxDate.getMonth() +1 ).padStart(2,'0');
        var yyyyMaxDate = maxDate.getFullYear();
        var maxDateFinal =mmMaxDate+'/'+ddMaxDate+'/'+yyyyMaxDate;


        //初始化日历插件
        $('#date').daterangepicker({
            "singleDatePicker": true,
            "startDate":currentDate,
            "minDate":currentDate,
            "maxDate":maxDateFinal
        },function () {

        });


        /* 此方法查询所有的实名信息并将信息放入到页面中 */
        function selectRealName(element) {
            $.ajax({
                url:"${pageContext.request.contextPath}/selectRealNameByTravelUserId?travelUserId=${travelUser.travelUserId}",
                type:"get",
                success:function(result){
                    $.each(result.extend.realNames,function(index,item){
                        var option=$("<option></option>").append(item.realName).attr("value",item.realNameId);
                        $(element).append(option);
                    });
                }
            });
        }
        var loginUser="${travelUser}";//查看用户是否登录
        if(loginUser){//如果登陆了，就查询该用户对应的实名信息都有哪些
            selectRealName("#showRealNamesSelect");//将查询到的数据回显到下拉框中。
        }


        //点击立即付款后生成订单
        $("#purchaseScenic").click(function () {
            var isLogin="${travelUser}";
            if(!isLogin){//如果没有登陆，就跳转到登录页面
                window.location.href="${pageContext.request.contextPath}/loginPage";
            }else{
                $.ajax({
                    url:"${pageContext.request.contextPath}/purchaseScenic",
                    type:"post",
                    data:"travelUserId=${travelUser.travelUserId}&price=${scenic.scenicPrice}&realNameId="+$("#showRealNamesSelect").val()+"&scenicId=${scenic.scenicId}&date="+$("#date").val()+"",
                    success:function(result){
                        if(result.result==1){
                            window.location.href="${pageContext.request.contextPath}/openPayPage";
                        }else{
                            alert("失败！");
                        }
                    }
                });
            }

        });

        //点击加入购物车
        $("#addToCart").click(function () {
            var isLogin="${travelUser}";
            if(!isLogin){//如果没有登陆，就跳转到登录页面
                window.location.href="${pageContext.request.contextPath}/loginPage";
            }else{
                $.ajax({
                    url:"${pageContext.request.contextPath}/addScenicToCart",
                    type:"post",
                    data:"travelUserId=${travelUser.travelUserId}&price=${scenic.scenicPrice}&realNameId="+$("#showRealNamesSelect").val()+"&scenicId=${scenic.scenicId}&date="+$("#date").val()+"",
                    success:function(result){
                        if(result.result==1){
                            alert("添加成功！")
                        }else{
                            alert("添加失败！");
                        }
                    }
                });
            }

        });


        $.ajax({
            url:"${pageContext.request.contextPath}/commentsByScenicId",
            type:"get",
            data:"scenicId=${scenic.scenicId}",
            success:function(result){
                build_CommentList(result);
            }
        });


        function build_CommentList(data) {//将json中的数据通过jquery遍历添加到table上显示出来
            $("#commentTable tbody").empty();//清空上一次查询到的数据，防止重叠

            var comments=data.extend.comments;
            $.each(comments,function (index,item) {
                var realNameTd=$("<td></td>").append(item.commentId);
                var commentTextTd=$("<td></td>").append(item.commentText);
                var commentStarTd=$("<td></td>").append(item.commentStar);
                var commentDateTd=$("<td></td>").append(item.commentDate);


                $("<tr></tr>").append(realNameTd).append(commentTextTd).append(commentStarTd).append(commentDateTd).appendTo("#commentTable tbody");
            });
        }
    });

</script>

<%--   随着鼠标下滑，到达一定高度之后，导航栏就固定在顶部--%>
<script type="text/javascript">
    $(function(){
        //获取要定位元素距离浏览器顶部的距离
        var navH = $("#div1").offset().top;
        // console.log(navH);
        //滚动条事件
        $(window).scroll(function(){
            //获取滚动条的滑动距离
            var scroH = $(this).scrollTop();
            // console.log(scroH);
            //滚动条的滑动距离大于等于定位元素距离浏览器顶部的距离，就固定，反之就不固定
            if(scroH>=navH){
                $("#div1").css({"position":"sticky","top":0});
            }else if(scroH<navH){
                $("#div1").css({"position":"static"});
            }
        })
    });
</script>

</body>
</html>
