package cn.yy.pojo;

public class TaoCanItem {
    private Integer taoCanItemId;

    private Integer taoCanId_FK_TaoCanItem;

    private Integer scenicId_FK_TaoCanItem;

    private Integer hotelId_FK_TaoCanItem;

    private String roomType;

    public Integer getTaoCanItemId() {
        return taoCanItemId;
    }

    public void setTaoCanItemId(Integer taoCanItemId) {
        this.taoCanItemId = taoCanItemId;
    }

    public Integer getTaoCanId_FK_TaoCanItem() {
        return taoCanId_FK_TaoCanItem;
    }

    public void setTaoCanId_FK_TaoCanItem(Integer taoCanId_FK_TaoCanItem) {
        this.taoCanId_FK_TaoCanItem = taoCanId_FK_TaoCanItem;
    }

    public Integer getScenicId_FK_TaoCanItem() {
        return scenicId_FK_TaoCanItem;
    }

    public void setScenicId_FK_TaoCanItem(Integer scenicId_FK_TaoCanItem) {
        this.scenicId_FK_TaoCanItem = scenicId_FK_TaoCanItem;
    }

    public Integer getHotelId_FK_TaoCanItem() {
        return hotelId_FK_TaoCanItem;
    }

    public void setHotelId_FK_TaoCanItem(Integer hotelId_FK_TaoCanItem) {
        this.hotelId_FK_TaoCanItem = hotelId_FK_TaoCanItem;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType == null ? null : roomType.trim();
    }
}