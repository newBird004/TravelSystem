package cn.yy.service;

import cn.yy.pojo.RoomTime;

import java.util.List;

public interface RoomTimeService {

    List<RoomTime> selectRoomTimeByRoomId(Integer roomId);

    public void deleteOldDataByEndDate(String endDate);

    public Integer insertRoomTime(RoomTime roomTime);

}
