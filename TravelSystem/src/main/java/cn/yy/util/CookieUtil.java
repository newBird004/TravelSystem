package cn.yy.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

    public static void addCookie(String name, String value,HttpServletRequest request,HttpServletResponse response){
        //创建cookie
        Cookie newCookie = new Cookie(name, value);
        newCookie.setPath(request.getContextPath());//设置cookie路径
        //设置cookie保存的时间 单位：秒
        newCookie.setMaxAge(7*24*60*60);

//        newCookie.setHttpOnly(true);//要注意这句话，千万注意！！！可能会导致你无法将cookie中的数据读取到jsp页面上。
        //将cookie添加到响应
        response.addCookie(newCookie);
    }
}
