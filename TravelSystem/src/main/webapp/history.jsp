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

    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/swiper.min.css">
    <script src="${pageContext.request.contextPath}/js/swiper.min.js"></script>

    <style type="text/css">
        ul{
            list-style-type:none;
        }
    </style>
</head>
<body>
<div id="page"></div>
<script>
    $("#page").load("header.jsp");
</script>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12" style="">
            <img style="text-align: center" src="${pageContext.request.contextPath}/img/history.jpg" width="1500px">
        </div>
    </div>


    <div class="row" id="div1" style="z-index: 1;margin-top: 5px">
        <ul class="nav nav-tabs" style="height:60px;background-color:rgb(174,138,110);">
            <li class=" col-md-4" style="text-align: center;" role="presentation"><a href="#jqls" style="color: black;font-size: x-large">景区历史</a></li>
            <li class="col-md-4" style="text-align: center" role="presentation"><a href="#qywh" style="color: black;font-size: x-large">企业文化</a></li>
            <li class="col-md-4 " style="text-align: center" role="presentation"><a href="#jtlx" style="color: black;font-size: x-large">交通路线</a></li>
        </ul>
    </div>

    <div class="row" id="jqls">
        <div class="col-md-offset-2 col-lg-8 col-md-offset-2" style="margin-top: 20px">

            <span style="font-weight: bold;font-size: large;"><span class="glyphicon glyphicon-globe" style="color:#00bcd4" aria-hidden="true"></span>&nbsp;景区历史</span><br>

            <div style="margin-bottom: 20px;margin-top: 20px">
                北古小镇位于北京市密云区北古口镇，坐落在司马台长城脚下。北古口自古以雄险著称，有着优越的军事地理位置，《密云县志》上描述北古口“京师北控边塞，顺天所属以松亭、北古口、居庸三关为总要，而北古为尤冲”。北古口以其独特的军事文化吸引了无数文人雅士，苏辙、刘敞、纳兰性德等文词大家在此留下了许多名文佳句，更有康熙、乾隆皇帝多次赞颂，以“地扼襟喉趋溯漠，天留锁钥枕雄关”来称颂它地势的险峻与重要。<br>
            </div>

            <div style="margin-bottom: 20px;margin-top: 20px">
                而今，北古小镇依托司马台遗留的历史文化，进行深度发掘，将9平方公里的度假区整体规划为“六区三谷”，分别为老营区、民国街区、水街风情区、卧龙堡民俗文化区、汤河古寨区、民宿餐饮区与后川禅谷、伊甸谷、云峰翠谷。北古小镇是集观光游览、休闲度假、商务会展、创意文化等旅游业态为一体，服务与设施一流、参与性和体验性极高的综合性特色休闲国际旅游度假目的地。度假区内拥有43万平方米精美的明清及民国风格的山地合院建筑，包含4家主题酒店、10家精品酒店、28家民宿客栈、30余家独立餐厅、50余处商铺和10多个文化展示体验区及完善的配套服务设施。<br>
            </div>

            <div style="text-align: center">
                <img src="${pageContext.request.contextPath}/img/history1.jpg">
            </div>

            <div style="margin-bottom: 20px;margin-top: 20px">
                北古小镇夜景堪称北京一绝，2016年全新重磅打造长城脚下的夜游“八大名玩”：登长城，提灯夜游司马台；品长城，城下湖畔精致晚餐；望长城，摇橹长城下；赏长城，星空温泉絮语；聆长城，浪漫水舞秀；宿长城，夜宿长城脚下；戏长城，戏水长城脚下；醉长城，山顶品酒观星。这个基于北方水文化建造而成的小镇，正在成为北京夜游时尚新地标，吸引越来越多年轻人及国际友人前来度假休闲，这里也是摄影家和美食爱好者的天堂。<br>
            </div>

            <div style="margin-bottom: 20px;margin-top: 20px">
                北古小镇在基础设施的建设中以近项目总投入的三分之一用于生态环保建设，投入资金与规模在国内度假区首屈一指。正如公司总裁所言，“真正的旅游应该是人和自然环境历史的和谐”。公司投资建造了高品质的自来水厂（达到欧盟标准，可以直接饮用）、污水（中水）处理厂；新增改造了各种高压、低压线路；打造应用生物质环保煤的集中供暖中心、液化气站；增加了大量的绿化面积；度假区内河道疏浚拓宽，水系流畅。<br>
            </div>

            <div style="text-align: center">
                <img src="${pageContext.request.contextPath}/img/history2.jpg">
            </div>

            <div style="margin-bottom: 20px;margin-top: 20px">
                为了较完整地保存古朴原貌，使地面免遭破坏，度假区的街道全部采用长条青石板铺设，将热力管道、中水管道、直饮水管道等均埋于地下，不仅有效地保护了地面，对于建设原汁原味的历史文化旅游目的地也起到了重要作用。<br>
            </div>
            <div style="margin-bottom: 20px;margin-top: 20px">
                北古小镇在规划建设阶段，就重视“改厕工程”。北古小镇正式运营三年多以来，既是“旅游厕所革命”的见证者，也是积极的实践家。休息室、母婴室、无障碍厕位、直饮水设置、随处可见的盆栽绿萝、定时控制排气换气扇和喷香机等，无不体现出北古小镇厕所完善的配套设施，以及细致入微的人性化服务。2016年11月19日，由国家旅游局主办，人民日报社人民网承办的“世界厕所日暨中国厕所革命宣传日”，评选出“厕所革命十大典型景区”，北古小镇作为北京市唯一一家代表景区，光荣入选。2017年初，《纽约时报》发文赞许中国国家旅游局在2016年公布的“十三五计划”中对于公厕的指示，积极倡导文明如厕。此次，《纽约时报》不但刊出了北古小镇的公厕照片，还描述了记者的亲身体验：带有沙发、盆栽植物和水彩画的洗手间。小便池特别干净，公共设施完备。北古小镇现有公共厕所二十余个。人性化的母婴室与休息室遍布景区的厕所内。宽松的沙发、座椅、饮水机，搭配轻音乐、装饰画和鲜花，让游客在如厕同时，享受放松的休闲度假时光。<br>
            </div>
        </div>
    </div>


    <div class="row" id="qywh">
        <div class="col-md-offset-2 col-lg-8 col-md-offset-2" style="margin-top: 20px">

            <span style="font-weight: bold;font-size: large;"><span class="glyphicon glyphicon-tower" style="color: #795548" aria-hidden="true"></span>&nbsp;企业文化</span><br>
            <div style="margin-bottom: 20px;margin-top: 20px">
                北京北古小镇旅游有限公司成立于2010年7月，由IDG战略资本、中青旅控股股份有限公司、乌镇旅游股份有限公司和北京能源投资（集团）有限公司共同投资建设。公司旗下北京•密云北古小镇（司马台长城）国际旅游度假区总占地面积9平方公里，总投资60亿元人民币，集观光游览、休闲度假、商务会展、创意文化等旅游业态为一体，服务与设施一流、参与性和体验性极高的综合性特色休闲国际旅游度假目的地。度假区内拥有43万平方米精美的明清及民国风格的山地合院建筑，包含4家主题酒店、10家精品酒店、28家民宿客栈、30余家独立餐厅、50余处商铺和10多个文化展示体验区及完善的配套服务设施。到目前为止，公司拥3500余员工。<br>
            </div>

            <div style="text-align: center">
                <img style="width: 900px" src="${pageContext.request.contextPath}/img/history3.jpg">
            </div>

            <br>

            <div style="margin-top: 20px"><span style="font-size: large;">企业精神</span><br></div>
            <ul>
                <li><span class="glyphicon glyphicon-hand-right" style="color: #d43f3a" aria-hidden="true">&nbsp;</span>愿景：做中国最优秀的度假目的地</li>
                <li><span class="glyphicon glyphicon-hand-right" style="color: #d43f3a" aria-hidden="true">&nbsp;</span>价值观：将最大的善意释放给每一位游客，为每一位宾客提供亲情的体验</li>
                <li><span class="glyphicon glyphicon-hand-right" style="color: #d43f3a" aria-hidden="true">&nbsp;</span>人才观：诚信正直、有作为、有地位</li>
                <li><span class="glyphicon glyphicon-hand-right" style="color: #d43f3a" aria-hidden="true">&nbsp;</span>行为准则：敬业、高效、严谨、关爱</li>
                <li><span class="glyphicon glyphicon-hand-right" style="color: #d43f3a" aria-hidden="true">&nbsp;</span>经营理念：文化是最大的边际利润，细节是最好的口碑传播</li>
                <li><span class="glyphicon glyphicon-hand-right" style="color: #d43f3a" aria-hidden="true">&nbsp;</span>管理理念：制度管人 流程管事 因人成事 因事练人</li>
            </ul>

            <br>

            <span style="font-size: large;">企业荣誉</span><br>
            <ul>
                <li>  <span class="glyphicon glyphicon-grain" style="color: green" aria-hidden="true"></span>&nbsp;2019年4月，北古小镇函谷山庄获评KOL公信力金榜“2019年最佳城市周边休闲度假酒店”。</li>
                <li><span class="glyphicon glyphicon-grain" style="color: green" aria-hidden="true"></span>&nbsp;2019年1月25日，第六届北京惠民文化消费季发布2018北京文化消费品牌榜，北古小镇获评“十大文化旅游路线”。</li>
                <li><span class="glyphicon glyphicon-grain" style="color: green" aria-hidden="true"></span>&nbsp;2019年1月，在2018今日头条年度城市营销大赏活动中，北古小镇获评“2018城市精品品牌”。</li>
                <li><span class="glyphicon glyphicon-grain" style="color: green" aria-hidden="true"></span>&nbsp;2018年10月16日，北京北古小镇旅游有限公司被北京老年旅游接待基地评定委员会评为“2018年老年旅游接待基地达标单位”。</li>
                <li><span class="glyphicon glyphicon-grain" style="color: green" aria-hidden="true"></span>&nbsp;2018年9月，在北京市旅游发展委员会开展的北京赏红叶最佳目的地评选活动中，北古小镇在2018年观赏红叶最佳目的地排名第一名。</li>
                <li><span class="glyphicon glyphicon-grain" style="color: green" aria-hidden="true"></span>&nbsp;2018年2月7日，北古小镇荣获文荟北京•质量生活“十大文化消费地标奖”。</li>
                <li><span class="glyphicon glyphicon-grain" style="color: green" aria-hidden="true"></span>&nbsp;2018年2月3日，北古小镇荣获北京商报社主办的“京燕杯2017北京人喜爱的十大景区”奖。</li>
                <li><span class="glyphicon glyphicon-grain"style="color: green" aria-hidden="true"></span>&nbsp;2017年12月，北古小镇（司马台长城）国际旅游度假区荣获中国会议产业大会2017中国最具体验会奖综合体。</li>
                <li><span class="glyphicon glyphicon-grain"style="color: green" aria-hidden="true"></span>&nbsp;2017年11月，北古小镇荣获2017CITM中国国际旅游交易会优秀广告奖。</li>
                <li><span class="glyphicon glyphicon-grain"style="color: green" aria-hidden="true"></span>&nbsp;2017年6月，荣获2016年度北京市“安康杯”竞赛优胜单位。 </li>
                <li><span class="glyphicon glyphicon-grain"style="color: green" aria-hidden="true"></span>&nbsp;2016年8月，北古小镇荣获第十五届“首都旅游紫禁杯”先进集体奖。</li>
                <li><span class="glyphicon glyphicon-grain" style="color: green"aria-hidden="true"></span>&nbsp;2016年6月，荣获由密云总工会颁发的北京市第四届“福田杯”经济技术创新竞赛活动“优秀班组”奖。</li>
                <li><span class="glyphicon glyphicon-grain"style="color: green" aria-hidden="true"></span>&nbsp;2015年，北古小镇荣获中国旅游总评榜北京榜“年度最具推广力景区”。</li>
                <li><span class="glyphicon glyphicon-grain"style="color: green" aria-hidden="true"></span>&nbsp;2015年1月，北古小镇荣获2014新京报中国旅游总评榜北京榜“最佳生态文明奖”。</li>

            </ul>

        </div>

    </div>


    <div class="row" id="jtlx">
        <div class="col-md-offset-2 col-lg-8 col-md-offset-2" style="margin-top: 20px">

            <span style="font-weight: bold;font-size: large;"><span class=" glyphicon glyphicon-road " style="color:#4A515B" aria-hidden="true"></span>&nbsp;交通路线</span><br>
            <div style="margin-bottom: 20px;margin-top: 20px">
                北古小镇位于北京市密云区北古口镇司马台村，是北京的东北门户。距北京市区120公里，首都机场98公里，密云区城区60公里，承德市区80公里。地处燕山余脉浅丘陵地带，是华北平原通往松辽平原和内蒙古草原的必经要塞之一。目前拥有京承高速、京通铁路、101国道三条主要交通干线。
            </div>
            <table class="table" border="1px solid">
                <thead style="background-color: #f7ecb5">
                <th>城市</th>
                <th>里程（参考）</th>
                <th>所需时间（参考）</th>
                <th>路线（参考）</th>
                </thead>

                <tbody>
                <tr>
                    <td>北京（市内）</td>
                    <td>120公里</td>
                    <td>1.5小时</td>
                    <td>北京→京承高速→北古小镇</td>
                </tr>
                <tr>
                    <td>密云区</td>
                    <td>60公里</td>
                    <td>40分钟</td>
                    <td>1.北古小镇→京承高速→密云<br>
                        2.北古小镇→京密路（101国道）→密云</td>
                </tr>
                </tbody>
            </table>

            <img src="${pageContext.request.contextPath}/img/shoudujichangchufa.jpg"><br><br>

            <span style="font-weight: bold;">1、直通车路线</span><br>
            <div style="margin-bottom: 20px;margin-top: 20px">
                乘坐机场快轨到东直门地铁站下车，在东直门外公交站（东直门外斜街和香河园南街交界处，942、855公交场内）换乘北京-北古小镇专线直达车到达北古小镇，预计120分钟直达北古小镇。票价：48元/人/单程，上车购票（提前半小时开始购票至坐满）。<br>
            </div>
            <span style="font-weight: bold;">2、怀密线列车路线</span><br>
            <div style="margin-bottom: 20px;margin-top: 20px">
                乘坐机场快轨到东直门站换乘13号线（开往西直门方向），到霍营站下车；步行约323米到达S5线黄土店站后乘坐S5线列车（开往怀柔北方向），到北古口站下车，从北古口站乘坐密69路公交车抵达北古小镇。<br>
            </div>
            <span style="font-weight: bold;">3、公交车路线</span><br>
            <div style="margin-bottom: 20px;margin-top: 20px">
                乘坐机场快轨到三元桥站换乘980路公交车或980（快）公交车，到密云西大桥站下车，对面换乘密云51路公交车（北古小镇方向），抵达北古小镇。<br>
            </div>
            <br>

            <img src="${pageContext.request.contextPath}/img/beijinghuochezhanchufa.jpg"><br><br>
            <span style="font-weight: bold;">1、北京站 → “怀密线”黄土店站 → 北古口站 → 北古小镇（约3小时10分钟）</span><br>
            <div style="margin-bottom: 20px;margin-top: 20px">
                乘坐地铁2号线（开往建国门方向），到东直门站下车，换乘13号线（开往西直门方向），到霍营站下车，步行约323米到达“怀密线”黄土店站后乘坐“怀密线”列车（开往怀柔北方向），到北古口站下车，从北古口站乘坐北古小镇专线抵达北古小镇。<br>
            </div>
            <span style="font-weight: bold;">2、北京南站 → “怀密线”黄土店站 → 北古口站 → 北古小镇（约3小时20分钟）</span><br>
            <div style="margin-bottom: 20px;margin-top: 20px">
                乘坐地铁4号线大兴线（开往安河桥北方向），到西直门站下车，换乘13号线（开往东直门方向），到霍营站下车，步行约323米到达“怀密线”黄土店站后乘坐“怀密线”列车（开往怀柔北方向），到北古口站下车，从北古口站乘坐北古小镇专线抵达北古小镇。<br>
            </div>
            <span style="font-weight: bold;">3、北京西站 → “怀密线”黄土店站 → 北古口站 → 北古小镇（约3小时20分钟）</span><br>
            <div style="margin-bottom: 20px;margin-top: 20px">
                乘坐地铁9号线（开往国家图书馆方向）到国家图书馆站换乘4号线大兴线（开往天宫院方向），到西直门站下车；之后换乘13号线（开往东直门方向）到霍营站下车，步行约323米到达“怀密线”黄土店站后乘坐“怀密线”列车（开往怀柔北方向），到北古口站下车，从北古口站乘坐北古小镇专线抵达北古小镇。<br>
            </div>
            <br>

            <img src="${pageContext.request.contextPath}/img/beijinggongjiaochechufa.jpg"><br>
            <div style="margin-bottom: 20px;margin-top: 20px">
                由东直门乘坐980路,在密云西大桥站下车,换乘密51路抵达北古小镇<br>
            </div>
            <br>

            <img src="${pageContext.request.contextPath}/img/beijingditiezhanchufa.jpg"><br>
            <div style="margin-bottom: 90px;margin-top: 20px">
                乘坐地铁13号线到到霍营站下车，步行约323米到达“怀密线”黄土店站后乘坐“怀密线”列车（开往怀柔北方向），到北古口站下车，从北古口站乘坐北古小镇专线抵达北古小镇。<br>
            </div>
        </div>
    </div>
</div>

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
