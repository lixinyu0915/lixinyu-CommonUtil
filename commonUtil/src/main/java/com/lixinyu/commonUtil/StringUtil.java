package com.lixinyu.commonUtil;

public class StringUtil {
	/*
	 * 判断字符串是否为空
	 */
	public static boolean isBlank(String str) {
		if(str==null) {
			return true;
		}
		str.trim();
		if(str.length()==0) {
			return true;
		}
		return false;
	}
	/**
	 * 判断是否是手机号
	 * @param str
	 * @return
	 */
	public static boolean isNum(String str) {
		String regex="\\d+||\\d+.\\d+";
		return str.matches(regex);
	}
	/**
	 * 判断是否是手机号
	 * @param str
	 * @return
	 */
	public static boolean isPhoneNum(String str) {
		String regex="1[3578]\\d{9}";
		return str.matches(regex);
	}
	/**
	 * 字符串替换
	 * @param str1
	 * @return
	 */
	public static String replacestr(String str1) {
		String str="asdaxexca";
		str=str.replace("xca", str1);
		return str;
	}
	
	public static boolean judgeTelephoneIsOk(String src){
		String regex="1[3578]\\d{9}";
		String regex1="\\d+";
		boolean matches=true;
		if(src.matches(regex1)) {
				matches = src.matches(regex);
		}
		return matches;
	}
	
	/**
	 * 验证是否是URL
	 * @param url
	 * @return
	 */
	public static boolean isHttpUrl(String str){
		 //转换为小写
        str = str.toLowerCase();
        String regex = "^((https|http|ftp|rtsp|mms)?://)"  //https、http、ftp、rtsp、mms
                + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp的user@  
               + "(([0-9]{1,3}\\.){3}[0-9]{1,3}" // IP形式的URL- 例如：199.194.52.184               
                 + "|" // 允许IP和DOMAIN（域名） 或单域名
                 + "[0-9a-z]*"  // 或单域名
                 + "|" // 允许IP和DOMAIN（域名） 或单域名
                 + "([0-9a-z_!~*'()-]+\\.)*" // 域名- www.  
                 + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\." // 二级域名  
                + "[a-z]{2,6})" // first level domain- .com or .museum  
                + "(:[0-9]{1,5})?" // 端口号最大为65535,5位数
                + "((/?)|" // a slash isn't required if there is no file name  
                + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";  
        return  str.matches(regex);	
	}
	
	public static void main(String[] args) {
		System.out.println(isHttpUrl("localhost/article/5.html"));
	}
}
