package cn.yy.dao;

import cn.yy.pojo.TaoCan;
import cn.yy.pojo.TaoCanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaoCanMapper {
    int countByExample(TaoCanExample example);

    int deleteByExample(TaoCanExample example);

    int deleteByPrimaryKey(Integer taoCanId);

    int insert(TaoCan record);

    int insertSelective(TaoCan record);

    List<TaoCan> selectByExample(TaoCanExample example);

    TaoCan selectByPrimaryKey(Integer taoCanId);

    int updateByExampleSelective(@Param("record") TaoCan record, @Param("example") TaoCanExample example);

    int updateByExample(@Param("record") TaoCan record, @Param("example") TaoCanExample example);

    int updateByPrimaryKeySelective(TaoCan record);

    int updateByPrimaryKey(TaoCan record);
}