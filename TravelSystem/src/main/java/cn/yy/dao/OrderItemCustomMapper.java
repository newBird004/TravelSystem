package cn.yy.dao;

import cn.yy.pojo.OrderItem;
import cn.yy.pojo.OrderItemExample;
import cn.yy.vo.OrderItemCustom;
import org.apache.ibatis.annotations.Param;
import org.springframework.core.annotation.Order;

import java.util.List;

public interface OrderItemCustomMapper {

    List<OrderItemCustom> selectOrderItemDetail(Integer orderId);

}