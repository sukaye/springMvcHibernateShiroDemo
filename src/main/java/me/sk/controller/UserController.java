package me.sk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.sk.entity.User;

/**
 * spring mvc controller 示例
 * 
 * @author SK
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	/*
	 * 将实体对象转为json
	 */
	@RequestMapping("/getUser")
	@ResponseBody
	public User getUser(){
		User user = new User();
		user.setUserName("Jack");
		user.setPassword("111111");
		return user;
	}
	
	
	/*
	 * 直接返回返回json
	 * 如果没有指定请求类型，默认post,get两者都可以
	 * 指定请求类型 @RequestMapping(value = "/data", method = RequestMethod.GET)
	 */
	@RequestMapping("/data")
	@ResponseBody // 处理 AJAX 请求，返回响应的内容，而不是 View Name
	public String dataview() {
		return "{\"nam\":\"李文\"}";
	}
}
