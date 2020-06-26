package cn.yy.pojo;

public class Comment {
    private Integer commentId;

    private Integer scenicId_FK_Comment;

    private Integer hotelId_FK_Comment;

    private String commentDate;

    private String commentText;

    private Integer commentStar;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getScenicId_FK_Comment() {
        return scenicId_FK_Comment;
    }

    public void setScenicId_FK_Comment(Integer scenicId_FK_Comment) {
        this.scenicId_FK_Comment = scenicId_FK_Comment;
    }

    public Integer getHotelId_FK_Comment() {
        return hotelId_FK_Comment;
    }

    public void setHotelId_FK_Comment(Integer hotelId_FK_Comment) {
        this.hotelId_FK_Comment = hotelId_FK_Comment;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate == null ? null : commentDate.trim();
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText == null ? null : commentText.trim();
    }

    public Integer getCommentStar() {
        return commentStar;
    }

    public void setCommentStar(Integer commentStar) {
        this.commentStar = commentStar;
    }
}