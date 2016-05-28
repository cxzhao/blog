package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.blog.bean.Page;
import com.blog.domain.Article;
import com.blog.domain.ArticleType;
import com.blog.service.ArticleService;
import com.blog.service.RankService;
import com.blog.service.RecentService;
import com.blog.service.TagService;
import com.blog.service.TypeService;
import com.blog.utils.ReturnCode;
import com.blog.utils.StringUtils;

@RestController
@RequestMapping("/type")
public class TypeController {

	@Autowired
	private TypeService typeService;
	
	@Autowired
	private TagService tagService;
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private RecentService recentService;
	
	@Autowired
	private RankService rankService;
	
	@RequestMapping(value="/type",method=RequestMethod.GET)
	public ModelAndView type(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/type");
		return mv;
	}
	
	/**
	 * 添加类型
	 * @param type
	 * @return
	 * @author chenxi
	 * @date 2016年4月23日 下午3:16:07
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public RESTFul<?> addType(@RequestParam(value="type") String type){
		RESTFul<Object> rest = new RESTFul<Object>();	
		if(StringUtils.isEmptyOrBlank(type)){
			rest.setReturnCode(ReturnCode.PARAM_ERROR);
		}else{
			if(typeService.save(type)){
				rest.setReturnCode(ReturnCode.SUCCESS);
			}else{
				rest.setReturnCode(ReturnCode.FAILED);
			}
		}	
		return rest;	
	}
	
	@RequestMapping(value="/queryType",method=RequestMethod.GET)
	public RESTFul<?> queryType(){
		RESTFul<Object> rest = new RESTFul<Object>();
		List<ArticleType> list = typeService.queryType(); 
		if(list!=null){
			rest.setReturnCode(ReturnCode.SUCCESS);
			rest.setData(list);
		}else{
			rest.setReturnCode(ReturnCode.FAILED);
		}
		return rest;
	}
	
	@RequestMapping(value="queryByType",method=RequestMethod.GET)
	public ModelAndView queryArticleByType(@RequestParam(value="type") String type){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/client/index");
		List<ArticleType> typeList = typeService.queryType();
		Page<Article> articlePage = articleService.queryArticleByType(type, 1, 50);
		mv.addObject("types", typeList);
		mv.addObject("articles", articlePage);
		mv.addObject("rencents", recentService.queryDistinctRecentArticle(0, 10));
		mv.addObject("rank", rankService.queryRank(0, 10));
		return mv;
	}
	
}
