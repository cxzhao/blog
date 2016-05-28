package com.blog.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.blog.bean.Page;
import com.blog.domain.Article;
import com.blog.redis.PipeCallback;
import com.blog.redis.RedisCallback;
import com.blog.redis.RedisKit;
import com.blog.utils.BuilderUtils;
import com.blog.utils.RedisKey;
import com.blog.utils.SerializeUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.util.JedisByteHashMap;

@Component
public class ArticleDao {
	
	/**
	 * 新增加一篇文章
	 * @param article
	 * @return　返回增加是否成功
	 * @author chenxi
	 * @date 2016年4月9日 下午3:39:05
	 */
	public boolean add(final Article article) {
		if (article == null) {
			return false;
		}
		RedisKit kit = new RedisKit();
		final long id = kit.incr(RedisKey.MAX_ARTICLE_ID, 1);
		article.setId(id);
		kit.pipelining(new PipeCallback() {
			@Override
			public void execute(Pipeline pipe) {
				Map<byte[], byte[]> articleMap = new HashMap<byte[], byte[]>();
				articleMap.put(SerializeUtils.serialize("id"), SerializeUtils.serialize(article.getId()));
				articleMap.put(SerializeUtils.serialize("title"), SerializeUtils.serialize(article.getTitle()));
				articleMap.put(SerializeUtils.serialize("content"), SerializeUtils.serialize(article.getContent()));
				articleMap.put(SerializeUtils.serialize("date"), SerializeUtils.serialize(article.getDate()));
				articleMap.put(SerializeUtils.serialize("comments"),SerializeUtils.serialize(article.getComments()));
				articleMap.put(SerializeUtils.serialize("tag"), SerializeUtils.serialize(article.getTag()));
				articleMap.put(SerializeUtils.serialize("type"), SerializeUtils.serialize(article.getType()));
				articleMap.put(SerializeUtils.serialize("author"), SerializeUtils.serialize(article.getAuthor()));
				pipe.hmset(SerializeUtils.serialize(RedisKey.ARTICLE + id), articleMap);
				double timeStamp = System.currentTimeMillis();
				// 将文章ID添加到有序集合中
				pipe.zadd(SerializeUtils.serialize(RedisKey.ARTICLE_SET), timeStamp,SerializeUtils.serialize(article.getId()));
				// 将文章ID添加到类型列表中
				pipe.lpush(SerializeUtils.serialize(article.getType()), SerializeUtils.serialize(article.getId()));
				
				for (String tag : article.getTag()) {
					//把标签添加到标签集合中
					pipe.sadd(SerializeUtils.serialize(RedisKey.TAG),SerializeUtils.serialize(tag));
					//文章添加到标签集合中
					pipe.sadd(SerializeUtils.serialize(RedisKey.TAG_SET+tag),SerializeUtils.serialize(article.getId()));
				}
			}
		});
		return true;
	}
	
	/**
	 * 分页查询文章
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @author chenxi
	 * @date 2016年4月9日 下午5:17:42
	 */
	public Page<Article> queryArticleAllField(int pageNumber,int pageSize){
		Page<Article> page = new Page<Article>();
		page.setPageNumber(pageNumber);
		page.setPageSize(pageSize);
		
		RedisKit kit = new RedisKit();
		int start = (pageNumber-1)*pageSize;
		int end = start+pageSize;
		final List<Long> ids = kit.zrange(RedisKey.ARTICLE_SET,start , end);
		
		List<Object> list=kit.pipelining(new PipeCallback() {	
			@Override
			public void execute(Pipeline pipe) {
				for(int i=0;i<ids.size();i++){
					long id = ids.get(i);
					pipe.hgetAll(SerializeUtils.serialize(RedisKey.ARTICLE + id));
				}
			}
		});
		List<Article> articleList = new ArrayList<Article>();
		for(Object obj:list){
			JedisByteHashMap map = (JedisByteHashMap) obj;
			Article article = BuilderUtils.builderArticle(map);
			articleList.add(article);
		}
		page.setList(articleList);
		return page;
	}
	
	/**
	 * 查询文章，记录文章的访问
	 * @param id 文章ID
	 * @param isAddRecentList 是否添加到最近查询中
	 * @param isUpdateRank 是否添加到查询排行中
	 * @return 
	 * @author chenxi
	 * @date 2016年4月10日 下午2:59:42
	 */
	public Article queryById(final long id,final boolean isAddRecentList,final boolean isUpdateRank){
		RedisKit kit = new RedisKit();
		List<Object> returnList=kit.pipelining(new PipeCallback() {
			
			@Override
			public void execute(Pipeline pipe) {
				pipe.hgetAll(SerializeUtils.serialize(RedisKey.ARTICLE + id));
				//添加文章到最近阅读
				if(isAddRecentList){
					pipe.lpush(SerializeUtils.serialize(RedisKey.RECENT_ARTICLE_LIST), SerializeUtils.serialize(id));
				}				
				//文章点击量加１
				if(isUpdateRank){
					pipe.zincrby(SerializeUtils.serialize(RedisKey.RANK_ARTICLE_SET), 1, SerializeUtils.serialize(id));
				}
			}
		});
		Article article = BuilderUtils.builderArticle((JedisByteHashMap)returnList.get(0));
		return  article;	
	}
	
	public Page<Article> queryByType(String typeName, int pageNumber,int pageSize){
		int start = (pageNumber-1)*pageSize;
		int end = start+pageSize;
		
		RedisKit kit = new RedisKit();
		List<byte[]> ids=kit.redisOperator(new RedisCallback() {			
			@Override
			public Object execute(Jedis jedis) {			
				return jedis.lrange(SerializeUtils.serialize(typeName), start, end);
			}
		});
		
		List<Object> list=kit.pipelining(new PipeCallback() {
			
			@Override
			public void execute(Pipeline pipe) {
				for(int i=0;i<ids.size();i++){
					long id = (long) SerializeUtils.deserialize(ids.get(i));
					pipe.hgetAll(SerializeUtils.serialize(RedisKey.ARTICLE + id));
				}
			}
		});
		
		List<Article> articleList = new ArrayList<Article>();
		for(Object obj:list){
			JedisByteHashMap map = (JedisByteHashMap) obj;
			Article article = BuilderUtils.builderArticle(map);
			articleList.add(article);
		}
		
		Page<Article> page = new Page<Article>();
		page.setPageNumber(pageNumber);
		page.setPageSize(pageSize);
		page.setList(articleList);
		return page;		
	}
}
