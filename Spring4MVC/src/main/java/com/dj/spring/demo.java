package com.dj.spring;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;



@Controller
//@RequestMapping("dj") 可以限定访问路径，
public class demo {
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(@RequestParam("uname") String uname,	//通过@RequestParam获取页面传递的值
			@RequestParam("upassword") String upassword, Model model)
	{
		Map errormap = validateLogin(uname);
		if(errormap.size()>0)
		{
			model.addAttribute("errormap", errormap);
			return "index";
		}
 		model.addAttribute("uname", uname);		//向jsp页面传值
		System.out.println(uname+"==="+upassword);
		return "login";
	}
	
	private Map validateLogin(String name)
	{
		Map errorMap = new HashMap();
		if(name.equals(""))
		{
			errorMap.put("userNameisNull", "用户名为空！");
		}
		return errorMap;
	}
	
	/**
	 * 获取前台传递的参数,再返回数据
	 * @param name
	 * @param pw
	 */
	@RequestMapping("/getPerson")
    public void getPerson(String name,PrintWriter pw){
        pw.write("hello,"+name);        
    }
	
	/**
	 * 测试重定向，ajax传值无法重定向
	 * @param name
	 * @return
	 */
	@RequestMapping("/Redir")
    public String redirct(String name){    
        return "redirect:/testRedirparam?name=" + name;	//进行重定向，实现控制层的跳转
    }
	
	@RequestMapping("/Redir2")
    public String redirct2(){    
        return "redirect:/testRedirNoparam";	//进行重定向，实现控制层的跳转
    }
	
	/**
	 * 无参重定向
	 */
	@RequestMapping("/testRedirNoparam")
    public String testRedirNoparam(){   
		System.out.println("这是无参重定向！");
		return "noparamRedir";
    }
	
	/**
	 * 有参重定向
	 * @param name
	 */
	@RequestMapping("/testRedirparam")
    public String testRedirparam(@RequestParam("name") String name, Model model){
		System.out.println(name);
		System.out.println("这是有参重定向！");
		model.addAttribute("param", name);
		return "paramRedir";
    }
	
	/**
	 * 路径匹配
	 * @param userID
	 * @return
	 */
	@RequestMapping("/dj/{userID}")
    public String testURLMatch(@PathVariable String userID){
		System.out.println("匹配URL路径执行指定Controller "+userID);
		return "index";
    }
	
	/**
	 * 接受前台发过来的json对象
	 * @param jsonstring
	 * @param pw
	 */
	@RequestMapping(value="getJSONString", method=RequestMethod.POST)
    public void getjson(@RequestParam("jsonstr") String jsonstring, PrintWriter pw){
		JSONObject onject = JSONObject.fromObject(jsonstring);
		System.out.println(onject.get("name"));
		System.out.println(onject.get("password"));       		    
		pw.write("hello，杜杰"+onject.getString("name"));		
    }
	
	/**
	 * 接受前台传递的json对象并转为实体类
	 * @param u
	 * @return
	 */
	@RequestMapping(value="json2object", method=RequestMethod.POST)
    public String json2object(@RequestBody user u){
		System.out.println(u.getName()+"="+u.getPassword());
		return "index";
    }
	
	/**
	 * 返回json字符串
	 * @param u
	 * @return
	 */
	@RequestMapping(value="sendjson", method=RequestMethod.POST)
	@ResponseBody
	public String sendjson(@RequestBody user u)
	{
		System.out.println(u.getName()+"="+u.getPassword());
		System.out.println(JSONObject.fromObject(u).toString());
		return JSONObject.fromObject(u).toString();		
	}	
	/**
	 * 返回json对象
	 * @param u
	 * @return
	 */
	@RequestMapping(value="sendjson2", method=RequestMethod.POST)
	@ResponseBody
	public user sendjson2(@RequestBody user u)
	{
		System.out.println(u.getName()+"="+u.getPassword());		
		return u;		
	}	
	
}
