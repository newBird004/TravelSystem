package cn.yy.service;

import cn.yy.pojo.OrderItem;
import cn.yy.vo.OrderItemCustom;

import java.util.List;
import java.util.Map;

public interface OrderItemService {

    public Integer insertOrderItem(OrderItem orderItem);

    List<OrderItemCustom> selectCouldCommentOrderItemsByUserId(Integer travelUserId);

    OrderItem selectByOrderItemId(Integer orderItemId);

    Map<String,Integer> selectMoneyDataToAnalyze();
}
