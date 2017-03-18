package me.sk.service;

import me.sk.entity.User;

public interface LoginService {
	public boolean login(String loginName, String password);
	public User getUser(String loginName);
}
