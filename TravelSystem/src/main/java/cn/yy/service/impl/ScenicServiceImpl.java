package cn.yy.service.impl;

import cn.yy.dao.*;
import cn.yy.pojo.*;
import cn.yy.service.ScenicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ScenicServiceImpl implements ScenicService {

    @Autowired
    public ScenicMapper scenicMapper;

    @Autowired
    public OrdersMapper ordersMapper;

    @Autowired
    public OrderItemMapper orderItemMapper;

    @Autowired
    public RoomTimeMapper roomTimeMapper;

    @Autowired
    public CartMapper cartMapper;


    @Override
    public Scenic selectById(Integer id) {
        Scenic scenic=scenicMapper.selectByPrimaryKey(id);
        return  scenic;
    }

    @Override
    public Scenic selectByScenicName(String scenicName) {
        ScenicExample scenicExample=new ScenicExample();
        ScenicExample.Criteria criteria = scenicExample.createCriteria();
        criteria.andScenicNameEqualTo(scenicName);

        List<Scenic> scenics = scenicMapper.selectByExample(scenicExample);
        if(!scenics.isEmpty()){
            return scenics.get(0);
        }
        return null;
    }

    @Override
    public void insertScenic(Scenic scenic) {

        scenicMapper.insertSelective(scenic);
    }

    @Override
    public List<Scenic> selectAll() {
        ScenicExample scenicExample=new ScenicExample();
        ScenicExample.Criteria criteria = scenicExample.createCriteria();
        criteria.andScenicExistEqualTo(1);

        List<Scenic> scenics = scenicMapper.selectByExample(scenicExample);

//        List<Scenic> scenics = scenicMapper.selectByExample(null);
        return scenics;
    }

    @Override
    public void updateScenic(Scenic scenic) {
        scenicMapper.updateByPrimaryKeySelective(scenic);
    }

    @Override
    public void deleteScenicById(Integer id) {
        Scenic scenic = scenicMapper.selectByPrimaryKey(id);
        scenic.setScenicExist(0);
        scenicMapper.updateByPrimaryKeySelective(scenic);
//        scenicMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteScenicBatch(List<Integer> idList) {
        ScenicExample scenicExample=new ScenicExample();
        ScenicExample.Criteria criteria = scenicExample.createCriteria();
        criteria.andScenicIdIn(idList);
        List<Scenic> scenics = scenicMapper.selectByExample(scenicExample);
        for (Scenic scenic:scenics){
            scenic.setScenicExist(0);
            scenicMapper.updateByPrimaryKeySelective(scenic);
        }

//        scenicMapper.deleteByExample(scenicExample);
    }

    @Override
    public Integer purchaseScenic(String travelUserId, String orderPrice, String realNameId, String scenicId, String date) {
//        首先会向订单表中添加一个未支付状态的订单
        Orders orders=new Orders();
        //将今天作为下单日期
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date today = new Date(System.currentTimeMillis());
        String todayDate=sdf.format(today);

        orders.setOrderDate(todayDate);
        orders.setOrderPrice(Integer.parseInt(orderPrice));
        orders.setOrderStatus(0);
        orders.setTravelUserId_FK_Orders(Integer.parseInt(travelUserId));
//      插入订单表
        ordersMapper.insertSelective(orders);

//        System.out.println("--------------"+orders.getOrderId()+"--------------");

        OrderItem orderItem=new OrderItem();
        orderItem.setOrderId_FK_OrderItem(orders.getOrderId());
        orderItem.setOrderItemPrice(Integer.parseInt(orderPrice));
        orderItem.setOrderItemStartDate(date);
        orderItem.setRealNameId_FK_OrderItem(Integer.parseInt(realNameId));
        orderItem.setScenicId_FK_OrderItem(Integer.parseInt(scenicId));
        orderItem.setOrderItemPayStatus(0);
        orderItem.setOrderItemCreateDate(todayDate);

        orderItemMapper.insertSelective(orderItem);

        return orders.getOrderId();
    }

    @Override
    public void changeOrderToPaied(String orderId) {

        Orders orders = ordersMapper.selectByPrimaryKey(Integer.parseInt(orderId));
        orders.setOrderStatus(1);
        ordersMapper.updateByPrimaryKeySelective(orders);//更改订单状态为支付状态


        /*查询该订单对应的子订单，并修改子订单为支付状态为完成*/
        OrderItemExample orderItemExample=new OrderItemExample();
        OrderItemExample.Criteria criteria = orderItemExample.createCriteria();
        criteria.andOrderId_FK_OrderItemEqualTo(Integer.parseInt(orderId));

        List<OrderItem> orderItems = orderItemMapper.selectByExample(orderItemExample);
        for(OrderItem orderItem:orderItems){
            orderItem.setOrderItemPayStatus(1);
            orderItemMapper.updateByPrimaryKeySelective(orderItem);

            /*修改子订单中房间日期安排表为支付完成*/
            if(orderItem.getRoomTimeId_FK_OrderItem()!=null){
                RoomTime roomTime = roomTimeMapper.selectByPrimaryKey(orderItem.getRoomTimeId_FK_OrderItem());
                roomTime.setPayStatus(1);
                roomTimeMapper.updateByPrimaryKeySelective(roomTime);
            }
        }

    }

    @Override
    public String selectScenicNameById(Integer scenicId) {
        Scenic scenic = scenicMapper.selectByPrimaryKey(scenicId);
        return scenic.getScenicName();
    }

    @Override
    public void addScenicToCart(String travelUserId, String orderPrice, String realNameId, String scenicId, String date) {

        Cart cart=new Cart();
        cart.setTravelUserId_FK_Cart(Integer.parseInt(travelUserId));
        cart.setRealNameId_FK_Cart(Integer.parseInt(realNameId));
        cart.setScenicId_FK_Cart(Integer.parseInt(scenicId));
        cart.setCartStartDate(date);
        cart.setCartPrice(Integer.parseInt(orderPrice));

        cartMapper.insertSelective(cart);
    }

    @Override
    public List<Scenic> selectHasDeteledScenic() {
        ScenicExample scenicExample=new ScenicExample();
        ScenicExample.Criteria criteria = scenicExample.createCriteria();
        criteria.andScenicExistEqualTo(0);

        List<Scenic> scenics = scenicMapper.selectByExample(scenicExample);

        return scenics;
    }

    @Override
    public Map<String, Integer> selectScenicDataToAnalyze() {
        Map<String, Integer> scenicAnalyze=new HashMap<>();

        List<Scenic> scenics = scenicMapper.selectByExample(null);
        for(Scenic scenic:scenics){
            int count = orderItemMapper.selectScenicDataToAnalyze(scenic.getScenicId());
            scenicAnalyze.put(scenic.getScenicName()+"("+scenic.getScenicId()+")",count);
        }
        return scenicAnalyze;
    }

}
