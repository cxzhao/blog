package com.blog.bean;

/*
 * redis有序集合成员
 */
public class SetMember {
	
	private String member;
	private long score;
	
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
	
	public long getScore() {
		return score;
	}
	
	public void setScore(long score) {
		this.score = score;
	}
	
}
