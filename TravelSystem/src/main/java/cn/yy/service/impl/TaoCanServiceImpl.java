package cn.yy.service.impl;

import cn.yy.dao.*;
import cn.yy.pojo.*;
import cn.yy.service.TaoCanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TaoCanServiceImpl implements TaoCanService {

    @Autowired
    public TaoCanMapper taoCanMapper;

    @Autowired
    public OrdersMapper ordersMapper;

    @Autowired
    public OrderItemMapper orderItemMapper;

    @Autowired
    public ScenicMapper scenicMapper;

    @Autowired
    public RoomMapper roomMapper;

    @Autowired
    public TaoCanItemMapper taoCanItemMapper;

    @Autowired
    public HotelMapper hotelMapper;

    @Autowired
    public RoomTimeMapper roomTimeMapper;

    @Override
    public TaoCan selectById(Integer id) {
        TaoCan taoCan=taoCanMapper.selectByPrimaryKey(id);
        return  taoCan;
    }

    @Override
    public TaoCan selectByTaoCanName(String taoCanName) {
        TaoCanExample taoCanExample=new TaoCanExample();
        TaoCanExample.Criteria criteria = taoCanExample.createCriteria();
        criteria.andTaoCanNameEqualTo(taoCanName);

        List<TaoCan> taoCans = taoCanMapper.selectByExample(taoCanExample);
        if(!taoCans.isEmpty()){
            return taoCans.get(0);
        }
        return null;
    }

    @Override
    public int insertTaoCan(TaoCan taoCan,String checkedScenicIdStr,String hotelId,String roomType) {
        Integer taoCanPrice=0;

        taoCan.setTaoCanIntroduce(taoCan.getTaoCanIntroduce()+"其中包含了：");//为了将包含的内容也加到介绍中去。
        /*根据所选择的景点，计算景点总价格*/
        String[] splits = checkedScenicIdStr.split("-");
        for(int i=0;i<splits.length;i++){
            Scenic scenic = scenicMapper.selectByPrimaryKey(Integer.parseInt(splits[i]));
            Integer scenicPrice = scenic.getScenicPrice();
            taoCanPrice=taoCanPrice+scenicPrice;//将所选景点的门票加入进去

            taoCan.setTaoCanIntroduce(taoCan.getTaoCanIntroduce()+scenic.getScenicName()+" 门票+ ");//将包含的景点名称写进去
        }


        //计算酒店价格
        RoomExample roomExample=new RoomExample();
        RoomExample.Criteria criteria = roomExample.createCriteria();
        criteria.andHotelId_FK_RoomEqualTo(Integer.parseInt(hotelId));
        criteria.andRoomTypeEqualTo(roomType);

        List<Room> rooms = roomMapper.selectByExample(roomExample);
        if(rooms!=null&&!rooms.isEmpty()){
            Room room=rooms.get(0);
            taoCanPrice=taoCanPrice+room.getRoomPrice();
        }
        //为了套餐设置价格
        taoCan.setTaoCanPrice((int) (taoCanPrice*0.7));

//        根据酒店id获取酒店，然后将酒店名字以及房间类型添加到套餐介绍中
        Hotel hotel = hotelMapper.selectByPrimaryKey(Integer.parseInt(hotelId));
        taoCan.setTaoCanIntroduce(taoCan.getTaoCanIntroduce()+hotel.getHotelName()+"-"+roomType);//将包含的景点名称写进去

        //添加到套餐表
        taoCanMapper.insertSelective(taoCan);

        for(int i=0;i<splits.length;i++){
            TaoCanItem taoCanItem=new TaoCanItem();
            taoCanItem.setTaoCanId_FK_TaoCanItem(taoCan.getTaoCanId());
            taoCanItem.setScenicId_FK_TaoCanItem(Integer.parseInt(splits[i]));
            taoCanItemMapper.insertSelective(taoCanItem);
        }
        TaoCanItem taoCanItem=new TaoCanItem();
        taoCanItem.setTaoCanId_FK_TaoCanItem(taoCan.getTaoCanId());
        taoCanItem.setHotelId_FK_TaoCanItem(Integer.parseInt(hotelId));
        taoCanItem.setRoomType(roomType);
        taoCanItemMapper.insertSelective(taoCanItem);

        return taoCan.getTaoCanPrice();

    }

    @Override
    public List<TaoCan> selectAll() {
        TaoCanExample taoCanExample=new TaoCanExample();
        TaoCanExample.Criteria criteria = taoCanExample.createCriteria();
        criteria.andTaoCanExistEqualTo(1);

        List<TaoCan> taoCans = taoCanMapper.selectByExample(taoCanExample);

//        List<TaoCan> taoCans = taoCanMapper.selectByExample(null);
        return taoCans;
    }

    @Override
    public void updateTaoCan(TaoCan taoCan) {
        taoCanMapper.updateByPrimaryKeySelective(taoCan);
    }

    @Override
    public void deleteTaoCanById(Integer id) {
        TaoCan taoCan = taoCanMapper.selectByPrimaryKey(id);
        taoCan.setTaoCanExist(0);
        taoCanMapper.updateByPrimaryKeySelective(taoCan);
//        taoCanMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteTaoCanBatch(List<Integer> idList) {
        TaoCanExample taoCanExample=new TaoCanExample();
        TaoCanExample.Criteria criteria = taoCanExample.createCriteria();
        criteria.andTaoCanIdIn(idList);
        List<TaoCan> taoCans = taoCanMapper.selectByExample(taoCanExample);
        for (TaoCan taoCan:taoCans){
            taoCan.setTaoCanExist(0);
            taoCanMapper.updateByPrimaryKeySelective(taoCan);
        }

//        taoCanMapper.deleteByExample(taoCanExample);
    }

    @Override
    public Integer purchaseTaoCan(String travelUserId, String orderPrice, String realNameId, String taoCanId, String date,String roomId) {
//        首先会向订单表中添加一个未支付状态的订单
        Orders orders=new Orders();
        //将今天作为下单日期
        SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date today = new Date(System.currentTimeMillis());
        String todayDate=sdf2.format(today);

        orders.setOrderDate(todayDate);
        orders.setOrderPrice(Integer.parseInt(orderPrice));
        orders.setOrderStatus(0);
        orders.setTravelUserId_FK_Orders(Integer.parseInt(travelUserId));
//      插入订单表
        ordersMapper.insertSelective(orders);


        /*为了根据页面上选择的单个时间推算出明天的时间，因为套餐中默认是一天住宿*/
        SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
        Date date1 = null;
        try {
            date1= sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time1 = date1.getTime();
        long time2=time1+24*60*60*1000;
        String endDate = sdf.format(time2);



        /*向房间的时间表中插入数据*/
        RoomTime roomTime=new RoomTime();
        roomTime.setRoomId_FK_RoomTime(Integer.parseInt(roomId));
        roomTime.setRoomTimeStartDate(date);
        roomTime.setRoomTimeEndDate(endDate);
        roomTime.setPayStatus(0);
        roomTime.setCreateDate(todayDate);
//      插入房间日期表
        roomTimeMapper.insertSelective(roomTime);




        /*向子订单表中插入购买套餐的记录*/
        OrderItem orderItem=new OrderItem();
        orderItem.setOrderId_FK_OrderItem(orders.getOrderId());
        orderItem.setOrderItemPrice(Integer.parseInt(orderPrice));
        orderItem.setOrderItemStartDate(date);
        orderItem.setRealNameId_FK_OrderItem(Integer.parseInt(realNameId));
        orderItem.setTaoCanId_FK_OrderItem(Integer.parseInt(taoCanId));
        orderItem.setOrderItemPayStatus(0);
        orderItem.setOrderItemCreateDate(todayDate);
        orderItem.setOrderItemEndDate(endDate);
        //      插入子订单表
        orderItemMapper.insertSelective(orderItem);



        /*
        * 将套餐中包含的房间信息以及房间日期信息写入
        * 其中，还包含着套餐id，但是价格为0，意思是这个房间是属于这个套餐中的，钱已经付过了。
        * */
        OrderItem orderItem2=new OrderItem();
        orderItem2.setOrderId_FK_OrderItem(orders.getOrderId());
        orderItem2.setRealNameId_FK_OrderItem(Integer.parseInt(realNameId));
        orderItem2.setRoomId_FK_OrderItem(Integer.parseInt(roomId));
        orderItem2.setRoomTimeId_FK_OrderItem(roomTime.getRoomTimeId());
        orderItem2.setTaoCanId_FK_OrderItem(Integer.parseInt(taoCanId));
        orderItem2.setOrderItemPrice(0);
        orderItem2.setOrderItemStartDate(date);
        orderItem2.setOrderItemEndDate(endDate);
        orderItem2.setOrderItemPayStatus(0);
        orderItem2.setOrderItemCreateDate(todayDate);

        //      插入子订单表
        orderItemMapper.insertSelective(orderItem2);




        /*
         * 想要把套餐中所包含的景点也都加进去，为了根据订单后期统计每个景点的销量。
         * 其中，还包含着套餐id，但是价格为0，意思是这个景点是属于这个套餐中的，钱已经付过了。
         * */
        //根据订单编号查询其中包含哪些景点
        TaoCanItemExample taoCanItemExample=new TaoCanItemExample();
        TaoCanItemExample.Criteria criteria = taoCanItemExample.createCriteria();
        criteria.andTaoCanId_FK_TaoCanItemEqualTo(Integer.parseInt(taoCanId));

        List<TaoCanItem> taoCanItems = taoCanItemMapper.selectByExample(taoCanItemExample);
        for(TaoCanItem taoCanItem:taoCanItems){
            if(taoCanItem.getScenicId_FK_TaoCanItem()!=null){
                OrderItem orderItem3=new OrderItem();
                orderItem3.setOrderId_FK_OrderItem(orders.getOrderId());
                orderItem3.setRealNameId_FK_OrderItem(Integer.parseInt(realNameId));
                orderItem3.setScenicId_FK_OrderItem(taoCanItem.getScenicId_FK_TaoCanItem());
                orderItem3.setTaoCanId_FK_OrderItem(Integer.parseInt(taoCanId));
                orderItem3.setOrderItemPrice(0);
                orderItem3.setOrderItemStartDate(date);
                orderItem3.setOrderItemPayStatus(0);
                orderItem3.setOrderItemCreateDate(todayDate);

                //      插入子订单表
                orderItemMapper.insertSelective(orderItem3);
            }
        }

        return orders.getOrderId();
    }

    @Override
    public void changeOrderToPaied(String orderId) {
        Orders orders = ordersMapper.selectByPrimaryKey(Integer.parseInt(orderId));
        orders.setOrderStatus(1);
        ordersMapper.updateByPrimaryKeySelective(orders);
    }

    @Override
    public TaoCanItem selectHotelIdAndRoomTypeByTaoCanId(Integer taoCanId) {
        TaoCanItemExample taoCanItemExample=new TaoCanItemExample();
        TaoCanItemExample.Criteria criteria = taoCanItemExample.createCriteria();
        criteria.andTaoCanId_FK_TaoCanItemEqualTo(taoCanId);
        criteria.andHotelId_FK_TaoCanItemIsNotNull();

        List<TaoCanItem> taoCanItems = taoCanItemMapper.selectByExample(taoCanItemExample);
        if(taoCanItems!=null){
            return taoCanItems.get(0);
        }else {
            return null;
        }
    }


}
