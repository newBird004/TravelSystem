package cn.yy.util;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomNumUtil {

    public static String getRandomNum(){
        String code= RandomStringUtils.random(4, true, true);
        return  code;
    }
}
