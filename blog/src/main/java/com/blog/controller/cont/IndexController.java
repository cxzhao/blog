package com.blog.controller.cont;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class IndexController {
	
	@RequestMapping(method=RequestMethod.GET,value="index")
	public String index(){
		return "/client/index";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="admin")
	public String admin(){
		return "/admin/index";
	}
	
}
