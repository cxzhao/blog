package com.blog.dao;

import org.springframework.stereotype.Component;

import com.blog.domain.User;
import com.blog.redis.RedisKit;
import com.blog.utils.RedisKey;

@Component
public class UserDao {
	
	/**
	 * 增加用户
	 * @param user
	 * @return
	 * @author chenxi
	 * @date 2016年4月6日 下午9:21:08
	 */
	public boolean add(User user) {
		if ( user == null) {
			return false;
		}
		RedisKit kit = new RedisKit();
		kit.set(RedisKey.USER+":"+user.getName(), user);
		return true;
	}
	
	/**
	 * 查询用户
	 * @param name
	 * @return
	 * @author chenxi
	 * @date 2016年4月6日 下午9:21:29
	 */
	public User queryUser(String name){
		RedisKit kit = new RedisKit();
		User user = kit.get(RedisKey.USER+":"+name);
		return user;
	}
	
}
