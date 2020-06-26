package cn.yy.pojo;

public class CartMsg extends Cart{
    private String realName;
    private String goodsName;
    private String startDate;
    private String endDate;
    private String goodsPrice;


    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public CartMsg(String realName, String goodsName, String startDate, String endDate, String goodsPrice) {
        this.realName = realName;
        this.goodsName = goodsName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.goodsPrice = goodsPrice;
    }

    public CartMsg() {
    }

    @Override
    public String toString() {
        return "CartMsg{" +
                "realName='" + realName + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", goodsPrice='" + goodsPrice + '\'' +
                '}';
    }

}
