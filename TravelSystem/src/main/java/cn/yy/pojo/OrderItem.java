package cn.yy.pojo;

public class OrderItem {
    private Integer orderItemId;

    private Integer orderId_FK_OrderItem;

    private Integer realNameId_FK_OrderItem;

    private Integer scenicId_FK_OrderItem;

    private Integer roomId_FK_OrderItem;

    private Integer taoCanId_FK_OrderItem;

    private Integer commentId_FK_OrderItem;

    private Integer orderItemPrice;

    private String orderItemStartDate;

    private String orderItemEndDate;

    private Integer orderItemPayStatus;

    private String orderItemCreateDate;

    private Integer roomTimeId_FK_OrderItem;

    public Integer getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Integer getOrderId_FK_OrderItem() {
        return orderId_FK_OrderItem;
    }

    public void setOrderId_FK_OrderItem(Integer orderId_FK_OrderItem) {
        this.orderId_FK_OrderItem = orderId_FK_OrderItem;
    }

    public Integer getRealNameId_FK_OrderItem() {
        return realNameId_FK_OrderItem;
    }

    public void setRealNameId_FK_OrderItem(Integer realNameId_FK_OrderItem) {
        this.realNameId_FK_OrderItem = realNameId_FK_OrderItem;
    }

    public Integer getScenicId_FK_OrderItem() {
        return scenicId_FK_OrderItem;
    }

    public void setScenicId_FK_OrderItem(Integer scenicId_FK_OrderItem) {
        this.scenicId_FK_OrderItem = scenicId_FK_OrderItem;
    }

    public Integer getRoomId_FK_OrderItem() {
        return roomId_FK_OrderItem;
    }

    public void setRoomId_FK_OrderItem(Integer roomId_FK_OrderItem) {
        this.roomId_FK_OrderItem = roomId_FK_OrderItem;
    }

    public Integer getTaoCanId_FK_OrderItem() {
        return taoCanId_FK_OrderItem;
    }

    public void setTaoCanId_FK_OrderItem(Integer taoCanId_FK_OrderItem) {
        this.taoCanId_FK_OrderItem = taoCanId_FK_OrderItem;
    }

    public Integer getCommentId_FK_OrderItem() {
        return commentId_FK_OrderItem;
    }

    public void setCommentId_FK_OrderItem(Integer commentId_FK_OrderItem) {
        this.commentId_FK_OrderItem = commentId_FK_OrderItem;
    }

    public Integer getOrderItemPrice() {
        return orderItemPrice;
    }

    public void setOrderItemPrice(Integer orderItemPrice) {
        this.orderItemPrice = orderItemPrice;
    }

    public String getOrderItemStartDate() {
        return orderItemStartDate;
    }

    public void setOrderItemStartDate(String orderItemStartDate) {
        this.orderItemStartDate = orderItemStartDate == null ? null : orderItemStartDate.trim();
    }

    public String getOrderItemEndDate() {
        return orderItemEndDate;
    }

    public void setOrderItemEndDate(String orderItemEndDate) {
        this.orderItemEndDate = orderItemEndDate == null ? null : orderItemEndDate.trim();
    }

    public Integer getOrderItemPayStatus() {
        return orderItemPayStatus;
    }

    public void setOrderItemPayStatus(Integer orderItemPayStatus) {
        this.orderItemPayStatus = orderItemPayStatus;
    }

    public String getOrderItemCreateDate() {
        return orderItemCreateDate;
    }

    public void setOrderItemCreateDate(String orderItemCreateDate) {
        this.orderItemCreateDate = orderItemCreateDate == null ? null : orderItemCreateDate.trim();
    }

    public Integer getRoomTimeId_FK_OrderItem() {
        return roomTimeId_FK_OrderItem;
    }

    public void setRoomTimeId_FK_OrderItem(Integer roomTimeId_FK_OrderItem) {
        this.roomTimeId_FK_OrderItem = roomTimeId_FK_OrderItem;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderItemId=" + orderItemId +
                ", orderId_FK_OrderItem=" + orderId_FK_OrderItem +
                ", realNameId_FK_OrderItem=" + realNameId_FK_OrderItem +
                ", scenicId_FK_OrderItem=" + scenicId_FK_OrderItem +
                ", roomId_FK_OrderItem=" + roomId_FK_OrderItem +
                ", taoCanId_FK_OrderItem=" + taoCanId_FK_OrderItem +
                ", commentId_FK_OrderItem=" + commentId_FK_OrderItem +
                ", orderItemPrice=" + orderItemPrice +
                ", orderItemStartDate='" + orderItemStartDate + '\'' +
                ", orderItemEndDate='" + orderItemEndDate + '\'' +
                ", orderItemPayStatus=" + orderItemPayStatus +
                ", orderItemCreateDate='" + orderItemCreateDate + '\'' +
                ", roomTimeId_FK_OrderItem=" + roomTimeId_FK_OrderItem +
                '}';
    }
}