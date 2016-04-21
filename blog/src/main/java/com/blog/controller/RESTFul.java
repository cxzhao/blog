package com.blog.controller;

public class RESTFul<T>{

	private int returnCode;
	private String message;
	private T data;
	
	public RESTFul(){}
	public RESTFul(int returnCode,String message,T t){
		this.returnCode=returnCode;
		this.message = message;
	}
	
	public int getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

	
	
}
