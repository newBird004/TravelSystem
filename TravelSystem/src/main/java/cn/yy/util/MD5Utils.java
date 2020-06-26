package cn.yy.util;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class 	MD5Utils {

	public static String getMD5(String s) {
		try {
			MessageDigest messageDigest=MessageDigest.getInstance("md5");//创建摘要对象，利用md5的方式
			messageDigest.update(s.getBytes());//更新加密数据
			byte[] data = messageDigest.digest();//获取加密后的数据
			
			/*
			 * 也可以这样来做：byte[] byte2=md.digest(password.getBytes());
			 * String str=Base64.getEncoder().encodeToString(byte2);
			 * 这样做是使用了Base64进行编码生成字符串.也就是又经过了base64加密
			 * */
			BigInteger bigInteger=new BigInteger(1,data);//用这个字节数组创建一个integer类型对象出来
			String string = bigInteger.toString(16);//转换为string字符串，用16进制转换。
			return string;//返回生成的字符串
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s;
	}

	@Test
	public void test(){
        System.out.println(getMD5("1234567"));
    }
}
