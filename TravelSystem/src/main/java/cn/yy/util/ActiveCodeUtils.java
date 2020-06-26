package cn.yy.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ActiveCodeUtils {

	public static String getActiveCode() {
		Date date=new Date();
		DateFormat df=new SimpleDateFormat("yyyyMMddHHmmsss");//用这种格式获取日期
		String format = df.format(date);//对日期对象格式化，获的字符串
		Integer random = new Random().nextInt(999);//随机数
		String valueOf = String.valueOf(random);//将随机数转换为string
		String result=format+valueOf;//拼接字符串
		return result;//返回字符串。
		
	}
}
