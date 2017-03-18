package me.sk.controller;

import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 处理页面跳转
 *
 * @author SK
 *
 */
@Controller
public class PageController {
	@RequiresRoles("admin")	//只有拥有 admin 角色的用户才能访问
	@RequestMapping("/admin/{name:.+}")
	public String demoJumper(@PathVariable("name") String name) {
		return "admin/" + name;
	}
	
}
