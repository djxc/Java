package com.dj.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dj.entity.Users;
import com.dj.service.UserService;

@Controller
public class UserController {
	@Resource(name="userService")
    private UserService service;
    
    @RequestMapping(value="/manager",method=RequestMethod.GET)
    public ModelAndView hello2(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "HelloMVC");
        mv.setViewName("users");
        return mv;
    }
    
    @RequestMapping(value="/count",method=RequestMethod.GET)
    public ModelAndView count(){
        
        int c = service.userCount();
        
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", c);
        mv.setViewName("users");
        return mv;
    }
    
    @RequestMapping(value="/getAllUsers",method=RequestMethod.GET)
    @ResponseBody
    public List<Users> getAlluser()
    {
    	List<Users> users = service.getAllUser();
    	return users;    	
    }
    
    
    @RequestMapping(value="/AddUser",method=RequestMethod.POST)    
    public void AddUser(@RequestBody Users user)
    {
    	service.addUser(user);
    }
}
