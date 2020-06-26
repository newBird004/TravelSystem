package cn.yy.controller;

import cn.yy.pojo.Msg;
import cn.yy.pojo.TaoCan;
import cn.yy.pojo.TaoCanItem;
import cn.yy.service.TaoCanService;
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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class TaoCanController {

    @Autowired
    private TaoCanService taoCanService;


    @RequestMapping("/checkTaoCanNameReapt")
    @ResponseBody
    public String checkTaoCanNameReapt(String name){//检查用户名是否重复
        TaoCan taoCan = taoCanService.selectByTaoCanName(name);
        if(taoCan!=null){
            return "1";
        }
        return "0";
    }

    /*跳转到套餐列表jsp页面*/
    @RequestMapping("/openTaoCanListPage")
    public String openTaoCanListPage(){
        return "taoCan";
    }

    /*根据页数查询到用户并返回给页面加载*/
    @RequestMapping("/loadTaoCanList")
    @ResponseBody
    public Msg loadTaoCanList(@RequestParam(value = "pn",defaultValue ="1")Integer pageNum){

        PageHelper.startPage(pageNum,8);//设置分页的数据。第一个参数指的是当前页，第二个参数是每页有多少条数据

        List<TaoCan> taoCans = taoCanService.selectAll();//紧跟在PageHelper.startPage()方法之后的这个查询就是一个分页查询

        PageInfo pageInfo=new PageInfo(taoCans,5);//用pageinfo封装分页的信息。

        Msg msg=Msg.success();
        msg.add("pageInfo",pageInfo);
        return msg;
    }

    /*保存套餐*/
    @ResponseBody
    @RequestMapping(value = "/taoCan",method = RequestMethod.POST)
    public Msg saveTaoCan(TaoCan taoCan,String checkedScenicIdStr,String hotelId,String roomType){
//        System.out.println(taoCan);
//        System.out.println("房间类型为"+roomType);
        taoCan.setTaoCanExist(1);
        int taoCanPrice=taoCanService.insertTaoCan(taoCan,checkedScenicIdStr,hotelId,roomType);
        Msg msg = Msg.success();
        msg.add("taoCanPrice",taoCanPrice);
//        System.out.println("套餐价格："+taoCanPrice);
        return  msg;
    }

    /*
     * 根据id查询数据，并返回给页面。进行数据回显。
     * */
    @ResponseBody
    @RequestMapping(value = "/taoCan/{id}",method = RequestMethod.GET)
    public Msg getMsgById(@PathVariable("id")Integer id){
        TaoCan taoCan = taoCanService.selectById(id);
        Msg msg=Msg.success();
        msg.add("taoCan",taoCan);
        return  msg;
    }


    /*
     * 将传过来的数据进行更新
     * */
    @ResponseBody
    @RequestMapping(value="/taoCan/{taoCanId}",method = RequestMethod.PUT)
    public Msg updateTaoCan(TaoCan taoCan){
//        System.out.println(taoCan);
        taoCanService.updateTaoCan(taoCan);
        return Msg.success();
    }


    /*
     * 删除数据（删除单个数据和批量删除数据通用）
     * */
    @ResponseBody
    @RequestMapping(value="/taoCan/{ids}",method = RequestMethod.DELETE)
    public Msg deleteById(@PathVariable("ids")String ids){
        if(ids.contains("-")) {//批量删除
            List<Integer> deleteIdList=new ArrayList<Integer>();
            String[] deleteIds=ids.split("-");
            for(String s:deleteIds) {//遍历，将字符串转换为id的list集合
                Integer id = Integer.parseInt(s);
                deleteIdList.add(id);
            }
            try {
                taoCanService.deleteTaoCanBatch(deleteIdList);//调用service层方法执行批量删除
            }catch (Exception e){
                e.printStackTrace();
                return Msg.fail();
            }

        }else {//单个删除
            try {
                taoCanService.deleteTaoCanById(Integer.parseInt(ids));
            }catch (Exception e){
                e.printStackTrace();
                return Msg.fail();
            }
            return Msg.success();
        }
        return Msg.success();
    }

    @RequestMapping(value = "/uploadTaoCan")
    @ResponseBody
    public String uploadTaoCanImage(@RequestParam(value = "fileName", required = false) MultipartFile file, HttpServletRequest request) throws IOException {

//        System.out.println("......................");
        String path = request.getServletContext().getRealPath("/img/TaoCan");//文件的上传路径

//        System.out.println("path" + path);
        String fileName = file.getOriginalFilename();
        //获取文件名
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        // 获得文件后缀名称
        String suffixName = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
        // 生成最新的uuid文件名称
        String newFileName = uuid + "."+ suffixName;


//        System.out.println("文件名" + fileName);
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


    @RequestMapping(value = "/upload_updateTaoCan")
    @ResponseBody
    public String upload_updateTaoCanImage(@RequestParam(value = "fileName_update", required = false) MultipartFile file, HttpServletRequest request) throws IOException {

//        System.out.println("......................");
        String path = request.getServletContext().getRealPath("/img/TaoCan");//文件的上传路径

//        System.out.println("path" + path);
        String fileName = file.getOriginalFilename();
        //获取文件名
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        // 获得文件后缀名称
        String suffixName = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
        // 生成最新的uuid文件名称
        String newFileName = uuid + "."+ suffixName;

//        System.out.println("文件名" + fileName);
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


    /*跳转到套餐列表jsp页面*/
    @RequestMapping("/openAllTaoCanPage")
    public String openAllTaoCanPage(){
        return "taoCanList";
    }


    /*带着酒店信息跳转到酒店详情页面*/
    @RequestMapping("/openTaoCanDetailPage")
    public String openTaoCanDetailPage(@RequestParam(value = "taoCanId") String taoCanId, Model model){
        TaoCan taoCan = taoCanService.selectById(Integer.parseInt(taoCanId));
        model.addAttribute("taoCan",taoCan);
        return "taoCanDetail";
    }

    /*预订套餐门票*/
    @RequestMapping("/purchaseTaoCan")
    @ResponseBody
    public Msg purchaseTaoCan(String travelUserId, String price, String realNameId, String taoCanId, String date,String roomId,HttpServletRequest request){

        Integer orderId=taoCanService.purchaseTaoCan(travelUserId,price,realNameId,taoCanId,date,roomId);

        HttpSession session = request.getSession();
        session.setAttribute("price",price);
        session.setAttribute("orderId",orderId);

        Msg msg=Msg.success();
        return msg;
    }



    /*根据套餐编号查询到套餐并返回给页面*/
    @RequestMapping("/selectTaoCanMsgById")
    @ResponseBody
    public Msg selectTaoCanMsgById(String taoCanId){

        TaoCan taoCan = taoCanService.selectById(Integer.parseInt(taoCanId));

        Msg msg=Msg.success();
        msg.add("taoCan",taoCan);
        return msg;
    }
}
