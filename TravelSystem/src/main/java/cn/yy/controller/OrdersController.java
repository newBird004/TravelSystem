package cn.yy.controller;

import cn.yy.pojo.Msg;
import cn.yy.pojo.Orders;
import cn.yy.pojo.Scenic;
import cn.yy.service.HotelService;
import cn.yy.service.OrderItemService;
import cn.yy.service.OrdersService;
import cn.yy.service.ScenicService;
import cn.yy.vo.OrderItemCustom;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private ScenicService scenicService;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private OrderItemService orderItemService;

    /*跳转到订单列表jsp页面*/
    @RequestMapping("/openOrdersListPage")
    public String openOrderListPage(){
        return "orders";
    }

    /*根据页数查询到订单并返回给页面加载*/
    @RequestMapping("/loadOrderList")
    @ResponseBody
    public Msg loadOrderList(@RequestParam(value = "pn",defaultValue ="1")Integer pageNum){

        PageHelper.startPage(pageNum,8);//设置分页的数据。第一个参数指的是当前页，第二个参数是每页有多少条数据

        List<Orders> orders = ordersService.selectAll();//紧跟在PageHelper.startPage()方法之后的这个查询就是一个分页查询

        PageInfo pageInfo=new PageInfo(orders,5);//用pageinfo封装分页的信息。

        Msg msg=Msg.success();
        msg.add("pageInfo",pageInfo);
        return msg;
    }

    /*
     * 根据id查询数据，并返回给页面。进行数据回显。
     * */
    @ResponseBody
    @RequestMapping(value = "/order/{id}",method = RequestMethod.GET)
    public Msg getMsgById(@PathVariable("id")Integer id){

        List<OrderItemCustom> orderItemCustoms = ordersService.selectOrderDetailByOrderId(id);

        Msg msg=Msg.success();
        msg.add("orderItems",orderItemCustoms);
        return  msg;
    }


    /*根据订单编号查询订单*/
    @RequestMapping("/selectOrderById")
    @ResponseBody
    public Msg selectOrderById(String orderId){

        Orders orderById = ordersService.selectOrderByOrderId(Integer.parseInt(orderId));//紧跟在PageHelper.startPage()方法之后的这个查询就是一个分页查询

        Msg msg=Msg.success();
        msg.add("orderById",orderById);
        return msg;
    }
    /*根据用户编号查询订单*/
    @RequestMapping("/selectOrderByUserId")
    @ResponseBody
    public Msg selectOrderByUserId(String userId){

        List<Orders> orders = ordersService.selectOrdersByUserId(Integer.parseInt(userId));

        Msg msg=Msg.success();
        msg.add("orders",orders);
        return msg;
    }


    /*根据订单编号查询个人订单*/
    @RequestMapping("/selectPersonalOrderById")
    @ResponseBody
    public Msg selectPersonalOrderById(String orderId,String travelUserId){

        List<Orders> orderByIds = ordersService.selectOrderByOrderIdAndUserId(Integer.parseInt(orderId),Integer.parseInt(travelUserId));//紧跟在PageHelper.startPage()方法之后的这个查询就是一个分页查询

        Orders orderById=new Orders();

        if(orderByIds.size()!=0){
            orderById=orderByIds.get(0);
        }
        Msg msg=Msg.success();
        msg.add("orderById",orderById);
        return msg;
    }

    /*根据订单编号取消未支付订单*/
    @ResponseBody
    @RequestMapping("/cancelUnPaidOrder/{orderId}")
    public Msg cancelUnPaidOrder(@PathVariable(value = "orderId") String orderId){

        ordersService.cancelUnpaiedOrder(Integer.parseInt(orderId));
        Msg msg=Msg.success();
        return msg;
    }


    /*跳转到订单分析jsp页面*/
    @RequestMapping("/openOrderAnalyze")
    public String openOrderAnalyze(){
        return "analyzeOrder";
    }

    /*拿到所有景区对应的销量数据*/
    @RequestMapping("/getScenicDataToAnalyze")
    @ResponseBody
    public Msg getScenicDataToAnalyze(){

        Map<String, Integer> scenicAnalyze = scenicService.selectScenicDataToAnalyze();
//        Set<String> strings = scenicAnalyze.keySet();
//        for(String s:strings){
//            System.out.println(s+"-"+scenicAnalyze.get(s));
//        }
        Msg msg=Msg.success();
        msg.add("scenicAnalyze",scenicAnalyze);
        return msg;
    }

    /*拿到所有酒店对应的销量数据*/
    @RequestMapping("/getHotelDataToAnalyze")
    @ResponseBody
    public Msg getHotelDataToAnalyze(){

        Map<String, Integer> hotelAnalyze = hotelService.selectHotelDataToAnalyze();
//        Set<String> strings = hotelAnalyze.keySet();
//        for(String s:strings){
//            System.out.println(s+"-"+hotelAnalyze.get(s));
//        }
        Msg msg=Msg.success();
        msg.add("hotelAnalyze",hotelAnalyze);
        return msg;
    }

    /*拿到所有日期收入的数据*/
    @RequestMapping("/getMoneyDataToAnalyze")
    @ResponseBody
    public Msg getMoneyDataToAnalyze(){

        Map<String, Integer> moneyAnalyze =orderItemService.selectMoneyDataToAnalyze();
        Set<String> strings = moneyAnalyze.keySet();
        for(String s:strings){
            System.out.println(s+"-"+moneyAnalyze.get(s));
        }

        Msg msg=Msg.success();
        msg.add("moneyAnalyze",moneyAnalyze);
        return msg;
    }

}
