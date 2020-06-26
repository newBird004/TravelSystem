package cn.yy.pojo;

public class RoomTime {
    private Integer roomTimeId;

    private Integer roomId_FK_RoomTime;

    private String roomTimeStartDate;

    private String roomTimeEndDate;

    private Integer payStatus;

    private String createDate;

    public Integer getRoomTimeId() {
        return roomTimeId;
    }

    public void setRoomTimeId(Integer roomTimeId) {
        this.roomTimeId = roomTimeId;
    }

    public Integer getRoomId_FK_RoomTime() {
        return roomId_FK_RoomTime;
    }

    public void setRoomId_FK_RoomTime(Integer roomId_FK_RoomTime) {
        this.roomId_FK_RoomTime = roomId_FK_RoomTime;
    }

    public String getRoomTimeStartDate() {
        return roomTimeStartDate;
    }

    public void setRoomTimeStartDate(String roomTimeStartDate) {
        this.roomTimeStartDate = roomTimeStartDate == null ? null : roomTimeStartDate.trim();
    }

    public String getRoomTimeEndDate() {
        return roomTimeEndDate;
    }

    public void setRoomTimeEndDate(String roomTimeEndDate) {
        this.roomTimeEndDate = roomTimeEndDate == null ? null : roomTimeEndDate.trim();
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate == null ? null : createDate.trim();
    }
}