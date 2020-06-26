package cn.yy.service;

import cn.yy.pojo.Orders;
import cn.yy.vo.OrderItemCustom;

import java.util.List;

public interface OrdersService {
    public Integer insertOrders(Orders orders);

    List<Orders> selectAll();

    List<OrderItemCustom> selectOrderDetailByOrderId(Integer orderId);

    Orders selectOrderByOrderId(Integer orderId);

    List<Orders> selectOrdersByUserId(Integer travelUserId);

    List<Orders> selectOrderByOrderIdAndUserId(Integer orderId,Integer travelUserId);

    void cancelUnpaiedOrder(Integer orderId);



}
