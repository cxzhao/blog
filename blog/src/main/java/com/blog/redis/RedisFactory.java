package com.blog.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * redis工厂
 * @author chenxi
 * @date 2016年4月4日 下午7:54:05
 */
public class RedisFactory {
	
	/**
	 * 生产一个redis连接对象
	 * @return
	 * @author chenxi
	 * @date 2016年4月4日 下午8:27:51
	 */
	public static Jedis redisFactory(){
		JedisPool pool = RedisManager.getPool();
		if(pool!=null){	
			return pool.getResource();
		}else{
			RedisManager manager = new RedisManager();
			manager.init();
			pool = RedisManager.getPool();
			return pool.getResource();
		}
	} 
}
