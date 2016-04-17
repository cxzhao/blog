package com.blog.utils;

public class RedisKey {
	public final static String ARTICLE="article:";
	//用与存储文章列表，每一次的文章添加都将文章加入到该列表种
	public final static String ARTICLE_SET = "articlesSet";
	
	//最近阅读文章添加到这个list中。
	public final static String RECENT_ARTICLE_LIST = "recentList";
	
	//文章点击阅读排行榜
	public final static String RANK_ARTICLE_SET = "rankSet";
	
	public final static String 	MAX_ARTICLE_ID = "maxArticleId";
	
	public final static String TAG = "tagSet";//存储文章中的标签
	
	public final static String BLOG_TYPE = "type";//存储文章中的类型
	
	public static String USER="user";
	
	//标签集合，用来存储一个标签包含的文章id,如：tag:set:mysql
    public static String TAG_SET="tag:set:";
    
    
}
