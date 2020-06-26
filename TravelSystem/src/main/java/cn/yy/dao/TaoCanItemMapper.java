package cn.yy.dao;

import cn.yy.pojo.TaoCanItem;
import cn.yy.pojo.TaoCanItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaoCanItemMapper {
    int countByExample(TaoCanItemExample example);

    int deleteByExample(TaoCanItemExample example);

    int deleteByPrimaryKey(Integer taoCanItemId);

    int insert(TaoCanItem record);

    int insertSelective(TaoCanItem record);

    List<TaoCanItem> selectByExample(TaoCanItemExample example);

    TaoCanItem selectByPrimaryKey(Integer taoCanItemId);

    int updateByExampleSelective(@Param("record") TaoCanItem record, @Param("example") TaoCanItemExample example);

    int updateByExample(@Param("record") TaoCanItem record, @Param("example") TaoCanItemExample example);

    int updateByPrimaryKeySelective(TaoCanItem record);

    int updateByPrimaryKey(TaoCanItem record);
}