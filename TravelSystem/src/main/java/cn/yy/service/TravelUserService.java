package cn.yy.service;


import cn.yy.pojo.TravelUser;

import java.util.List;

public interface TravelUserService {


    public TravelUser selectById(Integer id);

    public TravelUser selectByUserNameAndPassword(String userName, String password);

    public TravelUser selectByUserName(String userName);

    public void insertTravelUser(TravelUser travelUser);

    public List<TravelUser> selectAll();

    public void updateTravelUser(TravelUser travelUser);

    public void deleteTravelUserById(Integer id);

    public void deleteTravelUserBatch(List<Integer> idList);

    public TravelUser selectByEmail(String email);

    public void updatePwdByEmail(String email,TravelUser travelUser);
}
