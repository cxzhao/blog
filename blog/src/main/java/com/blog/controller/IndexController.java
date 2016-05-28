package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.blog.bean.Page;
import com.blog.domain.Article;
import com.blog.domain.ArticleTag;
import com.blog.domain.ArticleType;
import com.blog.service.ArticleService;
import com.blog.service.RankService;
import com.blog.service.RecentService;
import com.blog.service.TagService;
import com.blog.service.TypeService;


@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	private TagService tagService;
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private TypeService typeService;
	
	@Autowired
	private RecentService recentService;
	
	@Autowired
	private RankService rankService;
	
	
	@RequestMapping(method=RequestMethod.GET,value="index")
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/client/index");		
		List<ArticleType> typeList = typeService.queryType();
		Page<Article> articlePage = articleService.queryArticle(1, 50);
		mv.addObject("types", typeList);
		mv.addObject("articles", articlePage);
		mv.addObject("rencents", recentService.queryDistinctRecentArticle(0, 10));
		mv.addObject("rank", rankService.queryRank(0, 10));
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.GET,value="admin")
	public ModelAndView admin(){
		ModelAndView mv = new ModelAndView();
		List<ArticleTag> tagList=tagService.queryAllTag();
		mv.addObject("tagList", tagList);
		mv.setViewName("/admin/index");
		return mv;
	}
	
}
