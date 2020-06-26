package cn.yy.vo;

import cn.yy.pojo.OrderItem;

public class OrderItemCustom extends OrderItem {

    private String scenicName;
    private String hotelName;
    private String roomType;
    private String taoCanName;
    private String goodsName;
    private String realName;
    private Integer goodsId;

    public OrderItemCustom() {
    }

    public OrderItemCustom(String scenicName, String hotelName, String roomType, String taoCanName, String goodsName, String realName) {
        this.scenicName = scenicName;
        this.hotelName = hotelName;
        this.roomType = roomType;
        this.taoCanName = taoCanName;
        this.goodsName = goodsName;
        this.realName = realName;
    }

    public String getScenicName() {
        return scenicName;
    }

    public void setScenicName(String scenicName) {
        this.scenicName = scenicName;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getTaoCanName() {
        return taoCanName;
    }

    public void setTaoCanName(String taoCanName) {
        this.taoCanName = taoCanName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public String toString() {
        return "OrderItemCustom{" +
                "scenicName='" + scenicName + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", roomType='" + roomType + '\'' +
                ", taoCanName='" + taoCanName + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", realName='" + realName + '\'' +
                '}';
    }
}
