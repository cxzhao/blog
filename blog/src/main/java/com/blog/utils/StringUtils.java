package com.blog.utils;

public class StringUtils {

	private StringUtils(){}
	
	public static boolean isEmptyOrBlank(String name){
		if(name==null){
			return true;
		}
		if(name.equals("")){
			return true;
		}
		return false;
	}
}
