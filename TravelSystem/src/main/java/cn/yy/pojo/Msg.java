package cn.yy.pojo;

import java.util.HashMap;
import java.util.Map;

public class Msg {
    private int result;
    private String message;
    private Map<String,Object> extend=new HashMap<>();

    /*
     * 指定的快捷存放成功信息的方法
     * */
    public static Msg success() {
        Msg result=new Msg();
        result.setResult(1);
        result.setMessage("操作成功!");
        return result;
    }
    /*
     * 指定的快捷存放失败信息的方法
     * */
    public static Msg fail() {
        Msg result=new Msg();
        result.setResult(0);
        result.setMessage("操作失败!");
        return result;
    }

    /*
     * 用于添加其他数据的方法
     * */
    public Msg add(String key,Object value) {
        this.extend.put(key, value);
        return this;
    }

    public Msg(int result, String message, Map<String, Object> extend) {
        this.result = result;
        this.message = message;
        this.extend = extend;
    }

    public Msg() {
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "result=" + result +
                ", message='" + message + '\'' +
                ", extend=" + extend +
                '}';
    }

}
