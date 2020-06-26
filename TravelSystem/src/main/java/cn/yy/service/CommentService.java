package cn.yy.service;

import cn.yy.pojo.Comment;

import java.util.List;

public interface CommentService {
    Integer insertIntoComment(String rating,String inputComment,String orderItemId);

    List<Comment> selectCommentsByScenicId(Integer scenicId);

    List<Comment> selectCommentsByHotelId(Integer hotelId);

}
