package cn.yy.controller;


import cn.yy.pojo.Msg;

import cn.yy.pojo.Scenic;
import cn.yy.service.ScenicService;
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
public class ScenicController {

    @Autowired
    private ScenicService scenicService;


    @RequestMapping("/checkScenicNameReapt")
    @ResponseBody
    public String checkScenicNameReapt(String name){//检查用户名是否重复
        Scenic scenic = scenicService.selectByScenicName(name);
        if(scenic!=null){
            return "1";
        }
        return "0";
    }

    /*跳转到景点列表jsp页面*/
    @RequestMapping("/openScenicListPage")
    public String openScenicListPage(){
        return "scenic";
    }

    /*根据页数查询到用户并返回给页面加载*/
    @RequestMapping("/loadScenicList")
    @ResponseBody
    public Msg loadScenicList(@RequestParam(value = "pn",defaultValue ="1")Integer pageNum){

        PageHelper.startPage(pageNum,8);//设置分页的数据。第一个参数指的是当前页，第二个参数是每页有多少条数据

        List<Scenic> scenics = scenicService.selectAll();//紧跟在PageHelper.startPage()方法之后的这个查询就是一个分页查询

        PageInfo pageInfo=new PageInfo(scenics,5);//用pageinfo封装分页的信息。

        Msg msg=Msg.success();
        msg.add("pageInfo",pageInfo);
        return msg;
    }

    /*保存景点*/
    @ResponseBody
    @RequestMapping(value = "/scenic",method = RequestMethod.POST)
    public Msg saveScenic(Scenic scenic){
//        System.out.println(scenic);
        scenic.setScenicExist(1);
        scenicService.insertScenic(scenic);
        Msg msg=Msg.success();
        return msg;
    }

    /*
     * 根据id查询数据，并返回给页面。进行数据回显。
     * */
    @ResponseBody
    @RequestMapping(value = "/scenic/{id}",method = RequestMethod.GET)
    public Msg getMsgById(@PathVariable("id")Integer id){
        Scenic scenic = scenicService.selectById(id);
        Msg msg=Msg.success();
        msg.add("scenic",scenic);
        return  msg;
    }


    /*
     * 将传过来的数据进行更新
     * */
    @ResponseBody
    @RequestMapping(value="/scenic/{scenicId}",method = RequestMethod.PUT)
    public Msg updateScenic(Scenic scenic){
//        System.out.println(scenic);
        scenicService.updateScenic(scenic);
        return Msg.success();
    }


    /*
     * 删除数据（删除单个数据和批量删除数据通用）
     * */
    @ResponseBody
    @RequestMapping(value="/scenic/{ids}",method = RequestMethod.DELETE)
    public Msg deleteById(@PathVariable("ids")String ids){
        if(ids.contains("-")) {//批量删除
            List<Integer> deleteIdList=new ArrayList<Integer>();
            String[] deleteIds=ids.split("-");
            for(String s:deleteIds) {//遍历，将字符串转换为id的list集合
                Integer id = Integer.parseInt(s);
                deleteIdList.add(id);
            }
            try {
                scenicService.deleteScenicBatch(deleteIdList);//调用service层方法执行批量删除
            }catch (Exception e){
                e.printStackTrace();
                return Msg.fail();
            }

        }else {//单个删除
            try {
                scenicService.deleteScenicById(Integer.parseInt(ids));
            }catch (Exception e){
                e.printStackTrace();
                return Msg.fail();
            }
            return Msg.success();
        }
        return Msg.success();
    }

    @RequestMapping(value = "/upload")
    @ResponseBody
    public String uploadScenicImage(@RequestParam(value = "fileName", required = false) MultipartFile file, HttpServletRequest request) throws IOException {

//        System.out.println("......................");
        String path = request.getServletContext().getRealPath("/img/Scenic");//文件的上传路径

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


    @RequestMapping(value = "/upload_update")
    @ResponseBody
    public String upload_updateScenicImage(@RequestParam(value = "fileName_update", required = false) MultipartFile file, HttpServletRequest request) throws IOException {

//        System.out.println("......................");
        String path = request.getServletContext().getRealPath("/img/Scenic");//文件的上传路径

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


    /*跳转到景点列表jsp页面*/
    @RequestMapping("/openAllScenicPage")
    public String openAllScenicPage(){
        return "scenicList";
    }


    /*带着酒店信息跳转到酒店详情页面*/
    @RequestMapping("/openScenicDetailPage")
    public String openScenicDetailPage(@RequestParam(value = "scenicId") String scenicId, Model model){
        Scenic scenic = scenicService.selectById(Integer.parseInt(scenicId));
        model.addAttribute("scenic",scenic);
        return "scenicDetail";
    }

    /*预订景点门票*/
    @RequestMapping("/purchaseScenic")
    @ResponseBody
    public Msg purchaseScenic(String travelUserId, String price, String realNameId, String scenicId, String date,HttpServletRequest request){

        Integer orderId=scenicService.purchaseScenic(travelUserId,price,realNameId,scenicId,date);

        HttpSession session = request.getSession();
        session.setAttribute("price",price);
        session.setAttribute("orderId",orderId);

        Msg msg=Msg.success();
        return msg;
    }

    /*实现添加到购物车的功能*/
    @RequestMapping("/addScenicToCart")
    @ResponseBody
    public Msg addScenicToCart(String travelUserId, String price, String realNameId, String scenicId, String date){
        scenicService.addScenicToCart(travelUserId,price,realNameId,scenicId,date);
        Msg msg=Msg.success();
        return msg;
    }


    /*跳转到支付页面*/
    @RequestMapping("/openPayPage")
    public String openPayPage(){
        return "pay";
    }

    /*改变支付状态*/
    @RequestMapping("/changeOrderToPaied")
    public String changeOrderToPaied(String orderId){

        scenicService.changeOrderToPaied(orderId);
        return "redirect:/";
    }


    /*根据页数查询到用户并返回给页面加载*/
    @RequestMapping("/loadScenicToTaoCan")
    @ResponseBody
    public Msg loadScenicToTaoCan(){
        List<Scenic> scenics = scenicService.selectAll();//紧跟在PageHelper.startPage()方法之后的这个查询就是一个分页查询
        Msg msg=Msg.success();
        msg.add("scenics",scenics);
        return msg;
    }

    /*根据景点名称搜索景点*/
    @RequestMapping("/selectScenicMsgByScenicId")
    @ResponseBody
    public Msg selectScenicMsgByScenicId(String scenicId){
        Scenic scenic = scenicService.selectById(Integer.parseInt(scenicId));
        Msg msg=Msg.success();
        msg.add("scenics",scenic);
        return msg;
    }

    /*根据页数查询到已经删除的景点并返回给页面加载*/
    @RequestMapping("/loadHasDeletedScenicList")
    @ResponseBody
    public Msg loadHasDeletedScenicList(@RequestParam(value = "pn",defaultValue ="1")Integer pageNum){

        PageHelper.startPage(pageNum,8);//设置分页的数据。第一个参数指的是当前页，第二个参数是每页有多少条数据

        List<Scenic> scenics = scenicService.selectHasDeteledScenic();//紧跟在PageHelper.startPage()方法之后的这个查询就是一个分页查询

        PageInfo pageInfo=new PageInfo(scenics,5);//用pageinfo封装分页的信息。

        Msg msg=Msg.success();
        msg.add("pageInfo",pageInfo);
        return msg;
    }

}
