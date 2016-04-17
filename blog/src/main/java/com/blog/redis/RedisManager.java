package com.blog.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import com.blog.utils.PropertyUtils;

import redis.clients.jedis.JedisPool;

/**
 * redis连接管理
 * @author chenxi
 */
public class RedisManager {
	
	private String host;
	private int port;
	private String password;
	private int dbIndex;
	private  static  JedisPool pool;
	
	public void init(){
		getProperties();
		getConnPool();
	}
	
	/**
	 * 获取配置的连接属性
	 * @author chenxi
	 * @date 2016年4月4日 下午8:05:26
	 */
	private void  getProperties(){
		PropertyUtils.getProperties(RedisManager.class, "redis.properties");
		host = PropertyUtils.getString("host");
		port=PropertyUtils.getInt("port");
		password=PropertyUtils.getString("password");
		dbIndex=PropertyUtils.getInt("dbIndex");
	}
	
	public void getConnPool(){
		GenericObjectPoolConfig config = new GenericObjectPoolConfig();
		config.setMaxWaitMillis(2000);
		config.setMaxIdle(10);
		config.setMaxTotal(5000);
		config.setTestOnBorrow(true);
		if(password==null){
			setPool(new JedisPool(config,host,port));
		}else{
			setPool(new JedisPool(config, host, port, 10000, password, dbIndex));
		}
	}

	public static JedisPool getPool() {
		return pool;
	}

	public static void setPool(JedisPool pool) {
		RedisManager.pool = pool;
	}
	
}
