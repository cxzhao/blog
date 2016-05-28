package com.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.blog.domain.User;
import com.blog.enums.RoleEnum;

@Controller
@RequestMapping("/test")
public class TestController {

	/**
	 * JSON返回方式一
	 * @param model
	 * @return
	 * @author chenxi
	 * @date 2016年4月17日 下午7:30:31
	 */
	@RequestMapping(method = RequestMethod.GET, value = "user")
	public RESTFul<?> user() {
		User user = new User();
		user.setId(1);
		user.setName("cxzhao");
		user.setPassword("123123");
		user.setRole(RoleEnum.admin);
		RESTFul<User> rest  =new RESTFul<User>();
		rest.setData(user);
		return rest;
	}
	
	@RequestMapping(method=RequestMethod.GET,value="index")
	public String index(){
		return "/client/index";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "index_2")
	public String index_2() {
		return "/client/index";
	}
}
