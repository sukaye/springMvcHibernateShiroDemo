package me.sk.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import me.sk.entity.User;

@Repository
public class LoginDaoImpl extends AbstractDao implements LoginDao {

	public boolean login(String userName, String password) {
		String hql = "from User where userName=? and password=?";
		List<User> list = super.query(hql, new Object[] { userName, password });
		if (list != null && list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public User getUser(String userName) {
		String hql = "from User where userName=?";
		List<User> list = super.query(hql, new Object[] { userName });
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}
}
