package com.blog.bean;

import java.util.List;

/**
 * 分页类
 * @author chenxi
 * @date 2016年4月9日 下午3:48:27 
 * @param <T>
 */
public class Page <T>{
	private int pageSize;
	private int pageNumber;
	private int totalPage;
	private List<T> list;
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		if(pageNumber<=0){
			throw new RuntimeException("pageNumber的最小值为１");
		}
		this.pageNumber = pageNumber;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
}
