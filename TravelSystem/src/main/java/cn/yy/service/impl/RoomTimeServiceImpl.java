package cn.yy.service.impl;

import cn.yy.dao.RoomTimeMapper;
import cn.yy.pojo.RoomTime;
import cn.yy.pojo.RoomTimeExample;
import cn.yy.service.RoomTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoomTimeServiceImpl implements RoomTimeService {
    @Autowired
    private RoomTimeMapper roomTimeMapper;

    @Override
    public List<RoomTime> selectRoomTimeByRoomId(Integer roomId) {
        RoomTimeExample roomTimeExample=new RoomTimeExample();
        RoomTimeExample.Criteria criteria = roomTimeExample.createCriteria();
        criteria.andRoomId_FK_RoomTimeEqualTo(roomId);

        List<RoomTime> roomTimes = roomTimeMapper.selectByExample(roomTimeExample);
        return roomTimes;
    }

    @Override
    public void deleteOldDataByEndDate(String endDate) {
        RoomTimeExample roomTimeExample=new RoomTimeExample();
        RoomTimeExample.Criteria criteria = roomTimeExample.createCriteria();
        criteria.andRoomTimeEndDateEqualTo(endDate);

        roomTimeMapper.deleteByExample(roomTimeExample);
    }

    @Override
    public Integer insertRoomTime(RoomTime roomTime) {

        roomTimeMapper.insertSelective(roomTime);
        return roomTime.getRoomTimeId();
    }

}
