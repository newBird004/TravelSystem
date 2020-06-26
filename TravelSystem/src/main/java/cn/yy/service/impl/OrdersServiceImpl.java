package cn.yy.service.impl;

import cn.yy.dao.*;
import cn.yy.pojo.*;
import cn.yy.service.OrdersService;
import cn.yy.vo.OrderItemCustom;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrdersServiceImpl implements  OrdersService{

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private OrderItemCustomMapper orderItemCustomMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private RoomTimeMapper roomTimeMapper;

    @Autowired
    private RoomMapper roomMapper;



    @Override
    public Integer insertOrders(Orders orders) {
        ordersMapper.insertSelective(orders);
        return orders.getOrderId();
    }

    @Override
    public List<Orders> selectAll() {

        List<Orders> orders = ordersMapper.selectByExample(null);
        return orders;
    }


    @Override
    public List<OrderItemCustom> selectOrderDetailByOrderId(Integer orderId) {
        List<OrderItemCustom> orderItemCustoms = orderItemCustomMapper.selectOrderItemDetail(orderId);

        for(OrderItemCustom o:orderItemCustoms){
            if(o.getHotelName()!=null){
                o.setGoodsName("酒店："+o.getHotelName()+"-"+o.getRoomType());

                Room room = roomMapper.selectByPrimaryKey(o.getRoomId_FK_OrderItem());
                o.setGoodsId(room.getHotelId_FK_Room());
            }else if(o.getScenicName()!=null){
                o.setGoodsName("景点："+o.getScenicName());
                o.setGoodsId(o.getScenicId_FK_OrderItem());
            }else if(o.getTaoCanName()!=null&&o.getOrderItemPrice()!=null){
                o.setGoodsName("套餐："+o.getTaoCanName());
                o.setGoodsId(o.getTaoCanId_FK_OrderItem());
            }
//            System.out.println(o);

        }
        return orderItemCustoms;
    }

    @Override
    public Orders selectOrderByOrderId(Integer orderId) {
        Orders orders = ordersMapper.selectByPrimaryKey(orderId);
        return orders;
    }

    @Override
    public List<Orders> selectOrdersByUserId(Integer travelUserId) {
        OrdersExample ordersExample=new OrdersExample();
        OrdersExample.Criteria criteria = ordersExample.createCriteria();
        criteria.andTravelUserId_FK_OrdersEqualTo(travelUserId);
        ordersExample.setOrderByClause("orderId DESC");

        List<Orders> orders = ordersMapper.selectByExample(ordersExample);
        return orders;
    }

    /*个人页面中根据订单id查询订单*/
    @Override
    public List<Orders> selectOrderByOrderIdAndUserId(Integer orderId, Integer travelUserId) {
        OrdersExample ordersExample=new OrdersExample();
        OrdersExample.Criteria criteria = ordersExample.createCriteria();
        criteria.andTravelUserId_FK_OrdersEqualTo(travelUserId);
        criteria.andOrderIdEqualTo(orderId);

        List<Orders> orders = ordersMapper.selectByExample(ordersExample);
        return orders;
    }

    @Override
    public void cancelUnpaiedOrder(Integer orderId) {

        /*要先删除子订单，不然无法删除订单和roomTime记录*/
        OrderItemExample orderItemExample=new OrderItemExample();
        OrderItemExample.Criteria criteria = orderItemExample.createCriteria();
        criteria.andOrderId_FK_OrderItemEqualTo(orderId);

        List<OrderItem> orderItems = orderItemMapper.selectByExample(orderItemExample);
        if(orderItems!=null){
            for(OrderItem o:orderItems){
                orderItemMapper.deleteByPrimaryKey(o.getOrderItemId());

                /*删除roomTime记录*/
                if(o.getRoomTimeId_FK_OrderItem()!=null){
                    roomTimeMapper.deleteByPrimaryKey(o.getRoomTimeId_FK_OrderItem());
                }
            }
        }

        /*删除订单记录*/
        ordersMapper.deleteByPrimaryKey(orderId);

    }


}
