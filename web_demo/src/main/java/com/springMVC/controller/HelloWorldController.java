package com.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 控制器类
 * 使用@RequestMapping注解声明了这个类是默认处理程序键入“/”的所有请求
 * @author dj
 *
 */
@Controller
@RequestMapping("/")
public class HelloWorldController {
	@RequestMapping(method = RequestMethod.GET)
	public String sayHello(ModelMap model) {
		model.addAttribute("greeting", "Hello World from Spring 4 MVC欢迎");
		model.addAttribute("name", "我是杜杰！");
		return "index";
	}

	@RequestMapping(value = "/helloagain", method = RequestMethod.GET)
	public String sayHelloAgain(ModelMap model) {
		model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
		return "welcome";
	}
	
	@RequestMapping(value = "/html", method = RequestMethod.GET)
	public String HelloHtml(ModelMap model) {
		model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
		return "index1";
	}
}
