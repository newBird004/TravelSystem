package cn.yy.util;

import java.util.Base64;

public class Base64Utils {

	public static String encode(String s) {
		String encodeToString = Base64.getEncoder().encodeToString(s.getBytes());
		return encodeToString;
	}
	
	public static String decode(String s) {
		String decodeToString =new String( Base64.getDecoder().decode(s));
		return decodeToString;
	}
}
