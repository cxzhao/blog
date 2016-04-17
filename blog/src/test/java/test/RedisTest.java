package test;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.blog.redis.TransCallback;
import com.blog.redis.RedisKit;
import com.blog.utils.SerializeUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

public class RedisTest {

	/*@Test
	public void test() {
		RedisKit kit = new RedisKit();
		//kit.set("test","test");
		String res = kit.get("test");
		System.out.println(res);
	}*/
	
	@Test
	public void test() {
		RedisKit kit = new RedisKit();
		 /*List<Response<?>> resList=kit.transaction(new TransCallback(){
			@Override
			public void execute(Transaction trans) {
				
				try {
					Response<Long> idRes=trans.incr(SerializeUtils.serialize("id"));
					trans.set(SerializeUtils.serialize("person:"+1), SerializeUtils.serialize("cxzhao"));			
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
		});*/
		//queryById();
		String name = kit.get("person:1");
		System.out.println(name);
	}

}
