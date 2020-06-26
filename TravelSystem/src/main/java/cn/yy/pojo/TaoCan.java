package cn.yy.pojo;

public class TaoCan {
    private Integer taoCanId;

    private String taoCanName;

    private String taoCanIntroduce;

    private String taoCanImage;

    private Integer taoCanExist;

    private Integer taoCanPrice;

    public Integer getTaoCanId() {
        return taoCanId;
    }

    public void setTaoCanId(Integer taoCanId) {
        this.taoCanId = taoCanId;
    }

    public String getTaoCanName() {
        return taoCanName;
    }

    public void setTaoCanName(String taoCanName) {
        this.taoCanName = taoCanName == null ? null : taoCanName.trim();
    }

    public String getTaoCanIntroduce() {
        return taoCanIntroduce;
    }

    public void setTaoCanIntroduce(String taoCanIntroduce) {
        this.taoCanIntroduce = taoCanIntroduce == null ? null : taoCanIntroduce.trim();
    }

    public String getTaoCanImage() {
        return taoCanImage;
    }

    public void setTaoCanImage(String taoCanImage) {
        this.taoCanImage = taoCanImage == null ? null : taoCanImage.trim();
    }

    public Integer getTaoCanExist() {
        return taoCanExist;
    }

    public void setTaoCanExist(Integer taoCanExist) {
        this.taoCanExist = taoCanExist;
    }

    public Integer getTaoCanPrice() {
        return taoCanPrice;
    }

    public void setTaoCanPrice(Integer taoCanPrice) {
        this.taoCanPrice = taoCanPrice;
    }
}