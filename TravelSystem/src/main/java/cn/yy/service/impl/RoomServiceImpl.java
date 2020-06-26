package cn.yy.service.impl;

import cn.yy.dao.RoomMapper;
import cn.yy.pojo.Room;
import cn.yy.pojo.RoomExample;
import cn.yy.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomMapper roomMapper;

    @Override
    public List<String> selectRoomTypeByHotelId(Integer hotelId) {
        List<String> rooms = roomMapper.selectRoomTypeByHotelId(hotelId);
//        System.out.println(rooms);
        return  rooms;
    }


    @Override
    public void insertRoom(Room room) {
        roomMapper.insertSelective(room);
    }

    @Override
    public Room selectRoomById(Integer roomId) {
        Room room = roomMapper.selectByPrimaryKey(roomId);
        return room;
    }

    @Override
    public void updateRoom(Room room) {
        roomMapper.updateByPrimaryKeySelective(room);
    }

    @Override
    public void deleteRoomById(Integer roomId) {
        roomMapper.deleteByPrimaryKey(roomId);
    }

    @Override
    public void deleteRoomBatch(List<Integer> idList) {
        RoomExample roomExample=new RoomExample();
        RoomExample.Criteria criteria = roomExample.createCriteria();
        criteria.andRoomIdIn(idList);

        roomMapper.deleteByExample(roomExample);

    }

    @Override
    public List<Room> selectRoomByHotelIdAndRoomType(Integer hotelId, String roomType) {
        RoomExample roomExample=new RoomExample();
        RoomExample.Criteria criteria = roomExample.createCriteria();
        criteria.andRoomTypeEqualTo(roomType);
        criteria.andHotelId_FK_RoomEqualTo(hotelId);
        List<Room> rooms = roomMapper.selectByExample(roomExample);
        return  rooms;
    }

}
