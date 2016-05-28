package test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blog.bean.Page;
import com.blog.domain.Article;
import com.blog.domain.User;
import com.blog.enums.RoleEnum;
import com.blog.dao.ArticleDao;
import com.blog.dao.RankDao;
import com.blog.dao.RecentDao;
import com.blog.dao.UserDao;
import com.blog.redis.RedisKit;
import com.blog.service.TypeService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"}) 
public class TestCase extends AbstractJUnit4SpringContextTests {

	@Autowired
	private TypeService typeService;
	
/*	@Test
	 public void test(){
		
		UserDao  dao= new UserDao();
		User user = new User();
		user.setId(1);
		user.setName("cxzhao");
		user.setPassword("123456");
		user.setRole(RoleEnum.admin);
		dao.add(user);
		RedisKit kit = new RedisKit();
		User u = kit.get("user:1");
		System.out.println(u.getName());
		
	}*/
	
	
	@Test
	 public void test(){
		if(typeService.save("javascripet")){
			System.out.println("yes");
		}else{
			System.out.println("no");
		}
	}

	
	
}
