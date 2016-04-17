package com.blog.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 对象序列化工具类
 * @author chenxi
 */
public class SerializeUtils {
	
	private SerializeUtils(){}
	
	/**
	 * 序列化，序列化的对象必须实现序列化接口
	 * @param object
	 * @return 序列化之后的字节数组
	 * @throws IOException
	 */
	public static byte[] serialize(Object object) {		
		ByteArrayOutputStream out = new ByteArrayOutputStream();			
		ObjectOutputStream objOut;
		byte[] buffer = null;
		try {
			objOut = new ObjectOutputStream(out);
			objOut.writeObject(object);
			buffer = out.toByteArray();
			objOut.close();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return buffer;
	}
	
	/**
	 * 将字节数组反序列化为对象
	 * @param b
	 * @return 返回一个泛型对象
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object deserialize(byte[] b) {		
		ByteArrayInputStream in = new ByteArrayInputStream(b);			
		ObjectInputStream objIn;
		try {
			objIn = new ObjectInputStream(in);
			Object obj = objIn.readObject();
			in.close();
			objIn.close();
			return obj;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}
	
}
