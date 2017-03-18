package me.sk.dao;

import me.sk.entity.User;

public interface UserDao {
	public void addUser(User users);
	public void updateUser(User user);
	public void deleteUser(User user);
	public User getUser(String loginName, String pwd);
}
