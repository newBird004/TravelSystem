package cn.yy.service;

import cn.yy.pojo.RealName;

import java.util.List;

public interface RealNameService {
    public List<RealName> selectRealNameByTravelUserId(Integer travelUserId);

    public void insertRealName(RealName realName);

    public RealName selectRealNameById(Integer realNameId);

    public void updateRealName(RealName realName);

    public void deleteRealNameById(Integer realNameId);

    public void deleteRealNameBatch(List<Integer> idList);

    public String selectRealNameNameById(Integer realNameId);
}
