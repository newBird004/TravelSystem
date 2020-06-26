package cn.yy.service.impl;

import cn.yy.dao.*;
import cn.yy.pojo.*;
import cn.yy.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    public HotelMapper hotelMapper;

    @Autowired
    public OrdersMapper ordersMapper;

    @Autowired
    public OrderItemMapper orderItemMapper;

    @Autowired
    public RoomMapper roomMapper;

    @Autowired
    public RoomTimeMapper roomTimeMapper;

    @Autowired
    public CartMapper cartMapper;



    @Override
    public Hotel selectByHotelName(String hotelName) {
        HotelExample hotelExample=new HotelExample();
        HotelExample.Criteria criteria = hotelExample.createCriteria();
        criteria.andHotelNameEqualTo(hotelName);

        List<Hotel> hotels = hotelMapper.selectByExample(hotelExample);
        if(!hotels.isEmpty()){
            return hotels.get(0);
        }
        return null;
    }

    @Override
    public List<Hotel> selectAll() {
        HotelExample hotelExample=new HotelExample();
        HotelExample.Criteria criteria = hotelExample.createCriteria();
        criteria.andHotelExistEqualTo(1);

        List<Hotel> hotels = hotelMapper.selectByExample(hotelExample);

//        List<Hotel> hotels = hotelMapper.selectByExample(null);
        return hotels;
    }

    @Override
    public void insertHotel(Hotel hotel) {
        hotel.setHotelExist(1);
        hotelMapper.insertSelective(hotel);
    }

    @Override
    public void insertRoomByHotelId(Integer hotelId, String roomType, String roomCount, String roomPrice) {
        for(int i=0;i<Integer.parseInt(roomCount);i++){
            Room room=new Room();
            room.setHotelId_FK_Room(hotelId);
            room.setRoomType(roomType);
            room.setRoomPrice(Integer.parseInt(roomPrice));

            roomMapper.insertSelective(room);
        }
    }

    @Override
    public String selectHotelNameByHotelId(Integer hotelId) {

        Hotel hotel = hotelMapper.selectByPrimaryKey(hotelId);
        return hotel.getHotelName();
    }

    @Override
    public void addHotelToCart(int travelUserId, int orderPrice, int realNameId, int hotelId,String roomType, String startDate, String endDate) {

        Cart cart=new Cart();
        cart.setTravelUserId_FK_Cart(travelUserId);
        cart.setRealNameId_FK_Cart(realNameId);
        cart.setHotelId_FK_Cart(hotelId);
        cart.setRoomType(roomType);
        cart.setCartStartDate(startDate);
        cart.setCartEndDate(endDate);
        cart.setCartPrice(orderPrice);

        cartMapper.insertSelective(cart);
    }



    @Override
    public Hotel selectById(Integer id) {
        Hotel hotel=hotelMapper.selectByPrimaryKey(id);
        return  hotel;
    }

    @Override
    public void updateHotel(Hotel hotel) {
        hotelMapper.updateByPrimaryKeySelective(hotel);
    }

    @Override
    public void deleteHotelById(Integer id) {
        Hotel hotel = hotelMapper.selectByPrimaryKey(id);
        hotel.setHotelExist(0);
        hotelMapper.updateByPrimaryKeySelective(hotel);
//        hotelMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteHotelBatch(List<Integer> idList) {
        HotelExample hotelExample=new HotelExample();
        HotelExample.Criteria criteria = hotelExample.createCriteria();
        criteria.andHotelIdIn(idList);

        List<Hotel> hotels = hotelMapper.selectByExample(hotelExample);
        for(Hotel hotel:hotels){
            hotel.setHotelExist(0);
            hotelMapper.updateByPrimaryKeySelective(hotel);
        }

//        hotelMapper.deleteByExample(hotelExample);
    }

    @Override
    public  Integer purchaseHotel(int travelUserId,int orderPrice,int realNameId,int roomId,String startDate,String endDate) {
//        首先会向订单表中添加一个未支付状态的订单
        Orders orders=new Orders();

        //将今天作为下单日期
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date today = new Date(System.currentTimeMillis());
        String todayDate=sdf.format(today);


//      为订单对象设置属性
        orders.setOrderDate(todayDate);
        orders.setOrderPrice(orderPrice);
        orders.setOrderStatus(0);
        orders.setTravelUserId_FK_Orders(travelUserId);
//      插入订单表
        ordersMapper.insertSelective(orders);

        /*在房间时间安排表中添加数据，支付状态是未支付*/
        RoomTime roomTime=new RoomTime();
        roomTime.setRoomId_FK_RoomTime(roomId);
        roomTime.setRoomTimeStartDate(startDate);
        roomTime.setRoomTimeEndDate(endDate);
        roomTime.setCreateDate(todayDate);
        roomTime.setPayStatus(0);
//      插入房间日期表
        roomTimeMapper.insertSelective(roomTime);


        OrderItem orderItem=new OrderItem();
        orderItem.setOrderId_FK_OrderItem(orders.getOrderId());
        orderItem.setOrderItemPrice(orderPrice);
        orderItem.setOrderItemStartDate(startDate);
        orderItem.setOrderItemEndDate(endDate);
        orderItem.setRealNameId_FK_OrderItem(realNameId);
        orderItem.setRoomId_FK_OrderItem(roomId);
        orderItem.setRoomTimeId_FK_OrderItem(roomTime.getRoomTimeId());
        orderItem.setOrderItemCreateDate(todayDate);
        orderItem.setOrderItemPayStatus(0);

        //      插入子订单表
        orderItemMapper.insertSelective(orderItem);



        return orders.getOrderId();
    }

//    @Override
//    public void deleteRoomByHotelId(Integer hotelId) {
//        RoomExample roomExample=new RoomExample();
//        RoomExample.Criteria criteria = roomExample.createCriteria();
//        criteria.andHotelId_FK_RoomEqualTo(hotelId);
//
//        roomMapper.deleteByExample(roomExample);
//    }

    @Override
    public List<Hotel> selectHasDeletedHotelList() {
        HotelExample hotelExample=new HotelExample();
        HotelExample.Criteria criteria = hotelExample.createCriteria();
        criteria.andHotelExistEqualTo(0);

        List<Hotel> hotels = hotelMapper.selectByExample(hotelExample);

        return hotels;
    }

    @Override
    public Map<String, Integer> selectHotelDataToAnalyze() {
        Map<String, Integer> hotelAnalyze=new HashMap<>();

        List<Hotel> hotels = hotelMapper.selectByExample(null);
        for(Hotel hotel:hotels){
            int count = orderItemMapper.selectHotelDataToAnalyze(hotel.getHotelId());
            hotelAnalyze.put(hotel.getHotelName()+"("+hotel.getHotelId()+")",count);
        }
        return hotelAnalyze;
    }

}
