package me.sk.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import me.sk.entity.User;

@Transactional
@Repository
public class UserDaoImpl extends AbstractDao implements UserDao {
	public void addUser(User user) {
		super.add(user);
	}
	public void updateUser(User user) {
		super.update(user);
	}
	public void deleteUser(User user) {
		super.delete(user);
	}
	public User getUser(String userName, String password){
		String hql = "from User where userName=:loginName and password=:pwd ";
		Map<String, Object> param = new HashMap();
		param.put("userName", userName);
		param.put("password", password);
		return null;
	}
}
