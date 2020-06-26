package cn.yy.dao;

import cn.yy.pojo.RoomTime;
import cn.yy.pojo.RoomTimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoomTimeMapper {
    int countByExample(RoomTimeExample example);

    int deleteByExample(RoomTimeExample example);

    int deleteByPrimaryKey(Integer roomTimeId);

    int insert(RoomTime record);

    int insertSelective(RoomTime record);

    List<RoomTime> selectByExample(RoomTimeExample example);

    RoomTime selectByPrimaryKey(Integer roomTimeId);

    int updateByExampleSelective(@Param("record") RoomTime record, @Param("example") RoomTimeExample example);

    int updateByExample(@Param("record") RoomTime record, @Param("example") RoomTimeExample example);

    int updateByPrimaryKeySelective(RoomTime record);

    int updateByPrimaryKey(RoomTime record);
}