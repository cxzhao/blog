package com.blog.domain;

/**
 * 文章类别
 * @author root
 */
public class ArticleType {
	
	private String type;

	public ArticleType(){}
	
	public ArticleType(String type){
		setType(type);
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
