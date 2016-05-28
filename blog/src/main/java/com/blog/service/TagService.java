package com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.TagDao;
import com.blog.domain.ArticleTag;

@Service
public class TagService {

	@Autowired
	private TagDao tagDao;
	
	public List<ArticleTag>queryAllTag(){
		return tagDao.queryAllTag();
	}
}
