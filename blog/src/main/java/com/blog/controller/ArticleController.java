package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.blog.service.ArticleService;
import com.blog.service.RankService;
import com.blog.service.RecentService;
import com.blog.service.TypeService;
import com.blog.utils.ReturnCode;

@RestController
@RequestMapping("/article")
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private TypeService typeService;
	
	@Autowired
	private RecentService recentService;
	
	@Autowired
	private RankService rankService;
	
	@RequestMapping(value = "newArticle", method = RequestMethod.POST)
	public RESTFul<?> newArticle(@RequestParam(value="title") String title, 
			@RequestParam(value="type") String type,
			@RequestParam(value = "content") String content,
			@RequestParam(value = "newtag", required = false) String newtag, 
			@RequestParam(value="tag") String tag) {
		
		boolean res=articleService.addArticle(title, type, content, tag, newtag);
		
		RESTFul<String> rest = new RESTFul<String>();
		if(res){
			rest.setReturnCode(ReturnCode.SUCCESS);
		}else{
			rest.setReturnCode(ReturnCode.FAILED);
		}
		return rest;
	}
	
	@RequestMapping(value="articleDetail",method=RequestMethod.GET)
	public ModelAndView articleDetail(@RequestParam(value="id") int id){
		ModelAndView mv = new ModelAndView();		
		mv.setViewName("client/article");
		mv.addObject("types", typeService.queryType());
		mv.addObject("article", articleService.queryArticleById(id, true, true));
		mv.addObject("rencents", recentService.queryDistinctRecentArticle(0, 10));
		mv.addObject("rank", rankService.queryRank(0, 10));
		return mv;		
	}
	
}
