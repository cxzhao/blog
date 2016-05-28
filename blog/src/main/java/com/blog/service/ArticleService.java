package com.blog.service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.domain.Article;
import com.blog.utils.StringUtils;
import com.blog.bean.Page;
import com.blog.dao.ArticleDao;

/**
 * 文章业务逻辑类
 * @author chenxi
 * @date 2016年4月10日 下午2:18:29
 */
@Service
public class ArticleService {
	
	@Autowired
	private ArticleDao articleDao;
	
	/**
	 * 添加文章
	 * @param title
	 * @param type
	 * @param content
	 * @param tag　传过来的参数使用英文“,”隔开
	 * @param newtag
	 * @return
	 * @author chenxi
	 * @date 2016年4月12日 下午2:01:50
	 */
	public boolean addArticle(String title,String type,String content,String tag,String newtag){
		Article article = new Article();
		article.setTitle(title);
		article.setType(type);
		article.setContent(content);
		if(newtag!=null&&!StringUtils.isEmptyOrBlank(tag)){
			tag=","+newtag;
		}else{
			tag=newtag;
		}
		String [] tagArray = tag.split("\\,");
		Set<String> tagSet = new HashSet<String>();
		for(String str:tagArray){
			tagSet.add(str);
		}
		article.setTag(tagSet);
		article.setDate(new Date());		
		article.setComments(0);
		article.setAuthor("cxzhao");
		return articleDao.add(article);	
	}
	
	public Page<Article> queryArticle(int pageNumber,int pageSize){
		return articleDao.queryArticleAllField(pageNumber, pageSize);
	}
	
	public Article queryArticleById(int id,boolean isAddRecentList,boolean isUpdateRank){
		return articleDao.queryById(id, isAddRecentList, isUpdateRank);
	}
	
	public Page<Article> queryArticleByType(String type,int pageNumber,int pageSize){	
		return articleDao.queryByType(type, pageNumber, pageSize);
	}
}
