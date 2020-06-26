package cn.yy.pojo;

public class RealName {
    private Integer realNameId;

    private Integer travelUserId_FK_RealName;

    private String idCard;

    private String realName;

    private String sex;

    private Integer realNameExist;

    public Integer getRealNameId() {
        return realNameId;
    }

    public void setRealNameId(Integer realNameId) {
        this.realNameId = realNameId;
    }

    public Integer getTravelUserId_FK_RealName() {
        return travelUserId_FK_RealName;
    }

    public void setTravelUserId_FK_RealName(Integer travelUserId_FK_RealName) {
        this.travelUserId_FK_RealName = travelUserId_FK_RealName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getRealNameExist() {
        return realNameExist;
    }

    public void setRealNameExist(Integer realNameExist) {
        this.realNameExist = realNameExist;
    }
}