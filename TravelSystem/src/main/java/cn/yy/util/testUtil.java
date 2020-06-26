package cn.yy.util;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class testUtil {

    @Test
    public void test(){
        SimpleDateFormat formatter= new SimpleDateFormat("MM/dd/yyyy");
        Date today = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(today));
    }
}
