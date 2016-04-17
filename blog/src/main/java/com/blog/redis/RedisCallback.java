package com.blog.redis;

import redis.clients.jedis.Jedis;

public interface RedisCallback {
	Object execute(Jedis jedis);
}
