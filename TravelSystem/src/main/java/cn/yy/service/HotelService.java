package cn.yy.service;

import cn.yy.pojo.Hotel;

import java.util.List;
import java.util.Map;

public interface HotelService {
    public Hotel selectById(Integer id);

    public Hotel selectByHotelName(String hotelName);

    public void insertHotel(Hotel hotel);

    public List<Hotel> selectAll();

    public void updateHotel(Hotel hotel);

    public void deleteHotelById(Integer id);

    public void deleteHotelBatch(List<Integer> idList);

    public Integer purchaseHotel(int travelUserId,int orderPrice,int realNameId,int roomId,String startDate,String endDate);


    public void insertRoomByHotelId(Integer hotelId,String roomType,String roomCount,String roomPrice);

//    public void deleteRoomByHotelId(Integer hotelId);

    public String selectHotelNameByHotelId(Integer hotelId);

    public void addHotelToCart(int travelUserId,int orderPrice,int realNameId,int hotelId,String roomType,String startDate,String endDate);

    public List<Hotel> selectHasDeletedHotelList();

    Map<String,Integer> selectHotelDataToAnalyze();
}
