package cn.yy.test2;

import cn.yy.test.Father;

public class Son extends Father {

    private String name="原阳";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void test(){
        System.out.println("son method");
    }

    public void testSuper(){
        System.out.println(super.getName());
    }

    public static void main(String[] args) {
        Father son=new Son();

        System.out.println(son.name);

    }



}
