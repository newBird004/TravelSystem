package cn.yy.pojo;

public class Orders {
    private Integer orderId;

    private Integer travelUserId_FK_Orders;

    private String orderDate;

    private Integer orderPrice;

    private Integer orderStatus;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getTravelUserId_FK_Orders() {
        return travelUserId_FK_Orders;
    }

    public void setTravelUserId_FK_Orders(Integer travelUserId_FK_Orders) {
        this.travelUserId_FK_Orders = travelUserId_FK_Orders;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate == null ? null : orderDate.trim();
    }

    public Integer getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Integer orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }
}