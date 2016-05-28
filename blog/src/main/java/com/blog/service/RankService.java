package com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.RankDao;
import com.blog.domain.Article;

@Service
public class RankService {

	@Autowired
	private RankDao rankDao;
	
	public List<Article> queryRank(int start,int end){
		return rankDao.queryClickRank(start, end);
	} 
}
