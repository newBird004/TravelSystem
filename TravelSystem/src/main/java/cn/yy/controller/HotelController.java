package cn.yy.controller;

import cn.yy.pojo.Hotel;
import cn.yy.pojo.Msg;

import cn.yy.pojo.Scenic;
import cn.yy.service.HotelService;
import cn.yy.service.RoomService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RoomService roomService;


    @RequestMapping("/checkHotelNameReapt")
    @ResponseBody
    public String checkHotelNameReapt(String name){//检查用户名是否重复
        Hotel hotel = hotelService.selectByHotelName(name);
        if(hotel!=null){
            return "1";
        }
        return "0";
    }

    /*跳转到酒店列表jsp页面*/
    @RequestMapping("/openHotelListPage")
    public String openHotelListPage(){
        return "hotel";
    }

    /*根据页数查询到用户并返回给页面加载*/
    @RequestMapping("/loadHotelList")
    @ResponseBody
    public Msg loadHotelList(@RequestParam(value = "pn",defaultValue ="1")Integer pageNum){

        PageHelper.startPage(pageNum,6);//设置分页的数据。第一个参数指的是当前页，第二个参数是每页有多少条数据

        List<Hotel> hotels = hotelService.selectAll();//紧跟在PageHelper.startPage()方法之后的这个查询就是一个分页查询

        PageInfo pageInfo=new PageInfo(hotels,5);//用pageinfo封装分页的信息。

        Msg msg=Msg.success();
        msg.add("pageInfo",pageInfo);
        return msg;
    }

    /*保存酒店*/
    @ResponseBody
    @RequestMapping(value = "/hotel",method = RequestMethod.POST)
    public Msg saveHotel(Hotel hotel,String roomType1,String roomCount1,String roomPrice1,
                         String roomType2,String roomCount2,String roomPrice2,
                         String roomType3,String roomCount3,String roomPrice3){

//        System.out.println(roomType1+roomCount1+roomPrice1);
//        System.out.println("------"+hotel);

        hotel.setHotelExist(1);//设置存在状态
        hotelService.insertHotel(hotel);
        Integer hotelId=hotel.getHotelId();

        if(roomCount1!=""){
            hotelService.insertRoomByHotelId(hotelId,roomType1,roomCount1,roomPrice1);
        }
        if(roomCount2!=""){
            hotelService.insertRoomByHotelId(hotelId,roomType2,roomCount2,roomPrice2);
        }
        if(roomCount3!=""){
            hotelService.insertRoomByHotelId(hotelId,roomType3,roomCount3,roomPrice3);
        }

        Msg msg=Msg.success();
        return msg;
    }

    /*
     * 根据id查询数据，并返回给页面。进行数据回显。
     * */
    @ResponseBody
    @RequestMapping(value = "/hotel/{id}",method = RequestMethod.GET)
    public Msg getMsgById(@PathVariable("id")Integer id){
        Hotel hotel = hotelService.selectById(id);
        Msg msg=Msg.success();
        msg.add("hotel",hotel);
        return  msg;
    }


    /*
     * 将传过来的数据进行更新
     * */
    @ResponseBody
    @RequestMapping(value="/hotel/{hotelId}",method = RequestMethod.PUT)
    public Msg updateHotel(Hotel hotel){
//      System.out.println(hotel);
        hotelService.updateHotel(hotel);
        return Msg.success();
    }


    /*
     * 删除数据（删除单个数据和批量删除数据通用）
     * */
    @ResponseBody
    @RequestMapping(value="/hotel/{ids}",method = RequestMethod.DELETE)
    public Msg deleteById(@PathVariable("ids")String ids){
        if(ids.contains("-")) {//批量删除
            List<Integer> deleteIdList=new ArrayList<Integer>();
            String[] deleteIds=ids.split("-");
            for(String s:deleteIds) {//遍历，将字符串转换为id的list集合
                Integer id = Integer.parseInt(s);
                deleteIdList.add(id);
            }
            try {
                hotelService.deleteHotelBatch(deleteIdList);//调用service层方法执行批量删除

            }catch (Exception e){
                e.printStackTrace();
                return Msg.fail();
            }
        }else {//单个删除
            try {

//目前不用了,改成了假删除 // hotelService.deleteRoomByHotelId(Integer.parseInt(ids));//首先删除掉房间信息。不然会有外键依赖关系，删除报错
                hotelService.deleteHotelById(Integer.parseInt(ids));
            }catch (Exception e){
                e.printStackTrace();
                return Msg.fail();
            }

            return Msg.success();
        }
        return Msg.success();
    }

    @RequestMapping(value = "/uploadHotelImage")
    @ResponseBody
    public String uploadHotelImage(@RequestParam(value = "fileName", required = false) MultipartFile file, HttpServletRequest request) throws IOException {

//        System.out.println("......................");
        String path = request.getServletContext().getRealPath("/img/Hotel");//文件的上传路径

//        System.out.println("path" + path);
        String fileName = file.getOriginalFilename();
        //获取文件名
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        // 获得文件后缀名称
        String suffixName = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
        // 生成最新的uuid文件名称
        String newFileName = uuid + "."+ suffixName;


        System.out.println("文件名" + fileName);
//        String path1[] = path.split("\\\\");//对于特殊字符的分隔|  ^   $  *   .    (    )   \   /等都是正则表达式的一部分，只能通过前面加上\\进行转义。注意\要用三个\\\，也就是split（“\\\\”）
//        String path2 = path1[path1.length - 1];//截取图片所在的文件夹名称
        File dir = new File(path, newFileName);//将指定文件上传到指定的目录下
        /**
         * 如果文件夹不存在，自动创建该文件夹
         */
        if (!dir.exists()) {
            dir.mkdirs();
        }
        //MultipartFile自带的解析方法
        if (!file.isEmpty()) {
            file.transferTo(dir);
            return newFileName;
        } else {
            System.out.println("空文件");
            return "不允许上传空文件";
        }
    }


    @RequestMapping(value = "/upload_updateHotelImage")
    @ResponseBody
    public String upload_updateHotelImage(@RequestParam(value = "fileName_update", required = false) MultipartFile file, HttpServletRequest request) throws IOException {

//        System.out.println("......................");
        String path = request.getServletContext().getRealPath("/img/Hotel");//文件的上传路径

//        System.out.println("path" + path);
        String fileName = file.getOriginalFilename();
        //获取文件名
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        // 获得文件后缀名称
        String suffixName = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
        // 生成最新的uuid文件名称
        String newFileName = uuid + "."+ suffixName;

        System.out.println("文件名" + fileName);
//        String path1[] = path.split("\\\\");//对于特殊字符的分隔|  ^   $  *   .    (    )   \   /等都是正则表达式的一部分，只能通过前面加上\\进行转义。注意\要用三个\\\，也就是split（“\\\\”）
//        String path2 = path1[path1.length - 1];//截取图片所在的文件夹名称
        File dir = new File(path, newFileName);//将指定文件上传到指定的目录下
        /**
         * 如果文件夹不存在，自动创建该文件夹
         */
        if (!dir.exists()) {
            dir.mkdirs();
        }
        //MultipartFile自带的解析方法
        if (!file.isEmpty()) {
            file.transferTo(dir);
            return newFileName;
        } else {
            System.out.println("空文件");
            return "不允许上传空文件";
        }
    }


    /*跳转到酒店列表jsp页面*/
    @RequestMapping("/openAllHotelPage")
    public String openAllHotelPage(){
        return "hotelList";
    }


    /*带着酒店信息跳转到酒店详情页面*/
    @RequestMapping("/openHotelDetailPage")
    public String openHotelDetailPage(@RequestParam(value = "hotelId") String hotelId, Model model){
        Hotel hotel = hotelService.selectById(Integer.parseInt(hotelId));
        model.addAttribute("hotel",hotel);
        return "hotelDetail";
    }

    /*预订酒店房间*/
    @RequestMapping("/purchaseHotel")
    @ResponseBody
    public Msg purchaseHotel(String travelUserId, String price, String realNameId, String roomId, String date,HttpServletRequest request){
//        System.out.println(travelUserId);
//        System.out.println(price);
//        System.out.println(realNameId);
//        System.out.println(hotelId);
//        System.out.println(date);
//        System.out.println(roomType);

        /*计算客户订购了几天房间，计算出价格*/
        String[] dates = date.split("-");
        String startDate=dates[0];
        String endDate=dates[1];


        int day=0;//用于保存天数
        SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
        try {
            Date date1 = sdf.parse(startDate);
            Date date2 = sdf.parse(endDate);
            long time = date2.getTime() - date1.getTime();//计算两个日期相差毫秒数
            day= (int) (time/(3600*1000*24));//将毫秒数转换成天数即是相差天数
//            System.out.println("相差"+day+"天数");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        /*根据预定天数计算总价格*/
        Integer price2=Integer.parseInt(price);
        int orderPrice = day*price2;


        Integer orderId=hotelService.purchaseHotel(Integer.parseInt(travelUserId),orderPrice,Integer.parseInt(realNameId),Integer.parseInt(roomId),startDate,endDate);

        HttpSession session = request.getSession();
        session.setAttribute("price",orderPrice);
        session.setAttribute("orderId",orderId);

        Msg msg=Msg.success();
        return msg;
    }


    /*根据页数查询到用户并返回给页面加载*/
    @RequestMapping("/addHotelToCart")
    @ResponseBody
    public Msg addHotelToCart(String travelUserId, String price, String realNameId, String hotelId,String roomType, String date){

        /*计算客户订购了几天房间，计算出价格*/
        String[] dates = date.split("-");
        String startDate=dates[0];
        String endDate=dates[1];


        int day=0;//用于保存天数
        SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
        try {
            Date date1 = sdf.parse(startDate);
            Date date2 = sdf.parse(endDate);
            long time = date2.getTime() - date1.getTime();//计算两个日期相差毫秒数
            day= (int) (time/(3600*1000*24));//将毫秒数转换成天数即是相差天数
//            System.out.println("相差"+day+"天数");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        /*根据预定天数计算总价格*/
        Integer price2=Integer.parseInt(price);
        int orderPrice = day*price2;

        hotelService.addHotelToCart(Integer.parseInt(travelUserId),orderPrice,Integer.parseInt(realNameId),Integer.parseInt(hotelId),roomType,startDate,endDate);


        Msg msg=Msg.success();
        return msg;
    }


    /*根据页数查询到用户并返回给页面加载*/
    @RequestMapping("/loadHotelToTaoCan")
    @ResponseBody
    public Msg loadHotelToTaoCan(){
        List<Hotel> hotels = hotelService.selectAll();//紧跟在PageHelper.startPage()方法之后的这个查询就是一个分页查询
        Msg msg=Msg.success();
        msg.add("hotels",hotels);
        return msg;
    }

    /*根据酒店编号查询并返回给页面加载*/
    @RequestMapping("/selectHotelByHotelId")
    @ResponseBody
    public Msg selectHotelByHotelId(String hotelId){
        Hotel hotel= hotelService.selectById(Integer.parseInt(hotelId));//紧跟在PageHelper.startPage()方法之后的这个查询就是一个分页查询
        Msg msg=Msg.success();
        msg.add("hotel",hotel);
        return msg;
    }

    /*根据页数查询到已删除的酒店并返回给页面加载*/
    @RequestMapping("/loadHasDeletedHotelList")
    @ResponseBody
    public Msg loadHasDeletedHotelList(@RequestParam(value = "pn",defaultValue ="1")Integer pageNum){

        PageHelper.startPage(pageNum,6);//设置分页的数据。第一个参数指的是当前页，第二个参数是每页有多少条数据

        List<Hotel> hotels = hotelService.selectHasDeletedHotelList();//紧跟在PageHelper.startPage()方法之后的这个查询就是一个分页查询

        PageInfo pageInfo=new PageInfo(hotels,5);//用pageinfo封装分页的信息。

        Msg msg=Msg.success();
        msg.add("pageInfo",pageInfo);
        return msg;
    }


}
