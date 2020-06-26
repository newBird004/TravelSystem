package cn.yy.service.impl;

import cn.yy.dao.OrderItemCustomMapper;
import cn.yy.dao.OrderItemMapper;
import cn.yy.dao.OrdersMapper;
import cn.yy.pojo.OrderItem;
import cn.yy.pojo.OrderItemExample;
import cn.yy.pojo.Orders;
import cn.yy.pojo.OrdersExample;
import cn.yy.service.OrderItemService;
import cn.yy.vo.OrderItemCustom;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private OrderItemCustomMapper orderItemCustomMapper;

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public Integer insertOrderItem(OrderItem orderItem) {
        orderItemMapper.insertSelective(orderItem);
        return orderItem.getOrderItemId();
    }

    @Override
    public List<OrderItemCustom> selectCouldCommentOrderItemsByUserId(Integer travelUserId) {

        OrdersExample ordersExample=new OrdersExample();
        OrdersExample.Criteria criteria = ordersExample.createCriteria();
        criteria.andTravelUserId_FK_OrdersEqualTo(travelUserId);//这个用户的
        criteria.andOrderStatusEqualTo(1);//已经支付的

        List<Orders> orders = ordersMapper.selectByExample(ordersExample);

        SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
        Date today=new Date(System.currentTimeMillis());
        long todayTime = today.getTime();

        List<OrderItemCustom> orderItemCustomsCouldComment=new ArrayList<>();//可以评论的子订单

        if(orders!=null){
            for(Orders order:orders){

                List<OrderItemCustom> OrderItemCustoms = orderItemCustomMapper.selectOrderItemDetail(order.getOrderId());

                for(OrderItemCustom orderItemCustom:OrderItemCustoms){
                    try {
                        if(orderItemCustom.getCommentId_FK_OrderItem()==null&&todayTime>sdf.parse(orderItemCustom.getOrderItemStartDate()).getTime()+(24*60*60*1000)){//超过预约开始一天后就可以评价，不用等到结束
                            if(orderItemCustom.getHotelName()!=null){
                                orderItemCustom.setGoodsName("酒店："+orderItemCustom.getHotelName()+"-"+orderItemCustom.getRoomType());
                            }else if(orderItemCustom.getScenicName()!=null){
                                orderItemCustom.setGoodsName("景点："+orderItemCustom.getScenicName());
                            }else if(orderItemCustom.getTaoCanName()!=null&&orderItemCustom.getOrderItemPrice()!=null){
                                /*暂时注释掉，因为评价表中没有设置套餐编号这个字段，导致暂无法对套餐评价，干脆不让他显示。*/
//                                orderItemCustom.setGoodsName("套餐："+orderItemCustom.getTaoCanName());
                                continue;
                            }
                            orderItemCustomsCouldComment.add(orderItemCustom);
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return orderItemCustomsCouldComment;
    }

    @Override
    public OrderItem selectByOrderItemId(Integer orderItemId) {
        OrderItem orderItem = orderItemMapper.selectByPrimaryKey(orderItemId);
        return orderItem;
    }

    @Override
    public Map<String, Integer> selectMoneyDataToAnalyze() {
        Map<String, Integer> moneyAnalyze=new LinkedHashMap<>();
        String date1="",date2="",date3="",date4="",date5="",date6="",date7="",date8="",date9="",date10="";
        Integer money1=0,money2=0,money3=0,money4=0,money5=0,money6=0,money7=0,money8=0,money9=0,money10=0;

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date today=new Date(System.currentTimeMillis());
        long todayTime = today.getTime();

        date10 = sdf.format(new Date(todayTime - 10*24*60*60*1000)).substring(0,10);
        date9 = sdf.format(new Date(todayTime - 9*24*60*60*1000)).substring(0,10);
        date8 = sdf.format(new Date(todayTime - 8*24*60*60*1000)).substring(0,10);
        date7 = sdf.format(new Date(todayTime - 7*24*60*60*1000)).substring(0,10);
        date6 = sdf.format(new Date(todayTime - 6*24*60*60*1000)).substring(0,10);
        date5 = sdf.format(new Date(todayTime - 5*24*60*60*1000)).substring(0,10);
        date4 = sdf.format(new Date(todayTime - 4*24*60*60*1000)).substring(0,10);
        date3 = sdf.format(new Date(todayTime - 3*24*60*60*1000)).substring(0,10);
        date2 = sdf.format(new Date(todayTime - 2*24*60*60*1000)).substring(0,10);
        date1 = sdf.format(new Date(todayTime - 1*24*60*60*1000)).substring(0,10);

        /*设置默认值*/
        moneyAnalyze.put(date10,money10);
        moneyAnalyze.put(date9,money9);
        moneyAnalyze.put(date8,money8);
        moneyAnalyze.put(date7,money7);
        moneyAnalyze.put(date6,money6);
        moneyAnalyze.put(date5,money5);
        moneyAnalyze.put(date4,money4);
        moneyAnalyze.put(date3,money3);
        moneyAnalyze.put(date2,money2);
        moneyAnalyze.put(date1,money1);

        List<OrderItem> orderItems = orderItemMapper.selectByExample(null);

        for(OrderItem orderItem:orderItems){//遍历所有的子订单
            String orderItemCreateDate = orderItem.getOrderItemCreateDate();
            Date date=new Date();
            try {
                date = sdf.parse(orderItemCreateDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            long time = date.getTime();
            if(time>=todayTime-10*24*60*60*1000&&time<todayTime-9*24*60*60*1000){
                money10+=orderItem.getOrderItemPrice();
            }else if(time>=todayTime-9*24*60*60*1000&&time<todayTime-8*24*60*60*1000){
                money9+=orderItem.getOrderItemPrice();
            }else if(time>=todayTime-8*24*60*60*1000&&time<todayTime-7*24*60*60*1000){
                money8+=orderItem.getOrderItemPrice();
            }else if(time>=todayTime-7*24*60*60*1000&&time<todayTime-6*24*60*60*1000){
                money7+=orderItem.getOrderItemPrice();
            }else if(time>=todayTime-6*24*60*60*1000&&time<todayTime-5*24*60*60*1000){
                money6+=orderItem.getOrderItemPrice();
            }else if(time>=todayTime-5*24*60*60*1000&&time<todayTime-4*24*60*60*1000){
                money5+=orderItem.getOrderItemPrice();
            }else if(time>=todayTime-4*24*60*60*1000&&time<todayTime-3*24*60*60*1000){
                money4+=orderItem.getOrderItemPrice();
            }else if(time>=todayTime-3*24*60*60*1000&&time<todayTime-2*24*60*60*1000){
                money3+=orderItem.getOrderItemPrice();
            }else if(time>=todayTime-2*24*60*60*1000&&time<todayTime-1*24*60*60*1000){
                money2+=orderItem.getOrderItemPrice();
            }else if(time>=todayTime-1*24*60*60*1000&&time<todayTime){
                money1+=orderItem.getOrderItemPrice();
            }
        }

        moneyAnalyze.put(date10,money10);
        moneyAnalyze.put(date9,money9);
        moneyAnalyze.put(date8,money8);
        moneyAnalyze.put(date7,money7);
        moneyAnalyze.put(date6,money6);
        moneyAnalyze.put(date5,money5);
        moneyAnalyze.put(date4,money4);
        moneyAnalyze.put(date3,money3);
        moneyAnalyze.put(date2,money2);
        moneyAnalyze.put(date1,money1);


        return moneyAnalyze;
    }
}
