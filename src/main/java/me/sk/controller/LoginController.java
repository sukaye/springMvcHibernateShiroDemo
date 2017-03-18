package me.sk.controller;

import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import me.sk.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {
		model.put("loginError", "");
		return "login";
	}

	/*
	 * 方法参数name,password,role，必须与页面传来的参数名相同才能自动设值
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String userName, String password, String role, Map<String, Object> model) {
		/* 
		if (loginService.login(userName, password)) {
		 return "index";
		 } else {
		 model.put("loginError", "登录名或密码错误！");
		 return "login";
		 }
		 */

		// use shiro validation
		UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
		token.setRememberMe(false);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
		} catch (Exception e) {
			model.put("loginError", "登录名或密码错误！");
			e.printStackTrace();
			return "login";
		}
		
		if (subject.isAuthenticated()) {
			return "index";
		} else {
			model.put("loginError", "登录名或密码错误！");
			return "login";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(Map<String, Object> model) {
		SecurityUtils.getSubject().logout();
		model.put("loginError", "");
		return "login";
	}
}
