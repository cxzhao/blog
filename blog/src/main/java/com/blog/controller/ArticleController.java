package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.blog.service.ArticleService;
import com.blog.vo.JsonModel;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	@RequestMapping(value = "newArticle", method = RequestMethod.POST)
	public ModelAndView newArticle(@RequestParam(value="title") String title, 
			@RequestParam(value="type") String type,
			@RequestParam(value = "content") String content,
			@RequestParam(value = "newtag", required = false) String newtag, 
			@RequestParam(value="tag") String tag) {
		
		articleService.addArticle(title, type, content, tag, newtag);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/index.jsp");	
		
		JsonModel json = new JsonModel();
		json.setReturnCode(JsonModel.SUCCESS);
		
		return mv;
	}
}
