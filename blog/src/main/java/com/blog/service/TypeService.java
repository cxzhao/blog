package com.blog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.TypeDao;
import com.blog.domain.ArticleType;

@Service
public class TypeService {

	@Autowired
	private TypeDao typedDao;
	
	/**
	 * 添加类型
	 * @param type
	 * @return
	 * @author chenxi
	 * @date 2016年4月23日 上午11:43:49
	 */
	public boolean save(String type){
		long res=typedDao.add(type);
		if(res!=0){
			return true;
		}else{
			return false;
		}
	}
	
	public List<ArticleType> queryType(){
		List<String> list = typedDao.query();
		if(list==null){
			return null;
		}
		List<ArticleType> types = new ArrayList<ArticleType>();
		for(String str:list){
			types.add(new ArticleType(str));
		}
		return types;
	}
}
