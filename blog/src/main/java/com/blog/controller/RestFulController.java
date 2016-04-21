package com.blog.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.blog.domain.User;
import com.blog.enums.RoleEnum;

@RestController
@RequestMapping("/rest")
public class RestFulController {
	@RequestMapping(method = RequestMethod.GET, value = "user")
	public RESTFul<?> user(ModelMap model) {
		User user = new User();
		user.setId(1);
		user.setName("cxzhao");
		user.setPassword("123123");
		user.setRole(RoleEnum.admin);
		RESTFul<User> rest  =new RESTFul<User>();
		rest.setData(user);
		return rest;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "index")
	public String index() {
		return "/client/index";
	}
	
	
}
