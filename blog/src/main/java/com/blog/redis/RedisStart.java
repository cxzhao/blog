package com.blog.redis;

import org.springframework.beans.factory.InitializingBean;

public class RedisStart implements InitializingBean{

	@Override
	public void afterPropertiesSet() throws Exception {
		RedisManager manager = new RedisManager();
		manager.init();
		System.out.println("reids连接初始化……");
	}

}
