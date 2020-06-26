package cn.yy.pojo;

public class Hotel {
    private Integer hotelId;

    private String hotelName;

    private String hotelIntroduce;

    private String hotelImage;

    private Integer hotelExist;

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName == null ? null : hotelName.trim();
    }

    public String getHotelIntroduce() {
        return hotelIntroduce;
    }

    public void setHotelIntroduce(String hotelIntroduce) {
        this.hotelIntroduce = hotelIntroduce == null ? null : hotelIntroduce.trim();
    }

    public String getHotelImage() {
        return hotelImage;
    }

    public void setHotelImage(String hotelImage) {
        this.hotelImage = hotelImage == null ? null : hotelImage.trim();
    }

    public Integer getHotelExist() {
        return hotelExist;
    }

    public void setHotelExist(Integer hotelExist) {
        this.hotelExist = hotelExist;
    }
}