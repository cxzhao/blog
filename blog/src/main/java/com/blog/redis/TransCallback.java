package com.blog.redis;

import redis.clients.jedis.Transaction;

/**
 * Redis事务回调接口
 * @author chenxi
 * @date 2016年4月4日 下午9:42:41 
 * @param trans　返回的参数
 */
public interface TransCallback {
	void execute(Transaction trans);
}
