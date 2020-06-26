package cn.yy.dao;

import cn.yy.pojo.RealName;
import cn.yy.pojo.RealNameExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RealNameMapper {
    int countByExample(RealNameExample example);

    int deleteByExample(RealNameExample example);

    int deleteByPrimaryKey(Integer realNameId);

    int insert(RealName record);

    int insertSelective(RealName record);

    List<RealName> selectByExample(RealNameExample example);

    RealName selectByPrimaryKey(Integer realNameId);

    int updateByExampleSelective(@Param("record") RealName record, @Param("example") RealNameExample example);

    int updateByExample(@Param("record") RealName record, @Param("example") RealNameExample example);

    int updateByPrimaryKeySelective(RealName record);

    int updateByPrimaryKey(RealName record);
}