package cn.yy.pojo;

public class Room {
    private Integer roomId;

    private Integer hotelId_FK_Room;

    private Integer roomPrice;

    private String roomType;

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getHotelId_FK_Room() {
        return hotelId_FK_Room;
    }

    public void setHotelId_FK_Room(Integer hotelId_FK_Room) {
        this.hotelId_FK_Room = hotelId_FK_Room;
    }

    public Integer getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(Integer roomPrice) {
        this.roomPrice = roomPrice;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType == null ? null : roomType.trim();
    }
}