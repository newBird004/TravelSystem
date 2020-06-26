package cn.yy.service.impl;

import cn.yy.dao.CommentMapper;
import cn.yy.dao.OrderItemMapper;
import cn.yy.dao.RoomMapper;
import cn.yy.pojo.Comment;
import cn.yy.pojo.CommentExample;
import cn.yy.pojo.OrderItem;
import cn.yy.pojo.Room;
import cn.yy.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private RoomMapper roomMapper;

    @Override
    public Integer insertIntoComment(String rating,String inputComment,String orderItemId) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date(System.currentTimeMillis()));

        OrderItem orderItem = orderItemMapper.selectByPrimaryKey(Integer.parseInt(orderItemId));
        Comment comment=new Comment();
        comment.setCommentDate(date);
        if(rating!=null&&inputComment!=null){
            comment.setCommentStar(Integer.parseInt(rating));
            comment.setCommentText(inputComment);

            if(orderItem.getScenicId_FK_OrderItem()!=null){
                comment.setScenicId_FK_Comment(orderItem.getScenicId_FK_OrderItem());
                commentMapper.insertSelective(comment);//添加评论
                orderItem.setCommentId_FK_OrderItem(comment.getCommentId());//将这个订单编号同步到子订单记录中
                orderItemMapper.updateByPrimaryKeySelective(orderItem);
            }else if(orderItem.getRoomId_FK_OrderItem()!=null){
                Room room=roomMapper.selectByPrimaryKey(orderItem.getRoomId_FK_OrderItem());
                Integer hotelId_fk_room = room.getHotelId_FK_Room();
                comment.setHotelId_FK_Comment(hotelId_fk_room);
                commentMapper.insertSelective(comment);//添加评论
                orderItem.setCommentId_FK_OrderItem(comment.getCommentId());//将这个订单编号同步到子订单记录中
                orderItemMapper.updateByPrimaryKeySelective(orderItem);
            }


            return 1;
        }

        return 0;

    }

    @Override
    public List<Comment> selectCommentsByScenicId(Integer scenicId) {
        CommentExample commentExample=new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andScenicId_FK_CommentEqualTo(scenicId);
        commentExample.setOrderByClause("commentId DESC");

        List<Comment> comments = commentMapper.selectByExample(commentExample);
        return  comments;
    }

    @Override
    public List<Comment> selectCommentsByHotelId(Integer hotelId) {
        CommentExample commentExample=new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andHotelId_FK_CommentEqualTo(hotelId);
        commentExample.setOrderByClause("commentId DESC");

        List<Comment> comments = commentMapper.selectByExample(commentExample);
        return  comments;
    }



}
