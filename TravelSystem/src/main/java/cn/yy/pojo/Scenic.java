package cn.yy.pojo;

public class Scenic {
    private Integer scenicId;

    private String scenicName;

    private Integer scenicPrice;

    private String scenicIntroduce;

    private String scenicImage;

    private Integer scenicExist;

    public Integer getScenicId() {
        return scenicId;
    }

    public void setScenicId(Integer scenicId) {
        this.scenicId = scenicId;
    }

    public String getScenicName() {
        return scenicName;
    }

    public void setScenicName(String scenicName) {
        this.scenicName = scenicName == null ? null : scenicName.trim();
    }

    public Integer getScenicPrice() {
        return scenicPrice;
    }

    public void setScenicPrice(Integer scenicPrice) {
        this.scenicPrice = scenicPrice;
    }

    public String getScenicIntroduce() {
        return scenicIntroduce;
    }

    public void setScenicIntroduce(String scenicIntroduce) {
        this.scenicIntroduce = scenicIntroduce == null ? null : scenicIntroduce.trim();
    }

    public String getScenicImage() {
        return scenicImage;
    }

    public void setScenicImage(String scenicImage) {
        this.scenicImage = scenicImage == null ? null : scenicImage.trim();
    }

    public Integer getScenicExist() {
        return scenicExist;
    }

    public void setScenicExist(Integer scenicExist) {
        this.scenicExist = scenicExist;
    }
}