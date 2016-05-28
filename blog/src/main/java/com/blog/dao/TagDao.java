package com.blog.dao;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;

import com.blog.domain.ArticleTag;
import com.blog.redis.RedisCallback;
import com.blog.redis.RedisKit;
import com.blog.utils.RedisKey;
import com.blog.utils.Utils;

import redis.clients.jedis.Jedis;

@Component
public class TagDao {

	public RedisKit kit = new RedisKit();
	
	/**
	 * 查所有标签
	 * @return
	 * @author chenxi
	 * @date 2016年5月4日 下午10:59:01
	 */
	public List<ArticleTag> queryAllTag(){
		Set<byte[]> set=kit.redisOperator(new RedisCallback() {
			
			@Override
			public Object execute(Jedis jedis) {
				
				return jedis.smembers(SerializationUtils.serialize(RedisKey.TAG));
			}
		});
		List<ArticleTag> tagList = Utils.newArrayList();
		for(byte[] b:set){
			ArticleTag tag = new ArticleTag();
			tag.setTag((String)SerializationUtils.deserialize(b));
			tagList.add(tag);
		}
		return tagList;
	}
}
