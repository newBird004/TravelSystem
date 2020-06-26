package cn.yy.service;


import cn.yy.pojo.Scenic;
import cn.yy.pojo.TaoCan;
import cn.yy.pojo.TaoCanItem;

import java.util.List;

public interface TaoCanService {

    public TaoCan selectById(Integer id);

    public TaoCan selectByTaoCanName(String taoCanName);

    public int insertTaoCan(TaoCan taoCan,String checkedScenicIdStr,String hotelId,String roomType);

    public List<TaoCan> selectAll();

    public void updateTaoCan(TaoCan taoCan);

    public void deleteTaoCanById(Integer id);

    public void deleteTaoCanBatch(List<Integer> idList);

    public Integer purchaseTaoCan(String travelUserId, String orderPrice, String realNameId, String taoCanId, String date,String roomId);

    public void changeOrderToPaied(String orderId);

    public TaoCanItem selectHotelIdAndRoomTypeByTaoCanId(Integer taoCanId);

}
