package com.blog.vo;

/**
 * JSON模型
 * @author chenxi
 * @date 2016年4月12日 下午3:21:20
 */
public class JsonModel {
	
	public static final int SUCCESS=1;
	public static final int FAILED=0;
	
	private int returnCode;
	private Object data;
	private int message;
	
	
	public int getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public int getMessage() {
		return message;
	}
	
	public void setMessage(int message) {
		this.message = message;
	}
	
}
