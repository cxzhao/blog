package com.blog.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.blog.domain.Article;
import com.blog.redis.RedisCallback;
import com.blog.redis.RedisKit;
import com.blog.utils.RedisKey;
import com.blog.utils.SerializeUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
@Component
public class RankDao {
	
	/**
	 * 查询点击排名在start和end之间的文章
	 * @param start
	 * @param end
	 * @return　文章的List,Article中包含id和title
	 * @author chenxi
	 * @date 2016年4月10日 下午5:55:32
	 */
	public List<Article> queryClickRank(final long start,final long end){
		RedisKit kit = new RedisKit();
		List<Article> returnList=kit.redisOperator(new RedisCallback() {
			
			@Override
			public Object execute(Jedis jedis) {
				Set<byte[]> rankSet=jedis.zrevrange(SerializeUtils.serialize(RedisKey.RANK_ARTICLE_SET), start, end);
				Pipeline p = jedis.pipelined();
				for(byte[] b:rankSet){
					long id = (Long) SerializeUtils.deserialize(b);
					p.hmget(SerializeUtils.serialize(RedisKey.ARTICLE+id), SerializeUtils.serialize("id"),SerializeUtils.serialize("title"));
				}
				List<Object> list=p.syncAndReturnAll();
				List<Article> resList = new ArrayList<Article>();
				for(Object obj:list){
					@SuppressWarnings("unchecked")
					List<byte[]> blist = (List<byte[]>) obj;
					Article article = new Article();
					article.setId((Long)SerializeUtils.deserialize(blist.get(0)));
					article.setTitle((String)SerializeUtils.deserialize(blist.get(1)));
					resList.add(article);
				}
				return resList;
			}
		});
		return returnList;
	}
	
}
