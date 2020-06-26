package cn.yy.test;

public class Father {

    public String firstName;
    public String name="原志卯";

    public Father() {
    }

    public Father(String firstName, String name) {
        this.firstName = firstName;
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void test(){
        System.out.println("father method");
    }
    public void testF(){
        System.out.println("father method");
    }
}
