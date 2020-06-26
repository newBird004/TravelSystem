package cn.yy.service;


import cn.yy.pojo.Scenic;

import java.util.List;
import java.util.Map;

public interface ScenicService {

    public Scenic selectById(Integer id);

    public Scenic selectByScenicName(String scenicName);

    public void insertScenic(Scenic scenic);

    public List<Scenic> selectAll();

    public void updateScenic(Scenic scenic);

    public void deleteScenicById(Integer id);

    public void deleteScenicBatch(List<Integer> idList);

    public Integer purchaseScenic(String travelUserId,String orderPrice,String realNameId,String scenicId,String date);

    public void changeOrderToPaied(String orderId);

    public String selectScenicNameById(Integer scenicId);

    public void addScenicToCart(String travelUserId,String orderPrice,String realNameId,String scenicId,String date);

    public List<Scenic> selectHasDeteledScenic();

    Map<String,Integer> selectScenicDataToAnalyze();
}
