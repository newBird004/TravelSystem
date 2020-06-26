package cn.yy.controller;

import cn.yy.pojo.Comment;
import cn.yy.pojo.Msg;
import cn.yy.pojo.OrderItem;
import cn.yy.pojo.Room;
import cn.yy.service.CommentService;
import cn.yy.service.OrderItemService;
import cn.yy.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private RoomService roomService;

    /*保存新的评论*/
    @RequestMapping("/commentSubmit")
    @ResponseBody
    public String commentSubmit(String rating,String inputComment,String orderItemId){

        if(commentService.insertIntoComment(rating,inputComment,orderItemId)==1){//添加评论
            return "1";
        }else {
            return "0";
        }
    }

    /*根据景点id获取该景点的评论*/
    @RequestMapping("/commentsByScenicId")
    @ResponseBody
    public Msg commentsByScenicId(String scenicId){

        List<Comment> comments = commentService.selectCommentsByScenicId(Integer.parseInt(scenicId));
        Msg msg=Msg.success();
        msg.add("comments",comments);
        return  msg;
    }

    /*根据景点id获取该酒店的评论*/
    @RequestMapping("/commentsByHotelId")
    @ResponseBody
    public Msg commentsByHotelId(String hotelId){

        List<Comment> comments = commentService.selectCommentsByHotelId(Integer.parseInt(hotelId));
        Msg msg=Msg.success();
        msg.add("comments",comments);
        return  msg;
    }



}
