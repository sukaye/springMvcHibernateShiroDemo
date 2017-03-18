package me.sk.dao;

import me.sk.entity.User;

public interface LoginDao {
	public boolean login(String userName, String password);
	public User getUser(String userName);
}
