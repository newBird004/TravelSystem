package cn.yy.dao;

import cn.yy.pojo.TravelUser;
import cn.yy.pojo.TravelUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TravelUserMapper {
    int countByExample(TravelUserExample example);

    int deleteByExample(TravelUserExample example);

    int deleteByPrimaryKey(Integer travelUserId);

    int insert(TravelUser record);

    int insertSelective(TravelUser record);

    List<TravelUser> selectByExample(TravelUserExample example);

    TravelUser selectByPrimaryKey(Integer travelUserId);

    int updateByExampleSelective(@Param("record") TravelUser record, @Param("example") TravelUserExample example);

    int updateByExample(@Param("record") TravelUser record, @Param("example") TravelUserExample example);

    int updateByPrimaryKeySelective(TravelUser record);

    int updateByPrimaryKey(TravelUser record);
}