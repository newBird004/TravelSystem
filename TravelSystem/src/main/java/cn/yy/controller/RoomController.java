package cn.yy.controller;

import cn.yy.pojo.Msg;
import cn.yy.pojo.Room;
import cn.yy.pojo.RoomTime;
import cn.yy.pojo.TaoCanItem;
import cn.yy.service.RoomService;
import cn.yy.service.RoomTimeService;
import cn.yy.service.TaoCanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomTimeService roomTimeService;

    @Autowired
    private TaoCanService taoCanService;

    //    根据酒店id查询到所有的房间类型信息
    @ResponseBody
    @RequestMapping(value="/selectRoomTypeByHotelId")
    public Msg selectRoomTypeByHotelId(String hotelId){
//        System.out.println(hotelId);
        List<String> roomTypes = roomService.selectRoomTypeByHotelId(Integer.parseInt(hotelId));
        Msg msg = Msg.success();
        msg.add("roomTypes",roomTypes);
        return msg;
    }

    //    根据酒店id和房间类型查询到对应价格
    @ResponseBody
    @RequestMapping(value="/selectPriceByHotelIdAndRoomType")
    public Integer selectPriceByHotelIdAndRoomType(String hotelId,String roomType){
//        System.out.println(hotelId);
        Integer roomPrice=0;
        List<Room> rooms = roomService.selectRoomByHotelIdAndRoomType(Integer.parseInt(hotelId), roomType);
        if(rooms!=null&&!rooms.isEmpty()){
            Room room = rooms.get(0);
            roomPrice=room.getRoomPrice();
        }

        return roomPrice;
    }


    //根据用户所选查询是否有对应空房
    @ResponseBody
    @RequestMapping(value="/checkHasRoom")
    public Integer checkHasRoom(String hotelId,String roomType,String date){

//        System.out.println("//////////////"+date);
        /*
        * 得到今天的日期，然后在查询空房的时候顺便把已经过期了的时间记录删除掉。
        * */
        Date today = new Date(System.currentTimeMillis());
        long time5 = today.getTime();

        /*从数据中计算客户的起始和结束日期*/
        String[] dates = date.split("-");
        String startDate=dates[0];
        String endDate=dates[1];

        /*查出该酒店该房型所有的房间*/
        List<Room> rooms = roomService.selectRoomByHotelIdAndRoomType(Integer.parseInt(hotelId),roomType);

        Integer hasRoomId=0;//默认没有房子，为0代表没有房子

        for(Room room:rooms){//遍历每一个房子
            Integer roomId = room.getRoomId();
            List<RoomTime> roomTimes = roomTimeService.selectRoomTimeByRoomId(roomId);//得到这个房子的所有预约时间段

            boolean roomIdFlag=true;//这个房子是否能够满足客户要求。默认是满足的。
            if(roomTimes!=null){
                for(RoomTime roomTime:roomTimes){
                    String roomTimeStartDate = roomTime.getRoomTimeStartDate();
                    String roomTimeEndDate = roomTime.getRoomTimeEndDate();
                    Date date1=new Date();
                    Date date2=new Date();
                    Date date3=new Date();
                    Date date4=new Date();

                    SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
                    try {
                        date1 = sdf.parse(roomTimeStartDate);
                        date2 = sdf.parse(roomTimeEndDate);
                        date3 = sdf.parse(startDate);
                        date4 = sdf.parse(endDate);

                        long time1 = date1.getTime();//已经存在的开始日期
                        long time2 = date2.getTime();//已经存在的结束日期
                        long time3 = date3.getTime();//客户要求的开始日期
                        long time4 = date4.getTime();//客户要求的结束日期

                        if(time5>(time2+(24*60*60*1000))){//如果今天的时间大于数据库中已经存在的结束日期，就删掉这条数据。这个是为了删除旧的数据。
                            roomTimeService.deleteOldDataByEndDate(roomTimeEndDate);
                        }

                        if((time3>time2)||(time4<time1)){//如果满足，表示这个时间段并不重叠，可以继续比较下一个时间段。
                            continue;
                        }else{//如果不满足，就跳出循环，表示这个房间的时间段重合，不能提供房间。
                            roomIdFlag=false;
                            break;
                        }

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }

            if(roomIdFlag==true){
                hasRoomId=roomId;
                break;
            }else {
                continue;
            }
        }

        return hasRoomId;
    }



    //根据用户所选查询是否有对应空房
    @ResponseBody
    @RequestMapping(value="/checkHasRoomTaoCan")
    public Integer checkHasRoomTaoCan(String taoCanId,String date){

//        System.out.println("---------"+taoCanId+"--------"+date);
        /*根据套餐id在子套餐中查询出对应的酒店id和房间类型*/
        TaoCanItem taoCanItem = taoCanService.selectHotelIdAndRoomTypeByTaoCanId(Integer.parseInt(taoCanId));
        Integer hotelId = taoCanItem.getHotelId_FK_TaoCanItem();
        String roomType = taoCanItem.getRoomType();
//        System.out.println(hotelId+roomType+"----------------");

        /*
         * 得到今天的日期，然后在查询空房的时候顺便把已经过期了的时间记录删除掉。
         * */
        Date today = new Date(System.currentTimeMillis());
        long time5 = today.getTime();

        /*
        * 由于是套餐中的房间，日期只选择了一天，所以我们需要改成毫秒数类型
        * 然后加上24*60*60*1000即一天，作为预约到期的日期。
        * */
        SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
        Date startDate = null;
        try {
            startDate = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long startTime = startDate.getTime();//打算预约的开始日期
        long endTime=startTime+24*60*60*1000;//打算预约的终止日期

        /*查出该酒店该房型所有的房间*/
        List<Room> rooms = roomService.selectRoomByHotelIdAndRoomType(hotelId,roomType);

        Integer hasRoomId=0;//默认没有房子，为0代表没有房子

        for(Room room:rooms){//遍历每一个房子
            Integer roomId = room.getRoomId();
            List<RoomTime> roomTimes = roomTimeService.selectRoomTimeByRoomId(roomId);//得到这个房子的所有预约时间段

            boolean roomIdFlag=true;//这个房子是否能够满足客户要求。默认是满足的。
            for(RoomTime roomTime:roomTimes){
                String roomTimeStartDate = roomTime.getRoomTimeStartDate();
                String roomTimeEndDate = roomTime.getRoomTimeEndDate();
                Date date1=new Date();
                Date date2=new Date();

                try {
                    date1 = sdf.parse(roomTimeStartDate);
                    date2 = sdf.parse(roomTimeEndDate);

                    long time1 = date1.getTime();//已经存在的开始日期
                    long time2 = date2.getTime();//已经存在的结束日期

                    if(time5>(time2+(24*60*60*1000))){//如果今天的时间大于数据库中已经存在的结束日期，就删掉这条数据。这个是为了删除旧的数据。
                        roomTimeService.deleteOldDataByEndDate(roomTimeEndDate);
                    }

                    if((startTime>time2)||(endTime<time1)){//如果满足，表示这个时间段并不重叠，可以继续比较下一个时间段。
                        continue;
                    }else{//如果不满足，就跳出循环，表示这个房间的时间段重合，不能提供房间。
                        roomIdFlag=false;
                        break;
                    }

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            if(roomIdFlag==true){
                hasRoomId=roomId;
                break;
            }else {
                continue;
            }
        }

//        System.out.println(hasRoomId+"----------");
        return hasRoomId;

    }


}
