package com.blog.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public static String getDateYMDHMS(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");//小写的mm表示的是分钟  
		return sdf.format(new Date());
	}
	
	public static void main(String[] arg){
		System.out.println(getDateYMDHMS());
	}
}
