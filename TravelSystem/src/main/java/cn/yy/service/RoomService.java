package cn.yy.service;

import cn.yy.pojo.Room;

import java.util.List;

public interface RoomService {
    public List<String> selectRoomTypeByHotelId(Integer hotelId);

    public void insertRoom(Room room);

    public Room selectRoomById(Integer roomId);

    public void updateRoom(Room room);

    public void deleteRoomById(Integer roomId);

    public void deleteRoomBatch(List<Integer> idList);

    public List<Room> selectRoomByHotelIdAndRoomType(Integer hotelId,String roomType);


}
