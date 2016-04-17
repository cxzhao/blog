package com.blog.utils;

import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
	
	private static Properties properties;
	
	private PropertyUtils(){
	} 
	
	/**
	 * @author CHENXI ZHAO
	 * @Description: 加载配置文件
	 * @param c
	 * @param fileName
	 * @return
	 * @date 2016-3-26 下午8:37:17
	 */
	public static Properties getProperties(Class<?> c,String fileName){
		 properties = new Properties();
		try {
			properties.load(c.getClassLoader().getResourceAsStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("配置文件需要放在src目录下");
			return null;
		}
		return properties;
	}
	
	public static String getString(String key){
		if(properties==null){
			throw new RuntimeException("没有使用getProperties方法指定资源文件");
		}
		if(properties.containsKey(key)){
			return properties.getProperty(key);
		}else{
			return null;
		}
	
		
	}
	
	public static int getInt(String key){
		if(properties==null){
			throw new RuntimeException("没有使用getProperties方法指定资源文件");
		}
		if(properties.containsKey(key)){
			return Integer.valueOf(properties.getProperty(key));
		}else{
			throw new RuntimeException("没有找到Key："+key);
		}
		
	}
	
	public static double getDouble(String key){
		if(properties==null){
			throw new RuntimeException("没有使用getProperties方法指定资源文件");
		}
		if(properties.containsKey(key)){
			return Double.valueOf(properties.getProperty(key));
		}else{
			throw new RuntimeException("没有找到Key："+key);
		}
		
	}
	
	public static float getFloat(String key){
		if(properties==null){
			throw new RuntimeException("没有使用getProperties方法指定资源文件");
		}
		if(properties.containsKey(key)){
			return Float.valueOf(properties.getProperty(key));
		}else{
			throw new RuntimeException("没有找到Key："+key);
		}
		
	}
	
}
