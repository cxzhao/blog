package com.blog.redis;

import redis.clients.jedis.Pipeline;

/**
 * 管道回调接口
 * @author chenxi
 * @date 2016年4月5日 下午9:17:03
 */
public interface PipeCallback {
	void execute(Pipeline pipe);
}
