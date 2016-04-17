package test;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
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

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"}) 
public class TestCase extends AbstractJUnit4SpringContextTests {

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
		/*Article article = new Article();
		article.setAuthor("cxzhao");
		article.setComments(5);
		article.setContent("333333333333");
		article.setDate(new Date());
		article.setTitle("33333333333333333");
		article.setType("spring");
		Set<String>tag = new HashSet<String>();
		tag.add("java");
		tag.add("spring");
		article.setTag(tag);*/
		/*ArticleDao dao = new ArticleDao();
		dao.add(article);*/
		
/*		Page<Article> p=dao.queryArticleAllField(1, 10);
		 System.out.println(p.getPageNumber());*/
		/*ArticleDao dao = new ArticleDao();
		Article article =dao.queryById(1, true, true);
		dao.queryById(1, true, true);
		dao.queryById(1, true, true);
		dao.queryById(1, true, true);*/
		/*RecentDao reDao = new RecentDao();
		List<Article> l = reDao.queryRencentArticle(0, 3);*/
		
		RankDao rankDao = new RankDao();
		List<Article> list=rankDao.queryClickRank(0, 4);
		for(Article a:list){
			System.out.println(a.getTitle());
		}
	}

	
	
}
