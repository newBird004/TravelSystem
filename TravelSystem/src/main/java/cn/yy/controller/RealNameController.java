package cn.yy.controller;

import cn.yy.pojo.Msg;
import cn.yy.pojo.RealName;
import cn.yy.service.RealNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RealNameController {

    @Autowired
    private RealNameService realNameService;

//    根据用户id查询该用户的所有实名信息
    @ResponseBody
    @RequestMapping(value="/selectRealNameByTravelUserId")
    public Msg selectRealNameByTravelUserId(String travelUserId){
        System.out.println(travelUserId);
        List<RealName> realNames = realNameService.selectRealNameByTravelUserId(Integer.parseInt(travelUserId));
        Msg msg = Msg.success();
        msg.add("realNames",realNames);
        return msg;
    }



}





