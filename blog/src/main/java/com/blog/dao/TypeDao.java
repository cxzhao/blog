package com.blog.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.blog.redis.RedisCallback;
import com.blog.redis.RedisKit;
import com.blog.utils.RedisKey;
import com.blog.utils.SerializeUtils;

import redis.clients.jedis.Jedis;
@Component
public class TypeDao {
	
	public long add(final String type){
		
		RedisKit kit = new RedisKit();
		return kit.redisOperator(new RedisCallback() {
			
			@Override
			public Object execute(Jedis jedis) {
				// TODO Auto-generated method stub
				return jedis.sadd(SerializeUtils.serialize(RedisKey.BLOG_TYPE), SerializeUtils.serialize(type));
			}
		});
	}
	
	/**
	 * 查询文章中的类型
	 * @return
	 * @author chenxi
	 * @date 2016年4月10日 下午2:38:09
	 */
	public List<String> query(){
		RedisKit kit = new RedisKit();
		 Set<byte[]> set=kit.redisOperator(new RedisCallback() {
			
			@Override
			public Object execute(Jedis jedis) {
				return jedis.smembers(SerializeUtils.serialize(RedisKey.BLOG_TYPE));
			}
		});
		 
		 List<String> list = new ArrayList<String>();
		 for(byte[] b:set){
			 list.add((String) SerializeUtils.deserialize(b));
		 }
		 return list;
	}
	
	/**
	 * 删除类型
	 * @param type
	 * @return
	 * @author chenxi
	 * @date 2016年4月10日 下午2:45:05
	 */
	public boolean delete(final String type){
		RedisKit kit = new RedisKit();
		long res=kit.redisOperator(new RedisCallback() {
			
			@Override
			public Object execute(Jedis jedis) {
				return jedis.srem(SerializeUtils.serialize(RedisKey.BLOG_TYPE), SerializeUtils.serialize(type));
			}
		});
		if(res!=0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 查询文章中的标签
	 * @return
	 * @author chenxi
	 * @date 2016年4月11日 下午8:30:03
	 */
	public List<String> queryArticleTag(){
		RedisKit kit = new RedisKit();
		return kit.redisOperator(new RedisCallback() {
			
			@Override
			public Object execute(Jedis jedis) {
				// TODO Auto-generated method stub
				Set<byte[]> tagSet=jedis.smembers(SerializeUtils.serialize(RedisKey.TAG));
				List<String> list = new ArrayList<String>();
				for(byte[] b:tagSet){
					list.add((String)SerializeUtils.deserialize(b));
				}
				return list;
			}
		});
	}
	
}
