package com.blog.redis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import com.blog.utils.SerializeUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

/**
 * 本类对Jedis中的常用操作进行封装
 * @author chenxi
 * @date 2016年4月4日 下午8:30:05
 */
public class RedisKit {
	
	/**
	 * 存储一个字符串类型或者一个可序列化的对象
	 * @param key
	 * @param v　可以是一个对象或者一个集合
	 * @author chenxi
	 * @date 2016年4月4日 下午9:07:42
	 */
	public <V extends Serializable> void set(String key,V v){
		Jedis jedis = RedisFactory.redisFactory();
		jedis.set(SerializeUtils.serialize(key), SerializeUtils.serialize(v));
	}
	
	public long incr(String key,long step){
		Jedis jedis = RedisFactory.redisFactory();
		return jedis.incrBy(SerializeUtils.serialize(key), step);
	}
	
	/**
	 * 在有序集合种做范围查询
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 * @author chenxi
	 * @date 2016年4月9日 下午4:10:32
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> zrange(String key,int start,int end){
		Jedis jedis = RedisFactory.redisFactory();
		Set<byte[]> set=jedis.zrange(SerializeUtils.serialize(key), start, end);
		List<T> list = new ArrayList<T>();
		for(byte[] b:set){
			list.add((T) SerializeUtils.deserialize(b));
		}
		return list;
	}
	
	/**
	 * 根据key返回一个字符串类型或者返回一个对象
	 * @param key
	 * @return　可能是Object，也可能是一个集合
	 * @author chenxi
	 * @date 2016年4月4日 下午9:09:07
	 */
	public <V extends Serializable> V get(String key){
		Jedis jedis = RedisFactory.redisFactory();
		@SuppressWarnings("unchecked")
		V v=(V) SerializeUtils.deserialize(jedis.get(SerializeUtils.serialize(key)));
		return v;
	}
	
	
	/**
	 * redis事务操作
	 * @param callback
	 * @return
	 * @author chenxi
	 * @date 2016年4月5日 下午9:09:35
	 */
	public  List<Response<?>> transaction(TransCallback callback){
		Jedis jedis = RedisFactory.redisFactory();
		Transaction trans=jedis.multi();
		callback.execute(trans);
	    List<Response<?>> res=trans.execGetResponse();
        return res;
	}
	
	/**
	 * 管道操作，一次发送多个命令
	 * @param callback
	 * @return 将多个命令的返回值一起返回
	 * @author chenxi
	 * @date 2016年4月5日 下午9:20:06
	 */
	public List<Object> pipelining(PipeCallback callback){
		Jedis jedis = RedisFactory.redisFactory();
		Pipeline p = jedis.pipelined();
		callback.execute(p);
		List<Object> res=p.syncAndReturnAll();
		return res;
	}
	
	/**
	 * redis操作代码
	 * @param redisCallback
	 * @return
	 * @author chenxi
	 * @date 2016年4月6日 下午7:59:13
	 */
	public <T> T redisOperator(RedisCallback redisCallback){
		Jedis jedis = RedisFactory.redisFactory();
		@SuppressWarnings("unchecked")
		T t= (T) redisCallback.execute(jedis);
		return t;
	}
}
