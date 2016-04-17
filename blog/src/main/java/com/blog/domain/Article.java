package com.blog.domain;

import java.util.Date;
import java.util.Set;

public class Article {
	
	private long id;
	private String title;
	private String content;
	private Date date;
	private String author;
	private int comments;
	//使用set集合存储文章标签标签的键名为“article:Id:tag”
	private Set<String> tag;
	private String type;
	
	public Article(){}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getComments() {
		return comments;
	}
	public void setComments(int comments) {
		this.comments = comments;
	}
	public Set<String> getTag() {
		return tag;
	}
	public void setTag(Set<String>  tag) {
		this.tag = tag;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
