package com.blog.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.blog.domain.Article;
import com.blog.redis.PipeCallback;
import com.blog.redis.RedisCallback;
import com.blog.redis.RedisKit;
import com.blog.utils.RedisKey;
import com.blog.utils.SerializeUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
@Component
public class RecentDao {
	
	/**
	 * 查询最近阅读的文章
	 * @param start
	 * @param end
	 * @return
	 * @author chenxi
	 * @date 2016年4月10日 下午5:09:00
	 */
	public List<Article> queryRencentArticle(final int start,final int end){
		RedisKit kit = new RedisKit();
		final List<byte[]> returnList=kit.redisOperator(new RedisCallback() {
			
			@Override
			public Object execute(Jedis jedis) {
				List<byte[]> list=jedis.lrange(SerializeUtils.serialize(RedisKey.RECENT_ARTICLE_LIST), start, end);
				return list;
			}
		});
		
		List<Object> mapList=kit.pipelining(new PipeCallback() {
			
			@Override
			public void execute(Pipeline pipe) {
				for(byte[] b:returnList){
					long id = (long) SerializeUtils.deserialize(b);
					pipe.hmget(SerializeUtils.serialize(RedisKey.ARTICLE+id), SerializeUtils.serialize("id"),SerializeUtils.serialize("title"));
				}				
			}
		});
		List<Article> articleList = new ArrayList<Article>();
		
		for(Object obj:mapList){
			@SuppressWarnings("unchecked")
			List<byte[]> list = (List<byte[]>) obj;
			Article article = new Article();
			article.setId((long)SerializeUtils.deserialize(list.get(0)));
			article.setTitle((String)SerializeUtils.deserialize(list.get(1)));
			articleList.add(article);
		}
		
		return articleList;
	}
	
}
