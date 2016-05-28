package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blog.domain.ArticleTag;
import com.blog.service.TagService;
import com.blog.utils.ReturnCode;

@RestController
@RequestMapping("/tag")
public class TagController {

	@Autowired
	private TagService tagService;
	
	/**
	 * 查寻所有标签
	 * @return
	 * @author chenxi
	 * @date 2016年5月4日 下午11:07:04
	 */
	@RequestMapping(value="queryAllTag", method=RequestMethod.GET)
	public RESTFul<?> queryAllTag(){
		RESTFul<Object> rest = new RESTFul<Object>();
		List<ArticleTag> tags=tagService.queryAllTag();
		if(tags!=null){
			rest.setData(tags);
			rest.setReturnCode(ReturnCode.SUCCESS);
		}else{
			rest.setReturnCode(ReturnCode.FAILED);
		}	
		return rest;
	}
	
}
