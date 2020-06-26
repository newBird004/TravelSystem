package cn.yy.pojo;

import javax.validation.constraints.Pattern;

public class TravelUser {
    private Integer travelUserId;

    @Pattern(regexp = "(^[a-zA-Z0-9_-]{4,16}$)|(^[\\u2E80-\\u9FFF]{1,5})",
            message = "用户名必须为4~16个英文或者字母的组合或者1~5个汉字!")
    private String userName;

    private String password;

    private String sex;

    @Pattern(regexp = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$",
            message = "邮箱格式不正确！")
    private String email;

    private String address;

    private Integer role;

    private Integer travelUserExist;

    public Integer getTravelUserId() {
        return travelUserId;
    }

    public void setTravelUserId(Integer travelUserId) {
        this.travelUserId = travelUserId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getTravelUserExist() {
        return travelUserExist;
    }

    public void setTravelUserExist(Integer travelUserExist) {
        this.travelUserExist = travelUserExist;
    }
}