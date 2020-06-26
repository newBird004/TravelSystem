package cn.yy.pojo;

public class Cart {
    private Integer cartId;

    private Integer travelUserId_FK_Cart;

    private Integer realNameId_FK_Cart;

    private Integer scenicId_FK_Cart;

    private Integer hotelId_FK_Cart;

    private String roomType;

    private String cartStartDate;

    private String cartEndDate;

    private Integer cartPrice;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getTravelUserId_FK_Cart() {
        return travelUserId_FK_Cart;
    }

    public void setTravelUserId_FK_Cart(Integer travelUserId_FK_Cart) {
        this.travelUserId_FK_Cart = travelUserId_FK_Cart;
    }

    public Integer getRealNameId_FK_Cart() {
        return realNameId_FK_Cart;
    }

    public void setRealNameId_FK_Cart(Integer realNameId_FK_Cart) {
        this.realNameId_FK_Cart = realNameId_FK_Cart;
    }

    public Integer getScenicId_FK_Cart() {
        return scenicId_FK_Cart;
    }

    public void setScenicId_FK_Cart(Integer scenicId_FK_Cart) {
        this.scenicId_FK_Cart = scenicId_FK_Cart;
    }

    public Integer getHotelId_FK_Cart() {
        return hotelId_FK_Cart;
    }

    public void setHotelId_FK_Cart(Integer hotelId_FK_Cart) {
        this.hotelId_FK_Cart = hotelId_FK_Cart;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType == null ? null : roomType.trim();
    }

    public String getCartStartDate() {
        return cartStartDate;
    }

    public void setCartStartDate(String cartStartDate) {
        this.cartStartDate = cartStartDate == null ? null : cartStartDate.trim();
    }

    public String getCartEndDate() {
        return cartEndDate;
    }

    public void setCartEndDate(String cartEndDate) {
        this.cartEndDate = cartEndDate == null ? null : cartEndDate.trim();
    }

    public Integer getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(Integer cartPrice) {
        this.cartPrice = cartPrice;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", travelUserId_FK_Cart=" + travelUserId_FK_Cart +
                ", realNameId_FK_Cart=" + realNameId_FK_Cart +
                ", scenicId_FK_Cart=" + scenicId_FK_Cart +
                ", hotelId_FK_Cart=" + hotelId_FK_Cart +
                ", roomType='" + roomType + '\'' +
                ", cartStartDate='" + cartStartDate + '\'' +
                ", cartEndDate='" + cartEndDate + '\'' +
                ", cartPrice=" + cartPrice +
                '}';
    }
}