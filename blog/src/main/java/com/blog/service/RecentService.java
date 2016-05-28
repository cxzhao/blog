package com.blog.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.RecentDao;
import com.blog.domain.Article;

@Service
public class RecentService {

	@Autowired
	private RecentDao recentDao;
	
	/**
	 * 查询最近阅读，去掉重复的
	 * @param start
	 * @param end
	 * @return
	 * @author chenxi
	 * @date 2016年5月8日 下午9:48:22
	 */
	public List<Article> queryDistinctRecentArticle(int start,int end){
		List<Article> rencentArticles = recentDao.queryRencentArticle(start, end);
		if(rencentArticles==null){
			return null;
		}
		Set<Long> set = new HashSet<Long>();
		int length = rencentArticles.size();
		List<Article> rencent = new ArrayList<Article>();
		if(length==0){
			return null;
		}else if(length==1){
			return rencentArticles;
		}
		
		rencent.add(rencentArticles.get(0));
		set.add(rencentArticles.get(0).getId());
		
		for(int i=0;i<length;i++){
			if(!set.contains(rencentArticles.get(i).getId())){
				rencent.add(rencentArticles.get(i));
				set.add(rencentArticles.get(i).getId());
			}
		}		
		return rencent;
	}
}
