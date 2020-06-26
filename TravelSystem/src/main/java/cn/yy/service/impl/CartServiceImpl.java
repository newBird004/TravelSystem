package cn.yy.service.impl;

import cn.yy.dao.*;
import cn.yy.pojo.*;
import cn.yy.service.CartService;
import cn.yy.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    public CartMapper cartMapper;

    @Autowired
    public ScenicMapper scenicMapper;

    @Autowired
    public HotelMapper hotelMapper;

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private RoomTimeMapper roomTimeMapper;

    @Autowired
    private RoomMapper roomMapper;

    @Override
    public Cart selectById(Integer id) {
        Cart cart=cartMapper.selectByPrimaryKey(id);
        return  cart;
    }


    @Override
    public void insertCart(Cart cart) {

        cartMapper.insertSelective(cart);
    }

    @Override
    public List<Cart> selectAll(String travelUserId) {

        CartExample cartExample=new CartExample();
        CartExample.Criteria criteria = cartExample.createCriteria();
        criteria.andTravelUserId_FK_CartEqualTo(Integer.parseInt(travelUserId));
//        criteria.andScenicId_FK_CartNotIn(scenicsHasDeleted);
//        criteria.andHotelId_FK_CartNotIn(hotelsHasDeleted);


        List<Cart> carts = cartMapper.selectByExample(cartExample);


        /*获取到已经被删除的商品，放入集合*/
        ScenicExample scenicExample=new ScenicExample();
        ScenicExample.Criteria criteria1 = scenicExample.createCriteria();
        criteria1.andScenicExistEqualTo(0);//查询已经被删除的景点
        List<Scenic> scenics = scenicMapper.selectByExample(scenicExample);
        List<Integer> scenicsHasDeleted=new ArrayList<>();
        for(Scenic scenic:scenics){
            scenicsHasDeleted.add(scenic.getScenicId());
        }

        HotelExample hotelExample=new HotelExample();
        HotelExample.Criteria criteria2 = hotelExample.createCriteria();
        criteria2.andHotelExistEqualTo(0);//查询已经被删除的景点
        List<Hotel> hotels = hotelMapper.selectByExample(hotelExample);
        List<Integer> hotelsHasDeleted=new ArrayList<>();
        for(Hotel hotel:hotels){
            hotelsHasDeleted.add(hotel.getHotelId());
        }


        Iterator<Cart> iterator = carts.iterator();
        while (iterator.hasNext()){
            Cart cart=iterator.next();
            if(cart.getHotelId_FK_Cart()!=null&&hotelsHasDeleted.contains(cart.getHotelId_FK_Cart())){
                iterator.remove();
            }else if(cart.getScenicId_FK_Cart()!=null&&scenicsHasDeleted.contains(cart.getScenicId_FK_Cart())){
                iterator.remove();
            }
        }

        return carts;
    }


    @Override
    public void updateCart(Cart cart) {
        cartMapper.updateByPrimaryKeySelective(cart);
    }

    @Override
    public void deleteCartById(Integer id) {
        cartMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteCartBatch(List<Integer> idList) {
        CartExample cartExample=new CartExample();
        CartExample.Criteria criteria = cartExample.createCriteria();
        criteria.andCartIdIn(idList);
        List<Cart> carts = cartMapper.selectByExample(cartExample);
        for (Cart cart:carts){
            cartMapper.deleteByExample(cartExample);
        }

    }

    @Override
    public String cartToPay(String checkedIdStr, HttpServletRequest request) {
        String[] split = checkedIdStr.split("-");
        Map<Integer,Integer> roomIds=new HashMap<>();
        Map<Integer,String> roomIdAndDates=new HashMap<>();
        for(String s:split){

            Cart  cart = cartMapper.selectByPrimaryKey(Integer.parseInt(s));

            if(cart.getHotelId_FK_Cart()!=null){

                roomIds.put(cart.getCartId(),0);//默认是0，如果有房间，会将roomId放入。如果没有房间，那么就会一直是0.

                Integer hotelId=cart.getHotelId_FK_Cart();
                String roomType = cart.getRoomType();

                /*查出该酒店该房型所有的房间*/
                RoomExample roomExample=new RoomExample();
                RoomExample.Criteria criteria = roomExample.createCriteria();
                criteria.andRoomTypeEqualTo(roomType);
                criteria.andHotelId_FK_RoomEqualTo(hotelId);

                List<Room> rooms = roomMapper.selectByExample(roomExample);
                for(Room room:rooms){//遍历每一个房子
                    Integer roomId = room.getRoomId();

                    RoomTimeExample roomTimeExample=new RoomTimeExample();
                    RoomTimeExample.Criteria criteria1 = roomTimeExample.createCriteria();
                    criteria1.andRoomId_FK_RoomTimeEqualTo(roomId);

                    List<RoomTime> roomTimes = roomTimeMapper.selectByExample(roomTimeExample);//得到这个房子的所有预约时间段

                    boolean roomIdFlag=true;//这个房子是否能够满足客户要求。默认是满足的。
                    if(roomTimes!=null){
                        for(RoomTime roomTime:roomTimes){
                            String roomTimeStartDate = roomTime.getRoomTimeStartDate();
                            String roomTimeEndDate = roomTime.getRoomTimeEndDate();
                            Date date1=new Date();
                            Date date2=new Date();
                            Date date3=new Date();
                            Date date4=new Date();

                            SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
                            try {
                                date1 = sdf.parse(roomTimeStartDate);
                                date2 = sdf.parse(roomTimeEndDate);
                                date3 = sdf.parse(cart.getCartStartDate());
                                date4 = sdf.parse(cart.getCartEndDate());

                                long time1 = date1.getTime();//已经存在的开始日期
                                long time2 = date2.getTime();//已经存在的结束日期
                                long time3 = date3.getTime();//客户要求的开始日期
                                long time4 = date4.getTime();//客户要求的结束日期

                                if((time3>time2)||(time4<time1)){//如果满足，表示这个时间段并不重叠，可以继续比较下一个时间段。
                                    continue;
                                }else{//如果不满足，就跳出循环，表示这个房间的时间段重合，不能提供房间。
                                    roomIdFlag=false;
                                    break;
                                }

                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    if(roomIdFlag==true){
                        roomIds.put(cart.getCartId(),roomId);

                        roomIdAndDates.put(cart.getCartId(),roomId+"-"+cart.getCartStartDate()+"-"+cart.getCartEndDate());
                        break;
                    }else {
                        continue;
                    }
                }

            }
        }

        /*检验是否都有房间*/
        Set<Map.Entry<Integer, Integer>> entrySet = roomIds.entrySet();
        String dontHasRoomCartId="";
        for(Map.Entry<Integer, Integer> entry:entrySet){
            System.out.println(entry.getKey()+"-"+entry.getValue());
            if(entry.getValue()==0){//如果结果中有房子已经被买完了
                dontHasRoomCartId=dontHasRoomCartId+entry.getKey()+"-";
            } else {
                continue;
            }
        }

        /*检验是否会出现同一房间同一日期被购买两次的异常情况*/
        String hasReapetedRoomIdAndDate="";//防止出现同一房间同一日期的情况
        Set<Integer> keySet = roomIdAndDates.keySet();
        for (Integer i:keySet){
            String s = roomIdAndDates.get(i);
            for(Integer j:keySet){
                String ss = roomIdAndDates.get(j);
                if(s.equals(ss)&&i!=j){
                    hasReapetedRoomIdAndDate="订单编号为"+i+"订单编号为"+j+"的两个订单所订购的房间只剩一间了，请更换房型或者日期！";
                    break;
                }
            }

        }


        if(dontHasRoomCartId!=""){
            dontHasRoomCartId=dontHasRoomCartId.substring(0,dontHasRoomCartId.length()-1);
            return "商品编号为"+dontHasRoomCartId+"的房间已经被预定完了，请前去修改，选择其他日期或房间类型！";
        }else if(hasReapetedRoomIdAndDate!=""){
            return hasReapetedRoomIdAndDate;
        } else {//没啥问题，可以向表中插入数据了
            //将今天作为下单日期
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date today = new Date(System.currentTimeMillis());
            String todayDate=sdf.format(today);

            String orderIds="";
            Integer price=0;
            for(String s:split){

                Cart cart = cartMapper.selectByPrimaryKey(Integer.parseInt(s));

                /*向订单表插入数据*/
                Orders orders=new Orders();
                orders.setOrderStatus(0);
                orders.setTravelUserId_FK_Orders(cart.getTravelUserId_FK_Cart());
                orders.setOrderPrice(cart.getCartPrice());
                orders.setOrderDate(todayDate);
                ordersMapper.insertSelective(orders);
                Integer ordersId=orders.getOrderId();


                orderIds=orderIds+ordersId+"-";
                price+=cart.getCartPrice();

                if(cart.getHotelId_FK_Cart()!=null){//如果是房间类型的商品

                    /*向roomTime表插入数据*/
                    RoomTime roomTime=new RoomTime();
                    roomTime.setCreateDate(todayDate);
                    roomTime.setPayStatus(0);
                    roomTime.setRoomTimeStartDate(cart.getCartStartDate());
                    roomTime.setRoomTimeEndDate(cart.getCartEndDate());
                    Integer roomId = roomIds.get(cart.getCartId());
                    roomTime.setRoomId_FK_RoomTime(roomId);
                    roomTimeMapper.insertSelective(roomTime);
                    Integer roomTimeId=roomTime.getRoomTimeId();


                    /*向子订单表插入数据*/
                    OrderItem orderItem=new OrderItem();
                    orderItem.setOrderId_FK_OrderItem(ordersId);
                    orderItem.setRealNameId_FK_OrderItem(cart.getRealNameId_FK_Cart());
                    orderItem.setRoomId_FK_OrderItem(roomId);
                    orderItem.setRoomTimeId_FK_OrderItem(roomTimeId);
                    orderItem.setOrderItemPrice(cart.getCartPrice());
                    orderItem.setOrderItemStartDate(cart.getCartStartDate());
                    orderItem.setOrderItemEndDate(cart.getCartEndDate());
                    orderItem.setOrderItemPayStatus(0);
                    orderItem.setOrderItemCreateDate(todayDate);
                    orderItemMapper.insertSelective(orderItem);
                    Integer orderItemId=orderItem.getOrderItemId();
                    /*删除购物车中的数据*/
                    cartMapper.deleteByPrimaryKey(cart.getCartId());

                }else if(cart.getScenicId_FK_Cart()!=null){//如果是景点门票

                    /*向子订单表插入数据*/
                    OrderItem orderItem=new OrderItem();
                    orderItem.setOrderId_FK_OrderItem(ordersId);
                    orderItem.setRealNameId_FK_OrderItem(cart.getRealNameId_FK_Cart());
                    orderItem.setScenicId_FK_OrderItem(cart.getScenicId_FK_Cart());
                    orderItem.setOrderItemPrice(cart.getCartPrice());
                    orderItem.setOrderItemStartDate(cart.getCartStartDate());
                    orderItem.setOrderItemPayStatus(0);
                    orderItem.setOrderItemCreateDate(todayDate);
                    System.out.println(orderItem);
                    orderItemMapper.insertSelective(orderItem);

                    /*删除购物车中的数据*/
                    cartMapper.deleteByPrimaryKey(cart.getCartId());
                }

            }
            /*将订单和价格放入session域中*/
            HttpSession session = request.getSession();
            session.setAttribute("orderIds",orderIds);
            session.setAttribute("price",price+"");

            return "1";
        }
    }


    /*修改支付状态*/
    @Override
    public void changeCartOrderToPaied(String orderIds) {
        String[] split=null;
        if(orderIds!=null&&orderIds!=""){
            split= orderIds.split("-");
        }
        if(split!=null){
            for(String orderId:split){
                System.out.println(orderId+"----------------");
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

        }

    }



}
