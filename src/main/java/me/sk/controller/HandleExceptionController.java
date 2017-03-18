package me.sk.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleExceptionController {
	
	@ExceptionHandler(org.apache.shiro.authz.UnauthorizedException.class)
	public String handleException() {
		return "error/unauthorized";
	}
}
